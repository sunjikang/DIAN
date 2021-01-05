package com.xing.manage.apiservice;

import com.xing.commonbase.base.BaseResponse;
import com.xing.manage.bean.ActPage;
import com.xing.manage.bean.device.Line;
import com.xing.manage.bean.manage.DoneBean;
import com.xing.manage.bean.manage.FinishedBean;
import com.xing.manage.bean.manage.HistoryBean;
import com.xing.manage.bean.manage.ModelManageBean;
import com.xing.manage.bean.ProcessNodeVo;
import com.xing.manage.bean.manage.ProgressManageBean;
import com.xing.manage.bean.manage.RunningBean;
import com.xing.manage.bean.manage.TodoBean;
import com.xing.manage.bean.User;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ManageApiService {

    /**
     * 获取用户详情
     * GET /xboot/app/consumer/user/userinfo
     */
    @GET("xboot/app/consumer/user/userinfo")
    Observable<BaseResponse<User>> getUserInfo();

    /**
     * 获取带办列表
     */
    @GET("xboot/actTask/todoList")
    Observable<BaseResponse<ActPage<TodoBean>>> getTodoList(@Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);

    /**
     * 已办列表
     */
    @GET("xboot/actTask/doneList")
    Observable<BaseResponse<ActPage<DoneBean>>> getDoneList(@Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);

    /**
     * 运行中
     * http://101.200.140.188:8901/xboot/actProcess/getRunningProcess?name=&key=&pageNumber=1&pageSize=10
     */
    @GET("xboot/actProcess/getRunningProcess")
    Observable<BaseResponse<ActPage<RunningBean>>> getRunningList(@Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);

    /**
     * 已结束
     http://101.200.140.188:8901/xboot/actProcess/getFinishedProcess?name=&key=&pageNumber=1&pageSize=10
     */
    @GET("xboot/actProcess/getFinishedProcess")
    Observable<BaseResponse<ActPage<FinishedBean>>> getFinishedList(@Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);


    /**
     * 模型管理
     http://101.200.140.188:8901/xboot/actModel/getByCondition?name=&modelKey=&pageNumber=1&pageSize=10&sort=createTime&order=desc     */
    @GET("xboot/actModel/getByCondition")
    Observable<BaseResponse<ActPage<ModelManageBean>>> getModelManageList(@Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);
    /**
     * 流程管理
     * http://101.200.140.188:8901/xboot/actProcess/getByCondition?showLatest=true&name=&processKey=&status=&pageNumber=1&pageSize=10&sort=createTime&order=desc&startDate=&endDate=
   */
    @GET("xboot/actProcess/getByCondition")
    Observable<BaseResponse<ActPage<ProgressManageBean>>> getProgressList(@Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);
    /**
     * 处理历史记录
     *   http://101.200.140.188:8901/xboot/actTask/historicFlow/205001
      */
    @GET("xboot/actTask/historicFlow/{id}")
    Observable<BaseResponse<List<HistoryBean>>> getHistory(@Path("id") String id);

     /**
     * 获取所有设备
     *   http://10.2.8.201:8888/xboot/appPush/getAllLine
      *   accessToken    ced577f0a2fb45e0811e06394595b849
     */
    @GET("xboot/actTask/historicFlow/{id}")
    Observable<BaseResponse<List<Line>>> getAllLine();
    /**
     * 任务节点审批通过
     *
     * @param id          任务id
     * @param procInstId  流程实例id
     * @param assignees   流程实例id
     * @param priority    下个节点审批人
     * @param comment     优先级
     * @param sendMessage 是否发送站内消息
     * @param sendSms     是否发送短信通知
     * @param sendEmail   是否发送邮件通知
     * @return
     */
    @POST("xboot/actTask/pass")
    @FormUrlEncoded
    Observable<BaseResponse<Object>> pass(@Field("id") String id,
                                          @Field("procInstId") String procInstId,
                                          @Field("assignees") String[] assignees,
                                          @Field("priority") Integer priority,
                                          @Field("comment") String comment,
                                          @Field("sendMessage") Boolean sendMessage,
                                          @Field("sendSms") Boolean sendSms,
                                          @Field("sendEmail") Boolean sendEmail);

    /**
     * 任务节点审批驳回至发起人
     *
     * @param id          任务id
     * @param procInstId  流程实例id
     * @param comment     意见评论
     * @param sendMessage 是否发送站内消息
     * @param sendSms     是否发送短信通知
     * @param sendEmail   是否发送邮件通知
     * @return
     */
    @POST("xboot/actTask/back")
    @FormUrlEncoded
    Observable<BaseResponse<Object>> back(@Field("id") String id,
                                          @Field("procInstId") String procInstId,
                                          @Field("comment") String comment,
                                          @Field("sendMessage") Boolean sendMessage,
                                          @Field("sendSms") Boolean sendSms,
                                          @Field("sendEmail") Boolean sendEmail);

    /**
     * 委托他人代办
     *
     * @param id          任务id
     * @param userId      委托用户id
     * @param procInstId  流程实例id
     * @param comment     意见评论
     * @param sendMessage 是否发送站内消息
     * @param sendSms     是否发送短信通知
     * @param sendEmail   是否发送邮件通知
     * @return
     */
    @POST("xboot/actTask/delegate")
    @FormUrlEncoded
    Observable<BaseResponse<Object>> delegate(@Field("id") String id,
                                              @Field("userId") String userId,
                                              @Field("procInstId") String procInstId,
                                              @Field("comment") String comment,
                                              @Field("sendMessage") Boolean sendMessage,
                                              @Field("sendSms") Boolean sendSms,
                                              @Field("sendEmail") Boolean sendEmail);

    /**
     * 通过当前节点定义id获取下一个节点
     */
    @GET("xboot/actTask/historicFlow/{id}")
    Observable<BaseResponse<List<Object>>> historicFlow(@Path("id") String id);

    /**
     * 通过当前节点定义id获取下一个节点
     */
    @GET("xboot/actProcess/getNextNode/{procDefId}/{currActId}")
    Observable<BaseResponse<ProcessNodeVo>> getNextNode(@Path("procDefId") String procDefId, @Path("currActId") String currActId);

}
