package com.qcp.weatherproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imperial {

    @SerializedName("Value")
    @Expose
    private Double value;
    @SerializedName("Unit")
    @Expose
    private String unit;
    @SerializedName("UnitType")
    @Expose
    private Integer unitType;

    /**
     * No args constructor for use in serialization
     */
    public Imperial() {
    }

    /**
     * @param unitType
     * @param unit
     * @param value
     */
    public Imperial(Double value, String unit, Integer unitType) {
        super();
        this.value = value;
        this.unit = unit;
        this.unitType = unitType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

}
