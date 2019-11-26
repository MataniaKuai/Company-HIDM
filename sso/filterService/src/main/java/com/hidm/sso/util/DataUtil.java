package com.hidm.sso.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataUtil {
    private static final Logger log = LoggerFactory.getLogger(DataUtil.class);
    
    /**
     * 删除单个文件
     * @param fileName  要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                log.info("删除文件" + fileName + "成功！");
                return true;
            } else {
                log.info("删除文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除文件失败：" + fileName + "不存在！");
            return false;
        }
    }


    /**
     * 获取ip
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (!checkIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!checkIP(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    /**
     * 校验ip
     * @param ip
     * @return
     */
    public static boolean checkIP(String ip) {
        if (ip == null || ip.length() == 0 || "unkown".equalsIgnoreCase(ip)
                || ip.split(".").length != 4) {
            return false;
        }
        return true;
    }
}
