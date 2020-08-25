package com.qcp.weatherproject.api;

import com.qcp.weatherproject.model.Location;
import com.qcp.weatherproject.model.Weather;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("locations/v1/cities/ipaddress")
    Call<Location> getLocation(@Query("apikey") String apiKey, @Query("q") String userIp);

    @GET("currentconditions/v1/{loc_key}")
    Call<List<Weather>> getWeather(@Path("loc_key") String locationKey, @Query("apikey") String apiKey);
}
