package com.xing.manage.adapter.manage;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.manage.ProgressManageBean;

import java.util.List;

public class ProgressManageAdapter extends BaseQuickAdapter<ProgressManageBean, BaseViewHolder> {

    public ProgressManageAdapter(int layoutResId, @Nullable List<ProgressManageBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, ProgressManageBean item) {
        helper.setText(R.id.tv_handle_name, item.getName())
                .setText(R.id.tv_handle_version, "版本：V" + item.getVersion())
                .setText(R.id.tv_handle_category, "所属分类：" + item.getCategoryId())
                .setText(R.id.tv_handle_state, "状态：" + item.getStatus())
                .addOnClickListener(R.id.btn_is_suspend)
                .addOnClickListener(R.id.btn_progress_distribution)
                .addOnClickListener(R.id.btn_change_model)
                .addOnClickListener(R.id.btn_delete);

    }
}
