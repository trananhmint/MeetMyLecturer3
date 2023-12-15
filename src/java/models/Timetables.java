/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class Timetables {
    private String subjectCode;
    private String slotID;
    private String lecturerID;
    private String semesterID;
    private String day1;
    private String day2;
    private Date startTime;
    private Date endTime;

    public Timetables() {
    }

    public Timetables(String subjectCode, String slotID) {
        this.subjectCode = subjectCode;
        this.slotID = slotID;
    }
    
    

    public Timetables(String subjectCode, String slotID, String lecturerID, String semesterID) {
        this.subjectCode = subjectCode;
        this.slotID = slotID;
        this.lecturerID = lecturerID;
        this.semesterID = semesterID;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(String semesterID) {
        this.semesterID = semesterID;
    }

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    
}
