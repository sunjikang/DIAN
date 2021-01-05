package com.xing.module.quality.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xing.module.quality.R;
import com.xing.module.quality.bean.QCRecord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QCRecordAdapter extends BaseQuickAdapter<QCRecord, QCRecordAdapter.ViewHolder> {

    private boolean isEdit = false;

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    //  https://blog.csdn.net/qq_36771588/article/details/83445798
    public QCRecordAdapter(int layoutResId, List<QCRecord> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(final ViewHolder helper, QCRecord item) {
        helper.item_quality_check.setChecked(item.isCheck());
        helper.item_quality_check.setEnabled(false);
        if (isEdit) {
            helper.item_quality_check.setVisibility(View.VISIBLE);
        } else {
            helper.item_quality_check.setVisibility(View.GONE);
        }
        helper.item_quality_name.setText(item.getName());
        helper.item_quality_code.setText(item.getSerialNo());
        switch (item.getFlag()) {
            case "1":
                helper.item_quality_state.setText("合格");
                helper.ll_quality_types.setVisibility(View.GONE);
                break;
            case "0":
                helper.item_quality_state.setText("不良");
                helper.ll_quality_types.setVisibility(View.VISIBLE);
                helper.item_quality_types.setText("3");
                break;
        }
        helper.item_quality_images.setText("2");
        switch (item.getIsUpload()) {
            case "1":
                helper.item_quality_upload.setText("已上传");
                break;
            case "0":
                helper.item_quality_upload.setText("暂未上传");
                break;
        }
    }


    public class ViewHolder extends BaseViewHolder {

        private CheckBox item_quality_check;
        private TextView item_quality_name;
        private TextView item_quality_code;
        private TextView item_quality_state;
        private TextView item_quality_types;
        private TextView item_quality_images;
        private TextView item_quality_upload;
        private LinearLayout ll_quality_types;

        public ViewHolder(View view) {
            super(view);
            item_quality_check = view.findViewById(R.id.item_quality_check);
            item_quality_name = view.findViewById(R.id.item_quality_name);
            item_quality_code = view.findViewById(R.id.item_quality_code);
            item_quality_state = view.findViewById(R.id.item_quality_state);
            item_quality_types = view.findViewById(R.id.item_quality_types);
            item_quality_images = view.findViewById(R.id.item_quality_images);
            item_quality_upload = view.findViewById(R.id.item_quality_upload);
            ll_quality_types = view.findViewById(R.id.ll_quality_types);
        }
    }
}
