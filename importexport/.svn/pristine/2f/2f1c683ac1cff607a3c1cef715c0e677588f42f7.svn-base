package com.hidm.importexport.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.hidm.importexport.vo.PortalDeptVo;

public class RestUtil {
    private static Logger log = Logger.getLogger(RestUtil.class);
    
    public static String get(String url, Map<String, String> param) {
        if (null != url && null != param && !param.isEmpty()) {
            int i = 0;
            for (Map.Entry<String, String> entry : param.entrySet()) {
                if (i++ == 0) {
                    url += "?" + entry.getKey() + "=" + entry.getValue();
                } else {
                    url += "&" + entry.getKey() + "=" + entry.getValue();
                }
            }
        }
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = null;
        
        try {
            response1 = httpclient.execute(httpGet);
            HttpEntity entity1 = response1.getEntity();
            String str = EntityUtils.toString(entity1);
            return str;
        } catch (Exception e) {
            log.error("Failed to get. url:" + url + ", param:" + param);
            return null;
        } finally {
            try {
                response1.close();
            } catch (IOException e) {
                log.error("Failed to close get response. url:" + url + ", param:" + param);
            }
        }
    }
    
    public static <T> T get(String url, Map<String, String> param, Class<T> clazz) {
        String str = get(url, param);
        T obj = JsonUtil.parseJson(str, clazz);
        return obj;
    }
    
    public static String post(String url, Map<String, String> param) {
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        if (null != param && !param.isEmpty()) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response1 = null;
        
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            response1 = httpclient.execute(httpPost);
            HttpEntity entity1 = response1.getEntity();
            String str = EntityUtils.toString(entity1);
            return str;
        } catch (Exception e) {
            log.error("Failed to post. url:" + url + ", param:" + param);
            return null;
        } finally {
            try {
                response1.close();
            } catch (IOException e) {
                log.error("Failed to close post response. url:" + url + ", param:" + param);
            }
        }
    }
    
    public static <T> T post(String url, Map<String, String> param, Class<T> clazz) {
        String str = post(url, param);
        T obj = JsonUtil.parseJson(str, clazz);
        return obj;
    }

    public static void main(String[] args) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userid", "E100100");
        PortalDeptVo vo = RestUtil.post("http://portal.hidmgroup.com:8000/get_dept_by_userid.ashx", param, PortalDeptVo.class);
        System.out.println(vo);
    }
}
