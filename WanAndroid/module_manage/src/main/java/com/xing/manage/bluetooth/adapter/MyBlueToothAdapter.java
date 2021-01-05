package com.xing.manage.bluetooth.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.xing.manage.R;
import com.xing.manage.bluetooth.bean.BlueToothBean;

import java.util.List;


public class MyBlueToothAdapter extends BaseAdapter {
    private Context context;
    private List<BlueToothBean> blueToothBeans;
    private OnItemClickLitener mOnItemClickLitener;

    public MyBlueToothAdapter(Context context, List<BlueToothBean> blueToothBeans) {
        this.context = context;
        this.blueToothBeans = blueToothBeans;
    }

    //设置回调接口
    public interface OnItemClickLitener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public int getCount() {
        return blueToothBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return blueToothBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int postion=i;
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_bluetooth, null);
            viewHolder.item_bluetooth_id = (TextView) view.findViewById(R.id.item_bluetooth_id);
            viewHolder.item_bluetooth_name = (TextView) view.findViewById(R.id.item_bluetooth_name);
            viewHolder.item_bluetooth_address = (TextView) view.findViewById(R.id.item_bluetooth_address);
            viewHolder.item_bluetooth_connect = (Button) view.findViewById(R.id.item_bluetooth_connect);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.item_bluetooth_id.setText(postion+1+"");
        viewHolder.item_bluetooth_name.setText(blueToothBeans.get(i).BlueToothName);
        viewHolder.item_bluetooth_address.setText(blueToothBeans.get(i).BlueToothAddress);
        //连接的监听事件
        viewHolder.item_bluetooth_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickLitener.onItemClick(view, postion);
            }
        });
        return view;
    }
    class ViewHolder {
        TextView item_bluetooth_id,item_bluetooth_name,item_bluetooth_address;
        Button item_bluetooth_connect;
    }
}
