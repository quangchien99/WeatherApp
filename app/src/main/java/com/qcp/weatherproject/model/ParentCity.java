package com.qcp.weatherproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentCity {

    @SerializedName("Key")
    @Expose
    private String key;
    @SerializedName("LocalizedName")
    @Expose
    private String localizedName;
    @SerializedName("EnglishName")
    @Expose
    private String englishName;

    /**
     * No args constructor for use in serialization
     *
     */
    public ParentCity() {
    }

    /**
     *
     * @param englishName
     * @param localizedName
     * @param key
     */
    public ParentCity(String key, String localizedName, String englishName) {
        super();
        this.key = key;
        this.localizedName = localizedName;
        this.englishName = englishName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

}
