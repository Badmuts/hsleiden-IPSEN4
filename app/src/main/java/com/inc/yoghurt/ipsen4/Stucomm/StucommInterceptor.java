package com.inc.yoghurt.ipsen4.Stucomm;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by daan on 08/04/16.
 */
public class StucommInterceptor implements Interceptor {
    private final String clientToken;
    private final String accessToken;

    public StucommInterceptor(String clientToken, String accessToken) {
        this.clientToken = clientToken;
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request authRequest = request.newBuilder()
                .addHeader("clientToken", clientToken)
                .addHeader("accessToken", accessToken)
                .build();

        return chain.proceed(authRequest);
    }
}
