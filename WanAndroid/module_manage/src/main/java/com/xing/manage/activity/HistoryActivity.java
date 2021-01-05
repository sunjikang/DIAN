package com.xing.manage.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xing.commonbase.base.BaseMVPActivity;
import com.xing.commonbase.util.StatusBarUtil;
import com.xing.manage.R;
import com.xing.manage.adapter.manage.HistoryAdapter;
import com.xing.manage.adapter.manage.ProgressManageAdapter;
import com.xing.manage.bean.manage.HistoryBean;
import com.xing.manage.bean.manage.ProgressManageBean;
import com.xing.manage.contract.HistoryContract;
import com.xing.manage.presenter.HistoryPresenter;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/manage/HistoryActivity")
public class HistoryActivity extends BaseMVPActivity<HistoryPresenter> implements HistoryContract.View,View.OnClickListener {
    private RecyclerView recyclerView;
    private ArrayList<HistoryBean> dataList = new ArrayList<HistoryBean>();
    private HistoryAdapter adapter;
    private RefreshLayout refreshLayout;

    @Autowired(name = "procInstId")
    public String procInstId;
    private ImageView iv_img;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_manage_history;
    }

      @Override
    protected void initView() {
         StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        Toolbar toolbar=findViewById(R.id.toolbar_title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoryActivity.this.finish();
            }
        });

         iv_img=findViewById(R.id.imageView6);
         iv_img.setOnClickListener(this);

          refreshLayout = findViewById(R.id.srl_todo);
          recyclerView = findViewById(R.id.rv_todo);
          recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
              @Override
              public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                  presenter.getHistory(procInstId);
              }
          });


    }


    String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606020113167&di=e5774e1f7da2d5f5ee3098e0ecc8b687&imgtype=0&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D2186941715%2C2541343206%26fm%3D214%26gp%3D0.jpg";

    @Override
    protected void initData() {
        super.initData();
        ARouter.getInstance().inject(this);
        presenter.getHistory(procInstId);
        Glide.with(HistoryActivity.this).load(url).into(iv_img);

      }


    @Override
    protected HistoryPresenter createPresenter() {
        return new HistoryPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        refreshLayout.finishLoadMore();

    }
    @Override
    public void getHistory(List<HistoryBean> bean) {

        refreshLayout.finishRefresh();
        if (adapter == null) {
            adapter = new HistoryAdapter(R.layout.item_history, bean);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setNewData(bean);
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imageView6){
           gotoShowPhotoActivity();
           // presenter.getHistory(procInstId);
        }
    }

    private void gotoShowPhotoActivity() {
        ARouter.getInstance()
                .build("/manage/ShowPhotoActivity")
                .withString("imgurl",url)
                .navigation();
    }
}
