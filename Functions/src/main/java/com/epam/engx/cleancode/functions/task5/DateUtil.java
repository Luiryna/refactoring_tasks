package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    public Date changeToMidnight(Date date, boolean up) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        resetTimeToZero(calendar);
        return up ? addDay(calendar) : subtractDay(calendar);
    }

    public Date resetTimeToZero(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public Date addDay(Calendar calendar) {
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    public Date subtractDay(Calendar calendar) {
        calendar.add(Calendar.DATE, -1);
        return  calendar.getTime();
    }
}
