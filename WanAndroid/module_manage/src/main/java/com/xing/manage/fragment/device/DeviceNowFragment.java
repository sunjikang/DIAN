package com.xing.manage.fragment.device;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.utils.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.devil.library.media.MediaSelectorManager;
import com.devil.library.media.common.ImageLoader;
import com.devil.library.media.config.DVCameraConfig;
import com.devil.library.media.config.DVListConfig;
import com.devil.library.media.enumtype.DVMediaType;
import com.devil.library.media.listener.OnSelectMediaListener;
import com.xing.commonbase.base.BaseMVPFragment;
import com.xing.commonbase.mvp.IPresenter;
import com.xing.commonbase.util.ToastUtil;
import com.xing.manage.R;
import com.xing.manage.db.CheckNow;
import com.xing.manage.db.CheckNowDao;
import com.xing.manage.db.DbManager;
import com.xing.manage.db.Resource;
import com.xing.manage.db.ResourceDao;
import com.zyyoona7.popup.EasyPopup;
import com.zyyoona7.popup.XGravity;
import com.zyyoona7.popup.YGravity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DeviceNowFragment extends BaseMVPFragment implements  View.OnClickListener {


    public DeviceNowFragment() {

    }

    @Override
     protected int getLayoutResId() {
        return R.layout.fragment_check_now;
    }
     private Button btn2;
     private Button btn3;
      private Button btn6;
     private TextView tvResult;
     private TextInputEditText tie_0;
     private TextInputEditText tie_4;
     private TextInputEditText tie_5;
     private TextInputEditText tie_6;
     private TextInputEditText tie_7;
     private ImageView iv_result1;
     private ImageView iv_result2;
     private ImageView iv_result3;
     private ImageView iv_result4;
     private ImageView iv_result5;
     private ImageView iv_result6;
     private ImageView iv_result7;
     private ImageView iv_result8;
     private ImageView iv_result9;
     List<ImageView> imageViewList=new ArrayList<ImageView>();
       private ConstraintLayout constraintLayout;
    @Override
    protected void initView(View rootView) {
        tvResult=rootView.findViewById(R.id.textView7);
         tie_0=rootView.findViewById(R.id.textinputedittext3);
         tie_4=rootView.findViewById(R.id.textinputedittext4);
         tie_5=rootView.findViewById(R.id.textinputedittext5);
         tie_6=rootView.findViewById(R.id.textinputedittext6);
         tie_7=rootView.findViewById(R.id.textinputedittext7);
         btn2=   rootView.findViewById(R.id.button2);
         btn3=   rootView.findViewById(R.id.button3);

         btn6=   rootView.findViewById(R.id.button6);
          btn2.setOnClickListener(this);
         btn3.setOnClickListener(this);

         btn6.setOnClickListener(this);
        constraintLayout=rootView.findViewById(R.id.constraintLayout);
        iv_result1=rootView.findViewById(R.id.iv_result1);
        iv_result2=rootView.findViewById(R.id.iv_result2);
        iv_result3=rootView.findViewById(R.id.iv_result3);
        iv_result4=rootView.findViewById(R.id.iv_result4);
        iv_result5=rootView.findViewById(R.id.iv_result5);
        iv_result6=rootView.findViewById(R.id.iv_result6);
        iv_result7=rootView.findViewById(R.id.iv_result7);
        iv_result8=rootView.findViewById(R.id.iv_result8);
        iv_result9=rootView.findViewById(R.id.iv_result9);
        imageViewList.add(iv_result1);
        imageViewList.add(iv_result2);
        imageViewList.add(iv_result3);
        imageViewList.add(iv_result4);
        imageViewList.add(iv_result5);
        imageViewList.add(iv_result6);
        imageViewList.add(iv_result7);
        imageViewList.add(iv_result8);
        imageViewList.add(iv_result9);
      }

    @Override
    protected void initData() {
        initImg();
    }

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected IPresenter createPresenter() {
        return null;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }




    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button2){
             showpopupwindow();
        }
       else if (v.getId()==R.id.button3){
            showPupToSelectPhoto();


        }else if(v.getId()==R.id.button6){
            //todo 保存巡检任务
            savaData();
        }
    }

    private void showPupToSelectPhoto() {
        mCirclePop = EasyPopup.create()
                .setContentView(getActivity(), R.layout.popup_select_photo)
                //是否允许点击PopupWindow之外的地方消失
                .setFocusAndOutsideEnable(true)
                //允许背景变暗
                .setBackgroundDimEnable(true)
                //变暗的透明度(0-1)，0为完全透明
                .setDimValue(0.4f)
                //变暗的背景颜色
                .setDimColor(Color.GRAY)
                //指定任意 ViewGroup 背景变暗
                .setDimView(constraintLayout)
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


    private EasyPopup mCirclePop;

    private void showpopupwindow() {
        mCirclePop = EasyPopup.create()
                .setContentView(getActivity(), R.layout.popup_check_type)
                 //是否允许点击PopupWindow之外的地方消失
                .setFocusAndOutsideEnable(true)
                //允许背景变暗
                .setBackgroundDimEnable(true)
                //变暗的透明度(0-1)，0为完全透明
                .setDimValue(0.4f)
                //变暗的背景颜色
                .setDimColor(Color.GRAY)
                //指定任意 ViewGroup 背景变暗
                .setDimView(constraintLayout)
                .apply();
        mCirclePop.showAtAnchorView(btn2, YGravity.CENTER, XGravity.RIGHT, 0, 0);
        mCirclePop.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCirclePop.dismiss();
                ToastUtil.show(getContext(),"温度");
                btn2.setText("测量");
             }
        });
        mCirclePop.findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCirclePop.dismiss();
                ToastUtil.show(getContext(),"加速度");
                btn2.setText("加速度");

            }
        });
        mCirclePop.findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCirclePop.dismiss();
                ToastUtil.show(getContext(),"速度");
                btn2.setText("速度");

            }
        });
        mCirclePop.findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCirclePop.dismiss();
                ToastUtil.show(getContext(),"位移");
                btn2.setText("位移");

            }
        });
        mCirclePop.findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCirclePop.dismiss();
                ToastUtil.show(getContext(),"转速");
                btn2.setText("转速");

            }
        });
    }
    /**保存资源的本地url*/
    List<String> stringList=new ArrayList<String>();
    private void savaData() {
        String s7 = getStringToView(tie_7,"具体数值");
        String s6 =getStringToView(tie_6,"巡检项名称");
        String s5 = getStringToView(tie_5,"设备KKS码");
        String s4 = getStringToView(tie_4,"部门名称");
        String s = getStringToView(tie_0,"设备所属机组");


        CheckNow checkNow=new CheckNow();
        List<Resource> resourceList=new ArrayList<Resource>();
        CheckNowDao checkNowDao = DbManager.getInstance().getCheckNowDao();
        ResourceDao resourceDao = DbManager.getInstance().getResourceDao();

        checkNow.setDeviceGroup(s);
        checkNow.setDepartmentName(s4);
        checkNow.setDeviceKKS(s5);
        checkNow.setCheckName(s6);
        checkNow.setCheckName(s7);
        checkNowDao.insert(checkNow);
        if(stringList!=null){
            for (int i = 0; i <stringList.size() ; i++) {
                Resource resource = new Resource();
                resource.setUrl(stringList.get(i));
                resource.setIsUpdate(false);
                resource.setCheckId(checkNow.getId());
                resourceDao.insert(resource);
            }
        }
        ToastUtil.show(getContext(),"保存成功");
     }

    private String getStringToView(TextInputEditText view,String msg) {
        String s = view.getText().toString().trim();
        if (TextUtils.isEmpty(s)) {
            ToastUtil.show(getContext(), msg+"没有填写");

            return "";
        }else{
            return s;

        }
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    /**
     * 多选视频快速加载测试
     */
    public void selectVideos(){
          new Thread(new Runnable() {
            @Override
            public void run() {
                 getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //这里才是开始调用
                        DVListConfig config = MediaSelectorManager.getDefaultListConfigBuilder()
                                .mediaType(DVMediaType.VIDEO)
                                .quickLoadVideoThumb(true)
                                .hasPreview(true).build();
                        //打开界面
                        MediaSelectorManager.openSelectMediaWithConfig(getActivity(),config, new OnSelectMediaListener() {
                            @Override
                            public void onSelectMedia(List<String> li_path) {
                                for (String path : li_path) {
                                    tvResult.append(path + "\n");
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
     * 单选
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

        MediaSelectorManager.openSelectMediaWithConfig(getActivity(), config, new OnSelectMediaListener() {
            @Override
            public void onSelectMedia(List<String> li_path) {
                for (String path : li_path) {
                    showRes(path);
                }
            }
        });
    }

    /***
     * 显示到layout中
     * @param path 资源路径地址
     */
    private void showRes(String path) {
        tvResult.append(path + "\n");
        stringList.add(path);
        for (int i = 0; i <stringList.size() ; i++) {
            imageViewList.get(i).setVisibility(View.VISIBLE);

            Glide
                    .with( getActivity() )
                    .load( Uri.fromFile( new File( stringList.get(i) ) ) )
                    .into(  imageViewList.get(i));
         }

    }

    /**
     * 打开照相机
     */
    public void openCamera() {
        tvResult.setText("");
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

        MediaSelectorManager.openCameraWithConfig(getActivity(), config, new OnSelectMediaListener() {
            @Override
            public void onSelectMedia(List<String> li_path) {
                for (String path : li_path) {
                    showRes(path);
                }
            }
        });
    }
}
