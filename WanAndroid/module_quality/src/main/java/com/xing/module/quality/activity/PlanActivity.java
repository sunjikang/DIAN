package com.xing.module.quality.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.xing.commonbase.base.BaseMVPActivity;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.SharedPreferenceUtil;
import com.xing.commonbase.util.ToastUtil;
import com.xing.commonbase.widget.loading.ProgressDialog;
import com.xing.module.quality.R;
import com.xing.module.quality.adapter.PlanDialogAdapter;
import com.xing.module.quality.adapter.PlanMonthAdapter;
import com.xing.module.quality.bean.Plan;
import com.xing.module.quality.bean.PlanMonth;
import com.xing.module.quality.contract.PlanContract;
import com.xing.module.quality.db.DbManager;
import com.xing.module.quality.db.PlanMonthDao;
import com.xing.module.quality.presenter.PlanPresenter;
import com.xing.module.quality.view.numberbutton.NumberButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Route(path = "/quality/PlanActivity")
public class PlanActivity extends BaseMVPActivity<PlanPresenter> implements PlanContract.View, View.OnClickListener {

    private Toolbar toolbar;
    private TextView toolbarTitle;
    private RecyclerView recyclerPlan;
    private PlanMonthAdapter planMonthAdapter;
    private List<PlanMonth> planMonthList;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_plan;
    }

    @Override
    protected PlanPresenter createPresenter() {
        return new PlanPresenter();
    }

    @Override
    protected void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.plan_title);
        recyclerPlan = findViewById(R.id.recycler_plan);
    }


    @Override
    protected void initData() {
        super.initData();
        toolbarTitle.setText("五厂");
        //初始化列表
        initRecyclerView();
        planMonthAdapter.replaceData(DbManager.getInstance().getPlanMonthDao().queryBuilder().orderAsc(PlanMonthDao.Properties.Month).list());
        Log.e("TAG", "初始化size:" + planMonthList.size());
    }


    private void initRecyclerView() {

        recyclerPlan.setLayoutManager(new LinearLayoutManager(this));
        planMonthList = new ArrayList<>();
        planMonthAdapter = new PlanMonthAdapter(R.layout.item_plan, planMonthList);
        planMonthAdapter.setOnItemClickListener(itemClickListener);
        planMonthAdapter.setOnItemLongClickListener(itemLongClickListener);
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(planMonthAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(recyclerPlan);
        recyclerPlan.setAdapter(planMonthAdapter);
    }

    BaseQuickAdapter.OnItemClickListener itemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        }
    };
    BaseQuickAdapter.OnItemLongClickListener itemLongClickListener = new BaseQuickAdapter.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
            showDeleteDialog(position);
            return false;
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_plan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == android.R.id.home) {
            finish();
            return true;
        } else if (i == R.id.action_settings) {
            shouwCostomDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    AlertDialog alertDialog;

    private void shouwCostomDialog() {
        if (null == alertDialog) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = LayoutInflater.from(this);
            View layout = inflater.inflate(R.layout.dialog_calendar, null);
            builder.setCustomTitle(layout);
            alertDialog = builder.create();
            final NumberButton number = layout.findViewById(R.id.dialog_calendar_number);
            RecyclerView recyclerView = layout.findViewById(R.id.dialog_calendar_recycler);
            //年
            number.setCurrentNumber(Calendar.getInstance().get(Calendar.YEAR));
            number.setBuyMax(3000)
                    .setInventory(3000)
                    .setCurrentNumber(Calendar.getInstance().get(Calendar.YEAR));
            //12个月
            String[] items = new String[]{"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};
            List<String> list = Arrays.asList(items);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
            PlanDialogAdapter planDialogAdapter = new PlanDialogAdapter(R.layout.item_calendar_month, list);
            planDialogAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    String sub = position > 8 ? "" : "0";
                    String month = number.getNumber() + "-" + sub + (position + 1);
                    List<PlanMonth> lsit = DbManager.getInstance().getPlanMonthDao().queryBuilder().where(PlanMonthDao.Properties.Month.eq(month)).list();
                    if (lsit != null && lsit.size() > 0) {
                        showUpdateDialog(month);
                    } else {
                        String url = SharedPreferenceUtil.read(Constants.USER_LOGIN, Constants.URL, "");
                        presenter.getPlanByMonth(url, month);
                    }
                    alertDialog.dismiss();
                }
            });
            recyclerView.setAdapter(planDialogAdapter);
            alertDialog.show();
        } else {
            alertDialog.show();
        }
    }

    private void showUpdateDialog(final String month) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage(month + "计划单已获取，是否更新本地数据");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String url = SharedPreferenceUtil.read(Constants.USER_LOGIN, Constants.URL, "");
                presenter.getPlanByMonth(url, month);
            }
        });
        builder.show();
    }

    private void showDeleteDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("是否要删除这条数据");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PlanMonth planMonth = planMonthList.get(position);
                //删除月
                DbManager.getInstance().getPlanMonthDao().delete(planMonth);
                //删除子集
                List<Plan> list = DbManager.getInstance().getPlanDao()._queryPlanMonth_PlanList(planMonth.getId());
                for (Plan plan : list) {
                    DbManager.getInstance().getPlanDao().delete(plan);
                }
                //删除view
                planMonthAdapter.remove(position);
            }
        });
        builder.show();
    }

    @Override
    public void getPlanByMonth(List<Plan> data, String month) {
        if (data != null && data.size() > 0) {
            List<PlanMonth> planMonthList = DbManager.getInstance().getPlanMonthDao().queryBuilder().where(PlanMonthDao.Properties.Month.eq(month)).list();
            if (planMonthList != null && planMonthList.size() > 0) {
                PlanMonth planMonth = planMonthList.get(0);
                //更新月
                planMonth.setPlanCount(data.size());
                DbManager.getInstance().getPlanMonthDao().insertOrReplace(planMonth);
                //更新子集
                for (Plan plan : data) {
                    plan.setMonthId(planMonth.getId());
                    DbManager.getInstance().getPlanDao().insertOrReplace(plan);
                }
            } else {
                //保存月
                PlanMonth planMonth = new PlanMonth(null, month, data.size());
                DbManager.getInstance().getPlanMonthDao().insertOrReplace(planMonth);
                //保存子集
                List<Plan> list = DbManager.getInstance().getPlanDao()._queryPlanMonth_PlanList(planMonth.getId());
                DbManager.getInstance().getPlanDao().deleteInTx(list);
                for (Plan plan : data) {
                    plan.setMonthId(planMonth.getId());
                }
                DbManager.getInstance().getPlanDao().insertInTx(data);
            }
            planMonthAdapter.replaceData(DbManager.getInstance().getPlanMonthDao().queryBuilder().orderAsc(PlanMonthDao.Properties.Month).list());
        } else {
            ToastUtil.show(this, "该月数据为空");
        }
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
