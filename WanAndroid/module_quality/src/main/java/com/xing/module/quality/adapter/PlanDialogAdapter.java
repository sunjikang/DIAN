package com.xing.module.quality.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.module.quality.R;
import com.xing.module.quality.bean.PlanMonth;

import java.util.List;

public class PlanDialogAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public PlanDialogAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_calendar_tv, item);
    }
}
