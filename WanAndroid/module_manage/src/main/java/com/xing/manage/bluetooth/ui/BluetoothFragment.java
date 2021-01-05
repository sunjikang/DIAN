package com.xing.manage.bluetooth.ui;

import android.Manifest;
 import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 import android.widget.ListView;
 import android.widget.Toast;

import com.devil.library.camera.util.LogUtil;
import com.xing.manage.R;
 import com.xing.manage.bluetooth.adapter.MyBlueToothAdapter;
import com.xing.manage.bluetooth.bean.BlueToothBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BluetoothFragment extends DialogFragment {
    private final int REQUEST_PERMISSION_ACCESS_LOCATION = 123;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        getBlueToothDetail();
    }
     ListView listview;
    private MyBlueToothAdapter adapter;
    BluetoothAdapter blueToothAdapter;
    List<BlueToothBean> beans=new ArrayList<>();
    HashMap<String,BlueToothBean> map=new HashMap<String,BlueToothBean>();
    private static final int REQUEST_ENABLE = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dialog_bluetooth, null);
         listview=(ListView) root.findViewById(R.id.listview);
         root.findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 map.clear();
                 beans.clear();
                 blueToothAdapter.startDiscovery();
             }
         });
         root.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dismiss();
             }
         });
         adapter=new MyBlueToothAdapter(getActivity(),beans);

        listview.setAdapter(adapter);

        adapter.setOnItemClickLitener(new MyBlueToothAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                if (view.getId() == R.id.item_bluetooth_connect){
                    dismiss();
                    Toast.makeText(getActivity(),beans.get(position).BlueToothAddress,Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerReceiver();
        blueToothAdapter.startDiscovery();
    }

    public static void show(FragmentActivity activity) {
        BluetoothFragment dialog = new BluetoothFragment();
         dialog.show(activity.getSupportFragmentManager(), "bluetoothDialog");
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mBluetoothReceiver!=null){
             getActivity().unregisterReceiver(mBluetoothReceiver);

        }
    }


    private void init() {
        //获取蓝牙适配器
        blueToothAdapter = BluetoothAdapter.getDefaultAdapter();
        Log.e("sjk", "蓝牙是否打开: " + blueToothAdapter.isEnabled());
        //判断当前蓝牙是否打开
        if (!blueToothAdapter.isEnabled()) {
            //如果蓝牙不可用,弹出提示询问用户是否打开蓝牙
            Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enabler, REQUEST_ENABLE);
        }

    }


    private BroadcastReceiver mBluetoothReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)){//每扫描到一个设备，系统都会发送此广播。
                //获取蓝牙设备
                BluetoothDevice scanDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if(scanDevice == null || scanDevice.getName() == null) return;
                String name = scanDevice.getName();
                String address = scanDevice.getAddress();
                BlueToothBean blueToothBean = new BlueToothBean(name,address);
                Log.e("sjk", "搜索到了: name="+scanDevice.getName()+"  address="+scanDevice.getAddress());
                 map.put(address, blueToothBean);
                beans.clear();

                Iterator it = map.entrySet().iterator();
                while (it.hasNext()){
                    Map.Entry entry = (Map.Entry) it.next();
                    String key = (String) entry.getKey();
                    BlueToothBean  value = (BlueToothBean) entry.getValue();
                    beans.add(value);

                }
                adapter.notifyDataSetChanged();

            }else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){

                Log.e("sjk","搜索完成");

            }

        }

    };
    //注册广播搜索蓝牙
    private void registerReceiver() {
        IntentFilter intent = new IntentFilter();
        intent.addAction(BluetoothDevice.ACTION_FOUND); // 用BroadcastReceiver来取得搜索结果
        intent.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        intent.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        getActivity().registerReceiver(mBluetoothReceiver, intent);

    }

    //获取蓝牙详情
    private void getBlueToothDetail() {
        //获取本机蓝牙名称
        String name = blueToothAdapter.getName();
        //获取本机蓝牙地址
        String address = blueToothAdapter.getAddress();
        Log.e("sjk", "蓝牙名称: " + name + "蓝牙地址: " + address);
        //获取已配对蓝牙设备
        Set<BluetoothDevice> devices = blueToothAdapter.getBondedDevices();
        Log.e("sjk", "已配对蓝牙数: " + devices.size());
        for (BluetoothDevice bonddevice : devices) {
            Log.e("sjk", "已配对蓝牙 name =" + bonddevice.getName() + " address" + bonddevice.getAddress());
        }
    }


}
