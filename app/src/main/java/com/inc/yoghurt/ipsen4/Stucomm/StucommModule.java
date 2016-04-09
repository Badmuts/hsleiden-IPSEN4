package com.inc.yoghurt.ipsen4.Stucomm;

import com.inc.yoghurt.ipsen4.App;

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
    private final App app;

    public StucommModule(App app) {
        this.app = app;
    }

    @Provides StucommApi provideStucommApi(StucommConfiguration configuration,
                                           StucommInterceptor interceptor) {
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

    @Provides StucommConfiguration provideStucommConfiguration() {
        return new StucommConfiguration(app);
    }

    @Provides StucommInterceptor provideStucommInterceptor(StucommConfiguration configuration) {
        return new StucommInterceptor(configuration.getClientToken(), configuration.getAccessToken());
    }

    @Provides StucommTask provideStucommTask(StucommApi api) {
        return new StucommTask(api);
    }

}
