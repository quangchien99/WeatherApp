package com.qcp.weatherproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature {

    @SerializedName("Metric")
    @Expose
    private Metric metric;
    @SerializedName("Imperial")
    @Expose
    private Imperial imperial;

    /**
     * No args constructor for use in serialization
     */
    public Temperature() {
    }

    /**
     * @param metric
     * @param imperial
     */
    public Temperature(Metric metric, Imperial imperial) {
        super();
        this.metric = metric;
        this.imperial = imperial;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Imperial getImperial() {
        return imperial;
    }

    public void setImperial(Imperial imperial) {
        this.imperial = imperial;
    }

}