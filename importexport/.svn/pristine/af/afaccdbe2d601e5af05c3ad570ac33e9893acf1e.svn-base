package com.hidm.importexport.constant;

/**
 * 
*Description: 处理进口数据收货状态信息
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public class ImportInfoConstant {
    public static Integer STATUS_SAVED = 0;
    
    public static Integer STATUS_RELEASED = 1;
    
    public static Integer STATUS_PARTLY_RECEIVED = 2;
    
    public static Integer STATUSS_COMPLETE_RECEIVED = 3;
    
    public static String STATUS_SAVED_DESC = "已保存";
    
    public static String STATUS_RELEASED_DESC = "已Release";
    
    public static String STATUS_PARTLY_RECEIVED_DESC = "部分收货";
    
    public static String STATUS_COMPLETE_RECEIVED_DESC = "完全收货";

    public static String getStatusDesc(int status) {
        if (STATUS_SAVED == status) {
            return STATUS_SAVED_DESC;
        } else if (STATUS_RELEASED == status) {
            return STATUS_RELEASED_DESC;
        } else if (STATUS_PARTLY_RECEIVED == status) {
            return STATUS_PARTLY_RECEIVED_DESC;
        } else if (STATUSS_COMPLETE_RECEIVED == status) {
            return STATUS_COMPLETE_RECEIVED_DESC;
        } else {
            return null;
        }
        
    }
    
    public static Integer ACTION_RELEASE = 1;
    public static Integer ACTION_UNRELEASE = 0;
}