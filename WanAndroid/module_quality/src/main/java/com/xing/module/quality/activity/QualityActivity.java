package com.xing.module.quality.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.qrcode.Constant;
import com.example.qrcode.ScannerActivity;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.AppUtil;
import com.xing.commonbase.util.NetworkUtil;
import com.xing.commonbase.util.SharedPreferenceUtil;
import com.xing.commonbase.widget.LinearItemDecoration;
import com.xing.commonbase.widget.loading.ProgressDialog;
import com.xing.module.quality.adapter.QCRecordCodeAdapter;
import com.xing.module.quality.adapter.QCRecordImageAdapter;
import com.xing.module.quality.bean.AppInfo;
import com.xing.module.quality.bean.QCCode;
import com.xing.module.quality.bean.QCRImage;
import com.xing.module.quality.bean.QCRecord;
import com.xing.module.quality.bean.QCRecordCode;
import com.xing.module.quality.contract.QualityContract;
import com.xing.module.quality.db.DbManager;
import com.xing.module.quality.db.QCCodeDao;
import com.xing.module.quality.presenter.QualityPresenter;
import com.suke.widget.SwitchButton;
import com.xing.commonbase.base.BaseMVPActivity;
import com.xing.commonbase.mvp.IPresenter;
import com.xing.commonbase.util.ToastUtil;
import com.xing.module.quality.R;
import com.xing.module.quality.service.DownloadService;
import com.xing.module.quality.view.stacklabel.interfaces.OnLabelClickListener;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import okhttp3.MediaType;
import okhttp3.RequestBody;


@Route(path = "/quality/QualityActivity")
public class QualityActivity extends BaseMVPActivity<QualityPresenter> implements QualityContract.View, View.OnClickListener {
    //头部
    private TextView tvName;
    private TextView tvCode;
    private TextView tvChang;
    private TextView tvNum1;
    private TextView tvNum2;
    private TextView tvNum3;
    //跟单
    private ImageView ivFollowBlue;
    private TextView tvFollow;
    private TextView tvIsFinished;
    private TextView tvIsSemi;
    //拍照
    private RecyclerView recyclerImage;
    private RelativeLayout rlImageList;
    //合格
    private RadioGroup rgGoodBad;
    private TextView tvCamera;
    //不良原因
    private LinearLayout llReasonLayout;
    private ImageView ivBadGreen;
    private NiceSpinner spinnerType;
    //不良提交
    private TextView tvBadSumbit;
    private RecyclerView recyclerLabelCode;

