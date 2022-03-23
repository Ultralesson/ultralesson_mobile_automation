package com.ultralesson.training.mobile.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getTodayDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/dd/yyyy");
        return simpleDateFormat.format(date);
    }
}
