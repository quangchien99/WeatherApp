package com.qcp.weatherproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("LocalObservationDateTime")
    @Expose
    private String localObservationDateTime;
    @SerializedName("EpochTime")
    @Expose
    private Integer epochTime;
    @SerializedName("WeatherText")
    @Expose
    private String weatherText;
    @SerializedName("WeatherIcon")
    @Expose
    private Integer weatherIcon;
    @SerializedName("HasPrecipitation")
    @Expose
    private Boolean hasPrecipitation;
    @SerializedName("PrecipitationType")
    @Expose
    private Object precipitationType;
    @SerializedName("IsDayTime")
    @Expose
    private Boolean isDayTime;
    @SerializedName("Temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("MobileLink")
    @Expose
    private String mobileLink;
    @SerializedName("Link")
    @Expose
    private String link;

    /**
     * No args constructor for use in serialization
     */
    public Weather() {
    }

    /**
     * @param hasPrecipitation
     * @param weatherIcon
     * @param precipitationType
     * @param localObservationDateTime
     * @param isDayTime
     * @param temperature
     * @param link
     * @param mobileLink
     * @param epochTime
     * @param weatherText
     */
    public Weather(String localObservationDateTime, Integer epochTime, String weatherText, Integer weatherIcon, Boolean hasPrecipitation, Object precipitationType, Boolean isDayTime, Temperature temperature, String mobileLink, String link) {
        super();
        this.localObservationDateTime = localObservationDateTime;
        this.epochTime = epochTime;
        this.weatherText = weatherText;
        this.weatherIcon = weatherIcon;
        this.hasPrecipitation = hasPrecipitation;
        this.precipitationType = precipitationType;
        this.isDayTime = isDayTime;
        this.temperature = temperature;
        this.mobileLink = mobileLink;
        this.link = link;
    }

    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    public Integer getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(Integer epochTime) {
        this.epochTime = epochTime;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Integer getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(Integer weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public Object getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(Object precipitationType) {
        this.precipitationType = precipitationType;
    }

    public Boolean getIsDayTime() {
        return isDayTime;
    }

    public void setIsDayTime(Boolean isDayTime) {
        this.isDayTime = isDayTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
