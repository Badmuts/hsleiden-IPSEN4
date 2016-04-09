package com.inc.yoghurt.ipsen4;

import android.app.Application;

import com.inc.yoghurt.ipsen4.Activities.BaseActivity;
import com.inc.yoghurt.ipsen4.Activities.DashboardActivity;
import com.inc.yoghurt.ipsen4.Stucomm.StucommModule;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by daan on 08/04/16.
 */
public class App extends Application {

    private AppComponent component;

    @Singleton
    @Component(modules = {AppModule.class, StucommModule.class})
    public interface AppComponent {
        void inject(App app);
        void inject(BaseActivity baseActivity);
        void inject(DashboardActivity dashboardActivity);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApp_AppComponent.builder()
                .stucommModule(new StucommModule(this))
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

}
