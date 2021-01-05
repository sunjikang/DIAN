package com.xing.manage.fragment.device;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xing.commonbase.base.BaseMVPFragment;
import com.xing.commonbase.util.NetworkUtil;
import com.xing.manage.R;
import com.xing.manage.adapter.device.DeviceCheckAdapter;
import com.xing.manage.bean.device.Area;
import com.xing.manage.bean.device.Facility;
import com.xing.manage.bean.device.Inspection;
import com.xing.manage.bean.device.Line;
import com.xing.manage.contract.device.LineContract;
import com.xing.manage.db.AreaDao;
import com.xing.manage.db.DbManager;
import com.xing.manage.db.FacilityDao;
import com.xing.manage.db.InspectionDao;
import com.xing.manage.db.LineDao;
import com.xing.manage.presenter.device.LinePresenter;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class DeviceCheckFragment extends BaseMVPFragment<LinePresenter> implements LineContract.View, View.OnClickListener {

    private RecyclerView recyclerView;
    private List<Line> dataList = new ArrayList<Line>();
    private DeviceCheckAdapter adapter;
    private RefreshLayout refreshLayout;


    private Dialog chooseDialog;

    public DeviceCheckFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_manage_done;
    }

    @Override
    protected void initView(View rootView) {
        refreshLayout = rootView.findViewById(R.id.srl_todo);
        recyclerView = rootView.findViewById(R.id.rv_todo);

    }

    @Override
    protected void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        presenter.getAllLine();
         refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.getAllLine();
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                 presenter.getAllLine();
            }
        });
       if (NetworkUtil.isNetworkAvailable(getContext())){
           getAllLine(dataList);
       }else {
           fromSql();
       }





    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected LinePresenter createPresenter() {
        return new LinePresenter();
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        refreshLayout.finishLoadMore();
    }





    @Override
    public void getAllLine(final List<Line> data) {
            refreshLayout.finishRefresh();
            dataList.addAll(data);
            if (adapter == null) {
                 fromJson();
                adapter = new DeviceCheckAdapter(R.layout.item_common_device, dataList);
                recyclerView.setAdapter(adapter);
            } else {
                adapter.setNewData(dataList);
            }
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener(){

                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    gotoDeviceAreaActivity(dataList.get(position).id);
                }


            });
     }
    private void gotoDeviceAreaActivity(Long  id) {
        AreaDao areaDao = DbManager.getInstance().getAreaDao();
        QueryBuilder<Area> query = areaDao.queryBuilder();
        List<Area> list = query.where(AreaDao.Properties.LineId.eq(id)).list();
        if (list.size()>0){

            ARouter.getInstance().build("/manage/device/DeviceAreaActivity").withLong("id",id).navigation();
        }
    }
    private void fromJson() {
        Gson gson = new Gson();//创建Gson对象
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonElements = jsonParser.parse(jsonurl).getAsJsonArray();//获取JsonArray对象
        LineDao lineDao = DbManager.getInstance().getLineDao();
        AreaDao areaDao = DbManager.getInstance().getAreaDao();
        FacilityDao facilityDao = DbManager.getInstance().getFacilityDao();
        InspectionDao inspectionDao = DbManager.getInstance().getInspectionDao();
        lineDao.deleteAll();
        areaDao.deleteAll();
        facilityDao.deleteAll();
        inspectionDao.deleteAll();

        for (JsonElement bean : jsonElements) {
           Line bean1 = gson.fromJson(bean, Line.class);//解析
            dataList.add(bean1);
            lineDao.insert(bean1);
            if (bean1.dmList!=null&& bean1.dmList.size()>0){
                for (Area area : bean1.dmList){
                    area.lineId=bean1.id;
                    areaDao.insert(area);
                    if(area.facilityList!=null&&area.facilityList.size()>0){
                        for (Facility facility: area.facilityList){
                            facility.areaId=area.id;
                            facilityDao.insert(facility);
                            if(facility.inspectionItemList!=null&&facility.inspectionItemList.size()>0){
                                for (Inspection inspection: facility.inspectionItemList){
                                    inspection.facilityId=facility.id;
                                    inspectionDao.insert(inspection);
                                }
                            }
                        }
                    }
                }
            }

        }

    }
    private void fromSql(){
        LineDao lineDao = DbManager.getInstance().getLineDao();
        QueryBuilder<Line> query = lineDao.queryBuilder();
       dataList = query.list();
        refreshLayout.finishRefresh();
         if (adapter == null) {
             adapter = new DeviceCheckAdapter(R.layout.item_common_device, dataList);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setNewData(dataList);
        }
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                gotoDeviceAreaActivity(dataList.get(position).id);
            }


        });
     }

    String jsonurl=" [\n" +
        "         {\n" +
        "             \"id\": \"1329014116379136000\",\n" +
        "             \"createBy\": \"admin\",\n" +
        "             \"createTime\": \"2020-11-18 18:50:31\",\n" +
        "             \"updateBy\": \"admin\",\n" +
        "             \"updateTime\": \"2020-11-18 18:50:31\",\n" +
        "             \"delFlag\": 0,\n" +
        "             \"openStatus\": 0,\n" +
        "             \"lineName\": \"测试线路1\",\n" +
        "             \"lineCode\": \"CSXL1118\",\n" +
        "             \"post\": \"锅炉\",\n" +
        "             \"taskType\": \"定期巡检\",\n" +
        "             \"startStatus\": \"启用\",\n" +
        "             \"remark\": \"\",\n" +
        "             \"standbyI\": \"\",\n" +
        "             \"standbyII\": \"\",\n" +
        "             \"standbyIII\": \"\",\n" +
        "             \"dmList\": [\n" +
        "                 {\n" +
        "                     \"id\": \"1328154954527019008\",\n" +
        "                     \"createBy\": \"admin\",\n" +
        "                     \"createTime\": \"2020-11-16 09:56:31\",\n" +
        "                     \"updateBy\": \"admin\",\n" +
        "                     \"updateTime\": \"2020-11-16 09:56:31\",\n" +
        "                     \"delFlag\": 0,\n" +
        "                     \"openStatus\": 0,\n" +
        "                     \"areaCode\": \"xjqy0021\",\n" +
        "                     \"title\": \"\\t 0021-巡检\",\n" +
        "                     \"specialty\": \"电气\",\n" +
        "                     \"unit\": \"\",\n" +
        "                     \"remark\": \"\",\n" +
        "                     \"standbyI\": \"\",\n" +
        "                     \"standbyII\": \"\",\n" +
        "                     \"standbyIII\": \"\",\n" +
        "                     \"facilityList\": [\n" +
        "                         {\n" +
        "                             \"id\": \"1326855914325676033\",\n" +
        "                             \"createBy\": \"admin\",\n" +
        "                             \"createTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"updateBy\": \"admin\",\n" +
        "                             \"updateTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"delFlag\": 0,\n" +
        "                             \"openStatus\": 0,\n" +
        "                             \"code\": \"EO_10GMP11AP001.A_QY-QJ01.JZ-01.TY\",\n" +
        "                             \"name\": \"#1机地下室A排污泵\",\n" +
        "                             \"parentId\": \"1323531636956074074\",\n" +
        "                             \"kksCode\": \"10GMP11AP001\",\n" +
        "                             \"isMain\": 1,\n" +
        "                             \"type\": \"三类设备\",\n" +
        "                             \"scaleModel\": \"65HLB-A\",\n" +
        "                             \"productCompany\": \"江苏华电机械制造有限公司\",\n" +
        "                             \"productTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"debugCompany\": null,\n" +
        "                             \"installNumber\": 1,\n" +
        "                             \"installPosition\": \"汽机房\",\n" +
        "                             \"typeCode\": \"LX-B\",\n" +
        "                             \"specialty\": \"ZY-QJ\",\n" +
        "                             \"sysCode\": null,\n" +
        "                             \"inspectionItemList\": [\n" +
        "                                 {\n" +
        "                                     \"id\": \"1329007301364944896\",\n" +
        "                                     \"createBy\": \"admin\",\n" +
        "                                     \"createTime\": \"2020-11-18 18:23:27\",\n" +
        "                                     \"updateBy\": \"admin\",\n" +
        "                                     \"updateTime\": \"2020-11-18 18:23:27\",\n" +
        "                                     \"delFlag\": 0,\n" +
        "                                     \"openStatus\": 0,\n" +
        "                                     \"inspectionItemName\": \"阀门管线\",\n" +
        "                                     \"samplingNumber\": \"\",\n" +
        "                                     \"sampleFrequency\": \"\",\n" +
        "                                     \"defaultSpeed\": \"\",\n" +
        "                                     \"unit\": \"\",\n" +
        "                                     \"equipmentLevel\": \"B类\",\n" +
        "                                     \"pollingType\": \"观察\",\n" +
        "                                     \"pollingStatus\": \"备用\",\n" +
        "                                     \"emissivity\": \"\",\n" +
        "                                     \"upperUp\": \"\",\n" +
        "                                     \"upper\": \"\",\n" +
        "                                     \"floor\": \"\",\n" +
        "                                     \"floorFl\": \"\",\n" +
        "                                     \"remark\": \"泄漏/关闭不严\",\n" +
        "                                     \"standbyI\": \"\",\n" +
        "                                     \"standbyII\": \"\",\n" +
        "                                     \"standbyIII\": \"\"\n" +
        "                                 },\n" +
        "                                 {\n" +
        "                                     \"id\": \"1329007440607449089\",\n" +
        "                                     \"createBy\": \"admin\",\n" +
        "                                     \"createTime\": \"2020-11-18 18:24:00\",\n" +
        "                                     \"updateBy\": \"admin\",\n" +
        "                                     \"updateTime\": \"2020-11-18 18:24:00\",\n" +
        "                                     \"delFlag\": 0,\n" +
        "                                     \"openStatus\": 0,\n" +
        "                                     \"inspectionItemName\": \"前轴承温度\",\n" +
        "                                     \"samplingNumber\": \"\",\n" +
        "                                     \"sampleFrequency\": \"\",\n" +
        "                                     \"defaultSpeed\": \"\",\n" +
        "                                     \"unit\": \"\",\n" +
        "                                     \"equipmentLevel\": \"C类\",\n" +
        "                                     \"pollingType\": \"预设状况\",\n" +
        "                                     \"pollingStatus\": \"运行\",\n" +
        "                                     \"emissivity\": \"\",\n" +
        "                                     \"upperUp\": \"\",\n" +
        "                                     \"upper\": \"\",\n" +
        "                                     \"floor\": \"\",\n" +
        "                                     \"floorFl\": \"\",\n" +
        "                                     \"remark\": \"\",\n" +
        "                                     \"standbyI\": \"\",\n" +
        "                                     \"standbyII\": \"\",\n" +
        "                                     \"standbyIII\": \"\"\n" +
        "                                 }\n" +
        "                             ]\n" +
        "                         },\n" +
        "                         {\n" +
        "                             \"id\": \"1326855914325676034\",\n" +
        "                             \"createBy\": \"admin\",\n" +
        "                             \"createTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"updateBy\": \"admin\",\n" +
        "                             \"updateTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"delFlag\": 0,\n" +
        "                             \"openStatus\": 0,\n" +
        "                             \"code\": \"EO_10LBB10AA401.A_QY-QJ01.JZ-01.TY\",\n" +
        "                             \"name\": \"冷段总管疏水截止阀(逆止阀前)\",\n" +
        "                             \"parentId\": \"1323531636956074028\",\n" +
        "                             \"kksCode\": \"10LBB10AA401\",\n" +
        "                             \"isMain\": 0,\n" +
        "                             \"type\": \"三类设备\",\n" +
        "                             \"scaleModel\": \"J61H-100  DN65\",\n" +
        "                             \"productCompany\": \"美国沃克流体控制有限公司\",\n" +
        "                             \"productTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"debugCompany\": null,\n" +
        "                             \"installNumber\": null,\n" +
        "                             \"installPosition\": \"汽机房\",\n" +
        "                             \"typeCode\": \"LX-FM\",\n" +
        "                             \"specialty\": \"ZY-QJ\",\n" +
        "                             \"sysCode\": null,\n" +
        "                             \"inspectionItemList\": [\n" +
        "                                 {\n" +
        "                                     \"id\": \"1329007579325665281\",\n" +
        "                                     \"createBy\": \"admin\",\n" +
        "                                     \"createTime\": \"2020-11-18 18:24:33\",\n" +
        "                                     \"updateBy\": \"admin\",\n" +
        "                                     \"updateTime\": \"2020-11-18 18:24:33\",\n" +
        "                                     \"delFlag\": 0,\n" +
        "                                     \"openStatus\": 0,\n" +
        "                                     \"inspectionItemName\": \"油位低\",\n" +
        "                                     \"samplingNumber\": \"\",\n" +
        "                                     \"sampleFrequency\": \"\",\n" +
        "                                     \"defaultSpeed\": \"\",\n" +
        "                                     \"unit\": \"\",\n" +
        "                                     \"equipmentLevel\": \"A类\",\n" +
        "                                     \"pollingType\": \"观察\",\n" +
        "                                     \"pollingStatus\": \"运行\",\n" +
        "                                     \"emissivity\": \"\",\n" +
        "                                     \"upperUp\": \"\",\n" +
        "                                     \"upper\": \"\",\n" +
        "                                     \"floor\": \"\",\n" +
        "                                     \"floorFl\": \"\",\n" +
        "                                     \"remark\": \"正常/油低见底/油已用完\",\n" +
        "                                     \"standbyI\": \"\",\n" +
        "                                     \"standbyII\": \"\",\n" +
        "                                     \"standbyIII\": \"\"\n" +
        "                                 }\n" +
        "                             ]\n" +
        "                         },\n" +
        "                         {\n" +
        "                             \"id\": \"1326855914325676035\",\n" +
        "                             \"createBy\": \"admin\",\n" +
        "                             \"createTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"updateBy\": \"admin\",\n" +
        "                             \"updateTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"delFlag\": 0,\n" +
        "                             \"openStatus\": 0,\n" +
        "                             \"code\": \"EO_10LBB10AA011.A_QY-QJ01.JZ-01.TY\",\n" +
        "                             \"name\": \"冷段至邻机加热母管止回阀\",\n" +
        "                             \"parentId\": \"1323531636956074028\",\n" +
        "                             \"kksCode\": \"10LBB10AA011\",\n" +
        "                             \"isMain\": 0,\n" +
        "                             \"type\": \"三类设备\",\n" +
        "                             \"scaleModel\": \"H44H-100  DN200\",\n" +
        "                             \"productCompany\": \"美国沃克流体控制有限公司\",\n" +
        "                             \"productTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"debugCompany\": null,\n" +
        "                             \"installNumber\": null,\n" +
        "                             \"installPosition\": \"汽机房\",\n" +
        "                             \"typeCode\": \"LX-FM\",\n" +
        "                             \"specialty\": \"ZY-QJ\",\n" +
        "                             \"sysCode\": null,\n" +
        "                             \"inspectionItemList\": null\n" +
        "                         }\n" +
        "                     ]\n" +
        "                 }\n" +
        "             ]\n" +
        "         },\n" +
        "         {\n" +
        "             \"id\": \"1329014276899344384\",\n" +
        "             \"createBy\": \"admin\",\n" +
        "             \"createTime\": \"2020-11-18 18:51:10\",\n" +
        "             \"updateBy\": \"admin\",\n" +
        "             \"updateTime\": \"2020-11-18 18:51:10\",\n" +
        "             \"delFlag\": 0,\n" +
        "             \"openStatus\": 0,\n" +
        "             \"lineName\": \"测试线路2\",\n" +
        "             \"lineCode\": \"CSXL1115\",\n" +
        "             \"post\": \"汽机\",\n" +
        "             \"taskType\": \"临时巡检\",\n" +
        "             \"startStatus\": \"禁用\",\n" +
        "             \"remark\": \"\",\n" +
        "             \"standbyI\": \"\",\n" +
        "             \"standbyII\": \"\",\n" +
        "             \"standbyIII\": \"\",\n" +
        "             \"dmList\": [\n" +
        "                 {\n" +
        "                     \"id\": \"1328309821983821824\",\n" +
        "                     \"createBy\": \"admin\",\n" +
        "                     \"createTime\": \"2020-11-16 20:11:55\",\n" +
        "                     \"updateBy\": \"admin\",\n" +
        "                     \"updateTime\": \"2020-11-16 20:11:55\",\n" +
        "                     \"delFlag\": 0,\n" +
        "                     \"openStatus\": 0,\n" +
        "                     \"areaCode\": \"aaa\",\n" +
        "                     \"title\": \"A区域\",\n" +
        "                     \"specialty\": \"锅炉\",\n" +
        "                     \"unit\": \"0\",\n" +
        "                     \"remark\": \"\",\n" +
        "                     \"standbyI\": \"\",\n" +
        "                     \"standbyII\": \"\",\n" +
        "                     \"standbyIII\": \"\",\n" +
        "                     \"facilityList\": [\n" +
        "                         {\n" +
        "                             \"id\": \"1326855914325676032\",\n" +
        "                             \"createBy\": \"admin\",\n" +
        "                             \"createTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"updateBy\": \"admin\",\n" +
        "                             \"updateTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"delFlag\": 0,\n" +
        "                             \"openStatus\": 0,\n" +
        "                             \"code\": \"EO_10GMP11AP002.A_QY-QJ01.JZ-01.TY\",\n" +
        "                             \"name\": \"#1机地下室B排污泵\",\n" +
        "                             \"parentId\": \"1323531636956074074\",\n" +
        "                             \"kksCode\": \"10GMP11AP002\",\n" +
        "                             \"isMain\": 1,\n" +
        "                             \"type\": \"三类设备\",\n" +
        "                             \"scaleModel\": \"65HLB-A\",\n" +
        "                             \"productCompany\": \"江苏华电机械制造有限公司\",\n" +
        "                             \"productTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"debugCompany\": null,\n" +
        "                             \"installNumber\": 1,\n" +
        "                             \"installPosition\": \"汽机房\",\n" +
        "                             \"typeCode\": \"LX-B\",\n" +
        "                             \"specialty\": \"ZY-QJ\",\n" +
        "                             \"sysCode\": null,\n" +
        "                             \"inspectionItemList\": [\n" +
        "                                 {\n" +
        "                                     \"id\": \"1329008990138535936\",\n" +
        "                                     \"createBy\": \"admin\",\n" +
        "                                     \"createTime\": \"2020-11-18 18:30:09\",\n" +
        "                                     \"updateBy\": \"admin\",\n" +
        "                                     \"updateTime\": \"2020-11-18 18:33:00\",\n" +
        "                                     \"delFlag\": 0,\n" +
        "                                     \"openStatus\": 0,\n" +
        "                                     \"inspectionItemName\": \"泵体温度\",\n" +
        "                                     \"samplingNumber\": \"\",\n" +
        "                                     \"sampleFrequency\": \"\",\n" +
        "                                     \"defaultSpeed\": \"\",\n" +
        "                                     \"unit\": \"℃\",\n" +
        "                                     \"equipmentLevel\": \"B类\",\n" +
        "                                     \"pollingType\": \"温度\",\n" +
        "                                     \"pollingStatus\": \"运行\",\n" +
        "                                     \"emissivity\": \"0.95\",\n" +
        "                                     \"upperUp\": \"60.00\",\n" +
        "                                     \"upper\": \"50.00\",\n" +
        "                                     \"floor\": \"0.00\",\n" +
        "                                     \"floorFl\": \"-20.00\",\n" +
        "                                     \"remark\": \"\",\n" +
        "                                     \"standbyI\": \"\",\n" +
        "                                     \"standbyII\": \"\",\n" +
        "                                     \"standbyIII\": \"\"\n" +
        "                                 }\n" +
        "                             ]\n" +
        "                         },\n" +
        "                         {\n" +
        "                             \"id\": \"1326855914325676036\",\n" +
        "                             \"createBy\": \"admin\",\n" +
        "                             \"createTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"updateBy\": \"admin\",\n" +
        "                             \"updateTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"delFlag\": 0,\n" +
        "                             \"openStatus\": 0,\n" +
        "                             \"code\": \"EO_KKS600000711.A_QY-QJ01.JZ-01.TY\",\n" +
        "                             \"name\": \"冷再管道阀门\",\n" +
        "                             \"parentId\": \"1323531636956074028\",\n" +
        "                             \"kksCode\": \"KKS600000711\",\n" +
        "                             \"isMain\": 1,\n" +
        "                             \"type\": null,\n" +
        "                             \"scaleModel\": null,\n" +
        "                             \"productCompany\": null,\n" +
        "                             \"productTime\": \"2020-11-12 19:54:36\",\n" +
        "                             \"debugCompany\": null,\n" +
        "                             \"installNumber\": null,\n" +
        "                             \"installPosition\": null,\n" +
        "                             \"typeCode\": \"LX-FM\",\n" +
        "                             \"specialty\": \"ZY-QJ\",\n" +
        "                             \"sysCode\": null,\n" +
        "                             \"inspectionItemList\": null\n" +
        "                         }\n" +
        "                     ]\n" +
        "                 }\n" +
        "             ]\n" +
        "         }\n" +
        "     ]\n" ;

}
