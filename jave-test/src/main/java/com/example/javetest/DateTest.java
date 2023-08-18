package com.example.javetest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTest {

    public static void main(String[] args) {
        //生成标准LOCAL_DATE_TIME
        LocalDateTime ldtNow = LocalDateTime.now();
        System.out.println(ldtNow);

        String localDateTime = "2023-08-08T16:37:09.187";
        LocalDateTime parse = LocalDateTime.parse(localDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(parse);

        String format = parse.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(format);

        //比较两个日期的前后
        LocalTime lt1 = LocalTime.parse(localDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalTime lt2 = ldtNow.toLocalTime();
        System.out.println(lt1.isBefore(lt2));

        System.out.println(parse.getDayOfYear());
    }
}
