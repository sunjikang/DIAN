package com.xing.manage.adapter.device;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.devil.library.camera.util.FileUtil;
import com.xing.manage.R;
import com.xing.manage.bean.device.Record;
import com.xing.manage.bean.device.Resource;

import java.text.SimpleDateFormat;
import java.util.List;

public class SelectAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Context context;
    public SelectAdapter(int layoutResId, @Nullable List<String> data,Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    public SelectAdapter(@Nullable List<String> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

         Glide.with(context)
                .load(item)
                .into((ImageView) helper.itemView.findViewById(R.id.fiv));

         helper.addOnClickListener(R.id.ll_del);








    }
}
