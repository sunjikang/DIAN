package com.xing.manage.adapter.manage;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.manage.HistoryBean;
import com.xing.manage.bean.manage.ProgressManageBean;
import com.xing.manage.util.TimeUtil;

import java.sql.Time;
import java.util.List;

public class HistoryAdapter extends BaseQuickAdapter<HistoryBean, BaseViewHolder> {

    public HistoryAdapter(int layoutResId, @Nullable List<HistoryBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, HistoryBean item) {
        StringBuffer stringBuffer=new StringBuffer();
        if(item.assignees!=null&&item.assignees.size()>0){
            for (HistoryBean.Assignee assignee:item.assignees) {
                stringBuffer.append(assignee.nickname==null?"":assignee.nickname+"  ");
                helper.setText(R.id.tv_history_assignees, stringBuffer.toString());
            }
        }

        String durationTime ="";
        if(item.duration!=null){
            durationTime = TimeUtil.formatDateTime(Long.valueOf(item.duration));
        }

        helper.setText(R.id.tv_history_taskname,item.name+"" )
                .setText(R.id.tv_history_operation, ""+item.priority+"")
                .setText(R.id.tv_comment,  item.comment+"")
                .setText(R.id.tv_history_duration,  durationTime)
                .setText(R.id.tv_history_create_time,  item.createTime+"")
                .setText(R.id.tv_history_end_time,  item.endTime+"");

    }
}
