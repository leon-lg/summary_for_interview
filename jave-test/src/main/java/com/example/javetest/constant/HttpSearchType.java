package com.example.javetest.constant;

public enum HttpSearchType {

    none("none"),
    WEATHER_INFO("forecastsUrl"),
    food_info("foodSearchUrl"),
    hotel_info("hotelSearchUrl");


    private String urlInfo;

    HttpSearchType(String urlInfo){
        this.urlInfo = urlInfo;
    }

    public String getUrlInfo() {
        return urlInfo;
    }
}
