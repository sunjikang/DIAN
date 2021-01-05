package com.xing.manage.bean.device;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xing.manage.adapter.device.AreaListAdapter;

import java.util.ArrayList;


public class Level1Item extends AbstractExpandableItem<Level2Item> implements MultiItemEntity {

    public Area area;


    @Override
    public int getItemType() {
        return AreaListAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}