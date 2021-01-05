package com.xing.manage.bean.device;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xing.manage.adapter.device.AreaListAdapter;


public class Level2Item extends AbstractExpandableItem<Level3Item> implements MultiItemEntity {

    public Facility facility;


    @Override
    public int getItemType() {
        return AreaListAdapter.TYPE_LEVEL_2;
    }

    @Override
    public int getLevel() {
        return 2;
    }
}