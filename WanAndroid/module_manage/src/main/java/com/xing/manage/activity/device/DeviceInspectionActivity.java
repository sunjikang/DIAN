package com.xing.manage.activity.device;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xing.commonbase.base.BaseActivity;
import com.xing.commonbase.util.StatusBarUtil;
import com.xing.manage.R;
import com.xing.manage.adapter.device.DeviceInspectionAdapter;
import com.xing.manage.bean.device.Inspection;
import com.xing.manage.db.DbManager;
import com.xing.manage.db.InspectionDao;

import java.util.List;

@Route(path = "/manage/device/DeviceInspectionActivity")
public class DeviceInspectionActivity extends BaseActivity  {
    private RecyclerView recyclerView;
    private DeviceInspectionAdapter adapter;
    private List<Inspection> list;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_device_area;
    }





    @Override
    protected void initView() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);

        Toolbar toolbar=findViewById(R.id.toolbar_title);
        toolbar.setTitle("检查项管理");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView=findViewById(R.id.rv_content);

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }

    @Override
    protected void initData() {
        super.initData();

        Long id = DeviceInspectionActivity.this.getIntent().getLongExtra("id",0);
        list=DbManager.getInstance().getInspectionDao().queryBuilder().where(InspectionDao.Properties.FacilityId.eq(id)).list();

        if(adapter==null){
            adapter= new DeviceInspectionAdapter(R.layout.item_common_device,list);
        }else{
            adapter.setNewData(list);
        }
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                gotoDeviceDetailActivity(list.get(position));
            }
        });

    }

    private void gotoDeviceDetailActivity(Inspection bean) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("bean",bean);
        ARouter.getInstance().build("/manage/device/DeviceDetailActivity").with(bundle).navigation();
    }


}
