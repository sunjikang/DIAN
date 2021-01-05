package com.xing.manage.activity;

 import android.support.design.widget.TabLayout;
 import android.support.v4.app.Fragment;
 import android.support.v4.app.FragmentStatePagerAdapter;
 import android.support.v4.view.ViewPager;
 import android.support.v7.widget.Toolbar;
 import android.util.Log;
 import android.view.View;
 import android.view.ViewGroup;

 import com.alibaba.android.arouter.facade.annotation.Route;
 import com.xing.commonbase.base.BaseMVPActivity;
 import com.xing.commonbase.mvp.IPresenter;
 import com.xing.commonbase.util.StatusBarUtil;
 import com.xing.manage.R;
 import com.xing.manage.fragment.manage.DoneFragment;
 import com.xing.manage.fragment.manage.FinishedFragment;
 import com.xing.manage.fragment.manage.ModelManageFragment;
 import com.xing.manage.fragment.manage.ProgressManageFragment;
 import com.xing.manage.fragment.manage.RunningFragment;
 import com.xing.manage.fragment.manage.TodoFragment;

 import java.util.ArrayList;
 import java.util.List;

@Route(path = "/manage/ManageActivity")
public class ManageActivity extends BaseMVPActivity {
     private TabLayout mTabLayout;
    private ViewPager mViewPager;

    List<String> mTitle;
    List<Fragment> mFragment;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_manage;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        Toolbar toolbar =findViewById(R.id.toolbar_title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManageActivity.this.finish();
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
        mTitle.add("我的待办");
        mTitle.add("我的已办");
        mTitle.add("流转中");
        mTitle.add("已结束");
        mTitle.add("流程管理");
        mTitle.add("模型管理");

        mFragment = new ArrayList<>();
        mFragment.add(new TodoFragment());
        mFragment.add(new DoneFragment());
        mFragment.add(new RunningFragment());
        mFragment.add(new FinishedFragment());
        mFragment.add(new ProgressManageFragment());
        mFragment.add(new ModelManageFragment());

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
