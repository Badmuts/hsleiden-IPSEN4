package com.inc.yoghurt.ipsen4.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.inc.yoghurt.ipsen4.App;

import butterknife.ButterKnife;

/**
 * Created by daan on 08/04/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this); // Inject views
        ((App) getApplication()).component().inject(this); // Perfom injection
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
