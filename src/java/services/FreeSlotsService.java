/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.awt.Event;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import models.FreeSlots;
import repositories.FreeSlotsRepository;

/**
 *
 * @author DELL
 */
public class FreeSlotsService {

    public static void createSetBy(String setBy, FreeSlots fs) throws SQLException {
        FreeSlotsRepository fsr = new FreeSlotsRepository();
        Date startTime = fs.getStartTime();
        Date endTime = fs.getEndTime();
        fsr.create(fs);
        System.out.println(fs.toString());
        System.out.println("count " + fs.getCount());
        if (setBy.equalsIgnoreCase("date")) {
            for (int i = 0; i < fs.getCount() - 1; i++) {
                startTime = getNextDate(startTime);
                fs.setStartTime(startTime);
                endTime = getNextDate(endTime);
                fs.setEndTime(endTime);
//                fsr.create(fs);
                System.out.println(fs.toString());
            }
        } else {
            for (int i = 0; i < fs.getCount() - 1; i++) {
                startTime = getDateNextWeek(startTime);
                fs.setStartTime(startTime);
                endTime = getDateNextWeek(endTime);
                fs.setEndTime(endTime);
//                fsr.create(fs);
            }
        }
    }

    public boolean duplicateFreeSlot(FreeSlots f) throws SQLException {
        FreeSlotsRepository fsr = new FreeSlotsRepository();
        List<FreeSlots> list = fsr.listByDate(f.getStartTime());
        for(FreeSlots fl : list) {
            if(!Utilities.duplicateTime(f.getStartTime(), f.getEndTime(), fl.getStartTime(), fl.getEndTime())) {
                return false;
            }
        }
        return true;
    }

    public Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    public static Date getNextDate(Date curDate) {
        Date nextDate = null;
        try {
            Calendar today = Calendar.getInstance();

            today.setTime(curDate);
            today.add(Calendar.DAY_OF_YEAR, 1);

            nextDate = today.getTime();
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return nextDate;
        }
        return nextDate;
    }

    public static Date getDateNextWeek(Date curDate) {
        Date nextWeek = null;
        try {
            Calendar today = Calendar.getInstance();

            today.setTime(curDate);
            today.add(Calendar.DAY_OF_YEAR, 1);

            return nextWeek = today.getTime();
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return nextWeek;
        }
    }

    public static void main(String[] args) throws SQLException {
        Date date = new Date();
        System.out.println(date);
        FreeSlotsService fs = new FreeSlotsService();
        
        Date date1 = fs.getNextDate(date);
        FreeSlots f = new FreeSlots(1, "SWP391", date, date1, "123", 0, "asd", 1, "GV0002");
        fs.createSetBy("date", f);                                                                              

        
        
        
        
        
        
        
//        System.out.println("date " + date);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println("DATE: " + calendar);
//        System.out.println("d: " + calendar.get(Calendar.DATE) + " m : " + calendar.get(Calendar.MONTH) + " y: " + calendar.get(Calendar.YEAR));
//
//        System.out.printf("%d, %d, %d \n", fs.dateToCalendar(date).DATE, fs.dateToCalendar(date).DAY_OF_MONTH, fs.dateToCalendar(date).YEAR);
    }

}
