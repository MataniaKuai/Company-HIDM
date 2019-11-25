package com.hidm.importexport.util;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);
    
    private final static String DATE_FORMATE = "yyyy-MM";
    
    public static String formatDate(String date) {  
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATE);
        try {
            return sdf.format(sdf.parse(date));
        } catch (Exception e) {
            log.error("Failed to format date. date: " + date);
            return null;
        }
    }
    
    public static String getEnMonth(String mon) { 
        String enMon = "";
        switch(mon) 
        { 
            case "01": 
                enMon = "Jan";
                break;
            case "02": 
                enMon = "Feb";
                break; 
            case "03": 
                enMon = "Mar";
                break; 
            case "04": 
                enMon = "Apr";
                break; 
            case "05": 
                enMon = "May";
                break; 
            case "06": 
                enMon = "June";
                break; 
            case "07": 
                enMon = "July";
                break; 
            case "08": 
                enMon = "Aug";
                break; 
            case "09": 
                enMon = "Sept";
                break; 
            case "10": 
                enMon = "Oct";
                break; 
            case "11": 
                enMon = "Nov";
                break; 
            case "12": 
                enMon = "Dec";
                break; 
        } 
        return enMon;
    }
}
