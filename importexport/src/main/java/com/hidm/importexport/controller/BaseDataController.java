package com.hidm.importexport.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.importexport.entity.BaseData;
import com.hidm.importexport.entity.GoodsCode;
import com.hidm.importexport.service.BaseDataService;
import com.hidm.importexport.vo.PaginationVo;
  
/**
 * 
*Description: 处理业务基础数据
*@author GuoRong
*@date 2018年12月3日
*@version 1.0
*
 */
@Controller
public class BaseDataController {
    @Autowired
    private BaseDataService baseDataService;
    
    @RequestMapping("allgoodscodes")
    @ResponseBody
    public Map<String, Object> listGoodsCode(PaginationVo page, Model model, HttpSession session) {
        List<GoodsCode> list = baseDataService.allGoodsCodes();
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allcustomoffices")
    @ResponseBody
    public Map<String, Object> allCustomOffices(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allCustomOffices();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allcurrencys")
    @ResponseBody
    public Map<String, Object> allCurrencys(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allCurrencys();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("alltaxprepertys")
    @ResponseBody
    public Map<String, Object> allTaxPrepertys(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allTaxPrepertys();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allbondcla1s")
    @ResponseBody
    public Map<String, Object> allBondCla1s(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allBondCla1s();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allbondcla2s")
    @ResponseBody
    public Map<String, Object> allBondCla2s(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allBondCla2s();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allfreenos")
    @ResponseBody
    public Map<String, Object> allFreeNos(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allFreeNos();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    
    @RequestMapping("allControlStatus")
    @ResponseBody
    public Map<String, Object> allControlStatus(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allControlStatus();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allRelieveModes")
    @ResponseBody
    public Map<String, Object> allReleaseModes(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allRelieveModes();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allOutReasons")
    @ResponseBody
    public Map<String, Object> allOutReasons(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allOutReasons();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allReexportReasons")
    @ResponseBody
    public Map<String, Object> allReexportReasons(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allReexportReasons();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    
    
    @RequestMapping("allOrgs")
    @ResponseBody
    public Map<String, Object> allOrgs(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allOrgs();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allFreightTypes")
    @ResponseBody
    public Map<String, Object> allFreightTypes(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allFreightTypes();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allPackingTypes")
    @ResponseBody
    public Map<String, Object> allPackingTypes(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allPackingTypes();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allRecordNos")
    @ResponseBody
    public Map<String, Object> allRecordNos(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allRecordNos();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allAppTypes")
    @ResponseBody
    public Map<String, Object> allAppTypes(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allAppTypes();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allFreightTerms")
    @ResponseBody
    public Map<String, Object> allFreightTerms(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allFreightTerms();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allShipFromCountrys")
    @ResponseBody
    public Map<String, Object> allShipFromCountrys(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allShipFromCountrys();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allLoadingPorts")
    @ResponseBody
    public Map<String, Object> allLoadingPorts(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allLoadingPorts();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allImportCustoms")
    @ResponseBody
    public Map<String, Object> allImportCustoms(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allImportCustoms();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allImportPorts")
    @ResponseBody
    public Map<String, Object> allImportPorts(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allImportPorts();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allCarTypes")
    @ResponseBody
    public Map<String, Object> allCarTypes(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allCarTypes();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("allTradingTypes")
    @ResponseBody
    public Map<String, Object> allTradingTypes(PaginationVo page, Model model, HttpSession session) {
        List<BaseData> list = baseDataService.allTradingTypes();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
}