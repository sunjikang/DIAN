package com.xing.manage.activity.device;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;



import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.coorchice.library.SuperTextView;
import com.devil.library.media.MediaSelectorManager;
import com.devil.library.media.common.ImageLoader;
import com.devil.library.media.config.DVCameraConfig;
import com.devil.library.media.config.DVListConfig;
import com.devil.library.media.enumtype.DVMediaType;
import com.devil.library.media.listener.OnSelectMediaListener;
import com.xing.commonbase.base.BaseActivity;
import com.xing.commonbase.util.ToastUtil;
import com.xing.manage.R;
import com.xing.manage.adapter.device.FullyGridLayoutManager;
import com.xing.manage.adapter.device.SelectAdapter;
import com.xing.manage.bean.device.Inspection;
import com.xing.manage.bean.device.Record;
import com.xing.manage.bean.device.Resource;
import com.xing.manage.bluetooth.ui.BluetoothFragment;
import com.xing.manage.db.DbManager;
import com.xing.manage.db.InspectionDao;
import com.xing.manage.db.RecordDao;
import com.xing.manage.db.ResourceDao;
import com.xing.manage.util.TimeUtil;
import com.zyyoona7.popup.EasyPopup;
import com.zyyoona7.popup.XGravity;
import com.zyyoona7.popup.YGravity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Route(path = "/manage/device/DeviceDetailActivity")
public class DeviceDetailActivity extends BaseActivity implements View.OnClickListener{
    private ScrollView scrollView;
     private SuperTextView  supertv1;
    private SuperTextView  supertv2;
    private SuperTextView  supertv3;
    private SuperTextView  supertv4;

    private Button btn3;
    private Button btn6;


    private LinearLayout rg_layout;
    private SuperTextView text1;
    private SuperTextView text2;
    private  SuperTextView text3;
    /**备注*/
    private ConstraintLayout cl_have_value;
    private TextInputEditText tie_remark;//备注
    private TextInputEditText tie_check_value;//具体值

    /**刚进入的时间*/
    long oldTime;
    /**需要此刻用的时间*/
    long newTime;
    /**安全事件*/
    boolean isSafe=true;
    /**安全时间*/
    long safeTime =2*60*1000;
    /**警告时间*/
    long alertTime =1*60*1000;

