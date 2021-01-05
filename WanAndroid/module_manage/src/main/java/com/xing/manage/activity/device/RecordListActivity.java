package com.xing.manage.activity.device;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.android.arouter.facade.annotation.Route;

import com.xing.commonbase.base.BaseActivity;
import com.xing.manage.R;

import com.xing.manage.adapter.device.RecordListAdapter;

import com.xing.manage.bean.device.Line;
import com.xing.manage.bean.device.Record;
import com.xing.manage.db.DbManager;
import com.xing.manage.db.RecordDao;


import java.util.ArrayList;

@Route(path = "/manage/device/RecordListActivity")
public class RecordListActivity  extends BaseActivity {
    long lineId ;//传递过来的bean
    private RecyclerView recyclerView;
    private ArrayList<Record> dataList = new ArrayList<Record>();
    RecordListAdapter adapter;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_linelist;
    }

    @Override
    protected void initView() {
        Toolbar toolbar =findViewById(R.id.toolbar_title);
        toolbar.setTitle("记录列表");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView = findViewById(R.id.rv_todo);
    }

    @Override
    protected void initData() {
        super.initData();
         lineId = this.getIntent().getExtras().getLong("lineId");
        dataList = (ArrayList<Record>) DbManager.getInstance().getRecordDao().queryBuilder().where(RecordDao.Properties.LineId.eq(lineId)).list();
        setAdapte();
    }

    private void showDialog(String title,String strDetail) {
        new MaterialDialog.Builder(this).title(title+"详情").content(strDetail)
                .negativeText("关闭")
                .negativeColor(Color.RED)
                .autoDismiss(true)
                .show();
    }


    private void setAdapte() {
        if (adapter == null) {
            adapter = new RecordListAdapter(R.layout.item_record,dataList);
            final LinearLayoutManager manager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setNewData(dataList);
        }
    }


}
