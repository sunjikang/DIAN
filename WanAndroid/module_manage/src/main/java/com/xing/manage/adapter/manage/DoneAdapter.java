package com.xing.manage.adapter.manage;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.manage.DoneBean;


import java.util.List;

public class DoneAdapter extends BaseQuickAdapter<DoneBean, BaseViewHolder> {

    public DoneAdapter(int layoutResId, @Nullable List<DoneBean> data) {
        super(layoutResId, data);
    }

    public DoneAdapter(@Nullable List<DoneBean> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DoneBean item) {
        helper.setText(R.id.tv_handle_name, item.getName())
                .setText(R.id.tv_handle_pname, "任务：" + item.getProcessName())
                .setText(R.id.tv_handle_applyer, "发起人：" + item.getApplyer())
                .setText(R.id.tv_handle_owner, "委托人：" + item.getOwner())
                .setGone(R.id.tv_handle_owner, !TextUtils.isEmpty(item.getOwner()))
                .setText(R.id.tv_handle_createtime,"创建时间："+item.getCreateTime())
                .addOnClickListener(R.id.btn_change_model)
                .addOnClickListener(R.id.btn_pass)
                .addOnClickListener(R.id.btn_back)
                .addOnClickListener(R.id.btn_edit_history)
                .addOnClickListener(R.id.btn_delete);
        if (item.getPriority() == 0) {
            helper.setText(R.id.tv_handle_priority, "普通")
                    .setTextColor(R.id.tv_handle_priority, mContext.getResources().getColor(R.color.green))
                    .setBackgroundRes(R.id.tv_handle_priority, R.drawable.textview_border_green);
        } else if (item.getPriority() == 1) {
            helper.setText(R.id.tv_handle_priority, "重要")
                    .setTextColor(R.id.tv_handle_priority, mContext.getResources().getColor(R.color.orange))
                    .setBackgroundRes(R.id.tv_handle_priority, R.drawable.textview_border_orange);
        } else if (item.getPriority() == 2) {
            helper.setText(R.id.tv_handle_priority, "紧急")
                    .setTextColor(R.id.tv_handle_priority, mContext.getResources().getColor(R.color.red))
                    .setBackgroundRes(R.id.tv_handle_priority, R.drawable.textview_border_red);
        }
    }
}
