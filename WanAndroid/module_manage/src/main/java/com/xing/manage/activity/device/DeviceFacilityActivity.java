package com.xing.manage.activity.device;

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
import com.xing.manage.adapter.device.DeviceFacilityAdapter;
import com.xing.manage.bean.device.Facility;
import com.xing.manage.bean.device.Inspection;
import com.xing.manage.db.DbManager;
import com.xing.manage.db.FacilityDao;
import com.xing.manage.db.InspectionDao;

import java.util.List;

@Route(path = "/manage/device/DeviceFacilityActivity")
public class DeviceFacilityActivity extends BaseActivity  {
    private RecyclerView recyclerView;
    private DeviceFacilityAdapter adapter;
    private List<Facility> list;


     @Override
    protected int getLayoutResId() {
        return R.layout.activity_device_area;
    }





      @Override
    protected void initView() {
          StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);

          Toolbar toolbar=findViewById(R.id.toolbar_title);
          toolbar.setTitle("设备管理");
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

        long id = DeviceFacilityActivity.this.getIntent().getLongExtra("id",0);
          list= DbManager.getInstance().getFacilityDao().queryBuilder().where(FacilityDao.Properties.AreaId.eq(id)).list();;
         if(adapter==null){
            adapter= new DeviceFacilityAdapter(R.layout.item_common_device,list);
        }else{
            adapter.setNewData(list);
        }
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                gotoDeviceInspectionActivity(list.get(position).id);
            }
        });

      }

    private void gotoDeviceInspectionActivity(Long id) {
        List<Inspection> list = DbManager.getInstance().getInspectionDao().queryBuilder().where(InspectionDao.Properties.FacilityId.eq(id)).list();

          if (list!=null&&list.size()>0){

             ARouter.getInstance().build("/manage/device/DeviceInspectionActivity").withLong("id",id).navigation();
         }

    }


}
