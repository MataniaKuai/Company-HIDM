package com.hidm.coo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataProvider;
 
/**
 * 与SAP连接配置
 * @author taofeng
 */

@Service(value = "sapConService")
public class SAPConn {
    private static Logger log = Logger.getLogger(SAPConn.class); // 初始化日志对象
    
    private static final String ABAP_AS_POOLED = "ABAP_AS_WITH_POOL";

    @Value("${sap.jco_ashost}")
    private String jcoAshost;
    
    @Value("${sap.jco_sysnr}")
    private String jcoSysnr;

    @Value("${sap.jco_client}")
    private String jcoClient;

    @Value("${sap.jco_user}")
    private String jcoUser;

    @Value("${sap.jco_passwd}")
    private String jcoPasswd;

    @Value("${sap.jco_lang}")
    private String jcoLang;

    @Value("${sap.jco_pool_capacity}")
    private String jcoCapacity;

    @Value("${sap.jco_peak_limit}")
    private String jcoLimit;
    
    private boolean initialized;
    
    
    private void init() {
        if (!initialized) {
            Properties connectProperties = new Properties();
            
            connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, jcoAshost);//服务器
            connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,  jcoSysnr);        //系统编号
            connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, jcoClient);       //SAP集团
            connectProperties.setProperty(DestinationDataProvider.JCO_USER,   jcoUser);  //SAP用户名
            
            connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, jcoPasswd);     //密码
            connectProperties.setProperty(DestinationDataProvider.JCO_LANG,   jcoLang);        //登录语言
            connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, jcoCapacity);  //最大连接数  
            connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, jcoLimit);     //最大连接线程
            
            createDataFile(ABAP_AS_POOLED, "jcoDestination", connectProperties);
            initialized = true;
        }
    }

    
    /**
     * 创建SAP接口属性文件。
     * @param name    ABAP管道名称
     * @param suffix    属性文件后缀
     * @param properties    属性文件内容
     */
    private static void createDataFile(String name, String suffix, Properties properties) {
        File cfg = new File(name+"."+suffix);
        if (cfg.exists()) {
            cfg.deleteOnExit();
        }
        try {
            FileOutputStream fos = new FileOutputStream(cfg, false);
            properties.store(fos, "for tests only !");
            fos.close();
        } catch (Exception e) {
            log.error("Create Data file fault.", e);
            throw new RuntimeException("Unable to create the destination file " + cfg.getName(), e);
        }
    }
    
    /**
     * 获取SAP连接
     * @return    SAP连接对象
     */
    public JCoDestination connect() {
        init();
        JCoDestination destination = null;
        try {
            destination = JCoDestinationManager.getDestination(ABAP_AS_POOLED);
        } catch (JCoException e) {
            log.error("Connect SAP fault.", e);
        }
        return destination;
    }
    
}