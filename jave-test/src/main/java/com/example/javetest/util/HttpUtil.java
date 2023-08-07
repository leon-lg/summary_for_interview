package com.example.javetest.util;

import com.example.javetest.constant.HttpSearchType;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Field;

public class HttpUtil {

    @Value("${weatherapi.forecasts}")
    private String forecastsUrl = "123";

    @Value("${api.url.foodsearch}")
    private String foodSearchUrl = "2222";
    @Value("${api.url.hotelsearch}")
    private String hotelSearchUrl = "3333";

    public String doHttpGet(HttpSearchType httpSearchType){
        Field field = FieldUtils.getDeclaredField(getClass(), httpSearchType.getUrlInfo(), true);
        try {
            Object o = field.get(this);
            String s = o.toString();
            return s;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
