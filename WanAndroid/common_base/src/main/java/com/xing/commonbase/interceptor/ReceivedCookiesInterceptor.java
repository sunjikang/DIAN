package com.xing.commonbase.interceptor;

import android.util.Log;

import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.SharedPreferenceUtil;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //拦截的cookie保存在originalResponse中
        Response originalResponse = chain.proceed(chain.request());
        //打印cookie信息
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

            HashSet<String> cookies = new HashSet<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            SharedPreferenceUtil.write(Constants.KEY_COOKIE, Constants.COOKIE, cookies);
        }
        return originalResponse;
    }
}