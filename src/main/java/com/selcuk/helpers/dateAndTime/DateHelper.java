package com.selcuk.helpers.dateAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static String generateCurrentDateAndTime() {
        return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
    }
}
