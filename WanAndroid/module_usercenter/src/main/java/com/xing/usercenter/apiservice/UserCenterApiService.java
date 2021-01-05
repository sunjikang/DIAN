package com.xing.usercenter.apiservice;

import com.xing.commonbase.base.BaseResponse;
import com.xing.usercenter.bean.LoginResult;
import com.xing.usercenter.bean.RegisterResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserCenterApiService {
    /**
     * 注册
     *
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse<RegisterResult>> register(@Field("username") String username,
                                                      @Field("password") String password,
                                                      @Field("repassword") String repassword);


    /**
     * 登录
     * @param username
     * @param password
     * @param deviceUniqueCode
     * @param platform
     * @return
     */
    @POST("xboot/app/consumer/user/login")
    @FormUrlEncoded
    Observable<BaseResponse<String>> login(@Field("username") String username,
                                           @Field("password") String password,
                                           @Field("deviceUniqueCode") String deviceUniqueCode,
                                           @Field("platform") Integer platform);

}
