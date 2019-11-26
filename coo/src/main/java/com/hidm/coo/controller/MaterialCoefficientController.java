package com.hidm.coo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.coo.constant.BusinessConstant;
import com.hidm.coo.entity.MaterialCoefficient;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.MaterialCoefficientService;
import com.hidm.coo.vo.MaterialCoefficientSearchVo;
import com.hidm.coo.vo.MaterialCoefficientVo;
import com.hidm.coo.vo.PaginationVo;
@Controller
public class MaterialCoefficientController {
    private static final Logger log = LoggerFactory.getLogger(MaterialCoefficientController.class);
    
    @Autowired
    private MaterialCoefficientService materialService;
    
    @Autowired
    private BusinessHisService businessHisService;

    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("materialCoefficient/manage")
    public String index(Model model, HttpSession session) {
        return "/materialCoefficient/manage";
    }
    @RequestMapping("materialCoefficient/search")
    @ResponseBody
    public Map<String, Object> search(MaterialCoefficient material, PaginationVo page, Model model, HttpSession session) {
    	MaterialCoefficientSearchVo vo = new MaterialCoefficientSearchVo();
        vo.setMaterialCoefficient(material);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = materialService.count(vo);
        List<MaterialCoefficientVo> list = materialService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 校验重复
     * @return
     */
    @RequestMapping("materialCoefficient/checkData")
    @ResponseBody
    public Map<String, Object> checkData(MaterialCoefficient material) {
        MaterialCoefficientSearchVo vo = new MaterialCoefficientSearchVo();
        vo.setMaterialCoefficient(material);
        List<MaterialCoefficientVo> list = materialService.selectCheckData(vo);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("list", list);
        return result;
    }
    
    /**
     * 
    *Description: 保存或更新eqType同时保存操作记录
    *@param eqType
    *@return 
    *@author yl
    *@date 2019.6.17
    *@version 1.0
     */
    @RequestMapping("materialCoefficient/save")
    @ResponseBody
    public String save(MaterialCoefficient material, Model model, HttpSession session) {
        int action;
        //获取价格
        List<MaterialCoefficientVo> list = new ArrayList<MaterialCoefficientVo>();
        MaterialCoefficientVo coefficientVo = new MaterialCoefficientVo();
        coefficientVo.setMaterialNo(material.getMaterialNo());
        list.add(coefficientVo);
        if(!material.getMaterialNo().isEmpty()) {
            Map<String, String> map = materialService.getMatrialPrice(list);
            material.setMaterialPrice(map.get(material.getMaterialNo()));
        }
        
        if (null == material.getId() || 0 == material.getId()) {
        	materialService.insert(material);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
        	materialService.updateById(material);
            action = BusinessConstant.BUSINESS_UPDATE;
        }
        
        businessHisService.insert(String.valueOf(material.getId()), material.getMaterialNo(),
                BusinessConstant.BUSINESS_TYPE_EQTYPE, action, material);
        return "true";
    }
    
    /**
     * 
    *Description: 根据eqType的id删除记录，同时添加操作日志
    *@param ids Long[] 
    *@return boolean 
    *@author yl
    *@date 2019.6.17
    *@version 1.0
     */
    @RequestMapping("/materialCoefficient/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        materialService.deleteByIds(ids);
        return true;
    }
    
    /**
     * 
    *Description: 记录删除的eqType信息日志
    *@param ids Long[]
    *@author yl
    *@date 2019.6.17
    *@version 1.0
     */
    public void deleteBusiness(Long[] ids) {
        try {
            List<MaterialCoefficientVo> list = materialService.selectInfoByIds(ids);
            for (MaterialCoefficientVo e : list) {
                businessHisService.insert(String.valueOf(e.getId()), e.getMaterialNo(), 
                        BusinessConstant.BUSINESS_TYPE_EQTYPE, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. assetIds：" + ids, e);
        }
    }
    
    /**
     * 根据Material No 查询Material Price,Material Coefficient,Material Group,Material Name,Material unit
     * @param 
     * @param 
     * @return
     */
    @RequestMapping("materialCoefficient/searchInfoByMaterialNo")
    @ResponseBody
    public List<MaterialCoefficientVo> searchInfoByUtilityNo(MaterialCoefficientVo materialCoefficientVo) {
         List<MaterialCoefficientVo> list = materialService.selectInfoByMaterialNo(materialCoefficientVo);
         return list;
    }
    

    /**
     * 1.批量更新MaterialCoefficient的price
     */
    //@Scheduled(cron = "* 0/5 * * * ? ")
    //@Scheduled(cron = " 0 0 1 ? * SAT") // 每周日凌晨1点执行
    @Scheduled(cron = "0 0 1 * * ?") // 每天凌晨1点执行
    @Transactional(rollbackFor = { Exception.class })
    public void taskCycle() {
        log.info("=========start task===============");
        long startTime = System.currentTimeMillis();// 获取程序执行时间
        List<MaterialCoefficientVo> list = materialService.selectAll();
        Map<String, String> map = materialService.getMatrialPrice(list);
        for(MaterialCoefficientVo coeff : list) {
            coeff.setMaterialPrice(map.get(coeff.getMaterialNo()));
            materialService.updateById(coeff);
        }
        // 获取结束时间
        long endTime2 = System.currentTimeMillis();
        log.info("同步SAP MaterialCoefficient数据： " + (endTime2 - startTime) + "ms");
        System.out.println("========end=task===========");

    }
}