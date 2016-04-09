package com.inc.yoghurt.ipsen4.Activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.inc.yoghurt.ipsen4.App;

import butterknife.ButterKnife;

/**
 * Created by daan on 08/04/16.
 */
public class BaseActivity extends AppCompatActivity {
    @Override public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this); // Inject views
    }

    @Override public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this); // Inject views
    }
}