    private   Handler myhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            newTime=System.currentTimeMillis();
            String timeStr=  TimeUtil.formatDateTime((safeTime-(newTime-oldTime))/1000);
             text3.setText("检测倒计时："+timeStr);
            if (newTime-oldTime>safeTime){
                isSafe=false;
                text3.setTextColor(Color.RED);
                text3.setText("检测倒计时：已经超时");
            }else if(newTime-oldTime>alertTime){
                 text3.setTextColor(Color.parseColor("#ff9900"));
             }
        }
    };
    private RadioGroup radioGroup;
    private Inspection inspection;
    private SelectAdapter adapter;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        isSafe=false;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_check_common;
    }

    @Override
    protected void initView() {
        //键盘顶起输入框
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        scrollView=findViewById(R.id.scrollView);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);

        tie_check_value=findViewById(R.id.tie_check_value);
        supertv1=findViewById(R.id.supertv1);
        supertv2=findViewById(R.id.supertv2);
        supertv3=findViewById(R.id.supertv3);
        supertv4=findViewById(R.id.supertv4);
        tie_remark=findViewById(R.id.TextInputEditText);
        btn3=   findViewById(R.id.button3);
        btn6=   findViewById(R.id.button6);
        btn3.setOnClickListener(this);

        btn6.setOnClickListener(this);
         rg_layout=findViewById(R.id.rg_layout);
         cl_have_value=findViewById(R.id.cl_have_value);



        radioGroup=findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.state_nomal) {
                    checkState=true;
                } else if (checkedId == R.id.state_exception) {
                    checkState= false;
                }

            }
        });



     }


    // image
    private RecyclerView recyclerView;




    private int position;
    /**检测是否正常*/
    private boolean checkState=true;
    /**巡检列表传递过来的值*/
    private long lineId;
    private long areaId;
    private long facilityId;
    private long inspectionId;
    private long lineServerId;
    private long areaServerId;
    private long facilityServerId;
    private long inspectionServerId;
    private String lineCode;
    private String lineName;
    private String areaName;
    private String facilityName;
    private String inspectionName;
     @Override
    protected void initData() {
         super.initData();
         Bundle bundle = getIntent().getExtras();
        lineId=  bundle.getLong("lineId");
        areaId=  bundle.getLong("areaId");
        facilityId=  bundle.getLong("facilityId");
        inspectionId=  bundle.getLong("inspectionId");
        position=  bundle.getInt("position");

         lineServerId = bundle.getLong("lineServerId");
         areaServerId = bundle.getLong("areaServerId");
         facilityServerId = bundle.getLong("facilityServerId");
         inspectionServerId = bundle.getLong("inspectionServerId");

         lineCode = bundle.getString("lineCode");
         lineName = bundle.getString("lineName");
         areaName = bundle.getString("areaName");
         facilityName = bundle.getString("facilityName");
         inspectionName = bundle.getString("inspectionName");


        inspection = DbManager.getInstance().getInspectionDao().queryBuilder().where(InspectionDao.Properties.Mmid.eq(inspectionId)).list().get(0);
        //todo  传感器回调值

         Toolbar toolbar=findViewById(R.id.toolbar_title);
        toolbar.setTitle(inspection.inspectionItemName);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceDetailActivity.this.finish();
            }
        });

        text1.setText("巡检项："+inspection.inspectionItemName);
        text2.setText("检测类型："+inspection.pollingType);


        /*
            温度 速度 加速度 位移 抄表 转速 观察 录入 预设状况
        * */
        if (inspection.pollingType.equals("温度")){
            showBackValue(true,inspection);
        }else if (inspection.pollingType.equals("速度")){
            showBackValue(true,inspection);
        }else if (inspection.pollingType.equals("加速度")){
            showBackValue(true,inspection);
        }else if (inspection.pollingType.equals("位移")){
            showBackValue(true,inspection);
        }else if (inspection.pollingType.equals("抄表")){
            showBackValue(false,inspection);
        }else if (inspection.pollingType.equals("转速")){
            showBackValue(true,inspection);
        }else if (inspection.pollingType.equals("观察")){
            showBackValue(false,inspection);
        }else if (inspection.pollingType.equals("录入")){
            showBackValue(false,inspection);
        }else if (inspection.pollingType.equals("预设情况")){
            showBackValue(false,inspection);
        }

        oldTime=System.currentTimeMillis();
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (isSafe){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    myhandler.sendEmptyMessage(0);
                }
            }
        }.start();

        initImg();//初始化加载图片引擎


         //选择图片
         recyclerView = findViewById(R.id.recycler);
         FullyGridLayoutManager manager = new FullyGridLayoutManager(DeviceDetailActivity.this, 4, GridLayoutManager.VERTICAL, false);
         recyclerView.setLayoutManager(manager);

         adapter = new SelectAdapter(R.layout.item_select_photo,stringList,DeviceDetailActivity.this);
          recyclerView.setAdapter(adapter);
          adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
              @Override
              public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                  if (view.getId()==R.id.ll_del){
                      stringList.remove(position);
                      adapter.notifyDataSetChanged();
                  }
              }
          });
    }

    /***
     *
     * @param visible false 为观察类      true 为传感器检测
     * @param inspection
     */
    private void showBackValue(boolean visible,Inspection inspection) {
        if (visible){
            BluetoothFragment.show(this);
            cl_have_value.setVisibility(View.VISIBLE);
            rg_layout.setVisibility(View.GONE);
            supertv1.setText("上上限："+inspection.upperUp);
            supertv2.setText("上限："+inspection.upper);
            supertv3.setText("下限："+inspection.floor);
            supertv4.setText("下下限："+inspection.floorFl);
        }else{
            cl_have_value.setVisibility(View.GONE);
            rg_layout.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button3){
            showPupToSelectPhoto();
        }else if(v.getId()==R.id.button6){
            //todo 保存巡检任务
            savaData();
        }
    }

    private void savaData() {
        InspectionDao inspectionDao = DbManager.getInstance().getInspectionDao();
        inspection.isCheckOver = true;  //检测完成
        inspectionDao.update(inspection);//保存更新
        String strRemark =  tie_remark.getText().toString();
        String strCheckValue = tie_check_value.getText().toString().trim();
        RecordDao recordDao = DbManager.getInstance().getRecordDao();
        if (!TextUtils.isEmpty(strCheckValue)){
            Double douCheckValue = Double.valueOf(strCheckValue);
            Double upperUp = Double.valueOf(  inspection.upper==null?"0":inspection.upper);
            Double floorFl = Double.valueOf(  inspection.floor==null?"0":inspection.floor);

            if (douCheckValue>upperUp||douCheckValue<floorFl){
                checkState = false;
            }else{
                checkState = true;
            }

        }

        Record   record = new Record();
        record.lineId= lineId;
        record.areaId= areaId;
        record.facilityId=facilityId;
        record.inspectionId= inspection.mmid;
        record.pollingType = inspection.pollingType;
        record.observedValue = strCheckValue;
        record.remark = strRemark;
        record.isNormal= checkState;
        record.isUploaded = false;

        record.startTime = oldTime;
        record.endTime =  System.currentTimeMillis();

        record.lineServerId = lineServerId;
        record.areaServerId = areaServerId;
        record.facilityServerId = facilityServerId;
        record.inspectionServerId = inspectionServerId;

        record.lineCode = lineCode;
        record.lineName = lineName;
        record.areaName = areaName;
        record.facilityName = facilityName;
        record.inspectionName = inspectionName;

        recordDao.insert(record);
        ResourceDao resourceDao= DbManager.getInstance().getResourceDao();
        //生成资源数据
        for (int i = 0; i <stringList.size() ; i++){
             Resource resource = new Resource();
            resource.recordId = record.mmid;
            resource.path = stringList.get(i);
            resourceDao.insert(resource);
        }
        ToastUtil.show(this,"保存成功");
        //返回给区域页面的数据
         Intent intent  = new Intent();
         Bundle bundle = new Bundle();
         bundle.putLong("lineId", lineId);
         bundle.putInt("position", position);
         bundle.putBoolean("isNormal",checkState);
         intent.putExtras(bundle);
         setResult(AreaListActivity.CHECK_RESULT,intent);
         finish();
    }

    private EasyPopup mCirclePop;

    private void showPupToSelectPhoto() {
        mCirclePop = EasyPopup.create()
                .setContentView(DeviceDetailActivity.this, R.layout.popup_select_photo)
                //是否允许点击PopupWindow之外的地方消失
                .setFocusAndOutsideEnable(true)
                //允许背景变暗
                .setBackgroundDimEnable(true)
                //变暗的透明度(0-1)，0为完全透明
                .setDimValue(0.4f)
                //变暗的背景颜色
                .setDimColor(Color.GRAY)
                //指定任意 ViewGroup 背景变暗
                .setDimView(scrollView)
                .apply();
        mCirclePop.showAtAnchorView(btn3, YGravity.CENTER, XGravity.RIGHT, 0, 0);
        mCirclePop.findViewById(R.id.btn_camara).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCirclePop.dismiss();
                openCamera();
            }
        });
        mCirclePop.findViewById(R.id.btn_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCirclePop.dismiss();
                selectPhotos();
            }
        });
        mCirclePop.findViewById(R.id.btn_vedio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCirclePop.dismiss();

                selectVideos();
            }
        });
    }


    /**
     * 多选视频快速加载测试
     */
    public void selectVideos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //这里才是开始调用
                        DVListConfig config = MediaSelectorManager.getDefaultListConfigBuilder()
                                .mediaType(DVMediaType.VIDEO)
                                .quickLoadVideoThumb(true)
                                .hasPreview(true).build();
                        //打开界面
                        MediaSelectorManager.openSelectMediaWithConfig(DeviceDetailActivity.this,config, new OnSelectMediaListener() {
                            @Override
                            public void onSelectMedia(List<String> li_path) {
                                for (String path : li_path) {
                                     showRes(path);
                                }
                            }
                        });
                    }
                });
            }
        }).start();

    }



    /**
     * 选择图片
     */
    public void selectPhotos() {
        DVListConfig config = MediaSelectorManager.getDefaultListConfigBuilder()
                // 是否多选
                .multiSelect(true)
                //第一个菜单是否显示照相机
                .needCamera(true)
                //第一个菜单显示照相机的图标
                .cameraIconResource(R.mipmap.take_photo)
                //每行显示的数量
                .listSpanCount(4)
                // 确定按钮文字颜色
                .sureBtnTextColor(Color.WHITE)
                // 使用沉浸式状态栏
                .statusBarColor(Color.parseColor("#3F51B5"))
                // 返回图标ResId
                .backResourceId(R.mipmap.icon_dv_arrow_left_white_back)
                //标题背景
                .titleBgColor(Color.parseColor("#3F51B5"))
                //是否需要裁剪
                .needCrop(false)
                //裁剪大小
                .cropSize(1, 1, 200, 200)
                .build();

        MediaSelectorManager.openSelectMediaWithConfig(DeviceDetailActivity.this, config, new OnSelectMediaListener() {
            @Override
            public void onSelectMedia(List<String> li_path) {
                for (String path : li_path) {
                    showRes(path);
                }
            }
        });
    }
    List<String> stringList=new ArrayList<String>();

    /***
     * 显示到layout中
     * @param path 资源路径地址
     */
    private void showRes(String path) {
         stringList.add(path);

        adapter.notifyDataSetChanged();
    }

    /**
     * 打开照相机
     */
    public void openCamera() {
         DVCameraConfig config = MediaSelectorManager.getDefaultCameraConfigBuilder()
                //是否使用系统照相机（默认使用仿微信照相机）
                .isUseSystemCamera(false)
                //是否需要裁剪
                .needCrop(false)
                //裁剪大小
                .cropSize(1, 1, 200, 200)
                //媒体类型（如果是使用系统照相机，必须指定DVMediaType.PHOTO或DVMediaType.VIDEO）
                .mediaType(DVMediaType.ALL)
                //设置录制时长
                .maxDuration(10)
                .build();

        MediaSelectorManager.openCameraWithConfig(DeviceDetailActivity.this, config, new OnSelectMediaListener() {
            @Override
            public void onSelectMedia(List<String> li_path) {
                for (String path : li_path) {
                    showRes(path);
                }
            }
        });
    }

    /**
     * 选择器加载引擎
     */
    private void initImg() {
        //设置加载器
        MediaSelectorManager.getInstance().initImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, final String path, ImageView imageView) {
                Glide.with(context).load(path).listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.e("sjk","加载失败--》"+e.getMessage() + "\t加载地址-->"+path);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                }).into(imageView);
            }
        });
    }

}
