package com.hidm.coo.util;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Friend {
    String name;
    int age;
    
    Friend() {
        
    }
    
    Friend(String name, int page) {
        this.name = name;
        this.age = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String toString() {
        return name + ", " + age;
    }
}

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
    
    public static void main(String[] args) {
        Friend friend = new Friend("yitian", 25);
        
        String str = JsonUtil.toJson(friend);
        System.out.println(str);
        
        friend = JsonUtil.parseJson(str, Friend.class);
        System.out.println(friend);
    }
}
