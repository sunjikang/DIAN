package com.xing.main.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.xing.commonbase.base.BaseMVPFragment;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.AppUtil;
import com.xing.commonbase.util.BlurUtil;
import com.xing.commonbase.util.SharedPreferenceUtil;
import com.xing.commonbase.util.StatusBarUtil;
import com.xing.commonbase.widget.CircleImageView;
import com.xing.commonbase.widget.ItemView;
import com.xing.commonbase.widget.ZoomScrollView;
import com.xing.main.R;
import com.xing.main.activity.MainActivity;
import com.xing.main.bean.CheckVersion;
import com.xing.main.bean.xboot.User;
import com.xing.main.contract.MineContract;
import com.xing.main.presenter.MinePresenter;
import com.xing.main.update.AppUpdater;
import com.xing.main.update.bean.AppInfo;
import com.xing.main.update.net.INetCallBack;
import com.xing.main.update.ui.ShowAppInfoDialog;


public class MineFragment extends BaseMVPFragment<MinePresenter> implements MineContract.View, View.OnClickListener {
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private ZoomScrollView scrollView;
    private ImageView backImgView;
    private CircleImageView circleImageView;
    private TextView nicknameView;
    private TextView departmentView;

    private View avatarLayout;
    private TextView meiziView;
    private ItemView favoriteItemView;
    private ItemView meiziItemView;
    private ItemView aboutItemView;
    private ItemView checkItemView;
    private ItemView logoutItemView;

    public MineFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View rootView) {

        backImgView = rootView.findViewById(R.id.iv_avatar_background);
        circleImageView = rootView.findViewById(R.id.civ_avatar);
        nicknameView = rootView.findViewById(R.id.tv_nickname);
        departmentView = rootView.findViewById(R.id.tv_department);


        scrollView = rootView.findViewById(R.id.sv_scroll);
//        avatarLayout = rootView.findViewById(R.id.rl_layout);
        favoriteItemView = rootView.findViewById(R.id.iv_mine_favorite);
        meiziItemView = rootView.findViewById(R.id.iv_mine_meizi);
        aboutItemView = rootView.findViewById(R.id.iv_mine_about);
        checkItemView = rootView.findViewById(R.id.iv_mine_check);
        logoutItemView = rootView.findViewById(R.id.iv_mine_logout);
    }

    @Override
    protected void initData() {
        scrollView.setZoomView(backImgView);
        scrollView.setOnScrollListener(new ZoomScrollView.OnScrollListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            }
        });
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        backImgView.setImageBitmap(BlurUtil.blur(mContext, bitmap, 18));


        favoriteItemView.setOnClickListener(this);
        meiziItemView.setOnClickListener(this);
        aboutItemView.setOnClickListener(this);
        checkItemView.setOnClickListener(this);
        logoutItemView.setOnClickListener(this);

        presenter.getUserInfo();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_mine_about) {
            gotoAboutActivity();
        } else if (v.getId() == R.id.iv_mine_favorite) {
            gotoFavoriteActivity();
        } else if (v.getId() == R.id.iv_mine_meizi) {
            gotoMeiziActivity();
        } else if (v.getId() == R.id.iv_mine_check) {


           // checkVersion();


             presenter.checkVersion();


          } else if (v.getId() == R.id.iv_mine_logout) {
            gotoLoginActivity();
        }
    }

    private void checkVersion() {
        AppUpdater.getInstance().getNetManager().get("http://59.110.162.30/app_updater_version.json", new INetCallBack() {
            @Override
            public void success(String response) {
                //1.解析json;http://59.110.162.30/app_updater_version.json
                final AppInfo appInfo = AppInfo.parse(response);
                if (appInfo == null) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "服务器返回版本信息错误", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                //2.做版本匹配
                long version = Integer.valueOf(appInfo.getVersionCode());
                if (version <= AppUtil.getVerCode(getActivity())) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "已经是最新版本了!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    //弹框显示版本信息
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ShowAppInfoDialog.show(getActivity(), appInfo);
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable throwable) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "网络错误，更新版本失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }, getActivity());
    }


    private void gotoMeiziActivity() {
        ARouter.getInstance()
                .build("/gank/ImageMeiziActivity")
                .navigation();
    }

    private void gotoFavoriteActivity() {
        ARouter.getInstance()
                .build("/main/FavoriteActivity")
                .navigation();
    }

    private void gotoAboutActivity() {
        ARouter.getInstance()
                .build("/main/AboutActivity")
                .navigation();
    }

    /**
     * 跳转登录界面
     */
    private void gotoLoginActivity() {
        MainActivity mainActivity = (MainActivity) mContext;
        mainActivity.finish();
        SharedPreferenceUtil.write(Constants.FILE_TOKEN, Constants.ACCESS_TOKEN, "");
        ARouter.getInstance().build("/user/LoginActivity").navigation();
    }

    @Override
    public void onUserInfo(User user) {
        if (!TextUtils.isEmpty(user.getAvatar())) {
//            Glide.with(mContext).load(user.getAvatar()).into(backImgView);
            Glide.with(mContext).load(user.getAvatar()).into(circleImageView);
        }
        nicknameView.setText(user.getNickname());
        departmentView.setText(user.getDepartmentTitle());
    }

    @Override
    public void onCheckSuccess(final CheckVersion data) {
        //todo
        Log.i("sjk","检查版本成功"+data);


        //做版本匹配
        long version = Integer.valueOf(data.versionNumber);
        if (version <= AppUtil.getVerCode(getActivity())) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), "已经是最新版本了!!!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            //弹框显示版本信息
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    AppInfo appInfo=new AppInfo();
                    appInfo.setTitle("版本更新");
                    appInfo.setContent(data.updateInstructions);
                    //测试url  https://imtt.dd.qq.com/16891/apk/0E2551A47983D789F22A2247C03A1FD1.apk?fsname=com.ibox.calculators_3.2.2_1322.apk&csr=1bbd
                    appInfo.setUrl(data.url);
                    ShowAppInfoDialog.show(getActivity(), appInfo);
                }
            });
        }

    }



    @Override
    public void onCheckFail(String message) {
        Log.i("sjk","检查版本失败"+message);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
