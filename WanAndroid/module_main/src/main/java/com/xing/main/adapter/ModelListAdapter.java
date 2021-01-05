package com.xing.main.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.main.R;
import com.xing.main.bean.Model;


import java.util.List;

public class ModelListAdapter extends BaseQuickAdapter<Model, BaseViewHolder> {
    private Context context;

    public ModelListAdapter(int layoutResId, @Nullable List<Model> data,Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    public ModelListAdapter(@Nullable List<Model> data) {
        super(data);
    }

     @Override
    protected void convert(BaseViewHolder helper, Model item) {
        helper.setText(R.id.model_name,item.name);
          if (!TextUtils.isEmpty(item.urlImage)){
            ImageView image = helper.itemView.findViewById(R.id.model_img);
            Glide.with(context).load(item.urlImage).into(image);
         }

         if (!TextUtils.isEmpty(item.textColor) ){
             String color = item.textColor;
             if (color.contains("#")){
                 int i = Color.parseColor(color);
                 helper.setTextColor(R.id.model_name,i);
             }else{
                 color= "#"+color;
                 int i = Color.parseColor(color);
                 helper.setTextColor(R.id.model_name,i);

             }
         }

        helper.addOnClickListener(R.id.model_ll);
    }
}
