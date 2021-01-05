package com.xing.manage.fragment.manage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xing.commonbase.base.BaseMVPFragment;
import com.xing.commonbase.util.ToastUtil;
import com.xing.manage.R;
import com.xing.manage.adapter.manage.DoneAdapter;
import com.xing.manage.bean.manage.DoneBean;
import com.xing.manage.bean.ProcessNodeVo;
import com.xing.manage.contract.DoneContract;
import com.xing.manage.presenter.DonePresenter;


import java.util.ArrayList;
import java.util.List;

public class DoneFragment extends BaseMVPFragment<DonePresenter> implements DoneContract.View, View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<DoneBean> dataList = new ArrayList<DoneBean>();
    private DoneAdapter adapter;
    private RefreshLayout refreshLayout;
    private int pageSize = 10;
    private int pageNumber = 1;

    private Dialog chooseDialog;

    public DoneFragment() {
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
        presenter.getDoneList(pageNumber, pageSize);
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.getDoneList(pageNumber, pageSize);
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageNumber = 1;
                presenter.getDoneList(pageNumber, pageSize);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected DonePresenter createPresenter() {
        return new DonePresenter();
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



    private void gotoHistoryActivity(String procInstId) {
        ARouter.getInstance()
                .build("/manage/HistoryActivity")
                .withString("procInstId", procInstId)
                .navigation();
    }

    @Override
    public void onDoneList(final List<DoneBean> doneBeanList) {
        {
            refreshLayout.finishRefresh();
            if (pageNumber == 1) {
                dataList.clear();
            }
            pageNumber++;
            dataList.addAll(doneBeanList);
            if (adapter == null) {
                adapter = new DoneAdapter(R.layout.item_manage_done, dataList);
                recyclerView.setAdapter(adapter);
            } else {
                adapter.setNewData(dataList);
            }
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                }
            });
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    DoneBean result = dataList.get(position);
                    if (view.getId() == R.id.btn_change_model) {
                        showDialog(result, 1);
                    } else if (view.getId() == R.id.btn_edit_history) {
                        gotoHistoryActivity(result.getProcInstId());
                     } else if (view.getId() == R.id.btn_delete) {

                        new MaterialDialog.Builder(getContext()).title("确认删除吗？")
                                .positiveText("确定") //肯定按键
                                .negativeText("取消") //否定按键
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        ToastUtil.show(getContext(),"确定");
                                        //todo
                                    }
                                })
                                .onNegative(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        ToastUtil.show(getContext(),"取消");

                                    }
                                })
                                .positiveColor(Color.RED)
                                .negativeColor(Color.BLUE).show();
                    }
                }


            });
        }
    }

    @Override
    public void onPass() {
        chooseDialog = null;
        pageNumber = 1;
        presenter.getDoneList(pageNumber, pageSize);
    }

    @Override
    public void onBack() {
        chooseDialog = null;
        pageNumber = 1;
        presenter.getDoneList(pageNumber, pageSize);
    }

    @Override
    public void onDelegate() {

    }

    @Override
    public void onNextNode(ProcessNodeVo processNodeVo) {

    }

    private void showDialog(final DoneBean result, final int type) {
        View view = getLayoutInflater().inflate(R.layout.dialog_todo_pass, null);
        chooseDialog = new Dialog(mContext, R.style.transparentFrameWindowStyle);
        chooseDialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = chooseDialog.getWindow();
        // 设置显示动画
        if (window != null) {
            window.setWindowAnimations(R.style.main_menu_animstyle);
            WindowManager.LayoutParams wl = window.getAttributes();
            wl.x = 0;
            wl.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
            // 以下这两句是为了保证按钮可以水平满屏
            wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
            wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            // 设置显示位置
            chooseDialog.onWindowAttributesChanged(wl);
        }

        final TextView title = chooseDialog.findViewById(R.id.dialog_title);

        if (type == 1) {
            title.setText(result.getName() + "通过");
        } else if (type == 2) {
            title.setText(result.getName() + "驳回至发起人");
        } else if (type == 3) {
            title.setText(result.getName() + "委托");
        }

        // 设置点击外围解散
        chooseDialog.setCanceledOnTouchOutside(true);
        chooseDialog.findViewById(R.id.todo_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    presenter.getNextNode(result.getProcDefId(), result.getKey());

                //审批意见
                EditText comment = chooseDialog.findViewById(R.id.dialog_message);
                //发送消息类型
                CheckBox sendMessage = chooseDialog.findViewById(R.id.dialog_cb1);
                CheckBox sendSms = chooseDialog.findViewById(R.id.dialog_cb2);
                CheckBox sendEmail = chooseDialog.findViewById(R.id.dialog_cb3);
                String[] assignees = null;
                if (!TextUtils.isEmpty(result.getAssignee())) {
                    assignees = result.getAssignee().split(",");
                }
                if (type == 1) {
                    presenter.pass(result.getId(),
                            result.getProcInstId(),
                            assignees,
                            result.getPriority(),
                            comment.getText().toString(),
                            sendMessage.isChecked(),
                            sendSms.isChecked(),
                            sendEmail.isChecked());
                } else if (type == 2) {
                    presenter.back(result.getId(),
                            result.getProcInstId(),
                            comment.getText().toString(),
                            sendMessage.isChecked(),
                            sendSms.isChecked(),
                            sendEmail.isChecked());
                } else if (type == 3) {
                    // todo
                }

                chooseDialog.dismiss();
            }
        });
        chooseDialog.show();
    }


}
