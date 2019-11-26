package com.hidm.importexport.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.importexport.constant.ImportInfoConstant;
import com.hidm.importexport.constant.ReportConstant;
import com.hidm.importexport.entity.Asset;
import com.hidm.importexport.entity.ControlDetail;
import com.hidm.importexport.entity.ImportItem;
import com.hidm.importexport.entity.Material;
import com.hidm.importexport.entity.MaterialInventory;
import com.hidm.importexport.entity.ReleaseHis;
import com.hidm.importexport.service.AssetService;
import com.hidm.importexport.service.ControlDetailService;
import com.hidm.importexport.service.ImportInfoService;
import com.hidm.importexport.service.MaterialInventoryService;
import com.hidm.importexport.service.MaterialOrAssetSearchService;
import com.hidm.importexport.service.MaterialService;
import com.hidm.importexport.service.ReleaseHisService;
import com.hidm.importexport.util.DateUtil;
import com.hidm.importexport.vo.AssetSearchVo;
import com.hidm.importexport.vo.AssetVo;
import com.hidm.importexport.vo.ControlDetailSearchVo;
import com.hidm.importexport.vo.ControlDetailVo;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportReportVo;
import com.hidm.importexport.vo.MaterialInventorySearchVo;
import com.hidm.importexport.vo.MaterialInventoryVo;
import com.hidm.importexport.vo.MaterialOrAssetSearchVo;
import com.hidm.importexport.vo.MaterialSearchVo;
import com.hidm.importexport.vo.MaterialVo;
import com.hidm.importexport.vo.PaginationVo;
import com.hidm.importexport.vo.ReleaseHisSearchVo;
import com.hidm.importexport.vo.ReleaseHisVo;
import com.hidm.importexport.vo.TimeRangeVo;

