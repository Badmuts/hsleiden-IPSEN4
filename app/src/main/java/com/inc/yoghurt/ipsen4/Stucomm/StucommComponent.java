package com.inc.yoghurt.ipsen4.Stucomm;

import com.inc.yoghurt.ipsen4.Activities.DashboardActivity;
import com.inc.yoghurt.ipsen4.App;

import dagger.Component;

/**
 * Created by daan on 08/04/16.
 */
@Component(modules = {StucommModule.class}, dependencies = {App.AppComponent.class})
@PerActivity
public interface StucommComponent extends App.AppComponent {
    void inject(DashboardActivity activity);
}
