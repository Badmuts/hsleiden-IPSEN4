package com.inc.yoghurt.ipsen4.Stucomm;

import android.os.AsyncTask;
import android.util.Log;

import com.inc.yoghurt.ipsen4.Models.Event;
import com.inc.yoghurt.ipsen4.Stucomm.StucommApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by daan on 05/04/16.
 */
public class StucommTask extends AsyncTask<Void, Void, List<Event>> {
    private final StucommApi stucommApi;

    public StucommTask(StucommApi stucommApi) {
        this.stucommApi = stucommApi;
    }

    @Override
    protected List<Event> doInBackground(Void... params) {
        Call<List<Event>> schedule = stucommApi.getSchedule("1453071600", "1453590000");
        List<Event> events = new ArrayList<>();
        try {
            events = schedule.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }
}
