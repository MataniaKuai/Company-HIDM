package com.hidm.booksharingscore.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataUtil {
	
	private static final Logger log = LoggerFactory.getLogger(DataUtil.class);
	
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(!checkIP(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(!checkIP(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(!checkIP(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public static boolean checkIP(String ip) {
		if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)
				|| ip.split(".").length != 4) {
			return false;
		}
		return true;
	}
	
	public static String decoder(String url, String token, String remoteAddr) throws UnsupportedEncodingException {
		if(null == token || null == remoteAddr) {
			return null;
		}
 		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response1 = null;
		httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
		List<BasicNameValuePair> list = new LinkedList<BasicNameValuePair>();
		BasicNameValuePair param1 = new BasicNameValuePair("token", token);
		BasicNameValuePair param2 = new BasicNameValuePair("remoteAddr",remoteAddr);
		list.add(param1);
		list.add(param2);
		UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(list, "UTF-8");
		try {
			httpPost.setEntity(entityParam);
			response1 = httpclient.execute(httpPost);
			HttpEntity entity1 = response1.getEntity();
			String str = EntityUtils.toString(entity1);
			return str;
		}catch(Exception e) {
			log.error("Failed to get. url:" + url);
			return null;
		}finally {
			try {
				response1.close();
			}catch(IOException e) {
				log.error("Failed to close get response. url:" + url);
			}
		}
	}
}
