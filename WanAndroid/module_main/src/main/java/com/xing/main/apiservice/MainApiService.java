package com.xing.main.apiservice;

import com.xing.commonbase.base.BaseResponse;
import com.xing.main.bean.CheckVersion;
import com.xing.main.bean.xboot.User;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MainApiService {

    /**
     * 获取用户详情
     * GET /xboot/app/consumer/user/userinfo
     */
    @GET("xboot/app/consumer/user/userinfo")
    Observable<BaseResponse<User>> getUserInfo();








    /**
     * 检查当前版本
     * http://101.200.140.188:8900/xboot/app/consumer/version/checkVersion?versionName=1.0.1
     */
    @GET("/xboot/app/consumer/version/checkVersion")
    Observable<BaseResponse<CheckVersion>> checkVersion();


}
