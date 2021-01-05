package com.xing.manage.adapter.device;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xing.manage.R;
import com.xing.manage.bean.device.Level1Item;
import com.xing.manage.bean.device.Level2Item;
import com.xing.manage.bean.device.Level3Item;

import java.util.List;

public class AreaListAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = "sjk";

    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;
    public static final int TYPE_LEVEL_3 = 3;

       /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     * @param data A new list is created out of this one to avoid mutable list
     */

    public AreaListAdapter(List<MultiItemEntity> data) {
        super(data);
         addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
        addItemType(TYPE_LEVEL_2, R.layout.item_expandable_lv2);
        addItemType(TYPE_LEVEL_3, R.layout.item_expandable_lv3);
     }


    @Override
    protected void convert(@NonNull final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                holder.setText(R.id.title, lv1.area.title)
                        .setImageResource(R.id.iv, lv1.isExpanded() ? R.drawable.ic_baseline_arrow_downward_36 : R.drawable.ic_baseline_arrow_forward_36);
                setState(holder, lv1.area.isNormal);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        if (lv1.isExpanded()) {
                            collapse(pos);
                        }  else {
                            IExpandable willExpandItem = (IExpandable) getData().get(pos);
                            for (int i = getHeaderLayoutCount(); i < getData().size(); i++) {
                                IExpandable expandable = (IExpandable) getData().get(i);
                                if (expandable.isExpanded()) {
                                    collapse(i);
                                }
                            }
                            expand(getData().indexOf(willExpandItem) + getHeaderLayoutCount());
                        }
                    }
                });
                 holder.addOnClickListener(R.id.title);
                break;
            case TYPE_LEVEL_2:
                 final Level2Item lv2 = (Level2Item) item;
                holder.setText(R.id.title, lv2.facility.name)
                        .setImageResource(R.id.iv, lv2.isExpanded() ? R.drawable.ic_baseline_arrow_downward_24 : R.drawable.ic_baseline_arrow_forward_24);
                setState(holder, lv2.facility.isNormal);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();

                        if (lv2.isExpanded()) {
                            collapse(pos,true);
                        }  else{
                            expand(pos,true);
                        }
                    }
                });
                holder.addOnClickListener(R.id.title);
                break;

            case  TYPE_LEVEL_3:
                final Level3Item lv3 = (Level3Item) item;
                setState(holder, lv3.inspection.isNormal);
                if(lv3.inspection.isCheckOver){
                    holder.setText(R.id.tv_checkover, "已检测");
                 }else{
                    holder.setText(R.id.tv_checkover, "未检测");
                }

                holder.setText(R.id.title, lv3.inspection.inspectionItemName);
                holder.addOnClickListener(R.id.title);
                holder.addOnClickListener(R.id.ll_layout);
                break;
            default:
                break;
        }
    }

    private void setState(@NonNull BaseViewHolder holder, boolean isNormal) {
        if (isNormal) {
            holder.setText(R.id.state, "正常")
                    .setTextColor(R.id.state, mContext.getResources().getColor(R.color.green))
                    .setBackgroundRes(R.id.state, R.drawable.textview_border_green);
        } else {
            holder.setText(R.id.state, "异常")
                    .setTextColor(R.id.state, mContext.getResources().getColor(R.color.orange))
                    .setBackgroundRes(R.id.state, R.drawable.textview_border_orange);
        }
    }


}
