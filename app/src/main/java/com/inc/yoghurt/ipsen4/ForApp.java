package com.inc.yoghurt.ipsen4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by daan on 08/04/16.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForApp {
}
