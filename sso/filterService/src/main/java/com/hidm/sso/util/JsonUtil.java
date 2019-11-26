package com.hidm.sso.util;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static Logger log = Logger.getLogger(JsonUtil.class);
    
    public static <T> T parseJson(String json, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        
        T obj;
        try {
            obj = mapper.readValue(json, clazz);
            return obj;
        } catch (Exception e) {
            log.error("Failed to parseJson. json:" + json + ", clazz:" + clazz, e);
            return null;
        }
    }
    
    public static String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String text = mapper.writeValueAsString(obj);
            return text;
        } catch (JsonProcessingException e) {
            log.error("Failed to toJson. obj:" + obj, e);
            return null;
        }
    }
}
