package com.xing.module.quality.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.module.quality.R;
import com.xing.module.quality.bean.QCRImage;

import java.util.List;

public class QCRecordImageAdapter extends BaseQuickAdapter<QCRImage, BaseViewHolder> {
    public QCRecordImageAdapter(int layoutResId, List<QCRImage> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, QCRImage item) {
        Glide.with(mContext).load(item.getImageLocalUrl()).into((ImageView) helper.getView(R.id.item_image));
    }

}
