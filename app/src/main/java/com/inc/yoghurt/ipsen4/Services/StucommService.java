package com.inc.yoghurt.ipsen4.Services;

import com.inc.yoghurt.ipsen4.Models.Event;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by daan on 05/04/16.
 */
public interface StucommService {

    @GET("/")
    Call<List<Event>> getSchedule(@Query("start_date") String startDate, @Query("end_date") String endDate);

}
