package com.xing.manage.adapter.device;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.manage.R;
import com.xing.manage.bean.device.Facility;

import java.util.List;

public class DeviceFacilityAdapter extends BaseQuickAdapter<Facility, BaseViewHolder> {

    public DeviceFacilityAdapter(int layoutResId, @Nullable List<Facility> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Facility item) {
        if (item.openStatus.equals("0")){
            helper.setText(R.id.button,"正常");
            helper.setBackgroundRes(R.id.imageview2,R.drawable.btn_bg_green);
            helper.setBackgroundRes(R.id.button,R.drawable.btn_bg_green);
        }else{
            helper.setText(R.id.button,"异常");
            helper.setBackgroundRes(R.id.imageview2,R.drawable.btn_bg_red);
            helper.setBackgroundRes(R.id.button,R.drawable.btn_bg_red);
        }
        helper.setText(R.id.textView, item.name)
                .setText(R.id.textView12, "" + item.specialty)
                .setText(R.id.textView9, "" + item.code)
                .setText(R.id.textView10, "" + item.createBy)
                .setText(R.id.textView3, "" + item.createTime)
                .setText(R.id.textView14, "" + item.updateTime);
      }
}
