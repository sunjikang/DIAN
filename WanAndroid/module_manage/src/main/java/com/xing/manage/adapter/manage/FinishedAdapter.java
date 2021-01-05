package com.xing.manage.adapter.manage;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.manage.FinishedBean;

import java.util.List;

public class FinishedAdapter extends BaseQuickAdapter<FinishedBean, BaseViewHolder> {

    public FinishedAdapter(int layoutResId, @Nullable List<FinishedBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, FinishedBean item) {
        helper.setText(R.id.tv_handle_name, item.getName())
                .setText(R.id.tv_handle_id, "流程ID：" + item.getId())
                .setText(R.id.tv_handle_version, "版本：V" + item.getVersion())
                .setText(R.id.tv_handle_applyer, "申请人：" + item.getApplyer())
                .setText(R.id.tv_handle_category, "审批结果：" + item.getResult())

                 .addOnClickListener(R.id.btn_progress_distribution)
                .addOnClickListener(R.id.btn_change_model)
                .addOnClickListener(R.id.btn_delete);

    }
}
