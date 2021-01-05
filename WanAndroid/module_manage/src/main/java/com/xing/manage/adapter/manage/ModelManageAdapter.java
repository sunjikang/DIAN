package com.xing.manage.adapter.manage;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.manage.ModelManageBean;

import java.util.List;

public class ModelManageAdapter extends BaseQuickAdapter<ModelManageBean, BaseViewHolder> {

    public ModelManageAdapter(int layoutResId, @Nullable List<ModelManageBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, ModelManageBean item) {
        helper.setText(R.id.tv_handle_name, item.getName())
                 .setText(R.id.tv_handle_version, "版本：V" + item.getVersion())
                .setText(R.id.tv_handle_category, "申请人：" + item.getCreateTime())
                .setText(R.id.tv_handle_state, "审批结果：" + item.getUpdateTime())
                .addOnClickListener(R.id.btn_is_suspend)
                .addOnClickListener(R.id.btn_progress_distribution)
                .addOnClickListener(R.id.btn_change_model)
                .addOnClickListener(R.id.btn_delete);

    }
}
