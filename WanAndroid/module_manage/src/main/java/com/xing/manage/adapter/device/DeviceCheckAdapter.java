package com.xing.manage.adapter.device;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.device.Line;
import com.xing.manage.bean.manage.ProgressManageBean;

import java.util.List;

public class DeviceCheckAdapter extends BaseQuickAdapter<Line, BaseViewHolder> {

    public DeviceCheckAdapter(int layoutResId, @Nullable List<Line> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Line item) {
        if (item.startStatus.equals("启用")){
            helper.setText(R.id.button,"正常");
            helper.setBackgroundRes(R.id.imageview2,R.drawable.btn_bg_green);
            helper.setBackgroundRes(R.id.button,R.drawable.btn_bg_green);
        }else{
            helper.setText(R.id.button,"异常");
            helper.setBackgroundRes(R.id.imageview2,R.drawable.btn_bg_red);
            helper.setBackgroundRes(R.id.button,R.drawable.btn_bg_red);
        }
        helper.setText(R.id.textView, item.lineName)
                .setText(R.id.textView12, "" + item.lineName)
                .setText(R.id.textView9, "" + item.lineCode)
                .setText(R.id.textView10, "" + item.createBy)
                .setText(R.id.textView3, "" + item.createTime)
                .setText(R.id.textView14, "" + item.updateTime);
     }
}
