package com.xing.manage.adapter.device;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.device.Record;

import java.text.SimpleDateFormat;
import java.util.List;

public class RecordListAdapter extends BaseQuickAdapter<Record, BaseViewHolder> {

    public RecordListAdapter(int layoutResId, @Nullable List<Record> data) {
        super(layoutResId, data);
    }

    public RecordListAdapter(@Nullable List<Record> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Record item) {

        helper.setText(R.id.tv_record_name, item.inspectionName)
                .setText(R.id.tv_line, "线路：" + item.lineName)
                .setText(R.id.tv_area, "区域：" + item.areaName)
                .setText(R.id.tv_facility, "设备：" + item.facilityName)
                .setText(R.id.tv_start,"开始时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(item.startTime))
                .setText(R.id.tv_end,"结束时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(item.endTime))
                .setText(R.id.tv_type,"类型：" +item.pollingType)
                .setText(R.id.tv_remark,"备注：" +item.remark)

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

        if (item.observedValue!=null){
            helper.setGone(R.id.tv_check_value,true);
        }else{
            helper.setText(R.id.tv_check_value,"检测结果：" +item.observedValue);

        }

        if (item.isUploaded){
            helper.setText(R.id.upload_state,"上传状态：已上传");
        }else{
            helper.setText(R.id.upload_state,"上传状态：未上传");

        }
    }
}
