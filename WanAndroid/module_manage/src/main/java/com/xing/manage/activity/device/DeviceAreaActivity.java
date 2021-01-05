package com.xing.manage.activity.device;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xing.commonbase.base.BaseActivity;
import com.xing.commonbase.util.StatusBarUtil;
import com.xing.manage.R;
import com.xing.manage.adapter.device.DeviceAreaAdapter;
import com.xing.manage.bean.device.Area;
import com.xing.manage.bean.device.Facility;
import com.xing.manage.db.AreaDao;
import com.xing.manage.db.DbManager;
import com.xing.manage.db.FacilityDao;

import java.util.List;

@Route(path = "/manage/device/DeviceAreaActivity")
public class DeviceAreaActivity extends BaseActivity  {
    private RecyclerView recyclerView;
    private DeviceAreaAdapter adapter;
    private List<Area> list;


     @Override
    protected int getLayoutResId() {
        return R.layout.activity_device_area;
    }





      @Override
    protected void initView() {
          StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);

          Toolbar toolbar=findViewById(R.id.toolbar_title);
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

        Long lineId = DeviceAreaActivity.this.getIntent().getLongExtra("id",0);
        List<Area> list = DbManager.getInstance().getAreaDao().queryBuilder().where(AreaDao.Properties.LineId.eq(lineId)).list();
         this.list =list;
        Log.e("sjk", this.list.toString());
        if(adapter==null){
            adapter= new DeviceAreaAdapter(R.layout.item_common_device, this.list);
        }else{
            adapter.setNewData(this.list);
        }
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                 gotoDeviceFacilityActivity(DeviceAreaActivity.this.list.get(position).id);
            }
        });

      }

    private void gotoDeviceFacilityActivity(Long id) {
        List<Facility> list = DbManager.getInstance().getFacilityDao().queryBuilder().where(FacilityDao.Properties.AreaId.eq(id)).list();
        if (list!=null&&list.size()>0){
              ARouter.getInstance().build("/manage/device/DeviceFacilityActivity").withLong("id",id).navigation();
         }

    }
}
