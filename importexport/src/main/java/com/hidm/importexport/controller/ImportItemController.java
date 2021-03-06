package com.hidm.importexport.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.importexport.constant.BusinessConstant;
import com.hidm.importexport.entity.ImportItem;
import com.hidm.importexport.service.BusinessHisService;
import com.hidm.importexport.service.ImportBatchService;
import com.hidm.importexport.service.ImportItemService;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportItemVo;
import com.hidm.importexport.vo.PaginationVo;
  
@Controller
public class ImportItemController {
    private static final Logger log = LoggerFactory.getLogger(ImportItemController.class);
    
    @Autowired
    private ImportItemService importItemService;
    
    @Autowired
    private ImportBatchService importBatchService;
    
    @Autowired
    private BusinessHisService businessHisService;
    
    @RequestMapping("importItem/manage")
    public String manageSystem(Model model, HttpSession session) {
        return "/importinfo/manage";
    }
    
    /**
     * 
    *Description: 查询item信息记录
    *@param importItem
    *@param stat
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("importItem/search")
    @ResponseBody
    public Map<String, Object> search(ImportItemVo importItem, @RequestParam(value="stat", required=false) Integer stat, PaginationVo page, Model model, HttpSession session) {
        ImportItemSearchVo vo = new ImportItemSearchVo();
        vo.setImportItem(importItem);
        vo.setPage(page);
        vo.setIrNo(importItem.getIrNo());
        if (stat != null) {
            vo.setStat(stat);
        }
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = importItemService.count(vo);
        List<ImportItemVo> list = importItemService.selectList(vo);
        for (ImportItemVo item : list) {
            BigDecimal batchQty = importBatchService.calBatchQty(item.getImportId(), item.getPoNo(), 
                item.getPoItem(), item.getMaterialNo());
            item.setBatchQty(batchQty);
        	if(item.getAssetNo() != null && item.getChildAssetNo() != null) {
        		item.setAssetNo(item.getAssetNo() + "-" + item.getChildAssetNo());
        	}
            
        }
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 根据grNo查询item记录信息
    *@param importItem
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("importItem/searchGrNo")
    @ResponseBody
    public Map<String, Object> searchGrNo(ImportItemVo importItem, PaginationVo page, Model model, HttpSession session) {
        ImportItemSearchVo vo = new ImportItemSearchVo();
        //如果检索grNo是空，则查询记录为空
        if (StringUtils.isEmpty(importItem.getGrNo())) {
            return null;
        } else {
            page.setRowStart((page.getPage() - 1) * page.getRows());
            vo.setImportItem(importItem);
            vo.setPage(page);
            int total = importItemService.selectCountByGrNo(vo);
            List<ImportItemVo> list = importItemService.selectListByGrNo(vo);
            
            for(int i = 0; i < list.size(); i++) {
            	ImportItemVo temp = list.get(i);
            	if(temp.getAssetNo() != null && temp.getChildAssetNo() != null) {
            		temp.setAssetNo(temp.getAssetNo() + "-" + temp.getChildAssetNo());
            	}
            }
            
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("total", total);
            result.put("rows", list);
            return result;
        }
    }
    
    /**
     * 
    *Description: 保存或更新item记录信息同时保存操作日志信息
    *@param importItem
    *@return String 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("importItem/save")
    @ResponseBody
    public String save(ImportItem importItem, Model model, HttpSession session) {
        if (null == importItem.getId() || 0 == importItem.getId()) {
            importItemService.insert(importItem);
        } else {
	        if (!StringUtils.isEmpty(importItem.getAssetNo())) {
	        	String []temp = importItem.getAssetNo().split("-");
	        	if(temp.length ==2) {
	        		importItem.setAssetNo(temp[0]);
	        	}
	        }
            importItemService.updateById(importItem);
            businessHisService.insert(String.valueOf(importItem.getId()), importItem.getPoNo() + importItem.getPoItem(), 
                    BusinessConstant.BUSINESS_TYPE_ITEM, BusinessConstant.BUSINESS_UPDATE, importItem);
        }
        
        return "true";
    }
    
    /**
     * 
    *Description: 与SAP同步item信息记录
    *@param importItem
    *@return String
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("importItem/sync")
    @ResponseBody
    public String sync(ImportItem importItem, Model model, HttpSession session) {
        Long importId = importItem.getImportId();
        String poNo = importItem.getPoNo();
        
        if (null == importId || 0 == importId.intValue() || StringUtils.isEmpty(poNo)) {
            return "1";
        }
        
        ImportItemSearchVo vo = new ImportItemSearchVo();
        vo.setImportItem(importItem);
        int count = importItemService.count(vo);
        if (count > 0) {
            return "2";
        }
        
        importItemService.sync(importItem.getPoNo(), importItem.getImportId());
        return "0";
    }
    
    /**
     * 
    *Description: 删除item记录信息，同时保存操作日志
    *@param ids
    *@return boolean
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("importItem/delete")
    @ResponseBody
    public boolean delete(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        importItemService.deleteByIds(ids);
        return true;
    }
    
    /**
     * 
    *Description: 保存对item记录的删除操作日志
    *@param ids 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void deleteBusiness(Long[] ids) {
        //记录删除记录
        List<ImportItemVo> list = importItemService.selectImportItemByIds(ids);
        for (ImportItemVo importItem : list) {
            businessHisService.insert(String.valueOf(importItem.getId()), importItem.getPoNo()+importItem.getPoItem(), 
                    BusinessConstant.BUSINESS_TYPE_ITEM, BusinessConstant.BUSINESS_DELETE, null);
        }
        
    }
    
    /**
     * 
    *Description: 更新item记录
    *@param importItem
    *@return boolea true为操作成功，false为操作失败
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("importItem/updateBatchItem")
    @ResponseBody
    public boolean updateBatchItem(ImportItem importItem, Model model, HttpSession session) {
        if (null != importItem.getId() || 0 != importItem.getId()) {
            importItemService.updateById(importItem);
            return true;
        } else {
            log.error("id异常，无法获取到对应记录");
            return false;
        }
    }
}