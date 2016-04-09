package com.inc.yoghurt.ipsen4;

import android.app.Application;

import com.inc.yoghurt.ipsen4.Activities.BaseActivity;
import com.inc.yoghurt.ipsen4.Activities.DashboardActivity;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by daan on 08/04/16.
 */
public class App extends Application {

    private AppComponent component;

    @Singleton
    @Component(modules = {AndroidModule.class})
    public interface AppComponent {
        App app();
        void inject(App app);
        void inject(BaseActivity baseActivity);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApp_AppComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

}
