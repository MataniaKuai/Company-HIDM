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
import com.hidm.coo.entity.Utility;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.EQtypeService;
import com.hidm.coo.service.MaterialsCostItemService;
import com.hidm.coo.service.UtilityCostItemService;
import com.hidm.coo.service.UtilityService;
import com.hidm.coo.vo.EQtypeSearchVo;
import com.hidm.coo.vo.EQtypeVo;
import com.hidm.coo.vo.MaterialsCostItemVo;
import com.hidm.coo.vo.PaginationVo;
import com.hidm.coo.vo.UtilityCostItemVo;
import com.hidm.coo.vo.UtilitySearchVo;
import com.hidm.coo.vo.UtilityVo;
@Controller
public class MaterialsCostItemController {
    private static final Logger log = LoggerFactory.getLogger(MaterialsCostItemController.class);
    
    @Autowired
    private MaterialsCostItemService materialsCostItemService;
    
    @Autowired
    private BusinessHisService businessHisService;

    /**
     * 根据userBaseID 查询 Materials Name,Materials No,Materials Unit,Usage By Year Materials
     * @param 
     * @param 
     * @return
     */
    @RequestMapping("materialsCostItem/searchInfo")
    @ResponseBody
    public List<MaterialsCostItemVo> searchInfo(MaterialsCostItemVo materialsCostItemVo) {
         List<MaterialsCostItemVo> list = materialsCostItemService.searchInfo(materialsCostItemVo);
         return list;
    }
    
}