    private static final int RESULT_REQUEST_CODE_YZING = 10001;//打开二维码扫描
    private static final int RESULT_REQUEST_CODE_CAMERA = 10002;//调用系统相机
    private static final int RESULT_REQUEST_CODE_CHOOSE = 10003;//调用系统相机
    private File cameraSavePath;//拍照照片路径
    private Uri uri;//照片uri
    private String fileName;//照片名称 无后缀名
    private QCRecord qcRecord;//当前的纪录对象
    private List<QCRecordCode> qcRecordCodeList;//不良原因表
    private QCRecordCodeAdapter qcRecordCodeAdapter;//不良原因 适配器
    private List<QCRImage> qcrImageList;//图片集合
    private QCRecordImageAdapter qcRecordImageAdapter; //图片集合 适配器
    private List<QCCode> typeQCCodeList; //不良类型
    private String flagState = "1";

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_quality;
    }

    @Override
    protected void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.quality_title);
        //获取页面view对象
        tvName = findViewById(R.id.tv_name);
        tvCode = findViewById(R.id.tv_code);
        tvChang = findViewById(R.id.tv_chang);
        tvNum1 = findViewById(R.id.tv_num1);
        tvNum2 = findViewById(R.id.tv_num2);
        tvNum3 = findViewById(R.id.tv_num3);
        ivFollowBlue = findViewById(R.id.iv_follow_blue);
        tvFollow = findViewById(R.id.tv_follow);
        recyclerImage = findViewById(R.id.recycler_image);
        tvIsFinished = findViewById(R.id.tv_is_finished);
        rgGoodBad = findViewById(R.id.rg_good_bad);
        tvIsSemi = findViewById(R.id.tv_is_semi);
        tvCamera = findViewById(R.id.tv_camera);
        rlImageList = findViewById(R.id.rl_image_list);
        llReasonLayout = findViewById(R.id.ll_reason_layout);
        ivBadGreen = findViewById(R.id.iv_bad_green);
        spinnerType = findViewById(R.id.spinner_type);
        tvBadSumbit = findViewById(R.id.tv_bad_sumbit);
        tvBadSumbit.setEnabled(false);
        recyclerLabelCode = findViewById(R.id.recycler_label_code);
        //view对象初始化
        rlImageList.setVisibility(View.GONE);
        //注册点击事件
        tvChang.setOnClickListener(this);
        tvFollow.setOnClickListener(this);
        tvCamera.setOnClickListener(this);
        tvCamera.setEnabled(false);
        tvBadSumbit.setOnClickListener(this);
        rgGoodBad.setOnCheckedChangeListener(onCheckedChangeListener);
        disableRadioGroup(rgGoodBad);
        //设置布局管理器
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        //flexDirection 属性决定主轴的方向（即项目的排列方向）。类似 LinearLayout 的 vertical 和 horizontal。
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);//主轴为水平方向，起点在左端。
        //flexWrap 默认情况下 Flex 跟 LinearLayout 一样，都是不带换行排列的，但是flexWrap属性可以支持换行排列。
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);//按正常方向换行
        //justifyContent 属性定义了项目在主轴上的对齐方式。
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);//交叉轴的起点对齐。
        recyclerLabelCode.setLayoutManager(flexboxLayoutManager);
        recyclerLabelCode.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerImage.setLayoutManager(layoutManager);
    }

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (qcRecord != null) {
                if (checkedId == R.id.rb_good) {
                    llReasonLayout.setVisibility(View.GONE);
                    qcRecordCodeList.clear();
                    qcRecordCodeAdapter.notifyDataSetChanged();
                    flagState = "1";
                    qcRecord.setFlag(flagState);

                } else if (checkedId == R.id.rb_bad) {
                    llReasonLayout.setVisibility(View.VISIBLE);
                    qcRecordCodeAdapter.replaceData(createCodeDatas().get(spinnerType.getText().toString()));
                    flagState = "0";
                    qcRecord.setFlag(flagState);
                }
            }
        }
    };

    @Override
    protected void initData() {
        super.initData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        //获取版本信息
        presenter.doCheckVersion();
        if (DbManager.getInstance().getQCCodeDao().count() <= 0) {
            //初始化code字典库
            List<QCCode> qcCodeList = new LinkedList<>();
            qcCodeList.add(new QCCode(1l, 0l, "白身", "", 1));
            qcCodeList.add(new QCCode(2l, 0l, "包装", "", 2));
            qcCodeList.add(new QCCode(3l, 0l, "涂饰", "", 3));
            qcCodeList.add(new QCCode(4l, 0l, "软包", "", 4));
            qcCodeList.add(new QCCode(5l, 0l, "裁剪", "", 5));
            qcCodeList.add(new QCCode(6l, 0l, "缝纫", "", 6));
            qcCodeList.add(new QCCode(7l, 0l, "储运", "", 7));
            qcCodeList.add(new QCCode(11l, 1l, "组装不正", "poor assembly", 101));
            qcCodeList.add(new QCCode(12l, 1l, "涨线", "swelling", 102));
            qcCodeList.add(new QCCode(13l, 1l, "修补不良", "Poor repairing", 103));
            qcCodeList.add(new QCCode(14l, 1l, "脱胶起皮", "delamination", 104));
            qcCodeList.add(new QCCode(15l, 1l, "锁穿鼓裂", "screwing out", 105));
            qcCodeList.add(new QCCode(16l, 1l, "松动", "loose", 106));
            qcCodeList.add(new QCCode(17l, 1l, "实木色差", "Color variance", 107));
            qcCodeList.add(new QCCode(18l, 1l, "实木劈裂", "solid wood crack", 108));
            qcCodeList.add(new QCCode(19l, 1l, "实木开裂", "solid wood split", 109));
            qcCodeList.add(new QCCode(110l, 1l, "砂光不良", "Sanding", 110));
            qcCodeList.add(new QCCode(111l, 1l, "欠料", "Missing material", 111));
            qcCodeList.add(new QCCode(112l, 1l, "破损", "damage", 112));
            qcCodeList.add(new QCCode(113l, 1l, "碰划伤", "Scratch", 113));
            qcCodeList.add(new QCCode(114l, 1l, "配合不良", "fitness issue", 114));
            qcCodeList.add(new QCCode(115l, 1l, "木皮色差", "veneer color variance", 115));
            qcCodeList.add(new QCCode(116l, 1l, "木皮开裂", "Veneer chekcing", 116));
            qcCodeList.add(new QCCode(117l, 1l, "落差不标准", "nonstandard offset", 117));
            qcCodeList.add(new QCCode(118l, 1l, "漏装错装", "misplace", 118));
            qcCodeList.add(new QCCode(119l, 1l, "孔位不良", "poor boring location", 119));
            qcCodeList.add(new QCCode(120l, 1l, "胶印", "glue mark", 120));
            qcCodeList.add(new QCCode(121l, 1l, "缝隙不良", "poor gap", 121));
            qcCodeList.add(new QCCode(122l, 1l, "刀痕", "", 122));
            qcCodeList.add(new QCCode(123l, 1l, "抽拉不畅", "Poor execution on pulling out of the drawer", 123));
            qcCodeList.add(new QCCode(124l, 1l, "材料缺陷", "material defective", 124));
            qcCodeList.add(new QCCode(125l, 1l, "变形", "Warp", 125));
            qcCodeList.add(new QCCode(126l, 2l, "成品碰划伤", "scratch of finished good", 201));
            qcCodeList.add(new QCCode(127l, 2l, "包错漏包", "incorrect package", 202));
            qcCodeList.add(new QCCode(128l, 2l, "锁穿锁鼓锁裂", "screwing out", 203));
            qcCodeList.add(new QCCode(129l, 2l, "标签错误", "wrong label", 204));
            qcCodeList.add(new QCCode(130l, 2l, "玻璃不良", "defective glass", 205));
            qcCodeList.add(new QCCode(131l, 2l, "部件破损", "parts damaged", 206));
            qcCodeList.add(new QCCode(132l, 2l, "擦灰不净", "dust", 207));
            qcCodeList.add(new QCCode(133l, 2l, "电器不良", "defective electrical unit", 208));
            qcCodeList.add(new QCCode(134l, 2l, "发霉", "go mouldy", 209));
            qcCodeList.add(new QCCode(135l, 2l, "开焊", "open welding", 210));
            qcCodeList.add(new QCCode(136l, 2l, "配合不良", "fitness issue", 211));
            qcCodeList.add(new QCCode(137l, 2l, "生锈氧化", "rust", 212));
            qcCodeList.add(new QCCode(138l, 2l, "五金错误", "wrong hardware", 213));
            qcCodeList.add(new QCCode(139l, 2l, "异味", "eculiar smell", 214));
            qcCodeList.add(new QCCode(140l, 2l, "异响", "abnormal noise", 215));
            qcCodeList.add(new QCCode(141l, 2l, "印刷错误", "wrong printing", 216));
            qcCodeList.add(new QCCode(142l, 2l, "纸箱破损", "carton damaged", 217));
            qcCodeList.add(new QCCode(143l, 2l, "钟表不良", "defective clock", 218));
            qcCodeList.add(new QCCode(144l, 3l, "色差", "Color variance", 301));
            qcCodeList.add(new QCCode(145l, 3l, "返修不良", "Poor repairing", 302));
            qcCodeList.add(new QCCode(146l, 3l, "桔皮", "orange peel", 303));
            qcCodeList.add(new QCCode(147l, 3l, "亮度偏差", "wrong sheen", 304));
            qcCodeList.add(new QCCode(148l, 3l, "流油", "Lacquer run", 305));
            qcCodeList.add(new QCCode(149l, 3l, "露白", "White wood", 306));
            qcCodeList.add(new QCCode(150l, 3l, "喷涂不良", "poor spraying", 307));
            qcCodeList.add(new QCCode(151l, 3l, "气泡", "bubble", 308));
            qcCodeList.add(new QCCode(152l, 3l, "砂光不良", "Sanding", 309));
            qcCodeList.add(new QCCode(153l, 3l, "手感不良颗粒", "rough surface", 310));
            qcCodeList.add(new QCCode(154l, 3l, "污染", "Pollution", 311));
            qcCodeList.add(new QCCode(155l, 3l, "油漆白化", "lacquer blotch", 312));
            qcCodeList.add(new QCCode(156l, 3l, "油漆堆积", "Lacuer built up", 313));
            qcCodeList.add(new QCCode(157l, 3l, "油漆回粘", "Lacquer sticky", 314));
            qcCodeList.add(new QCCode(158l, 3l, "油漆开裂", "lacquer checking", 315));
            qcCodeList.add(new QCCode(159l, 3l, "油漆脱落", "Lacquer peel off", 316));
            qcCodeList.add(new QCCode(160l, 4l, "部件松脱", "parts loose", 401));
            qcCodeList.add(new QCCode(161l, 4l, "不饱满", "no crown look", 402));
            qcCodeList.add(new QCCode(163l, 4l, "剪口大", "too much cutting", 404));
            qcCodeList.add(new QCCode(164l, 4l, "扣板钉松锁穿", "scrweing out", 405));
            qcCodeList.add(new QCCode(165l, 4l, "露钉", "nail revealed", 406));
            qcCodeList.add(new QCCode(166l, 4l, "面料起球", "fuzzy ball on the fabric", 407));
            qcCodeList.add(new QCCode(167l, 4l, "面料瑕疵", "defective fabric", 408));
            qcCodeList.add(new QCCode(168l, 4l, "泡钉不直", "nail not straight", 409));
            qcCodeList.add(new QCCode(169l, 4l, "裙边高度不对", "fringe with in correct height", 410));
            qcCodeList.add(new QCCode(170l, 4l, "软包面料压印痕迹", "pressing mark", 411));
            qcCodeList.add(new QCCode(171l, 4l, "软包效果不良", "poor uph. Look", 412));
            qcCodeList.add(new QCCode(172l, 4l, "污染", "Pollution", 413));
            qcCodeList.add(new QCCode(173l, 4l, "线头", "thread end", 414));
            qcCodeList.add(new QCCode(174l, 4l, "牙条不直", "welt not straight", 415));
            qcCodeList.add(new QCCode(175l, 4l, "羽绒外漏", "down shown", 416));
            qcCodeList.add(new QCCode(176l, 4l, "坐感不良", "poor sitting", 417));
            qcCodeList.add(new QCCode(177l, 5l, "对花不良", "poor matching of the fabric pattern", 501));
            qcCodeList.add(new QCCode(178l, 5l, "布纹不直", "fabric grain not straight", 502));
            qcCodeList.add(new QCCode(179l, 5l, "尺寸错误", "incorrect size", 503));
            qcCodeList.add(new QCCode(180l, 6l, "尺寸错误", "wrinkle on the fabric", 601));
            qcCodeList.add(new QCCode(182l, 6l, "缝线不直", "sewing line not straight", 603));
            qcCodeList.add(new QCCode(183l, 6l, "拉布错误", "fabric stretching incorrect", 604));
            qcCodeList.add(new QCCode(184l, 6l, "毛向花向错误", "incorrect pattern", 605));
            qcCodeList.add(new QCCode(185l, 6l, "面料错误", "incorrect fabric", 606));
            qcCodeList.add(new QCCode(186l, 6l, "面料色差", "fabric color variance", 607));
            qcCodeList.add(new QCCode(187l, 6l, "跳线", "sewing line not consistent", 608));
            qcCodeList.add(new QCCode(188l, 6l, "牙条松紧不一致", "welt tight/loose inconsistent", 609));
            qcCodeList.add(new QCCode(189l, 7l, "包装破损", "damage on the package", 701));
            qcCodeList.add(new QCCode(190l, 7l, "包装压痕", "pressing mark", 702));
            qcCodeList.add(new QCCode(191l, 7l, "标签错误", "incorrect label", 703));
            qcCodeList.add(new QCCode(192l, 7l, "产品破损", "damaged products", 704));
            qcCodeList.add(new QCCode(193l, 7l, "配件破损", "damaged parts", 705));
            qcCodeList.add(new QCCode(194l, 7l, "外观污染", "pollution of the exterior", 706));
            qcCodeList.add(new QCCode(195l, 2l, "安装不当", "incorrect installation", 219));
            qcCodeList.add(new QCCode(196l, 4l, "脱丝脱线", "thread loose", 418));
            qcCodeList.add(new QCCode(197l, 1l, "虫蛀", "damaged by worms", 126));
            DbManager.getInstance().getQCCodeDao().insertInTx(qcCodeList);
        }
        //拿到所有不良类别
        typeQCCodeList = DbManager.getInstance().getQCCodeDao().queryBuilder().where(QCCodeDao.Properties.ParentID.eq(0l)).list();

        qcRecordCodeList = new ArrayList<>();
        qcrImageList = new ArrayList<>();
    }

    /**
     * 获取数据后，填充数据，并设置控件可以使用
     */
    private void setView() {
        if (qcRecord != null) {
            tvName.setText(qcRecord.getName());
            tvCode.setText(qcRecord.getSerialNo());
            tvChang.setText(qcRecord.getWerks());
            tvCamera.setEnabled(true);
            enableRadioGroup(rgGoodBad);
            tvBadSumbit.setEnabled(true);
            initRecordTypeAndCode();
            initImageRecycler();
        }
    }

    private void initRecordTypeAndCode() {
        //初始化不良列表
        qcRecordCodeAdapter = new QCRecordCodeAdapter(R.layout.item_record_code, qcRecordCodeList);
        qcRecordCodeAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        qcRecordCodeAdapter.setOnItemClickListener(itemClickListener);
        qcRecordCodeAdapter.setOnItemLongClickListener(itemLongClickListener);
        recyclerLabelCode.setAdapter(qcRecordCodeAdapter);
        //spinner 类别
        spinnerType.attachDataSource(createTypeDatas());
        spinnerType.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                qcRecordCodeAdapter.replaceData(createCodeDatas().get(item));
            }
        });
        qcRecordCodeAdapter.replaceData(createCodeDatas().get(spinnerType.getText().toString()));
    }


    private void initImageRecycler() {
        //拍照
        qcRecordImageAdapter = new QCRecordImageAdapter(R.layout.item_record_image, qcrImageList);
        qcRecordImageAdapter.setOnItemClickListener(photoItemClickListener);
        recyclerImage.setAdapter(qcRecordImageAdapter);
    }

    @Override
    protected QualityPresenter createPresenter() {
        return new QualityPresenter();
    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    BaseQuickAdapter.OnItemClickListener photoItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            ArrayList<String> photoPaths = getStrListForPic(qcrImageList);
            ToastUtil.show(QualityActivity.this, "未开通");
        }
    };
    BaseQuickAdapter.OnItemClickListener itemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            QCRecordCode qcRecordCode = qcRecordCodeList.get(position);
            qcRecordCode.setQty(qcRecordCode.getQty() + 1);
            qcRecordCodeAdapter.notifyItemChanged(position);
            DbManager.getInstance().getQCRecordCodeDao().insertOrReplace(qcRecordCode);
            if (qcRecordCode.getQty() == 1) {
                qcRecord.setCodeCount(qcRecord.getCodeCount() + 1);
                DbManager.getInstance().getQCRecordDao().insertOrReplace(qcRecord);
            }
        }
    };

    BaseQuickAdapter.OnItemLongClickListener itemLongClickListener = new BaseQuickAdapter.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
            QCRecordCode qcRecordCode = qcRecordCodeList.get(position);
            if (qcRecordCode.getQty() > 1) {
                qcRecordCode.setQty(qcRecordCode.getQty() - 1);
                qcRecordCodeAdapter.notifyItemChanged(position);
                DbManager.getInstance().getQCRecordCodeDao().update(qcRecordCode);
                qcRecord.setCodeCount(qcRecord.getCodeCount() - 1);
                DbManager.getInstance().getQCRecordDao().insertOrReplace(qcRecord);
            } else if (qcRecordCode.getQty() == 1) {
                qcRecordCode.setQty(qcRecordCode.getQty() - 1);
                qcRecordCodeAdapter.notifyItemChanged(position);
                DbManager.getInstance().getQCRecordCodeDao().delete(qcRecordCode);
                qcRecord.setCodeCount(qcRecord.getCodeCount() - 1);
                DbManager.getInstance().getQCRecordDao().insertOrReplace(qcRecord);
            }
            return true;
        }
    };

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_chang) {
            ToastUtil.show(this, "tv_chang");

        } else if (i == R.id.tv_camera) {
            File directoryPath = new File(Environment.getExternalStorageDirectory().getPath() + "/HZCSQuality/");
            if (!directoryPath.exists()) {
                directoryPath.mkdirs();
            }
            fileName = "hzcs" + System.currentTimeMillis();
            cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/HZCSQuality/" + fileName + ".jpg");
            Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //第二个参数为 包名.fileprovider
                uri = FileProvider.getUriForFile(this, "com.xing.module.quality.fileprovider", cameraSavePath);
                intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                uri = Uri.fromFile(cameraSavePath);
            }
            intent1.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent1, RESULT_REQUEST_CODE_CAMERA);

        } else if (i == R.id.tv_follow) {
            Intent intent2 = new Intent(this, ScannerActivity.class);
            //设置是否启用从相册获取二维码
            intent2.putExtra(Constant.EXTRA_IS_ENABLE_SCAN_FROM_PIC, true);
            startActivityForResult(intent2, RESULT_REQUEST_CODE_YZING);
        } else if (i == R.id.tv_bad_sumbit) {
            if (qcRecord.getIsUpload().equals("0")) {
                qcRecord.setQcRecordCodeList();
                qcRecord.setQcrImageList();
                List<QCRecord> qcRecordList = new ArrayList<>();
                qcRecordList.add(qcRecord);
                if (NetworkUtil.isNetworkAvailable(this)) {
                    presenter.doSubmit(qcRecordList);
                } else {
                    DbManager.getInstance().getQCRecordDao().insertOrReplace(qcRecord);
                    ToastUtil.show(this, "网络连接不可用，已经保存到本地");
                }
            } else if (qcRecord.getIsUpload().equals("1")) {
                ToastUtil.show(this, "本条质检记录已经上传");
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RESULT_REQUEST_CODE_YZING:
                    if (data == null) {
                        return;
                    }
                    String type = data.getStringExtra(Constant.EXTRA_RESULT_CODE_TYPE);
                    String content = data.getStringExtra(Constant.EXTRA_RESULT_CONTENT);
                    ToastUtil.show(this, "codeType:" + type + "-----content:" + content);
                    break;
                case RESULT_REQUEST_CODE_CAMERA:
                    String photoPath;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        photoPath = String.valueOf(cameraSavePath);
                    } else {
                        photoPath = uri.getEncodedPath();
                    }
                    Log.d("拍照返回图片路径:", photoPath);
                    rlImageList.setVisibility(View.VISIBLE);
                    QCRImage qcrImage = new QCRImage();
                    qcrImage.setImageLocalUrl(photoPath);
                    qcrImage.setImageShowname(fileName);
                    qcrImage.setImageName(fileName + ".jpg");
                    qcrImage.setQcrId(qcRecord.getId());
                    DbManager.getInstance().getQCRImageDao().insert(qcrImage);
                    qcRecordImageAdapter.addData(qcrImage);
                    qcRecord.setImageCount(qcrImageList.size());
                    DbManager.getInstance().getQCRecordDao().insertOrReplace(qcRecord);
                    break;
                case RESULT_REQUEST_CODE_CHOOSE:

                    break;
                default:
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_quality, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == android.R.id.home) {
            finish();
            return true;
        } else if (i == R.id.action_quality_list) {
            ARouter.getInstance().build("/quality/QualityListActivity").navigation();
            return true;
        } else if (i == R.id.action_plan_list) {
            ARouter.getInstance().build("/quality/PlanActivity").navigation();
            return true;
        } else if (i == R.id.action_test) {
            //假装是成功的扫描了二维码
            int random = (int) (1 + Math.random() * 100);
            qcRecord = new QCRecord();
            qcRecord.setWerks("五厂包装");
            qcRecord.setType(1);
            qcRecord.setFlag(flagState);
            qcRecord.setName("梳妆台" + random);
            qcRecord.setSerialNo("SAPMOCODE+9901+" + random);
            qcRecord.setIsUpload("0");
            qcRecord.setCreateDate(new Date());
            qcRecord.setCodeCount(0);
            qcRecord.resetQcRecordCodeList();
            qcRecord.setImageCount(0);
            qcRecord.resetQcrImageList();
            qcRecordCodeList.clear();
            qcrImageList.clear();
            DbManager.getInstance().getQCRecordDao().insertOrReplace(qcRecord);
            //给view填充数据
            setView();
            rlImageList.setVisibility(View.GONE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSubmitSuccess(List<QCRecord> list) {
        for (QCRecord qcRecord : list) {
            qcRecord.setIsUpload("1");
            DbManager.getInstance().getQCRecordDao().insertOrReplace(qcRecord);
        }
        ToastUtil.show(this, "上传成功");
    }

    @Override
    public void onCheckVersionSuccess(final AppInfo appInfo) {
        Log.e("TAG",AppUtil.getPackageName(this));
        if (AppUtil.getVerCode(this) < Integer.parseInt(appInfo.getVerCode())) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("更新提示");
            builder.setMessage(appInfo.getAppDescribe());
            builder.setNegativeButton("取消", null);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //更新
                    Intent intent = new Intent(QualityActivity.this, DownloadService.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(DownloadService.APP_INFO,appInfo);
                    intent.putExtras(bundle);
                    QualityActivity.this.startService(intent);
                }
            });
            builder.show();
        }
    }

    private List<String> getStrListForReasonName(List<QCCode> list) {
        List<String> stringList = new ArrayList<>();
        for (QCCode qcCode : list) {
            stringList.add(qcCode.getReasonName());
        }
        return stringList;
    }

    //得到type的string列表
    private List<String> createTypeDatas() {
        return getStrListForReasonName(typeQCCodeList);
    }

    //得到code的string列表
    private HashMap<String, List<QCRecordCode>> createCodeDatas() {
        //新建一个哈希表
        HashMap<String, List<QCRecordCode>> map = new HashMap<String, List<QCRecordCode>>();
        for (QCCode qcCode : typeQCCodeList) {
            //在这里把key与value分别列出，然后通过HashMap.put进行配对然后写入哈希表。
            List<QCCode> codeQCCodeList = DbManager.getInstance().getQCCodeDao().queryBuilder().where(QCCodeDao.Properties.ParentID.eq(qcCode.getId())).list();
            map.put(qcCode.getReasonName(), getItemListForReasonName(codeQCCodeList, qcCode.getReasonName()));
        }
        return map;
    }

    private List<QCRecordCode> getItemListForReasonName(List<QCCode> list, String reasonName) {
        List<QCRecordCode> itemList = new ArrayList<>();
        for (QCCode qcCode : list) {
            QCRecordCode qcRecordCode = new QCRecordCode();
            qcRecordCode.setQcrId(qcRecord.getId());
            qcRecordCode.setReasonType(reasonName);
            qcRecordCode.setReasonCode(qcCode.getReasonName());
            qcRecordCode.setQty(0);
            itemList.add(qcRecordCode);
        }
        return itemList;
    }

    private ArrayList<String> getStrListForPic(List<QCRImage> list) {
        ArrayList<String> stringList = new ArrayList<>();
        for (QCRImage qcrImage : list) {
            stringList.add(qcrImage.getImageLocalUrl());
        }
        return stringList;
    }

    public void disableRadioGroup(RadioGroup testRadioGroup) {
        for (int i = 0; i < testRadioGroup.getChildCount(); i++) {
            testRadioGroup.getChildAt(i).setEnabled(false);
        }
    }

    public void enableRadioGroup(RadioGroup testRadioGroup) {
        for (int i = 0; i < testRadioGroup.getChildCount(); i++) {
            testRadioGroup.getChildAt(i).setEnabled(true);
        }
    }
}