@Controller
public class ReportController {
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);
    
    @Autowired
    private MaterialService materialService;
    
    @Autowired
    private AssetService assetService;
    
    @Autowired
    private ControlDetailService controlDetailService;
    
    @Autowired
    private MaterialInventoryService materialInvenService;
    
    @Autowired
    
    private ImportInfoService importInfoService;
    @Autowired
    private MaterialOrAssetSearchService materialOrAssetSearchService;
    
    @Autowired
    private ReleaseHisService releaseHisService;
    
    @RequestMapping("report/report1")
    public String report1(Model model, HttpSession session) {
        return "/report/report1";
    }
     
    /**
     * 
    *Description: 查查询报表一的记录信息
    *@param materialNo
    *@param assetNo
    *@param goodsCode
    *@param timeRange
    *@param page
    *@param model
    *@param session
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("report/report1/search")
    @ResponseBody
    public Map<String, Object> report1Search(@RequestParam(value="materialNo", required = false) String materialNo, 
            @RequestParam(value="assetNo", required = false) String assetNo, 
            @RequestParam(value="goodsCode", required = false) String goodsCode, 
            TimeRangeVo timeRange, PaginationVo page, Model model, HttpSession session) {
        
        if (null != materialNo && !"".equals(materialNo)) {
            MaterialSearchVo vo = new MaterialSearchVo();
            Material mater = new Material();
            mater.setMaterialNo(materialNo.trim());
            mater.setGoodsCode(goodsCode);
            vo.setMaterial(mater);
            vo.setPage(page);
            
            Date endTime = timeRange.getEndTime();
            if (null != endTime) {
                Calendar c = Calendar.getInstance();
                c.setTime(endTime);
                c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
                endTime = c.getTime();
                timeRange.setEndTime(endTime);
            }
            
            vo.setTimeRange(timeRange);
            page.setRowStart((page.getPage() - 1) * page.getRows());
            
            int total = materialService.count(vo);
            List<MaterialVo> list = materialService.selectList(vo);
            
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("total", total);
            result.put("rows", list);
            return result;
        } else if (null != assetNo && !"".equals(assetNo)) {
            AssetSearchVo vo = new AssetSearchVo();
            Asset asset = new Asset();
            asset.setAssetNo(assetNo.trim());
            asset.setGoodsCode(goodsCode);
            vo.setAsset(asset);
            vo.setPage(page);
            page.setRowStart((page.getPage() - 1) * page.getRows());

            Date endTime = timeRange.getEndTime();
            if (null != endTime) {
                Calendar c = Calendar.getInstance();
                c.setTime(endTime);
                c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
                endTime = c.getTime();
                timeRange.setEndTime(endTime);
            }
            vo.setTimeRangeVo(timeRange); 
            int total = assetService.count(vo);
            List<AssetVo> list = assetService.selectList(vo);
            
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("total", total);
            result.put("rows", list);
            return result;
        } else {
            MaterialOrAssetSearchVo vo = new MaterialOrAssetSearchVo();
            vo.setGoodsCode(goodsCode);
            vo.setTimeRange(timeRange);
            vo.setPage(page);
            page.setRowStart((page.getPage() - 1) * page.getRows());
            int total = materialOrAssetSearchService.count(vo);
            List<MaterialVo> list = materialOrAssetSearchService.selectList(vo);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("total", total);
            result.put("rows", list);
            return result;
        }
        
    }
    
    /**
     * 
    *Description: 查询报表导出数据记录信息
    *@param materialNo
    *@param materialNos
    *@param assetNos
    *@param assetNo
    *@param goodsCode
    *@param timeRange
    *@param page
    *@param response 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping(value = "report/report1/export", method = RequestMethod.GET)
    public void report1Export(@RequestParam(value="materialNo", required = false) String materialNo, String[] materialNos, String[] assetNos,
            @RequestParam(value="assetNo", required = false) String assetNo, 
            @RequestParam(value="goodsCode", required = false) String goodsCode, 
            TimeRangeVo timeRange, PaginationVo page, Model model, HttpSession session, HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Report1");
        
        //如果选择复选框导出
        if ((materialNos != null && materialNos.length > 0) || 
                (assetNos != null && assetNos.length > 0)) {
            MaterialOrAssetSearchVo vo = new MaterialOrAssetSearchVo();
            if (materialNos != null && materialNos.length > 0) {
                vo.setMaterialNos(materialNos);
            }
            if (assetNos != null && assetNos.length > 0) {
                vo.setAssetNos(assetNos);
            }
            
            List<MaterialVo> list = materialOrAssetSearchService.selectExport(vo);
            
            String fileName = "Report1"  + ".xls";
            int rowNum = 1;
            
            String[] headers = {"Goods Code", "Custom Office", "Unit", "Hs Code", "Material No", "Asset No",
                    "Bond CLa", "Goods Description", "中文品名", "Currency", "免表号", "Hi-Tech", "Text_2", "Text_3", "Tax Preperty",
                    "免税文号", "Photo", "Item", "Employee NO"};
            
            try {
                HSSFRow row = sheet.createRow(0);
                for (int i=0; i<headers.length; i++) {
                    HSSFCell cell = row.createCell(i);
                    HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                    cell.setCellValue(text);
                }
                
                for (MaterialVo MVo : list) {
                    HSSFRow row1 = sheet.createRow(rowNum);
                    row1.createCell(0).setCellValue(MVo.getGoodsCodeName());
                    row1.createCell(1).setCellValue(MVo.getCustomOfficeName());
                    row1.createCell(2).setCellValue(MVo.getUnit());
                    row1.createCell(3).setCellValue(MVo.getHsCode());
                    row1.createCell(4).setCellValue(MVo.getMaterialNo());
                    row1.createCell(5).setCellValue(MVo.getAssetNo());
                    row1.createCell(6).setCellValue(MVo.getBondCla1Name() + " " + MVo.getBondCla2Name());
                    row1.createCell(7).setCellValue(MVo.getGoodsDesc());
                    row1.createCell(8).setCellValue(MVo.getChineseName());
                    row1.createCell(9).setCellValue(MVo.getCurrencyName());
                    row1.createCell(10).setCellValue(MVo.getText1());
                    row1.createCell(11).setCellValue(numberFormatter(MVo.getHiTech()));
                    row1.createCell(12).setCellValue(MVo.getText2());
                    row1.createCell(13).setCellValue(MVo.getText3());
                    row1.createCell(14).setCellValue(MVo.getTaxPrepertyName());
                    row1.createCell(15).setCellValue(MVo.getFreeNoName());
                    row1.createCell(16).setCellValue(MVo.getFilePath());
                    row1.createCell(17).setCellValue(MVo.getIterm());
                    row1.createCell(18).setCellValue(MVo.getEmployeeNo());
                    
                    rowNum++;
                }
                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", "attachment;filename=" + fileName);
                response.flushBuffer();
                workbook.write(response.getOutputStream());
            } catch (IOException e) {
                log.error("Failed to export report1.", e);
            } finally {
                
                try {
                    workbook.close();
                } catch (IOException e) {
                    log.error("Failed to export report1.", e);
                }
            }
        }
        
        else if (materialNo != null && !"".equals(materialNo)) {
                MaterialSearchVo vo = new MaterialSearchVo();
                Material material = new Material();
                material.setMaterialNo(materialNo.trim());
                material.setGoodsCode(goodsCode);
                vo.setMaterial(material);
                Date endTime = timeRange.getEndTime();
                if (null != endTime) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(endTime);
                    c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
                    endTime = c.getTime();
                    timeRange.setEndTime(endTime);
                }
                vo.setTimeRange(timeRange);
                
                List<MaterialVo> list = materialService.selectExport(vo);
                
                String fileName = "Report1"  + ".xls";
                
                int rowNum = 1;
                
                String[] headers = {"Goods Code", "Custom Office", "Unit", "Hs Code", "Material No",
                        "Bond CLa", "Goods Description", "中文品名", "Currency", "免表号", "Hi-Tech", "Text_2", "Text_3", "Tax Preperty",
                        "免税文号", "Photo", "Item", "Employee NO"};

                try {
                    HSSFRow row = sheet.createRow(0);
                    
                    for (int i = 0; i < headers.length; i++) {
                        HSSFCell cell = row.createCell(i);
                        HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                        cell.setCellValue(text);
                    }
                    
                    for (MaterialVo mate : list) {
                        HSSFRow row1 = sheet.createRow(rowNum);
                        row1.createCell(0).setCellValue(mate.getGoodsCodeName());
                        row1.createCell(1).setCellValue(mate.getCustomOfficeName());
                        row1.createCell(2).setCellValue(mate.getUnit());
                        row1.createCell(3).setCellValue(mate.getHsCode());
                        row1.createCell(4).setCellValue(mate.getMaterialNo());
                        row1.createCell(5).setCellValue(mate.getBondCla1Name() + " " + mate.getBondCla2Name());
                        row1.createCell(6).setCellValue(mate.getGoodsDesc());
                        row1.createCell(7).setCellValue(mate.getChineseName());
                        row1.createCell(8).setCellValue(mate.getCurrencyName());
                        row1.createCell(9).setCellValue(mate.getText1());
                        row1.createCell(10).setCellValue(numberFormatter(mate.getHiTech()));
                        row1.createCell(11).setCellValue(mate.getText2());
                        row1.createCell(12).setCellValue(mate.getText3());
                        row1.createCell(13).setCellValue(mate.getTaxPrepertyName());
                        row1.createCell(14).setCellValue(mate.getFreeNoName());
                        row1.createCell(15).setCellValue(mate.getFilePath());
                        row1.createCell(16).setCellValue(mate.getIterm());
                        row1.createCell(17).setCellValue(mate.getEmployeeNo());
                        
                        rowNum++;
                    }
                    
                    response.setContentType("application/octet-stream");
                    response.setHeader("Content-disposition", "attachment;filename=" + fileName);
                    response.flushBuffer();
                    workbook.write(response.getOutputStream());
                    
                } catch (Exception e) {
                    log.error("Failed to export report1.", e);
                } finally {
                    try {
                        workbook.close();
                    } catch (IOException e) {
                        log.error("Failed to close workbook.", e);
                    }
                }
        } else if (assetNo != null && !"".equals(assetNo)) {
            AssetSearchVo vo = new AssetSearchVo();
            Asset asset = new Asset();
            asset.setAssetNo(assetNo.trim());
            asset.setGoodsCode(goodsCode);
            vo.setAsset(asset);
            List<AssetVo> list = assetService.selectExport(vo);
            String fileName = "Report1"  + ".xls";
            int rowNum = 1;
           
            String[] headers = {"Goods Code", "Custom Office", "Unit", "Hs Code", "Asset No",
                    "Bond CLa", "Goods Description", "中文品名", "Currency", "免表号", "Hi-Tech", "Text_2", "Text_3", "Tax Preperty",
                    "免税文号", "Photo", "Item", "Employee NO"};
            
            try {
                HSSFRow row = sheet.createRow(0);
                for (int i=0; i<headers.length; i++) {
                    HSSFCell cell = row.createCell(i);
                    HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                    cell.setCellValue(text);
                }
                
                for (AssetVo assetVo : list) {
                    HSSFRow row1 = sheet.createRow(rowNum);
                    row1.createCell(0).setCellValue(assetVo.getGoodsCodeName());
                    row1.createCell(1).setCellValue(assetVo.getCustomOfficeName());
                    row1.createCell(2).setCellValue(assetVo.getUnit());
                    row1.createCell(3).setCellValue(assetVo.getHsCode());
                    row1.createCell(4).setCellValue(assetVo.getAssetNo());
                    row1.createCell(5).setCellValue(assetVo.getBondCla1Name() + " " + assetVo.getBondCla2Name());
                    row1.createCell(6).setCellValue(assetVo.getGoodsDesc());
                    row1.createCell(7).setCellValue(assetVo.getChineseName());
                    row1.createCell(8).setCellValue(assetVo.getCurrencyName());
                    row1.createCell(9).setCellValue(assetVo.getText1());
                    row1.createCell(10).setCellValue(numberFormatter(assetVo.getHiTech()));
                    row1.createCell(11).setCellValue(assetVo.getText2());
                    row1.createCell(12).setCellValue(assetVo.getText3());
                    row1.createCell(13).setCellValue(assetVo.getTaxPrepertyName());
                    row1.createCell(14).setCellValue(assetVo.getFreeNoName());
                    row1.createCell(15).setCellValue(assetVo.getFilePath());
                    row1.createCell(16).setCellValue(assetVo.getIterm());
                    row1.createCell(17).setCellValue(assetVo.getEmployeeNo());
                    
                    rowNum++;
                }
                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", "attachment;filename=" + fileName);
                response.flushBuffer();
                workbook.write(response.getOutputStream());
            } catch (IOException e) {
                log.error("Failed to export report1.", e);
            } finally {
                
                try {
                    workbook.close();
                } catch (IOException e) {
                    log.error("Failed to export report1.", e);
                }
            }
            
            
        } else {
            MaterialOrAssetSearchVo vo = new MaterialOrAssetSearchVo();
            vo.setGoodsCode(goodsCode);
            vo.setTimeRange(timeRange);
            List<MaterialVo> list = materialOrAssetSearchService.selectExport(vo);
            String fileName = "Report1"  + ".xls";
            int rowNum = 1;
            
            String[] headers = {"Goods Code", "Custom Office", "Unit", "Hs Code", "Material No", "Asset No",
                    "Bond CLa", "Goods Description", "中文品名", "Currency", "免表号", "Hi-Tech", "Text_2", "Text_3", "Tax Preperty",
                    "免税文号", "Photo", "Item", "Employee NO"};
            
            try {
                HSSFRow row = sheet.createRow(0);
                for (int i=0; i<headers.length; i++) {
                    HSSFCell cell = row.createCell(i);
                    HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                    cell.setCellValue(text);
                }
                
                for (MaterialVo MVo : list) {
                    HSSFRow row1 = sheet.createRow(rowNum);
                    row1.createCell(0).setCellValue(MVo.getGoodsCodeName());
                    row1.createCell(1).setCellValue(MVo.getCustomOfficeName());
                    row1.createCell(2).setCellValue(MVo.getUnit());
                    row1.createCell(3).setCellValue(MVo.getHsCode());
                    row1.createCell(4).setCellValue(MVo.getMaterialNo());
                    row1.createCell(5).setCellValue(MVo.getAssetNo());
                    row1.createCell(6).setCellValue(MVo.getBondCla1Name() + " " + MVo.getBondCla2Name());
                    row1.createCell(7).setCellValue(MVo.getGoodsDesc());
                    row1.createCell(8).setCellValue(MVo.getChineseName());
                    row1.createCell(9).setCellValue(MVo.getCurrencyName());
                    row1.createCell(10).setCellValue(MVo.getText1());
                    row1.createCell(11).setCellValue(numberFormatter(MVo.getHiTech()));
                    row1.createCell(12).setCellValue(MVo.getText2());
                    row1.createCell(13).setCellValue(MVo.getText3());
                    row1.createCell(14).setCellValue(MVo.getTaxPrepertyName());
                    row1.createCell(15).setCellValue(MVo.getFreeNoName());
                    row1.createCell(16).setCellValue(MVo.getFilePath());
                    row1.createCell(17).setCellValue(MVo.getIterm());
                    row1.createCell(18).setCellValue(MVo.getEmployeeNo());
                    
                    rowNum++;
                }
                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", "attachment;filename=" + fileName);
                response.flushBuffer();
                workbook.write(response.getOutputStream());
            } catch (IOException e) {
                log.error("Failed to export report1.", e);
            } finally {
                
                try {
                    workbook.close();
                } catch (IOException e) {
                    log.error("Failed to export report1.", e);
                }
            }
            
        }
    }
    
    @RequestMapping("report/report2")
    public String report2(Model model, HttpSession session) {
        return "/report/report2";
    }
    
    /**
     * 
    *Description: 查询报表二的记录信息
    *@param controlDetail
    *@param timeRange
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("report/report2/search")
    @ResponseBody
    public Map<String, Object> report2Search(ControlDetail controlDetail, TimeRangeVo timeRange, PaginationVo page, Model model, HttpSession session) {
        ControlDetailSearchVo vo = new ControlDetailSearchVo();
        vo.setControlDetail(controlDetail);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        Date endTime = timeRange.getEndTime();
        if (null != endTime) {
            Calendar c = Calendar.getInstance();
            c.setTime(endTime);
            c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
            endTime = c.getTime();
            timeRange.setEndTime(endTime);
        }
        vo.setTimeRange(timeRange);
        
        int total = controlDetailService.count(vo);
        List<ControlDetailVo> list = controlDetailService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 查询报表二导出记录信息
    *@param controlDetail
    *@param timeRange
    *@param response
    *@param materialNos
    *@param assetNos 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping(value = "report/report2/export", method = RequestMethod.GET)
    public void report2Export(ControlDetail controlDetail, TimeRangeVo timeRange, HttpServletResponse response, String[] materialNos, String[] assetNos) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Report2");

        ControlDetailSearchVo vo = new ControlDetailSearchVo();
        //如果选择复选框导出
        if ((materialNos != null && materialNos.length > 0) || 
                (assetNos != null && assetNos.length > 0)) {
            if (materialNos != null && materialNos.length > 0) {
                vo.setMaterialNos(materialNos);
            }
            if (assetNos != null && assetNos.length > 0) {
                vo.setAssetNos(assetNos);
            }
        } else {
            vo.setControlDetail(controlDetail);
            
            Date endTime = timeRange.getEndTime();
            if (null != endTime) {
                Calendar c = Calendar.getInstance();
                c.setTime(endTime);
                c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
                endTime = c.getTime();
                timeRange.setEndTime(endTime);
            }
            vo.setTimeRange(timeRange);
        }
        
        List<ControlDetailVo> list = controlDetailService.selectExport(vo);

        String fileName = "Report2"  + ".xls";

        int rowNum = 1;

        String[] headers = {"Goods Code", "Material No", "Asset No", "Po No", "原进口数量", "出厂数量", "Po Item", "Gr No", "Goods Description", "中文品名", "Tax Preperty", 
                "Release Date", "监管期到期日", "监管状态", "解除监管方式", "出厂时间", "出厂原因", "复运出口原因", 
                "RE-EXPORT NO", "出厂放行单编号", "是否回厂", "回厂时间","解除监管日期", "Employee No"};

        try {
            HSSFRow row = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            for (ControlDetailVo cd : list) {
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(cd.getGoodsCodeName());
                row1.createCell(1).setCellValue(cd.getMaterialNo());
                row1.createCell(2).setCellValue(cd.getAssetNo());
                row1.createCell(3).setCellValue(cd.getPoNo());
                if(cd.getQty() != null) {
                    row1.createCell(4).setCellValue(cd.getQty().toString());
                }
                if(cd.getOutQty() != null) {
                    row1.createCell(5).setCellValue(cd.getOutQty().toString());
                }
                row1.createCell(6).setCellValue(cd.getPoItem());
                row1.createCell(7).setCellValue(cd.getGrNo());
                row1.createCell(8).setCellValue(cd.getGoodsDesc());
                row1.createCell(9).setCellValue(cd.getChineseName());
                row1.createCell(10).setCellValue(cd.getTaxPrepertyName());
                row1.createCell(11).setCellValue(DateUtil.formatDate(cd.getReleaseTime()));
                row1.createCell(12).setCellValue(DateUtil.formatDate(cd.getExpireTime()));
                row1.createCell(13).setCellValue(cd.getControlStatusName());
                row1.createCell(14).setCellValue(cd.getRelieveModeName());
                row1.createCell(15).setCellValue(DateUtil.formatDate(cd.getOutTime()));
                row1.createCell(16).setCellValue(cd.getOutReasonName());
                row1.createCell(17).setCellValue(cd.getReexportReasonName());
                row1.createCell(18).setCellValue(cd.getReexportNo());
                row1.createCell(19).setCellValue(cd.getOutReleaseNo());
                row1.createCell(20).setCellValue(numberFormatter(cd.getIsReturn()));
                row1.createCell(21).setCellValue(DateUtil.formatDate(cd.getReturnTime()));
                row1.createCell(22).setCellValue(DateUtil.formatDate(cd.getRelieveTime()));
                row1.createCell(23).setCellValue(cd.getEmployeeNo());
                rowNum++;
            }

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            log.error("Failed to export report2.", e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                log.error("Failed to close workbook2.", e);
            }
        }
    }
    
    @RequestMapping("report/report3")
    public String report3(Model model, HttpSession session) {
        return "/report/report3";
    }
    
    /**
     * 
    *Description: 查询报表三的记录信息
    *@param materialInventory
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("report/report3/search")
    @ResponseBody
    public Map<String, Object> report3Search(MaterialInventory materialInventory, PaginationVo page, Model model, HttpSession session) {
        MaterialInventorySearchVo vo = new MaterialInventorySearchVo();
        vo.setMaterialInventory(materialInventory);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        
        int total = materialInvenService.countList(vo);
        List<MaterialInventoryVo> list = materialInvenService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 按照年份查询报表三的记录信息
    *@param model
    *@param session
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("report/report3/allHistMon")
    @ResponseBody
    public Map<String, Object> allHistMon(Model model, HttpSession session) {
        List<MaterialInventoryVo> list = materialInvenService.selectHistMon();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 查询报表3的导出数据记录
    *@param materialInventory
    *@param inventoryIds
    *@param response 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping(value = "report/report3/export", method = RequestMethod.GET)
    public void report3Export(MaterialInventory materialInventory, String[] inventoryIds, HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Report3");

        MaterialInventorySearchVo vo = new MaterialInventorySearchVo();
        if (inventoryIds != null && inventoryIds.length > 0) {
            vo.setInventoryIds(inventoryIds);
        } else {
            vo.setMaterialInventory(materialInventory);
        }
        
        List<MaterialInventoryVo> list = materialInvenService.selectExport(vo);

        String fileName = "Report3"  + ".xls";

        int rowNum = 1;

        String[] headers = {"Goods Code", "Goods Description", "中文品名", "Hs Code ", "Tax Preperty", "免税文号", 
                "Iterm", "Unit", "Material No", "Unit Price", "Vendor", "使用部门", "User", "收货数量", "退货数量", 
                "领用数量", "退料数量", "生产报废", "在线数量", "库存报废数量", "转售数量", "盘盈数量", "盘亏数量", "报废库存", "销毁数量"};

        try {
            HSSFRow row = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            for (MaterialInventoryVo mi : list) {
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(mi.getGoodsCodeName());
                row1.createCell(1).setCellValue(mi.getGoodsDescription());
                row1.createCell(2).setCellValue(mi.getGoodsDescriptionCn());
                row1.createCell(3).setCellValue(mi.getHsCode());
                row1.createCell(4).setCellValue(mi.getTaxPrepertyName());
                row1.createCell(5).setCellValue(mi.getFreeNoName());
                row1.createCell(6).setCellValue(mi.getIterm());
                row1.createCell(7).setCellValue(mi.getUnit());
                row1.createCell(8).setCellValue(mi.getMaterialNo());
                row1.createCell(9).setCellValue(mi.getUnitPrice());
                
                row1.createCell(10).setCellValue(mi.getVendor());
                row1.createCell(11).setCellValue(mi.getDept());
                row1.createCell(12).setCellValue(mi.getUserId());
                row1.createCell(13).setCellValue(mi.getGrQty());
                row1.createCell(14).setCellValue(mi.getRetreatGoodsQty());
                row1.createCell(15).setCellValue(mi.getUseGoodsQty());
                row1.createCell(16).setCellValue(mi.getReturnMaterialQty());
                row1.createCell(17).setCellValue(mi.getProductionScrapQty());
                row1.createCell(18).setCellValue(mi.getInlineGoodsQty());
                row1.createCell(19).setCellValue(mi.getInventoryScrapQty());
                row1.createCell(20).setCellValue(mi.getResaleQty());
                row1.createCell(21).setCellValue(mi.getInventoryProfitQty());
                row1.createCell(22).setCellValue(mi.getInventoryLossesQty());
                row1.createCell(23).setCellValue(mi.getScrapInventoryQty());
                row1.createCell(24).setCellValue(mi.getDestroyQty());

                rowNum++;
            }

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            log.error("Failed to export report3.", e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                log.error("Failed to close workbook3.", e);
            }
        }
    }
    
    @RequestMapping("report/report4")
    public String report4(Model model, HttpSession session) {
        return "/report/report4";
    }
    
    /**
     * 
    *Description: 查询报表4的信息记录
    *@param controlDetail
    *@param timeRange
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("report/report4/search")
    @ResponseBody
    public Map<String, Object> report4Search(ControlDetail controlDetail, TimeRangeVo timeRange, PaginationVo page, Model model, HttpSession session) {
        ControlDetailSearchVo vo = new ControlDetailSearchVo();
        vo.setControlDetail(controlDetail);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        Date endTime = timeRange.getEndTime();
        if (null != endTime) {
            Calendar c = Calendar.getInstance();
            c.setTime(endTime);
            c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
            endTime = c.getTime();
            timeRange.setEndTime(endTime);
        }
        vo.setTimeRange(timeRange);
        
        int total = controlDetailService.countReportList(vo);
        List<ControlDetailVo> list = controlDetailService.selectReportList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 查询报表4的导出数据记录
    *@param controlDetail
    *@param detailIds
    *@param timeRange
    *@param response 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping(value = "report/report4/export", method = RequestMethod.GET)
    public void report4Export(ControlDetail controlDetail, String[] detailIds, TimeRangeVo timeRange, HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Report4");

        ControlDetailSearchVo vo = new ControlDetailSearchVo();
        if (detailIds != null && detailIds.length > 0) {
            vo.setDetailIds(detailIds);
        } else {
            vo.setControlDetail(controlDetail);
            
            Date endTime = timeRange.getEndTime();
            if (null != endTime) {
                Calendar c = Calendar.getInstance();
                c.setTime(endTime);
                c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
                endTime = c.getTime();
                timeRange.setEndTime(endTime);
            }
            vo.setTimeRange(timeRange);
        }
        
        List<ControlDetailVo> list = controlDetailService.selectManageExport(vo);

        String fileName = "Report4"  + ".xls";

        int rowNum = 1;

        String[] headers = {"Po No","Po Item","Goods Code","Goods Description","中文品名","Hs Code","Tax Preperty",
                "免税文号","Material No","Asset No","Unit","Currency","Unit Price","Amount",
                "Declaration No","原进口数量","出厂数量","Release Date","监管到期日期","监管状态","解除监管方式","解除监管日期","出厂原因",
                "是否回厂","出厂放行单编号","出厂日期","回厂日期","GR.NO"};
        try {
            HSSFRow row = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            for (ControlDetailVo mate : list) {
                
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(mate.getPoNo());
                row1.createCell(1).setCellValue(mate.getPoItem());
                row1.createCell(2).setCellValue(mate.getGoodsCodeName());
                row1.createCell(3).setCellValue(mate.getGoodsDesc());
                row1.createCell(4).setCellValue(mate.getChineseName());
                row1.createCell(5).setCellValue(mate.getHsCode());
                row1.createCell(6).setCellValue(mate.getTaxPrepertyName());
                row1.createCell(7).setCellValue(mate.getFreeNo());
                row1.createCell(8).setCellValue(mate.getMaterialNo());
                row1.createCell(9).setCellValue(mate.getAssetNo());
                row1.createCell(10).setCellValue(mate.getUnit());
                row1.createCell(11).setCellValue(mate.getCurrency());
                row1.createCell(12).setCellValue(mate.getUnitPrice());
                row1.createCell(13).setCellValue(mate.getTotalAmount());
                row1.createCell(14).setCellValue(mate.getDeclarationNo());
                if(mate.getQty() != null) {
                    row1.createCell(15).setCellValue(mate.getQty().toString());
                }
                if(mate.getOutQty() != null) {
                    row1.createCell(16).setCellValue(mate.getOutQty().toString());
                }
                row1.createCell(17).setCellValue(DateUtil.formatDate(mate.getReleaseTime()));
                row1.createCell(18).setCellValue(DateUtil.formatDate(mate.getExpireTime()));
                row1.createCell(19).setCellValue(mate.getControlStatusName());
                row1.createCell(20).setCellValue(mate.getRelieveModeName());
                row1.createCell(21).setCellValue(DateUtil.formatDate(mate.getRelieveTime()));
                row1.createCell(22).setCellValue(mate.getOutReason());
                row1.createCell(23).setCellValue(numberFormatter(mate.getIsReturn()));
                row1.createCell(24).setCellValue(mate.getOutReleaseNo());
                row1.createCell(25).setCellValue(DateUtil.formatDate(mate.getOutTime()));
                row1.createCell(26).setCellValue(DateUtil.formatDate(mate.getReturnTime()));
                row1.createCell(27).setCellValue(mate.getGrNo());

                rowNum++;
            }

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.flushBuffer();
            workbook.write(response.getOutputStream());

        } catch (Exception e) {
            log.error("Failed to export report4.", e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                log.error("Failed to close workbook.", e);
            }
        }
    }
    
    @RequestMapping("report/reportImportInfo")
    public String reportImportInfo(Model model, HttpSession session) {
        return "/report/reportImportInfo";
    }
    
    /**
     * 
    *Description: 查询进口数据报表的信息记录
    *@param irNo
    *@param goodsCode
    *@param importItem
    *@param timeRange
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("report/reportImportInfo/search")
    @ResponseBody
    public Map<String, Object> reportImportInfoSearch(String irNo, String goodsCode, ImportItem importItem, 
            TimeRangeVo timeRange, PaginationVo page, Model model, HttpSession session) {
        ImportItemSearchVo vo = new ImportItemSearchVo();
        vo.setIrNo(irNo);
        vo.setGoodsCode(goodsCode);
        
        String [] temp = importItem.getAssetNo().split("-");
        if(temp.length == 2) {
        	importItem.setAssetNo(temp[0]);
        	importItem.setChildAssetNo(temp[1]);
        }
        
        vo.setImportItem(importItem);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        Date endTime = timeRange.getEndTime();
        if (null != endTime) {
            Calendar c = Calendar.getInstance();
            c.setTime(endTime);
            c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
            endTime = c.getTime();
            timeRange.setEndTime(endTime);
        }
        vo.setTimeRange(timeRange);
        
        int total = importInfoService.reportCount(vo);
        List<ImportReportVo> list = importInfoService.selectReportList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 查询进口数据导出报表的信息记录
    *@param irNo
    *@param goodsCode
    *@param importItem
    *@param timeRange
    *@param itemIds
    *@param response 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping(value = "report/reportImportInfo/export", method = RequestMethod.GET)
    public void reportImportInfoExport(String irNo, String goodsCode, ImportItem importItem, TimeRangeVo timeRange, String[] itemIds, 
            HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ReportImportInfo");

        ImportItemSearchVo vo = new ImportItemSearchVo();
        if (itemIds != null && itemIds.length > 0) {
            vo.setItemIds(itemIds);
        } else {
            Date endTime = timeRange.getEndTime();
            if (null != endTime) {
                Calendar c = Calendar.getInstance();
                c.setTime(endTime);
                c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
                endTime = c.getTime();
                timeRange.setEndTime(endTime);
            }
            vo.setIrNo(irNo);
            vo.setGoodsCode(goodsCode);
            
            String [] temp = importItem.getAssetNo().split("-");
            if(temp.length == 2) {
            	importItem.setAssetNo(temp[0]);
            	importItem.setChildAssetNo(temp[1]);
            }
            
            vo.setImportItem(importItem);
            vo.setTimeRange(timeRange);
        }
        
        List<ImportReportVo> list = importInfoService.selectExport(vo);
        
        for(int i = 0; i < list.size(); i++) {
        	if(list.get(i).getAssetNo() != null && list.get(i).getChildAssetNo() != null) {
        		list.get(i).setAssetNo(list.get(i).getAssetNo() + "-" + list.get(i).getChildAssetNo());
        	}
        }

        String fileName = "ReportImportInfo"  + ".xls";

        int rowNum = 1;

        String[] headers = {
                "ORG", "Goods Code", "IR NO", "Freight Type", "Declaration No", "Declaration Date",
                "Release Date", "Exporter", "Broker", "Forwarder", "Freight Term", "Trade Term", "unit price",
                "Qty", "Unit", "Total Amount", "G.W.(KG)", "N.W.(KG)", "CH.W(KG)", "Currency", "Goods Description",
                "中文品名", "B/L", "MAWB", "HAWB", "Arrival Date", "Receive Date", "Sailing Date", "Flight/Vessel Voy",
                "Dept", "Ship From Country", "Ship From Port", "LC No", "Total Package", "Packing Type", "Loading Port",
                "Discharge Port", "Inhouse Date", "Outhouse Date", "Asset No", "Record No", "Trading Type", "App Type", "HS  code", "Tariff tax",
                "Value added tax", "Import Custom", "Declaring Customs", "Tax Preperty", "PO NO", "Invoice No", "Original Country",
                "Material number", "Container No", "Car Type", "Car Num", "Unusual", "Remarks", "RMA NO", "RMA Qty",
                "Original Declaration No", "Original Ir No", "Import Person", "Final Reviser", "TEXT1", "TEXT2", "TEXT3",  "Last modified time", 
                "Gr No", "库存地点", "Employee No", "Tariff Rate", "Trading unit", "Transaction volume", "Legal quantity", "Legal unit"
        };

        try {
            HSSFRow row = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            for (ImportReportVo i : list) {
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(i.getOrg());
                row1.createCell(1).setCellValue(i.getGoodsCodeName());
                row1.createCell(2).setCellValue(i.getIrNo());
                row1.createCell(3).setCellValue(i.getFreightTypeName());
                row1.createCell(4).setCellValue(i.getDeclarationNo());
                
                if (null != i.getDeclarationTime()) {
                    row1.createCell(5).setCellValue(DateUtil.formatDate(i.getDeclarationTime()));
                }
                
                if (null != i.getReleaseTime()) {
                    row1.createCell(6).setCellValue(DateUtil.formatDate(i.getReleaseTime()));
                }
                
                row1.createCell(7).setCellValue(i.getExporter());
                row1.createCell(8).setCellValue(i.getBroker());
                row1.createCell(9).setCellValue(i.getForwarder());
                row1.createCell(10).setCellValue(i.getFreightTerm());
                row1.createCell(11).setCellValue(i.getTradeTerm());
                
                if (null != i.getUnitPrice()) {
                    row1.createCell(12).setCellValue(i.getUnitPrice());
                }
                
                if (null != i.getQty()) {
                    row1.createCell(13).setCellValue(i.getQty().toString());
                }
                row1.createCell(14).setCellValue(i.getUnit());
                
                if (null != i.getTotalAmount()) {
                    row1.createCell(15).setCellValue(i.getTotalAmount());
                }
                
                if (null != i.getGw()) {
                    row1.createCell(16).setCellValue(i.getGw());
                }
                
                if (null != i.getNw()) {
                    row1.createCell(17).setCellValue(i.getNw());
                }
                
                if (null != i.getChw()) {
                    row1.createCell(18).setCellValue(i.getChw());
                }
                
                row1.createCell(19).setCellValue(i.getCurrency());
                row1.createCell(20).setCellValue(i.getGoodsDesc());
                row1.createCell(21).setCellValue(i.getChineseName());
                row1.createCell(22).setCellValue(i.getBl());
                row1.createCell(23).setCellValue(i.getMawb());
                row1.createCell(24).setCellValue(i.getHawb());
                
                if (null != i.getArriveTime()) {
                    row1.createCell(25).setCellValue(DateUtil.formatDate(i.getArriveTime()));
                }
                
                if (null != i.getReceiveTime()) {
                    row1.createCell(26).setCellValue(DateUtil.formatDate(i.getReceiveTime()));
                }
                
                if (null != i.getSailingTime()) {
                    row1.createCell(27).setCellValue(DateUtil.formatDate(i.getSailingTime()));
                }
                
                row1.createCell(28).setCellValue(i.getFlightVesselVoy());
                row1.createCell(29).setCellValue(i.getDept());  //i.getDept() ////////////////
                row1.createCell(30).setCellValue(i.getShipFromCountryName());
                row1.createCell(31).setCellValue(i.getShipFromPortName());
                row1.createCell(32).setCellValue(i.getLcNo());
                row1.createCell(33).setCellValue(i.getTotalPackage());
                row1.createCell(34).setCellValue(i.getPackingTypeName());
                row1.createCell(35).setCellValue(i.getLoadingPortName());
                row1.createCell(36).setCellValue(i.getDischargePortName());
                
                if (null != i.getInhouseDate()) {
                    row1.createCell(37).setCellValue(DateUtil.formatDate(i.getInhouseDate()));
                }
                
                if (null != i.getOuthouseDate()) {
                    row1.createCell(38).setCellValue(DateUtil.formatDate(i.getOuthouseDate()));
                }
                
                row1.createCell(39).setCellValue(i.getAssetNo());
                row1.createCell(40).setCellValue(i.getRecordNo());
                row1.createCell(41).setCellValue(i.getTradingTypeName());
                row1.createCell(42).setCellValue(i.getAppTypeName());
                row1.createCell(43).setCellValue(i.getHsCode());
                row1.createCell(44).setCellValue(i.getTariffTax());
                row1.createCell(45).setCellValue(i.getValueAddedTax());
                row1.createCell(46).setCellValue(i.getImportCustomName());
                row1.createCell(47).setCellValue(i.getDeclaringCustomName());
                row1.createCell(48).setCellValue(i.getTaxPrepertyName());
                row1.createCell(49).setCellValue(i.getPoNo());
                row1.createCell(50).setCellValue(i.getInvoiceNo());
                row1.createCell(51).setCellValue(i.getOriginalCountryName());
                row1.createCell(52).setCellValue(i.getMaterialNo());
                row1.createCell(53).setCellValue(i.getContainerNo());
                row1.createCell(54).setCellValue(i.getCarTypeName());
                row1.createCell(55).setCellValue(i.getCarNo());
                
                if (null != i.getUnusual()) {
                    row1.createCell(56).setCellValue(numberFormatter(i.getUnusual()));
                }
                
                row1.createCell(57).setCellValue(i.getRemarks());
                row1.createCell(58).setCellValue(i.getRmaNo());
                
                if (null != i.getRmaQty()) {
                    row1.createCell(59).setCellValue(i.getRmaQty());
                }
                
                row1.createCell(60).setCellValue(i.getOriginalDeclarationNo());
                row1.createCell(61).setCellValue(i.getOriginalIrNo());
                row1.createCell(62).setCellValue(i.getImportPerson());
                row1.createCell(63).setCellValue(i.getFinalReviser());
                row1.createCell(64).setCellValue(i.getText1());
                row1.createCell(65).setCellValue(i.getText2());
                row1.createCell(66).setCellValue(i.getText3());
                if (null != i.getLastModifiedTime()) {
                    row1.createCell(67).setCellValue(DateUtil.formatDate(i.getLastModifiedTime()));
                }
                
                row1.createCell(68).setCellValue(i.getGrNo());
                row1.createCell(69).setCellValue(i.getStock());
                row1.createCell(70).setCellValue(i.getEmployeeNo());
                
                row1.createCell(71).setCellValue(i.getTariffRate());
                row1.createCell(72).setCellValue(i.getTradingUnit());
                if(null != i.getTransactionVolume()) {
                	 row1.createCell(73).setCellValue(i.getTransactionVolume().toString());
                }
                if(null != i.getLegalQuantity()) {
                	 row1.createCell(74).setCellValue(i.getLegalQuantity().toString());
                }
                row1.createCell(75).setCellValue(i.getLegalUnit());
                
                rowNum++;
            }

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.flushBuffer();
            workbook.write(response.getOutputStream());

        } catch (Exception e) {
            log.error("Failed to export reportImportInfo.", e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                log.error("Failed to close workbook.", e);
            }
        }
    }
    private static String numberFormatter(int flag) {
        if (flag == 0) {
            return ReportConstant.NO;
        } else if (flag == 1) {
            return ReportConstant.YES;
        } else {
            return "";
        }
    }
    
    /**
     * 
    *Description: 转换action
    *@param action
    *@author GuoRong
    *@date 2018年12月24日
    *@version 1.0
     */
    private String actionFormatter(int action) {
        if (ImportInfoConstant.ACTION_RELEASE == action) {
            return "RELEASE";
        } else if (ImportInfoConstant.ACTION_UNRELEASE == action) {
            return "UNRELEASE";
        } else {
        	return "";
        }
    }
    @RequestMapping("report/release")
    public String manageSystem(Model model, HttpSession session) {
        return "/report/release";
    }
    
    /**
     * 
    *Description: 查询release的进口操作记录
    *@param release
    *@param page
    *@param model
    *@param session
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author MeiDong
    *@date 2018年12月24日
    *@version 1.0
     */
    @RequestMapping("release/search")
    @ResponseBody
    public Map<String, Object> search(ReleaseHis release, PaginationVo page, Model model, HttpSession session) {
        ReleaseHisSearchVo vo = new ReleaseHisSearchVo();
        vo.setReleaseHis(release);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = releaseHisService.count(vo);
        List<ReleaseHisVo> list = releaseHisService.selectReportList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 查询报表导出数据记录信息
    *@param irNo
    *@param ids
    *@param model
    *@param session
    *@param response
    *@author MeiDong
    *@date 2018年12月24日
    *@version 1.0
     */
    @RequestMapping(value = "report/release/export", method = RequestMethod.GET)
    public void releaseExport(String irNo,  String[] ids, 
        Model model, HttpSession session, HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Release");
        ReleaseHis releaseHis = new ReleaseHis();
        ReleaseHisSearchVo vo = new ReleaseHisSearchVo();
        
        //如果选择复选框导出
        if(ids != null && ids.length > 0){
        	vo.setIds(ids);
        }else {
        	releaseHis.setIrNo(irNo);
	        vo.setReleaseHis(releaseHis);
        }
     
        
        List<ReleaseHisVo> list = releaseHisService.selectExport(vo);
        
        String fileName = "Release"  + ".xls";
        int rowNum = 1;
        
        String[] headers = {"ORG", "IR.NO", "操作员工号", "操作员日期", "Status"};
        
        try {
            HSSFRow row = sheet.createRow(0);
            for (int i=0; i<headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
            
            for (ReleaseHisVo release : list) {
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(release.getOrg());
                row1.createCell(1).setCellValue(release.getIrNo());
                row1.createCell(2).setCellValue(release.getAddUser());
                if (null != release.getAddTime()) {
                    row1.createCell(3).setCellValue(DateUtil.formatDate(release.getAddTime()));
                }
                if(null != release.getAction()) {
                	row1.createCell(4).setCellValue(actionFormatter(release.getAction()));
                }
                rowNum++;
            }
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("Failed to export release.", e);
        } finally {
            
	        try {
	            workbook.close();
	        } catch (IOException e) {
	            log.error("Failed to export release.", e);
	        }
        }
    }    
}
