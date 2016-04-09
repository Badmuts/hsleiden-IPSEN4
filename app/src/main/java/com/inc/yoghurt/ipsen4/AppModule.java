package com.inc.yoghurt.ipsen4;

import android.content.Context;

import com.inc.yoghurt.ipsen4.Stucomm.StucommConfiguration;
import com.inc.yoghurt.ipsen4.Stucomm.StucommModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link android.app.Application} to create.
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApp @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides @Singleton @ForApp App provideApp() {
        return application;
    }

}