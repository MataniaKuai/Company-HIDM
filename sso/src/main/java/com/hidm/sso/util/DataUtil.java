package com.hidm.sso.util;

import javax.servlet.http.HttpServletRequest;

public class DataUtil {
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
}
