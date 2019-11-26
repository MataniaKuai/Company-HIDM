package com.hidm.importexport.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hidm.importexport.constant.ReportConstant;
import com.hidm.importexport.entity.BaseData;
import com.hidm.importexport.service.BaseDataService;


@Component
public class NameConvertCodeUtil {

    private static BaseDataService baseDataService;

    @Autowired
    public void setBaseDataService(BaseDataService  baseDataService) {  
        NameConvertCodeUtil.baseDataService = baseDataService;  
    }  
    
    public static String getGoodsCode(String name) {
        return getCodeByNameCode(name);
    }
    
    public static String getCodeByNameCode(String name) {
        String code = "";
        name = name.replaceAll("（", "(").replaceAll("）", ")");
        // 截取括号中的code
        Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");  
        Matcher matcher = pattern.matcher(name);
        while (matcher.find()) {
            code = matcher.group();
        }
        return code;
    }

    public static String getShipFromCountry(String name) {
        return getCodeByNameCode(name);
    }

    public static String getLoadingPort(String name) {
        return getCodeByNameCode(name);
    }

    public static String getImportPort(String name) {
        return getCodeByNameCode(name);
    }

    public static String getTradingType(String name) {
        return getCodeByNameCode(name);
    }

    public static String getImportCustom(String name) {
        return getCodeByNameCode(name);
    }

    public static String getTaxPreperty(String name) {
        return getCodeByNameCode(name);
    }

    public static String getCarType(String name) {
        return getCodeByNameCode(name);
    }

    public static int nameForNumber(String flag) {
        if (ReportConstant.YES.equals(flag)) {
            return 1;
        } else {
            return 0;
        }
    }


    
    public static String getCodeByName(String name, List<BaseData> list) {
        String code = "";
        if (name.isEmpty()) {
            return code;
        }
        for (BaseData data : list) {
            if (name.trim().toUpperCase().equals(data.getName().trim().toUpperCase())) {
                code = data.getCode();
                break;
            }
        }
        return code;
    }
    public static String getFreightTermCode(String name) {
        List<BaseData> list = baseDataService.allFreightTerms();
        return getCodeByName(name, list);
    }

    public static String getFreightType(String name) {
        List<BaseData> list = baseDataService.allFreightTypes();
        return getCodeByName(name, list);
    }

    public static String getPackingType(String name) {
        List<BaseData> list = baseDataService.allPackingTypes();
        return getCodeByName(name, list);
    }

    public static String getAppType(String name) {
        List<BaseData> list = baseDataService.allAppTypes();
        return getCodeByName(name, list);
    }
}
