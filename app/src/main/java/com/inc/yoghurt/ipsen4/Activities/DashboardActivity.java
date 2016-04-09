package com.inc.yoghurt.ipsen4.Activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.inc.yoghurt.ipsen4.App;
import com.inc.yoghurt.ipsen4.R;
import com.inc.yoghurt.ipsen4.Stucomm.StucommApi;
import com.inc.yoghurt.ipsen4.Stucomm.StucommTask;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import butterknife.Bind;

public class DashboardActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Inject StucommTask retrieveAgenda;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.nav_view) NavigationView navigationView;
    @Bind(R.id.drawer_layout) DrawerLayout drawer;
    @Bind(R.id.courseName) TextView courseName;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Perfom injection
        ((App) getApplication()).component().inject(this);
        // View stuff
        setContentView(R.layout.activity_dashboard);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        // Retrieve agenda
        try {
            String course = retrieveAgenda.execute().get().get(0).toString();
            courseName.setText(course);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody") @Override public boolean onNavigationItemSelected(
            MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
