package com.xing.commonbase.http;

import android.text.TextUtils;

import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.SharedPreferenceUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class InterceptorUtil {
    public static Interceptor headerInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder();
                builder.addHeader("X-APP-Agent", "corp_zx_app")
                        .addHeader("X-OS", "Android")
//                        .addHeader("X-APP-ID", "20181018000061")
                        .addHeader("X-APP-ID", "20181130000009")
                        .addHeader("X-DEVICE-TYPE", "USERNAME")
                        .addHeader("appId", "281")
                        .addHeader("businessType", "610001");

                String token = "";
                if (!TextUtils.isEmpty(token)) {
                    builder.addHeader("Access-Token", token);
                }
                Request request = builder.build();
                return chain.proceed(request);
            }
        };
    }

    public static Interceptor logInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public static Interceptor headerTokenInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String token = SharedPreferenceUtil.read(Constants.FILE_TOKEN, Constants.ACCESS_TOKEN, "");
                if (TextUtils.isEmpty(token)) {
                    Request originalRequest = chain.request();
                    return chain.proceed(originalRequest);
                } else {
                    Request originalRequest = chain.request();
                    Request updateRequest = originalRequest.newBuilder().header("accessToken", token).build();
                    return chain.proceed(updateRequest);
                }
            }
        };
    }

}
