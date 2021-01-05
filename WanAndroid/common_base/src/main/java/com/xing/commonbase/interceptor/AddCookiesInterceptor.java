package com.xing.commonbase.interceptor;

import android.util.Log;

import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.SharedPreferenceUtil;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> perferences = (HashSet) SharedPreferenceUtil.read(Constants.KEY_COOKIE, Constants.COOKIE, new HashSet<String>());
        if (perferences != null) {
            for (String cookie : perferences) {
                builder.addHeader(Constants.COOKIE, cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}