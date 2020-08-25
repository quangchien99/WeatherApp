package com.qcp.weatherproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdministrativeArea {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("LocalizedName")
    @Expose
    private String localizedName;
    @SerializedName("EnglishName")
    @Expose
    private String englishName;
    @SerializedName("Level")
    @Expose
    private Integer level;
    @SerializedName("LocalizedType")
    @Expose
    private String localizedType;
    @SerializedName("EnglishType")
    @Expose
    private String englishType;
    @SerializedName("CountryID")
    @Expose
    private String countryID;

    /**
     * No args constructor for use in serialization
     */
    public AdministrativeArea() {
    }

    /**
     * @param englishName
     * @param localizedName
     * @param localizedType
     * @param level
     * @param englishType
     * @param iD
     * @param countryID
     */
    public AdministrativeArea(String iD, String localizedName, String englishName, Integer level, String localizedType, String englishType, String countryID) {
        super();
        this.iD = iD;
        this.localizedName = localizedName;
        this.englishName = englishName;
        this.level = level;
        this.localizedType = localizedType;
        this.englishType = englishType;
        this.countryID = countryID;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLocalizedType() {
        return localizedType;
    }

    public void setLocalizedType(String localizedType) {
        this.localizedType = localizedType;
    }

    public String getEnglishType() {
        return englishType;
    }

    public void setEnglishType(String englishType) {
        this.englishType = englishType;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }
}
