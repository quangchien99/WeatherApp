package com.qcp.weatherproject.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qcp.weatherproject.R;
import com.qcp.weatherproject.api.WeatherClient;
import com.qcp.weatherproject.api.WeatherService;
import com.qcp.weatherproject.constance.Const;
import com.qcp.weatherproject.model.Location;
import com.qcp.weatherproject.model.Weather;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private CircleImageView imgWeather;
    private TextView tvLocation, tvDateTime, tvTemperature, tvWeatherText;
    private String userIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        getUserIp();
        getLocationKey();
    }

    private void getUserIp() {
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        userIp = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        Log.d("qcpp", "UserIp Check: " + userIp);
        // try (final DatagramSocket socket = new DatagramSocket()) {
//            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
//            userIp = socket.getLocalAddress().getHostAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
    }

    private void getWeather(String locationKey) {
        Log.d("qcpp", "getWeather Check: " + locationKey);
        final List<Weather> weathers = new ArrayList<>();
        Retrofit retrofit = WeatherClient.getClient();
        WeatherService requestApi = retrofit.create(WeatherService.class);
        Call<List<Weather>> call = requestApi.getWeather(locationKey, Const.API_KEY);
        Log.d("qcpp", "getWeather Check: " + 2);
        call.enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                Log.d("qcpp", "getWeather Check: " + response.code());
                weathers.addAll(response.body());
                Log.d("qcpp", "Weather Check: " + weathers.get(0).getLocalObservationDateTime());
                Weather weather = weathers.get(0);
                String iconNumber = "" + weather.getWeatherIcon();
                if (weather.getWeatherIcon() < 10) {
                    iconNumber = "0" + weather.getWeatherIcon();
                }
                Glide.with(getApplicationContext())
                        .load("https://developer.accuweather.com/sites/default/files/" + iconNumber + "-s.png")
                        .into(imgWeather);
                tvWeatherText.setText(weather.getWeatherText());
                tvTemperature.setText(weather.getTemperature().getMetric().getValue().toString() + "°C");
                tvDateTime.setText(weather.getLocalObservationDateTime().substring(0, 10));
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                Log.d("qcpp", "getWeather Check: " + 4);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Waring")
                        .setMessage("Can't get user data")
                        .setCancelable(true)
                        .show();
                Log.d("qcpp", t.getMessage() + "");
            }
        });
    }

    private void getLocationKey() {
        Log.d("qcpp", "Check location key: go in1");
        Retrofit retrofit = WeatherClient.getClient();
        WeatherService requestApi = retrofit.create(WeatherService.class);
        Call<Location> call = requestApi.getLocation(Const.API_KEY, "171.241.28.223");
        Log.d("qcpp", "Check location key: go in2" + call.toString());
        call.enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call<Location> call, Response<Location> response) {
                Log.d("qcpp", "Check location key: go in3" + response.code() + call.toString());

                if (response.isSuccessful()) {
                    Location location = response.body();
                    Log.d("qcpp", "Check location key: " + location.getKey());
                    getWeather(location.getKey());
                    tvLocation.setText(location.getEnglishName() + " - " + location.getCountry().getEnglishName());
                }
            }

            @Override
            public void onFailure(Call<Location> call, Throwable t) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Waring")
                        .setMessage("Can't get user data")
                        .setCancelable(true)
                        .show();
                Log.d("qcpp", t.getMessage() + "");
            }
        });
    }

    private void findViewById() {
        imgWeather = findViewById(R.id.circle_img_weather);
        tvLocation = findViewById(R.id.tv_location);
        tvDateTime = findViewById(R.id.tv_date_time);
        tvTemperature = findViewById(R.id.tv_temperature);
        tvWeatherText = findViewById(R.id.tv_weather_text);

    }
}