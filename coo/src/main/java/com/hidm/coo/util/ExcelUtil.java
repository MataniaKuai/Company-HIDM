package com.hidm.coo.util;

import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
public class ExcelUtil {
    public static String getCellValue(Cell cell) {  
        String cellValue = "";  
        if (cell == null) {  
            return cellValue;  
        }  
        //把数字当成String来读，避免出现1读成1.0的情况  
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {  
            if (!HSSFDateUtil.isCellDateFormatted(cell)) {
                cell.setCellType(Cell.CELL_TYPE_STRING);  
            }
        }  
        //判断数据的类型  
        switch (cell.getCellType()) {  
            case Cell.CELL_TYPE_NUMERIC: //数字  
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    cellValue = DateUtil.formatDate(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));//获取日期并format
                } else {
                    cellValue = String.valueOf(cell.getNumericCellValue());  
                }
                break;  
            case Cell.CELL_TYPE_STRING: //字符串  
                cellValue = String.valueOf(cell.getStringCellValue());  
                break;  
            case Cell.CELL_TYPE_BOOLEAN: //Boolean  
                cellValue = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case Cell.CELL_TYPE_FORMULA: //公式  
                cellValue = String.valueOf(cell.getCellFormula());  
                break;
            case Cell.CELL_TYPE_BLANK: //空值   
                cellValue = "";  
                break;  
            case Cell.CELL_TYPE_ERROR: //故障  
                cellValue = "非法字符";  
                break;  
            default:  
                cellValue = "未知类型";  
                break;  
        }  
        return cellValue;  
    }  

    public static Double doubleFormat(String value) {  
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            return Double.parseDouble(value);
        }
    }  

    public static Integer integerFormat(String value) {  
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            return Integer.parseInt(value);
        }
    }  

    public static BigDecimal bigDecimalFormat(String value) {  
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            BigDecimal decimal = new BigDecimal(value);
            BigDecimal setScale = decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
            return setScale;
        }
    } 
}
