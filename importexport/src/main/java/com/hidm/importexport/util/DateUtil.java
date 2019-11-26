package com.hidm.importexport.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);
    
    private final static String DATE_FORMATE = "yyyy-MM-dd";
    
    public static Date parseDate(String str) {  
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATE);
        try {
            return sdf.parse(str);
        } catch (Exception e) {
            log.error("Failed to parse date. str: " + str);
            return null;
        }
    }
    
    public static Date parseDate(String str, String pattern) {  
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(str);
        } catch (Exception e) {
            log.error("Failed to parse date. str: " + str);
            return null;
        }
    }
    
    public static String formatDate(Date date) {  
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATE);
        try {
            return sdf.format(date);
        } catch (Exception e) {
            log.error("Failed to format date. date: " + date);
            return null;
        }
    }
}
