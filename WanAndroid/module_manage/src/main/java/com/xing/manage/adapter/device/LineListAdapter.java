package com.xing.manage.adapter.device;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.device.Line;

import java.util.List;

public class LineListAdapter extends BaseQuickAdapter<Line, BaseViewHolder> {

    public LineListAdapter(int layoutResId, @Nullable List<Line> data) {
        super(layoutResId, data);
    }

    public LineListAdapter(@Nullable List<Line> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Line item) {
        helper.setText(R.id.tv_record_name, item.title)
                .setText(R.id.tv_code, "编号：" + item.lineCode)
                .setText(R.id.tv_creater, "创建者：" + item.createBy)
                .setText(R.id.tv_period, "巡检周期：" + item.inspectionPeriod)
                .setText(R.id.tv_type,"类型：" +item.taskType)

                .addOnClickListener(R.id.btn_upload)
                .addOnClickListener(R.id.btn_history)
                .addOnClickListener(R.id.btn_start_check);
        if (item.isNormal) {
            helper.setText(R.id.tv_state, "正常")
                    .setTextColor(R.id.tv_state, mContext.getResources().getColor(R.color.green))
                    .setBackgroundRes(R.id.tv_state, R.drawable.textview_border_green);
        } else {
            helper.setText(R.id.tv_state, "异常")
                    .setTextColor(R.id.tv_state, mContext.getResources().getColor(R.color.orange))
                    .setBackgroundRes(R.id.tv_state, R.drawable.textview_border_orange);
        }
    }
}
