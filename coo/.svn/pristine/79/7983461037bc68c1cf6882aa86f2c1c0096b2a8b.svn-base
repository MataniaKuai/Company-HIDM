package com.hidm.coo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.coo.constant.BusinessConstant;
import com.hidm.coo.entity.EQtype;
import com.hidm.coo.entity.Vendor;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.VendorService;
import com.hidm.coo.vo.EQtypeSearchVo;
import com.hidm.coo.vo.EQtypeVo;
import com.hidm.coo.vo.PaginationVo;
import com.hidm.coo.vo.VendorSearchVo;
import com.hidm.coo.vo.VendorVo;
@Controller
public class VendorController {
    private static final Logger log = LoggerFactory.getLogger(VendorController.class);
    
    @Autowired
    private VendorService vendorService;
    
    @Autowired
    private BusinessHisService businessHisService;

    /**
     * vendor跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("vendor/manage")
    public String index(Model model, HttpSession session) {
        return "/vendor/manage";
    }
    @RequestMapping("vendor/search")
    @ResponseBody
    public Map<String, Object> search(Vendor vendor, PaginationVo page, Model model, HttpSession session) {
    	
        VendorSearchVo vo = new VendorSearchVo();
        vo.setVendor(vendor);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = vendorService.count(vo);
        List<VendorVo> list = vendorService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    /**
     * 校验重复
     * @param Vendor
     * @return
     */
    @RequestMapping("vendor/checkData")
    @ResponseBody
    public Map<String, Object> checkData(Vendor vendor) {
        VendorSearchVo vo = new VendorSearchVo();
        vo.setVendor(vendor);
        List<VendorVo> list = vendorService.selectCheckData(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("list", list);
        return result;
    }
    
    
    /**
     * 
    *Description: 保存或更新eqType同时保存操作记录
    *@param vendor
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    
    @RequestMapping("vendor/save")
    @ResponseBody
    public String save(Vendor vendor, Model model, HttpSession session) {
        int action;
        if (null == vendor.getId() || 0 == vendor.getId()) {
        	List<VendorVo> vendorVoList = vendorService.selectList(null);
        	if(vendorVoList.size() == 0) {
        		vendor.setVendorNo("10001");
        	}else {
        		long temp = Long.parseLong(vendorVoList.get(0).getVendorNo());
        		temp += 1;
        		vendor.setVendorNo(temp + "");
        	}
        	vendorService.insert(vendor);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
        	vendorService.updateById(vendor);
            action = BusinessConstant.BUSINESS_UPDATE;
        }
        
        businessHisService.insert(String.valueOf(vendor.getId()), vendor.getVendor(), 
                BusinessConstant.BUSINESS_TYPE_EQTYPE, action, vendor);
        return "true";
    }
    
    /**
     * 
    *Description: 根据eqType的id删除记录，同时添加操作日志
    *@param ids Long[] 
    *@return boolean 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    @RequestMapping("vendor/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        vendorService.deleteByIds(ids);
        return true;
    }
    
    /**
     * 
    *Description: 记录删除的eqType信息日志
    *@param ids Long[]
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public void deleteBusiness(Long[] ids) {
        try {
            List<VendorVo> list = vendorService.selectInfoByIds(ids);
            for (VendorVo e : list) {
                businessHisService.insert(String.valueOf(e.getId()), e.getVendor(), 
                        BusinessConstant.BUSINESS_TYPE_VENDOR, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. vendorIds：" + ids, e);
        }
    }
}