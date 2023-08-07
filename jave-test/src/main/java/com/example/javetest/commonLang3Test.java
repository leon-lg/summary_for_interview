package com.example.javetest;

import com.example.javetest.constant.HttpSearchType;
import com.example.javetest.util.HttpUtil;

public class commonLang3Test {

    public static void main(String[] args) {
        HttpUtil httpUtil = new HttpUtil();
        String s = httpUtil.doHttpGet(HttpSearchType.food_info);
        System.out.println(s);

        String name = HttpSearchType.WEATHER_INFO.name();
        System.out.println(name);
    }
}
