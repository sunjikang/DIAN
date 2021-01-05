package com.xing.module.quality.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xing.commonbase.base.BaseActivity;
import com.xing.commonbase.base.BaseMVPActivity;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.NetworkUtil;
import com.xing.commonbase.util.SharedPreferenceUtil;
import com.xing.commonbase.util.ToastUtil;
import com.xing.commonbase.widget.loading.ProgressDialog;
import com.xing.module.quality.R;
import com.xing.module.quality.adapter.QCRecordAdapter;
import com.xing.module.quality.adapter.QCRecordImageAdapter;
import com.xing.module.quality.bean.AppInfo;
import com.xing.module.quality.bean.QCRecord;
import com.xing.module.quality.contract.QualityContract;
import com.xing.module.quality.db.DbManager;
import com.xing.module.quality.presenter.QualityPresenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Route(path = "/quality/QualityListActivity")
public class QualityListActivity extends BaseMVPActivity<QualityPresenter> implements QualityContract.View, View.OnClickListener {

    private Toolbar toolbar;
    private TextView toolbarTitle;

    private RecyclerView recyclerQualtiy;
    private QCRecordAdapter qcRecordAdapter;
    private List<QCRecord> qcRecordList;
    private LinearLayout layoutBotton;
    private TextView allchexbox;
    private TextView nochexbox;
    private TextView delete;
    private TextView upload;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_quality_list;
    }

    @Override
    protected QualityPresenter createPresenter() {
        return new QualityPresenter();
    }

    @Override
    protected void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.quality_list_title);
        //初始化列表
        recyclerQualtiy = findViewById(R.id.recycler_qualtiy);
        recyclerQualtiy.setLayoutManager(new LinearLayoutManager(this));
        qcRecordList = new ArrayList<>();
        qcRecordAdapter = new QCRecordAdapter(R.layout.item_quality, qcRecordList);
        qcRecordAdapter.setOnItemClickListener(itemClickListener);
        recyclerQualtiy.setAdapter(qcRecordAdapter);

        layoutBotton = findViewById(R.id.layout_botton);
        layoutBotton.setVisibility(View.GONE);
        allchexbox = findViewById(R.id.allchexbox);
        nochexbox = findViewById(R.id.nochexbox);
        delete = findViewById(R.id.delete);
        upload = findViewById(R.id.upload);
        allchexbox.setOnClickListener(this);
        nochexbox.setOnClickListener(this);
        delete.setOnClickListener(this);
        upload.setOnClickListener(this);
    }

    BaseQuickAdapter.OnItemClickListener itemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            if (qcRecordAdapter.isEdit()) {
                QCRecord qcRecord = qcRecordList.get(position);
                qcRecord.setCheck(!qcRecord.isCheck());
                qcRecordList.set(position, qcRecord);
                qcRecordAdapter.notifyItemChanged(position);
            }
        }
    };

    @Override
    protected void initData() {
        super.initData();
        qcRecordList = DbManager.getInstance().getQCRecordDao().loadAll();
        qcRecordAdapter.replaceData(qcRecordList);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.allchexbox) {
            for (QCRecord qcRecord : qcRecordList) {
                qcRecord.setCheck(true);
            }
            qcRecordAdapter.notifyDataSetChanged();
        } else if (v.getId() == R.id.nochexbox) {
            for (QCRecord qcRecord : qcRecordList) {
                qcRecord.setCheck(false);
            }
            qcRecordAdapter.notifyDataSetChanged();
        } else if (v.getId() == R.id.delete) {
            List<QCRecord> list = new LinkedList<>();
            for (QCRecord qcRecord : qcRecordList) {
                if (qcRecord.isCheck()) {
                    list.add(qcRecord);
                }
            }
            DbManager.getInstance().getQCRecordDao().deleteInTx(list);
            qcRecordAdapter.replaceData(DbManager.getInstance().getQCRecordDao().loadAll());
        } else if (v.getId() == R.id.upload) {
            List<QCRecord> list = new ArrayList<>();
            for (QCRecord qcRecord : qcRecordList) {
                if (qcRecord.isCheck() && qcRecord.getIsUpload().equals("0")) {
                    list.add(qcRecord);
                }
            }
            if (NetworkUtil.isNetworkAvailable(this)) {
                presenter.doSubmit(list);
            } else {
                ToastUtil.show(this, "网络连接不可用，请检查网络");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_quality_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == android.R.id.home) {
            finish();
            return true;
        } else if (i == R.id.action_edit) {
            if (qcRecordAdapter.isEdit()) {
                qcRecordAdapter.setEdit(false);
                layoutBotton.setVisibility(View.GONE);
            } else {
                qcRecordAdapter.setEdit(true);
                layoutBotton.setVisibility(View.VISIBLE);
            }
            qcRecordAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSubmitSuccess(List<QCRecord> list) {
        for (QCRecord qcRecord : list) {
            qcRecord.setIsUpload("1");
            DbManager.getInstance().getQCRecordDao().insertOrReplace(qcRecord);
        }
        qcRecordAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCheckVersionSuccess(AppInfo appInfo) {

    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }
}
