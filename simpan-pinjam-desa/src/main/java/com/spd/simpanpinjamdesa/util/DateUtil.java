package com.spd.simpanpinjamdesa.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date stringToDate(String dateAsString) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
        Date dateResult = null;
        try {
            dateResult = formatter.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateResult);
        return dateResult;
    }

    public static String dateToString(Date dateInput) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(dateInput);
    }

    public static Date getCurrentDate() {
        long millis = System.currentTimeMillis();
        return new java.sql.Date(millis);
    }

    public static Timestamp getCurrentTimestamp() {
        Date date= new Date();
        long time = date.getTime();
        return new Timestamp(time);
    }

}
