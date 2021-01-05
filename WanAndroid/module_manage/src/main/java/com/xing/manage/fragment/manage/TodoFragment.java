    package com.xing.manage.fragment.manage;

import android.app.Dialog;
import android.content.Context;
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

import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xing.commonbase.base.BaseMVPFragment;
import com.xing.commonbase.util.ToastUtil;
import com.xing.manage.R;
import com.xing.manage.adapter.manage.TodoAdapter;
import com.xing.manage.bean.ProcessNodeVo;
import com.xing.manage.bean.manage.ProgressManageBean;
import com.xing.manage.bean.manage.TodoBean;
import com.xing.manage.contract.TodoContract;
import com.xing.manage.presenter.TodoPresenter;


import java.util.ArrayList;
import java.util.List;

public class TodoFragment extends BaseMVPFragment<TodoPresenter> implements TodoContract.View, View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<TodoBean> dataList = new ArrayList<>();
    private TodoAdapter adapter;
    private RefreshLayout refreshLayout;
    private int pageSize = 10;
    private int pageNumber = 1;


    public TodoFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragmentl_manage_todo;
    }

    @Override
    protected void initView(View rootView) {
        refreshLayout = rootView.findViewById(R.id.srl_todo);
        recyclerView = rootView.findViewById(R.id.rv_todo);
    }

    @Override
    protected void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        presenter.getTodoList(pageNumber, pageSize);
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.getTodoList(pageNumber, pageSize);
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageNumber = 1;
                presenter.getTodoList(pageNumber, pageSize);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected TodoPresenter createPresenter() {
        return new TodoPresenter();
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
    public void onTodoList(final List<TodoBean> todoBean) {
        refreshLayout.finishRefresh();
        if (pageNumber == 1) {
            dataList.clear();
        }
        pageNumber++;
        dataList.addAll(todoBean);
        if (adapter == null) {
            adapter = new TodoAdapter(R.layout.item_manage_todo, dataList);
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
                TodoBean result = dataList.get(position);
                if (view.getId() == R.id.btn_change_model) {

                } else if (view.getId() == R.id.btn_pass) {
                    showDialog(result, 1);
                } else if (view.getId() == R.id.btn_back) {
                    showDialog(result, 2);
                } else if (view.getId() == R.id.btn_edit_history) {
                    showDialog(result, 3);
                } else if (view.getId() == R.id.btn_delete) {
                    gotoHistoryActivity(result.getProcInstId());
                }
            }
        });
    }

    private void gotoHistoryActivity(String procInstId) {
        ARouter.getInstance()
                .build("/manage/HistoryActivity")
                .withString("procInstId", procInstId)
                .navigation();
    }

    @Override
    public void onPass() {
        pageNumber = 1;
        presenter.getTodoList(pageNumber, pageSize);
    }

    @Override
    public void onBack() {
        pageNumber = 1;
        presenter.getTodoList(pageNumber, pageSize);
    }

    @Override
    public void onDelegate() {

    }

    @Override
    public void onNextNode(ProcessNodeVo processNodeVo) {

    }

    private void showDialog(final TodoBean result, final int type) {

            final MaterialDialog dialog = new MaterialDialog.Builder(getContext())
                    .customView(R.layout.dialog_todo_pass, false).show();
            final View dialogCustomView = dialog.getCustomView();

         TextView title = dialogCustomView.findViewById(R.id.dialog_title);

        if (type == 1) {
            title.setText(result.getName() + "通过");
        } else if (type == 2) {
            title.setText(result.getName() + "驳回至发起人");
        } else if (type == 3) {
            title.setText(result.getName() + "委托");
        }

        // 设置点击外围解散
        dialogCustomView.findViewById(R.id.todo_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //审批意见
                EditText comment = dialogCustomView.findViewById(R.id.dialog_message);
                String commentStr = ""+comment.getText().toString();
                //发送消息类型
                CheckBox sendMessage = dialogCustomView.findViewById(R.id.dialog_cb1);
                CheckBox sendSms = dialogCustomView.findViewById(R.id.dialog_cb2);
                CheckBox sendEmail = dialogCustomView.findViewById(R.id.dialog_cb3);
                String[] assignees = null;
                if (!TextUtils.isEmpty(result.getAssignee())) {
                    assignees = result.getAssignee().split(",");
                }
                if (type == 1) {
                    presenter.pass(result.getId(),
                            result.getProcInstId(),
                            assignees,
                            result.getPriority(),
                            commentStr,
                            sendMessage.isChecked(),
                            sendSms.isChecked(),
                            sendEmail.isChecked());
                } else if (type == 2) {
                    presenter.back(result.getId(),
                            result.getProcInstId(),
                            commentStr,
                            sendMessage.isChecked(),
                            sendSms.isChecked(),
                            sendEmail.isChecked());
                } else if (type == 3) {
                    presenter.delegate(result.getId(), "userId",  result.getProcInstId(),commentStr, sendMessage.isChecked(),sendSms.isChecked(), sendEmail.isChecked());
                }
                dialog.dismiss();
             }
        });
     }
}
