package com.xing.manage.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.xing.commonbase.base.BaseActivity;
import com.xing.commonbase.util.StatusBarUtil;
import com.xing.manage.R;

@Route(path = "/manage/ShowPhotoActivity")
public class ShowPhotoActivity extends BaseActivity   {

    @Autowired(name = "imgurl")
    public String imgurl;

    private PhotoView iv_img;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_big_photo;
    }

    private PhotoView iv_photo;
     @Override
    protected void initView() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        Toolbar toolbar=findViewById(R.id.toolbar_title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPhotoActivity.this.finish();
            }
        });

        iv_img=findViewById(R.id.iv_photo);
     }



    @Override
    protected void initData() {
        super.initData();
        ARouter.getInstance().inject(this);
        String url=imgurl;
        Glide.with(ShowPhotoActivity.this).load(imgurl).into(iv_img)   ;

     }









}
