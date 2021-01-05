package com.xing.manage.bean.device;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xing.manage.adapter.device.AreaListAdapter;


public class Level3Item  implements MultiItemEntity {

    public Inspection inspection;


    @Override
    public int getItemType() {
        return AreaListAdapter.TYPE_LEVEL_3;
    }

}