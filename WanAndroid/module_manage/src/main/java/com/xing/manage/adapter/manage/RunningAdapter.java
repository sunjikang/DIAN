package com.xing.manage.adapter.manage;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.manage.RunningBean;

import java.util.List;

public class RunningAdapter extends BaseQuickAdapter<RunningBean, BaseViewHolder> {

    public RunningAdapter(int layoutResId, @Nullable List<RunningBean> data) {
        super(layoutResId, data);
    }

    public RunningAdapter(@Nullable List<RunningBean> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RunningBean item) {
        helper.setText(R.id.tv_handle_name, item.getName())
                .setText(R.id.tv_handle_id, "流程ID：" + item.getId())
                .setText(R.id.tv_handle_version, "版本：V" + item.getVersion())
                .setText(R.id.tv_handle_applyer, "申请人：" + item.getApplyer())
                .setText(R.id.tv_handle_category, "当前环节：" + item.getCurrTaskName())

                 .addOnClickListener(R.id.btn_suspend)
                .addOnClickListener(R.id.btn_progress_distribution)
                .addOnClickListener(R.id.btn_change_model)
                 .addOnClickListener(R.id.btn_delete);

            if(item.getSuspended()){
                helper.setText(R.id.tv_handle_state,"状态：已挂起");
            }else{
                helper.setText(R.id.tv_handle_state,"状态：已激活");
            }

    }
}
