/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.SimpleDateFormat;

/**
 *
 * @author Dell
 */
public class Services {

    private static final String fDate = "yyyy-MM-dd";
    private static final String fTime = "HH:mm";
    private static final String fDateTime = "yyyy-MM-dd HH:mm";

    //Convert Date into String
    public static final SimpleDateFormat sdfDate = new SimpleDateFormat(fDate);
    public static final SimpleDateFormat sdfTime = new SimpleDateFormat(fTime);
    public static final SimpleDateFormat sdfDateTime = new SimpleDateFormat(fDateTime);

    public static String getStatusOfUsers(boolean userStatus) {
        String statusText = null;
        if (userStatus == true) {
            statusText = "Active";
        } else {
            statusText = "Inactive";
        }

        return statusText;
    }

    public static String getStatusOfBookings(boolean status) {
        String statusText = null;
        if (status == true) {
            statusText = "Accepted";
        } else {
            statusText = "Declined";
        }

        return statusText;
    }

    public static String getStatusOfRequests(int status) {
        String statusText = null;
        switch (status) {
            case 0: {
                statusText = "In processing";
                break;
            }

            case 1: {
                statusText = "Accepted";
                break;
            }
            case 2: {
                statusText = "Declined";
                break;
            }
        }

        return statusText;
    }

    public static String getPresenceOfBookings(boolean presence) {
        String presenceText = null;
        if (presence == true) {
            presenceText = "Attended";
        }
        if (presence == false) {
            presenceText = "Absent";
        }

        return presenceText;
    }
}
