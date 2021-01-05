package com.xing.manage.activity.device;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xing.commonbase.base.BaseMVPActivity;
import com.xing.commonbase.mvp.IPresenter;
import com.xing.commonbase.util.StatusBarUtil;
import com.xing.manage.R;
import com.xing.manage.fragment.device.DeviceCheckFragment;
import com.xing.manage.fragment.device.DeviceNowFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/manage/device/DeviceActivity")
public class DeviceActivity extends BaseMVPActivity {
     private TabLayout mTabLayout;
    private ViewPager mViewPager;

    List<String> mTitle;
    List<Fragment> mFragment;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_device;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
            Toolbar toolbar =findViewById(R.id.toolbar_title);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DeviceActivity.this.finish();
                }
            });

        mTabLayout = findViewById(R.id.tl_project);
        mViewPager = findViewById(R.id.vp_project_page);
      }

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void initData() {
        super.initData();

        mTitle = new ArrayList<>();

        mTitle.add("日常巡检");
        mTitle.add("临时检测");

        mFragment = new ArrayList<>();

        mFragment.add(new DeviceCheckFragment());
        mFragment.add(new DeviceNowFragment());

        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        mViewPager.setOffscreenPageLimit(mTitle.size());
        mTabLayout.setupWithViewPager(mViewPager);

    }


}
