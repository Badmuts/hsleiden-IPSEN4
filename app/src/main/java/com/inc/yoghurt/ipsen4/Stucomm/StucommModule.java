package com.inc.yoghurt.ipsen4.Stucomm;

import com.inc.yoghurt.ipsen4.StucommTask;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by daan on 08/04/16.
 */
@Module
public class StucommModule {

    @Provides
    StucommApi provideStucommApi(StucommConfiguration configuration, StucommInterceptor interceptor) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(StucommApi.class);
    }

    @Provides
    StucommConfiguration provideStucommConfiguration(StucommConfiguration configuration) {
        return configuration;
    }

    @Provides
    StucommInterceptor provideStucommInterceptor(StucommInterceptor interceptor) {
        return interceptor;
    }

    @Provides
    StucommTask provideStucommTask(StucommTask task) {
        return task;
    }

}
