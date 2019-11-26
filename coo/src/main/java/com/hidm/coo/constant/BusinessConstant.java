package com.hidm.coo.constant;

/**
 * 
*Description: 处理操作历史日志
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public class BusinessConstant {
	//保存
    public static int BUSINESS_INSERT = 1;
    //提交
    public static int BUSINESS_SUBMIT = 1;
    //更新 
    public static int BUSINESS_UPDATE = 2;   
    //删除
    public static int BUSINESS_DELETE = 3;   
    // 1代表userbase数据 
    public static int BUSINESS_TYPE_USERBASE = 1;           
    // 2代表PRO数据
    public static int BUSINESS_TYPE_PRO = 2;
    // 3代表OP数据 
    public static int BUSINESS_TYPE_OP= 3;
    //  4代表MFG数据
    public static int BUSINESS_TYPE_MFG = 4;
    // 5代表其他参数表数据
    public static int BUSINESS_TYPE_OTHERS = 5;
    // 6代表EQ_Type数据
    public static int BUSINESS_TYPE_EQTYPE = 6;
    // 7代表Material coefficient table数据
    public static int BUSINESS_TYPE_MATERIAL = 7;
    // 8代表Utility table数据
    public static int BUSINESS_TYPE_UTILITY = 8;
    // 9代表Vendtor table数据
    public static int BUSINESS_TYPE_VENDOR = 9;
    // 10代表Model table数据
    public static int BUSINESS_TYPE_MODEL = 10;
}
