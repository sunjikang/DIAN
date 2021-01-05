package com.xing.module.quality.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.module.quality.R;
import com.xing.module.quality.bean.Plan;
import com.xing.module.quality.bean.PlanMonth;

import java.util.List;

public class PlanMonthAdapter extends BaseItemDraggableAdapter<PlanMonth, BaseViewHolder> {


    public PlanMonthAdapter(int layoutResId, @Nullable List<PlanMonth> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PlanMonth item) {
        helper.setText(R.id.item_plan_count, item.getPlanCount() + "");
        helper.setText(R.id.item_plan_month, item.getMonth());
    }
}