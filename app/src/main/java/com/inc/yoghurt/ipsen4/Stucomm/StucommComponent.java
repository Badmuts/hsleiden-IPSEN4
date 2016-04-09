package com.inc.yoghurt.ipsen4.Stucomm;

import com.inc.yoghurt.ipsen4.Activities.DashboardActivity;
import com.inc.yoghurt.ipsen4.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by daan on 08/04/16.
 */
@Component(modules = {StucommModule.class})
@Singleton
public interface StucommComponent {
    void inject(DashboardActivity activity);
}
