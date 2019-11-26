package com.hidm.importexport.controller;

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

import com.hidm.importexport.constant.BusinessConstant;
import com.hidm.importexport.constant.ReceiveConstant;
import com.hidm.importexport.entity.ControlDetail;
import com.hidm.importexport.entity.User;
import com.hidm.importexport.service.BusinessHisService;
import com.hidm.importexport.service.ControlDetailService;
import com.hidm.importexport.service.ImportInfoService;
import com.hidm.importexport.service.ImportItemService;
import com.hidm.importexport.util.LoginUtil;
import com.hidm.importexport.vo.ControlDetailSearchVo;
import com.hidm.importexport.vo.ControlDetailVo;
import com.hidm.importexport.vo.ImportInfoVo;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportItemVo;
import com.hidm.importexport.vo.PaginationVo;
  
@Controller
public class ControlDetailController {
    private static final Logger log = LoggerFactory.getLogger(ControlDetailController.class);
    
    @Autowired
    private ControlDetailService controlDetailService;

    @Autowired
    private ImportInfoService importInfoService;
    
    @Autowired
    private BusinessHisService businessHisService;
    
    @Autowired
    private ImportItemService importItemService;
    
    @RequestMapping("controlDetail/manage")
    public String manageSystem(Model model, HttpSession session) {
    	model.addAttribute("user", LoginUtil.getUserInfo());
        return "/controldetail/manage";
    }
    
    /**
     * 
    *Description: 查询监管明细信息记录
    *@param controlDetail
    *@param page 分页对象
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("controlDetail/search")
    @ResponseBody
    public Map<String, Object> search(ControlDetail controlDetail, PaginationVo page, Model model, HttpSession session) {
        ControlDetailSearchVo vo = new ControlDetailSearchVo();
        vo.setControlDetail(controlDetail);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = controlDetailService.count(vo);
        List<ControlDetailVo> list = controlDetailService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 保存或更新监管明细记录信息
    *@param controlDetail
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("controlDetail/save")
    @ResponseBody
    public String save(ControlDetail controlDetail, Model model, HttpSession session) {
    	 User user = LoginUtil.getUserInfo();
         if (user != null) {
             controlDetail.setEmployeeNo(user.getUserName());
         }
        int action;
        if (null == controlDetail.getId() || 0 == controlDetail.getId()) {
            //校验新增记录的时候是否重复新增item信息
            ControlDetailSearchVo vo = new ControlDetailSearchVo();
            ControlDetail searchControlDetail = new ControlDetail();
            searchControlDetail.setImportItemId(controlDetail.getImportItemId());
            vo.setControlDetail(searchControlDetail);
            List<ControlDetailVo> list = controlDetailService.selectList(vo);
            if(list.size() > 0) {
                return "false";
            }
            controlDetailService.insert(controlDetail);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
            controlDetailService.updateById(controlDetail);
            action = BusinessConstant.BUSINESS_UPDATE;
        }

        
        businessHisService.insert(String.valueOf(controlDetail.getId()), controlDetail.getIrNo(), 
                BusinessConstant.BUSINESS_TYPE_CONTROL, action, controlDetail);
        return "true";
    }
    
    /**
     * 
    *Description: 删除监管明细记录信息
    *@param ids Long[]
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("controlDetail/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        controlDetailService.deleteByIds(ids);
        return true;
    }
    
    public void deleteBusiness(Long[] ids) {
        try {
            //记录删除记录
            List<ControlDetailVo> list = controlDetailService.selectDetailByIds(ids);
            for (ControlDetailVo controlDetailVo : list) {
//            String bussinessNo = null;
//            if (controlDetailVo.getMaterialNo() != null && controlDetailVo.getMaterialNo() != "") {
//                bussinessNo = controlDetailVo.getMaterialNo();
//            } else {
//                bussinessNo = controlDetailVo.getAssetNo();
//            }
                businessHisService.insert(String.valueOf(controlDetailVo.getId()), controlDetailVo.getIrNo(), 
                        BusinessConstant.BUSINESS_TYPE_CONTROL, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. controlDetailIds：" + ids, e);
        }
        
    }
    
    /**
     * 
    *Description: 根据irNo查询进口记录信息
    *@param irNo
    *@return ImportInfoVo 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("controlDetail/getOtherInfo")
    @ResponseBody
    public ImportInfoVo getOtherInfo(String irNo) {
        ImportInfoVo selectByIrNo = importInfoService.selectByIrNo(irNo);
        return selectByIrNo;
    }

    /**
     * 
     * @param irNo
     * @return
     */
    @RequestMapping("controlDetail/getItemInfo")
    @ResponseBody
    public Map<String, Object> getItemInfo(String irNo, String materialNo, String assetNo, String importItemId, PaginationVo page) {
        Map<String, Object> result = new HashMap<String, Object>();
        if(irNo.trim().length() > 0 && (materialNo.trim().length() > 0 || assetNo.trim().length() > 0)) {
            ImportItemSearchVo vo = new ImportItemSearchVo();
            ImportItemVo importItem = new ImportItemVo();
            vo.setPage(page);
            page.setRowStart((page.getPage() - 1) * page.getRows());
            importItem.setMaterialNo(materialNo);
            importItem.setAssetNo(assetNo);
            if(!importItemId.isEmpty()) {
                importItem.setId(Long.parseLong(importItemId));
            }
            importItem.setStatus(ReceiveConstant.STATUS_RECEIVED);
            vo.setImportItem(importItem);
            vo.setIrNo(irNo);
            List<ImportItemVo> list = importItemService.selectList(vo);
            int total = importItemService.count(vo);
            
            result.put("total", total);
            result.put("rows", list);
        }
        return result;
    }

}