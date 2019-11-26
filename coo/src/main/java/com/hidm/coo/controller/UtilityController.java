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
import com.hidm.coo.entity.Utility;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.UtilityService;
import com.hidm.coo.vo.PaginationVo;
import com.hidm.coo.vo.UtilitySearchVo;
import com.hidm.coo.vo.UtilityVo;
@Controller
public class UtilityController {
    private static final Logger log = LoggerFactory.getLogger(UtilityController.class);
    
    @Autowired
    private UtilityService utilityService;
    
    @Autowired
    private BusinessHisService businessHisService;

    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("utility/manage")
    public String index(Model model, HttpSession session) {
        return "/utility/manage";
    }
    @RequestMapping("utility/search")
    @ResponseBody
    public Map<String, Object> search(Utility utility, PaginationVo page, Model model, HttpSession session) {
        UtilitySearchVo vo = new UtilitySearchVo();
        vo.setUtility(utility);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = utilityService.count(vo);
        List<UtilityVo> list = utilityService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 校验重复
     * @return
     */
    @RequestMapping("utility/checkData")
    @ResponseBody
    public Map<String, Object> checkData(Utility utility) {
        UtilitySearchVo vo = new UtilitySearchVo();
        vo.setUtility(utility);
        Map<String, Object> result = new HashMap<String, Object>();
        List<UtilityVo> list = utilityService.selectCheckData(vo);
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
    @RequestMapping("utility/save")
    @ResponseBody
    public String save(Utility utility, Model model, HttpSession session) {
        int action;
        if (null == utility.getId() || 0 == utility.getId()) {
        	utilityService.insert(utility);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
        	if(utility.getUtilityPrice().equals("***")) {
        		ArrayList<UtilityVo> list = utilityService.selectByUtilityNo(utility.getUtilityNo());
        		utility.setUtilityPrice(list.get(0).getUtilityPrice());
        	}
        	utilityService.updateById(utility);
            action = BusinessConstant.BUSINESS_UPDATE;
        }
        
        businessHisService.insert(String.valueOf(utility.getId()), utility.getUtilityNo(), 
                BusinessConstant.BUSINESS_TYPE_EQTYPE, action, utility);
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
    @RequestMapping("/utility/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
    	deleteBusiness(ids);
        utilityService.deleteByIds(ids);
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
            List<UtilityVo> list = utilityService.selectInfoByIds(ids);
            for (UtilityVo e : list) {
                businessHisService.insert(String.valueOf(e.getId()), e.getUtilityNo(), 
                        BusinessConstant.BUSINESS_TYPE_EQTYPE, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. assetIds：" + ids, e);
        }
    }
    
    /**
     * 根据UtilityNo 查询Utility Price,Utility Coefficient,Utility Group,Utility Name,Utility unit
     * @param 
     * @param 
     * @return
     */
    @RequestMapping("utility/searchInfoByUtilityNo")
    @ResponseBody
    public List<UtilityVo> searchInfoByUtilityNo(UtilityVo utilityVo) {
         List<UtilityVo> list = utilityService.selectInfoByUtilityNo(utilityVo);
         return list;
    }
    /**
     * 1.批量更新Utility的price
     */
    //@Scheduled(cron = "* 0/5 * * * ? ")
    //@Scheduled(cron = " 0 0 1 ? * SAT") // 每周五凌晨1点执行
    @Scheduled(cron = "0 0 1 * * ?") // 每天凌晨1点执行
    @Transactional(rollbackFor = { Exception.class })
    public void taskCycle() {
        log.info("=========start task===============");
        long startTime = System.currentTimeMillis();// 获取程序执行时间
        List<UtilityVo> list = utilityService.selectAll();
        Map<String, String> map = utilityService.getUtilityPrice(list);
        for(UtilityVo utility : list) {
            if(map.containsKey(utility.getUtilityNo())) {
                utility.setUtilityPrice(map.get(utility.getUtilityNo()));
                utility.setIsSap(1);
            }
            utilityService.updateById(utility);
        }
        // 获取结束时间
        long endTime2 = System.currentTimeMillis();
        log.info("同步SAP Utility数据： " + (endTime2 - startTime) + "ms");
        System.out.println("========end=task===========");

    }
}