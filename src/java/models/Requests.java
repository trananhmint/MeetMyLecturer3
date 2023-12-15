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
public class Requests {
    private int ID;
    private String requestID;
    private int status;
    private String subjectCode;
    private Date startTime;
    private Date endTime;
    private String description;
    private String studentID;
    private String lecturerID;
    private String statusText;

    public Requests() {
    }

    public Requests(int ID, String requestID, int status, String subjectCode, Date startTime, Date endTime, String description, String studentID, String lecturerID, String statusText) {
        this.ID = ID;
        this.requestID = requestID;
        this.status = status;
        this.subjectCode = subjectCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.studentID = studentID;
        this.lecturerID = lecturerID;
        this.statusText = statusText;
    }
    
    

    public Requests(int ID, int status, String subjectCode, String description, String studentID, String lecturerID) {
        this.ID = ID;
        this.status = status;
        this.subjectCode = subjectCode;
        this.description = description;
        this.studentID = studentID;
        this.lecturerID = lecturerID;
    }

    public Requests(int ID, String requestID, int status, String subjectCode, Date startTime, Date endTime, String description, String studentID, String lecturerID) {
        this.ID = ID;
        this.requestID = requestID;
        this.status = status;
        this.subjectCode = subjectCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.studentID = studentID;
        this.lecturerID = lecturerID;
    }

    public Requests(int status, String subjectCode, Date startTime, Date endTime, String description, String studentID, String lecturerID) {
        this.status = status;
        this.subjectCode = subjectCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.studentID = studentID;
        this.lecturerID = lecturerID;
    }

    public Requests(int ID, int status, String subjectCode, Date startTime, Date endTime, String description, String studentID, String lecturerID) {
        this.ID = ID;
        this.status = status;
        this.subjectCode = subjectCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.studentID = studentID;
        this.lecturerID = lecturerID;
    }
    


    public Requests(int ID, int status) {
        this.ID = ID;
        this.status = status;
    }
    
    
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
    
    

    @Override
    public String toString() {
        return "Requests{" + "ID=" + ID + ", requestID=" + requestID + ", status=" + status + ", subjectCode=" + subjectCode + ", startTime=" + startTime + ", endTime=" + endTime + ", description=" + description + ", studentID=" + studentID + ", lecturerID=" + lecturerID + '}';
    }

    
}
