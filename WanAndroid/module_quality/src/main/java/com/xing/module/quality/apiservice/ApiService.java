package com.xing.module.quality.apiservice;


import com.xing.commonbase.base.BaseResponse;
import com.xing.module.quality.bean.AppInfo;
import com.xing.module.quality.bean.Plan;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

public interface ApiService {

    @FormUrlEncoded
    @POST
    Observable<BaseResponse<List<Plan>>> getPlanByMonth(@Url String url, @Field("month") String month);

    @Multipart
    @POST
    Observable<BaseResponse> uploadQuality(@Url String url, @Part("data") String data, @PartMap Map<String, RequestBody> map);

    @POST
    Observable<BaseResponse<AppInfo>> getAppInfo(@Url String url);
}
