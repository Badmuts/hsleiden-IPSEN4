package com.inc.yoghurt.ipsen4;

import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.util.Log;

import com.inc.yoghurt.ipsen4.Models.Event;
import com.inc.yoghurt.ipsen4.Services.StucommService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by daan on 05/04/16.
 */
public class StucommTask extends AsyncTask<StucommService, Integer, Long> {
    @Override
    protected Long doInBackground(StucommService... stucommServices) {
        StucommService stucommService = stucommServices[0];
        Call<List<Event>> schedule = stucommService.getSchedule("1453071600", "1453590000");
        List<Event> events = new ArrayList<>();
        try {
            events = schedule.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("StucommService", events.get(0).getLongName());
        return null;
    }
}
