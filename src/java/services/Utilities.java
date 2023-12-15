/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Utilities {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean duplicateTime(Date startTime1, Date endTime1, Date startTime2, Date endTime2) {
        if (startTime1.compareTo(startTime2) > 0) {
            if (startTime1.compareTo(endTime2) > 0) {
                return true;
            } else {
                return false;
            }
        } else if (startTime1.compareTo(startTime2) == 0) {
            return false;
        } else {
            if (endTime1.compareTo(startTime2) < 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static int daysToInt(String day) {
        day = day.trim();
        String[] daysInWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i < daysInWeek.length; i++) {
            if (day.equalsIgnoreCase(daysInWeek[i])) {
                return i + 1;
            }
        }
        return 1;
    }
    
    public static String intToDays(int number) {
        String[] daysInWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return daysInWeek[number-1];
    }

    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static void main(String[] args) {
        Utilities u = new Utilities();
        System.out.println(u.daysToInt("Wednesday"));

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(date);
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }
}
