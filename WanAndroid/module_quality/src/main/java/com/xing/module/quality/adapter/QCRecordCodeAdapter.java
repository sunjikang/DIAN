package com.xing.module.quality.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.module.quality.R;
import com.xing.module.quality.bean.QCCode;
import com.xing.module.quality.bean.QCRecordCode;
import com.xing.module.quality.db.DbManager;

import java.util.List;

public class QCRecordCodeAdapter extends BaseQuickAdapter<QCRecordCode, QCRecordCodeAdapter.ViewHolder> {
    public QCRecordCodeAdapter(int layoutResId, List<QCRecordCode> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final ViewHolder helper, QCRecordCode item) {
        final int position = helper.getLayoutPosition();
        helper.label.setText(item.getReasonCode());
        helper.num.setText(item.getQty() + "");
        if (item.getQty() > 0) {
            helper.label.setTextColor(Color.parseColor("#ffffff"));
            helper.num.setTextColor(Color.parseColor("#ffffff"));
            helper.num.setVisibility(View.VISIBLE);
            helper.boxLabel.setBackgroundResource(R.drawable.shape_bg_red);
        } else {
            helper.label.setTextColor(Color.parseColor("#dc000000"));
            helper.num.setTextColor(Color.parseColor("#dc000000"));
            helper.num.setVisibility(View.GONE);
            helper.boxLabel.setBackgroundResource(R.drawable.shape_bg_white);
        }
    }


    public class ViewHolder extends BaseViewHolder {
        TextView label;
        TextView num;
        LinearLayout boxLabel;

        public ViewHolder(View view) {
            super(view);
            label = view.findViewById(R.id.txt_label);
            num = view.findViewById(R.id.txt_num);
            boxLabel = view.findViewById(R.id.box_label);
        }
    }
}
