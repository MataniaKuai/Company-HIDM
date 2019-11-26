package com.hidm.coo.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.coo.constant.BusinessConstant;
import com.hidm.coo.constant.ReportConstant;
import com.hidm.coo.constant.StatusConstant;
import com.hidm.coo.entity.IEBase;
import com.hidm.coo.entity.MFGBase;
import com.hidm.coo.entity.MaterialsCostItem;
import com.hidm.coo.entity.OPBase;
import com.hidm.coo.entity.Others;
import com.hidm.coo.entity.PROBase;
import com.hidm.coo.entity.User;
import com.hidm.coo.entity.UserBase;
import com.hidm.coo.entity.Utility;
import com.hidm.coo.entity.UtilityCostItem;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.EQtypeService;
import com.hidm.coo.service.IEBaseService;
import com.hidm.coo.service.MFGBaseService;
import com.hidm.coo.service.MaterialCoefficientService;
import com.hidm.coo.service.MaterialsCostItemService;
import com.hidm.coo.service.ModelService;
import com.hidm.coo.service.OPBaseService;
import com.hidm.coo.service.OthersService;
import com.hidm.coo.service.PROBaseService;
import com.hidm.coo.service.UserBaseService;
import com.hidm.coo.service.UserService;
import com.hidm.coo.service.UtilityCostItemService;
import com.hidm.coo.service.UtilityService;
import com.hidm.coo.service.VendorService;
import com.hidm.coo.util.LoginUtil;
import com.hidm.coo.vo.EQtypeVo;
import com.hidm.coo.vo.MaterialCoefficientVo;
import com.hidm.coo.vo.ModelVo;
import com.hidm.coo.vo.PaginationVo;
import com.hidm.coo.vo.PortalUserVo;
import com.hidm.coo.vo.UserBaseSearchVo;
import com.hidm.coo.vo.UserBaseVo;
import com.hidm.coo.vo.UtilityVo;
import com.hidm.coo.vo.VendorVo;

@Controller
public class UserBaseController {

    
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private PROBaseService proBaseService;
    @Autowired
    private OPBaseService opBaseService;
    @Autowired
    private MFGBaseService mfgBaseService;
    @Autowired
    private BusinessHisService businessHisService;
    @Autowired
    private EQtypeService eqTypeService;
    @Autowired
    private UtilityService utilityService;
    @Autowired
    private UtilityCostItemService utilityCostItemService;
    @Autowired
    private MaterialsCostItemService materialsCostItemService;
    @Autowired
    private MaterialCoefficientService materialCoefficientService;
    @Autowired
    private IEBaseService ieBaseService;
    @Autowired
    private VendorService vendorService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private OthersService othersService;
    @Autowired
    private UserService userService;
    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("userBase/manage")
    public String index(Model model, HttpSession session) {
    	User user = LoginUtil.getUserInfo();
        PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
        model.addAttribute("userName", user.getUserName() + "(" + userInfo.getUsername() + ")");
    	
    	//切分Moudule
    	String moudule = user.getMoudule();
		String [] modules = moudule.split("/");
    	if(ReportConstant.ALL.equals(moudule)) {
    		modules = null;
    	}
    	//根据modules查询EQ Type
    	List<EQtypeVo> eqTypeList = eqTypeService.selectInfoByModules(modules);
        model.addAttribute("eqTypeList", eqTypeList);
        model.addAttribute("moudule",user.getMoudule());
        
        List<VendorVo> vendorList = vendorService.selectList(null);
        model.addAttribute("vendorList", vendorList);
        
        List<ModelVo> modelList = modelService.selectList(null);
        model.addAttribute("modelList", modelList);
        return "/userBase/manage";
    }
    
    
    
    /**
     * 保存User输入的信息
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("userBase/save")
    @ResponseBody
    @Transactional(rollbackFor={Exception.class})
    public String save(UserBase userBase, Model model, HttpSession session) {
    	 userBase.setStatus(StatusConstant.INIT);
    	 userBase.setIsSubmit(StatusConstant.INIT);
         if (null == userBase.getId() || 0 == userBase.getId()) {
        	 //向t_user_base表插入基础数据
        	 userBaseService.insert(userBase);
        	 //向t_utility_cost_item表插入基础数据 可能会有多条
        	 int length1 = userBase.getUtilityName().length();
        	 if(length1 > 0) {
	        	 String [] utilityNameArr = userBase.getUtilityName().split(",");
	        	 String [] utilityUsageArr = userBase.getUtilityUsage().split(",");
	        	 for(int i = 0; i < utilityNameArr.length; i++) {
	        		 UtilityCostItem utilityCostItem = new UtilityCostItem();
	        		 utilityCostItem.setItemNo(i + 1);
	        		 utilityCostItem.setUserBaseId(userBase.getId());
	        		 utilityCostItem.setUtility(utilityNameArr[i]);
	        		 utilityCostItem.setUsageByYear(utilityUsageArr[i]);
	        		 utilityCostItemService.insert(utilityCostItem);
	        	 }
        	 }
        	 
        	 //向t_material_cost_item表插入基础数据 可能会有多条
        	 int length2 = userBase.getMaterialName().length();
        	 if(length2 > 0) {
            	 String [] materialNameArr = userBase.getMaterialName().split(",");
            	 String [] materialUsageArr = userBase.getMaterialUsage().split(",");
            	 for(int i = 0; i < materialNameArr.length; i++) {
            		 MaterialsCostItem materialsCostItem = new MaterialsCostItem();
            		 materialsCostItem.setItemNo(i + 1);
            		 materialsCostItem.setUserBaseId(userBase.getId());
            		 materialsCostItem.setMaterialNo(materialNameArr[i]);
            		 materialsCostItem.setUsageByYear(materialUsageArr[i]);
            		 materialsCostItemService.insert(materialsCostItem);
            	 }
        	 }
        	
        	 
         } else {
        	 userBaseService.updateById(userBase);
        	 //先根据userBaseId删t_utility_cost_item表的除所有数据
        	 Long [] ids = new Long[1];
        	 ids[0] = new Long(userBase.getId());
        	 utilityCostItemService.deleteByUserBaseIds(ids);
        	 //向t_utility_cost_item表插入更新后的数据
             int length3 = userBase.getUtilityName().length();
             if(length3 > 0) {
                 String [] utilityNameArr = userBase.getUtilityName().split(",");
                 String [] utilityUsageArr = userBase.getUtilityUsage().split(",");
                 for(int i = 0; i < utilityNameArr.length; i++) {
                     UtilityCostItem utilityCostItem = new UtilityCostItem();
                     utilityCostItem.setItemNo(i + 1);
                     utilityCostItem.setUserBaseId(userBase.getId());
                     utilityCostItem.setUtility(utilityNameArr[i]);
                     utilityCostItem.setUsageByYear(utilityUsageArr[i]);
                     utilityCostItemService.insert(utilityCostItem);
                 }
             }
        	 
        	 //先根据userBaseId删t_materials_cost_item表的除所有数据
        	 Long [] ids2 = new Long[1];
        	 ids2[0] = new Long(userBase.getId());
        	 materialsCostItemService.deleteByUserBaseIds(ids2);
        	 //向t_utility_cost_item表插入更新后的数据
        	 int length4 = userBase.getMaterialName().length();
        	 if(length4 > 0) {
        	     String [] materialNameArr = userBase.getMaterialName().split(",");
        	     String [] materialUsageArr = userBase.getMaterialUsage().split(",");
        	     for(int i = 0; i < materialNameArr.length; i++) {
        	         MaterialsCostItem materialsCostItem = new MaterialsCostItem();
        	         materialsCostItem.setItemNo(i + 1);
        	         materialsCostItem.setUserBaseId(userBase.getId());
        	         materialsCostItem.setMaterialNo(materialNameArr[i]);
        	         materialsCostItem.setUsageByYear(materialUsageArr[i]);
        	         materialsCostItemService.insert(materialsCostItem);
        	     }
        	 }
         }
         
         userBaseService.synchToSap(userBase);
         //ieBaseService.synchToSAP(userBase.getId());
         
         //调用5号接口 获取sap传回的ex_mlCost
         Others other;
    	 other=othersService.selectByName("Operate Labor Salary");
    	 BigDecimal operateLaborSalary=new BigDecimal(other.getValue());
    	 userBase.setOperateLaborSalary(operateLaborSalary);
    	 
    	 other=othersService.selectByName("Maintain Labor Salary");
    	 BigDecimal maintainLaborSalary=new BigDecimal(other.getValue());
    	 userBase.setMaintainLaborSalary(maintainLaborSalary);
    	 
    	 other=othersService.selectByName("Floor Cost_Fix");
    	 BigDecimal floorCost=new BigDecimal(other.getValue());
    	 userBase.setFloorCost(floorCost);
    	 
    	 BigDecimal housing=new BigDecimal(userBase.getHousing());
    	 userBase.setFloorCostAcount(floorCost.multiply(housing));
    	 userBaseService.synchToSap2(userBase);
         
         return "true";
   
    }
    /**
     * 提交User输入的信息
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("userBase/submit")
    @ResponseBody
    @Transactional(rollbackFor={Exception.class})
    public String submit(UserBase userBase, Model model, HttpSession session) {
    	 userBase.setStatus(StatusConstant.SUBMIT);
    	 userBase.setIsSubmit(StatusConstant.SUBMIT);
    	 int action;
         if (null == userBase.getId() || 0 == userBase.getId()) {
        	 //向t_user_base表插入基础数据
        	 userBaseService.insert(userBase);
        	 //向t_utility_cost_item表插入基础数据 可能会有多条
        	 int length1 = userBase.getUtilityName().length();
        	 if(length1 > 0) {
	        	 String [] utilityNameArr = userBase.getUtilityName().split(",");
	        	 String [] utilityUsageArr = userBase.getUtilityUsage().split(",");
	        	 for(int i = 0; i < utilityNameArr.length; i++) {
	        		 UtilityCostItem utilityCostItem = new UtilityCostItem();
	        		 utilityCostItem.setItemNo(i + 1);
	        		 utilityCostItem.setUserBaseId(userBase.getId());
	        		 utilityCostItem.setUtility(utilityNameArr[i]);
	        		 utilityCostItem.setUsageByYear(utilityUsageArr[i]);
	        		 utilityCostItemService.insert(utilityCostItem);
	        	 }
        	 }
        	 
        	 //向t_material_cost_item表插入基础数据 可能会有多条
        	 int length2 = userBase.getMaterialName().length();
        	 if(length2 > 0) {
            	 String [] materialNameArr = userBase.getMaterialName().split(",");
            	 String [] materialUsageArr = userBase.getMaterialUsage().split(",");
            	 for(int i = 0; i < materialNameArr.length; i++) {
            		 MaterialsCostItem materialsCostItem = new MaterialsCostItem();
            		 materialsCostItem.setItemNo(i + 1);
            		 materialsCostItem.setUserBaseId(userBase.getId());
            		 materialsCostItem.setMaterialNo(materialNameArr[i]);
            		 materialsCostItem.setUsageByYear(materialUsageArr[i]);
            		 materialsCostItemService.insert(materialsCostItem);
            	 }
        	 }
        	 
             action = BusinessConstant.BUSINESS_SUBMIT;
         } else {
             User user = LoginUtil.getUserInfo();
             PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
             userBase.setUpdateUserId(user.getUserName() + "(" + userInfo.getUsername() + ")");
        	 userBaseService.updateById(userBase);
        	 //先根据userBaseId删t_utility_cost_item表的除所有数据
        	 Long [] ids = new Long[1];
        	 ids[0] = new Long(userBase.getId());
        	 utilityCostItemService.deleteByUserBaseIds(ids);
        	 //向t_utility_cost_item表插入更新后的数据
             int length3 = userBase.getUtilityName().length();
             if(length3 > 0) {
                 String [] utilityNameArr = userBase.getUtilityName().split(",");
                 String [] utilityUsageArr = userBase.getUtilityUsage().split(",");
                 for(int i = 0; i < utilityNameArr.length; i++) {
                     UtilityCostItem utilityCostItem = new UtilityCostItem();
                     utilityCostItem.setItemNo(i + 1);
                     utilityCostItem.setUserBaseId(userBase.getId());
                     utilityCostItem.setUtility(utilityNameArr[i]);
                     utilityCostItem.setUsageByYear(utilityUsageArr[i]);
                     utilityCostItemService.insert(utilityCostItem);
                 }
             }
        	 
        	 //先根据userBaseId删t_materials_cost_item表的除所有数据
        	 Long [] ids2 = new Long[1];
        	 ids2[0] = new Long(userBase.getId());
        	 materialsCostItemService.deleteByUserBaseIds(ids2);
        	 //向t_utility_cost_item表插入更新后的数据
        	 int length4 = userBase.getMaterialName().length();
        	 if(length4 > 0) {
        	     String [] materialNameArr = userBase.getMaterialName().split(",");
        	     String [] materialUsageArr = userBase.getMaterialUsage().split(",");
        	     for(int i = 0; i < materialNameArr.length; i++) {
        	         MaterialsCostItem materialsCostItem = new MaterialsCostItem();
        	         materialsCostItem.setItemNo(i + 1);
        	         materialsCostItem.setUserBaseId(userBase.getId());
        	         materialsCostItem.setMaterialNo(materialNameArr[i]);
        	         materialsCostItem.setUsageByYear(materialUsageArr[i]);
        	         materialsCostItemService.insert(materialsCostItem);
        	     }
        	 }
             action = BusinessConstant.BUSINESS_UPDATE;
         }
         
         //UserBase新增数据的同时向PRO表新增刚插入的表的id
         List<PROBase> proList = proBaseService.selectByUserId(userBase.getId());
         if(proList.size() == 0) {
             PROBase proBase = new PROBase();
             proBase.setUserBaseId(userBase.getId());
             proBase.setStatus(StatusConstant.INIT);
             proBase.setAddUserId(userBase.getAddUserId());
             proBaseService.insert(proBase);
         }
         
         //OP
         List<OPBase> opList = opBaseService.selectByUserId(userBase.getId());
         if(opList.size() == 0) {
             OPBase opBase = new OPBase();
             opBase.setUserBaseId(userBase.getId());
             opBase.setStatus(StatusConstant.INIT);
             opBase.setAddUserId(userBase.getAddUserId());
             opBaseService.insert(opBase);
         }
         
        //MFG
         List<MFGBase> mfgList = mfgBaseService.selectByUserId(userBase.getId());
         if(mfgList.size() == 0) {
             MFGBase mfgBase = new MFGBase();
             mfgBase.setUserBaseId(userBase.getId());
             mfgBase.setStatus(StatusConstant.INIT);
             mfgBase.setAddUserId(userBase.getAddUserId());
             mfgBaseService.insert(mfgBase);
         }
         
        //IE
         List<IEBase> ieList = ieBaseService.selectByUserId(userBase.getId());
         if(ieList.size() == 0) {
             IEBase ieBase = new IEBase();
             ieBase.setUserBaseId(userBase.getId());
             ieBase.setStatus(StatusConstant.INIT);
             ieBase.setAddUserId(userBase.getAddUserId());
             ieBaseService.insert(ieBase);
         }
         
           businessHisService.insert(String.valueOf(userBase.getId()),userBase.getEqTypeId(), 
           BusinessConstant.BUSINESS_TYPE_USERBASE, action, userBase);
           userBaseService.synchToSap(userBase);
           //ieBaseService.synchToSAP(userBase.getId());
           
           //调用5号接口 获取sap传回的ex_mlCost
           Others other;
      	  other=othersService.selectByName("Operate Labor Salary");
      	  BigDecimal operateLaborSalary=new BigDecimal(other.getValue());
      	  userBase.setOperateLaborSalary(operateLaborSalary);
      	 
      	  other=othersService.selectByName("Maintain Labor Salary");
      	  BigDecimal maintainLaborSalary=new BigDecimal(other.getValue());
      	  userBase.setMaintainLaborSalary(maintainLaborSalary);
      	 
      	  other=othersService.selectByName("Floor Cost_Fix");
      	  BigDecimal floorCost=new BigDecimal(other.getValue());
      	  userBase.setFloorCost(floorCost);
      	 
      	  BigDecimal housing=new BigDecimal(userBase.getHousing());
      	  userBase.setFloorCostAcount(floorCost.multiply(housing));
      	  UserBase ub = userBaseService.synchToSap2(userBase);
      	  IEBase ib = new IEBase();
      	  ib.setUserBaseId(ub.getId());
      	  ib.setMaintainLaborCost(ub.getMaintainLaborCost());
      	  ieBaseService.updateByUserBaseId(ib);
         
         return "true";
   
    }
    
    @RequestMapping("userBase/checkData")
    @ResponseBody
    public Map<String, Object> checkData(UserBase userBase) {
        UserBaseSearchVo vo = new UserBaseSearchVo();
        vo.setUserBase(userBase);
        List<UserBaseVo> list = userBaseService.selectCheckData(vo);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("list", list);
        return result;
    }
    
    @RequestMapping("userBase/checkPrice")
    @ResponseBody
    public Map<String, Object> checkPrice(UserBase userBase) {
        Map<String, Object> result = new HashMap<String, Object>();
        int length4 = userBase.getMaterialName().length();
        if(length4 > 0) {
            String [] materialNameArr = userBase.getMaterialName().split(",");
            List<MaterialCoefficientVo> list = materialCoefficientService.selectInfoByNos(materialNameArr);
            for(MaterialCoefficientVo material : list) {
                if(material.getMaterialPrice()== null || material.getMaterialPrice().isEmpty()) {
                    result.put("error", "Materials  " + material.getMaterialNo());
                    break;
                }
            }
        }
        int length3 = userBase.getUtilityName().length();
        if(length3 > 0) {
            String [] utilityNameArr = userBase.getUtilityName().split(",");
            List<UtilityVo> list = utilityService.selectInfoByNos(utilityNameArr);
            for(Utility utility : list) {
                if(utility.getUtilityPrice() == null || utility.getUtilityPrice().isEmpty()) {
                    result.put("error", "Utility  " + utility.getUtilityNo());
                    break;
                }
            }
        }
        return result;
    }
    
    @RequestMapping("userBase/search")
    @ResponseBody
    public Map<String, Object> search(UserBase userBase, PaginationVo page, Model model, HttpSession session) {
        UserBaseSearchVo vo = new UserBaseSearchVo();
        User user = LoginUtil.getUserInfo();

    	String moudule = user.getMoudule();
		String [] modules = moudule.split("/");
    	if(ReportConstant.ALL.equals(moudule)) {
    		modules = null;
    	}
        
        userBase.setModules(modules);
        vo.setUserBase(userBase);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = userBaseService.count(vo);
        List<UserBaseVo> list = userBaseService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);

        
        return result;
    }
    
    @RequestMapping("userBase/delete")
    @ResponseBody
    @Transactional
    public int deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        utilityCostItemService.deleteByUserBaseIds(ids);
        materialsCostItemService.deleteByIds(ids);
        userBaseService.deleteByIds(ids);
        proBaseService.deleteByUserBaseIds(ids);
        opBaseService.deleteByUserBaseIds(ids);
        mfgBaseService.deleteByUserBaseIds(ids);
        ieBaseService.deleteByUserBaseIds(ids);
        return 0;
    }
    
    @RequestMapping("userBase/allUtility")
    @ResponseBody
    public List<UtilityVo> allUtility() {
        List<UtilityVo> utilityList = utilityService.selectList(null);
        return utilityList;
    }
    
    @RequestMapping("userBase/allMaterials")
    @ResponseBody
    public List<MaterialCoefficientVo> allMaterials() {
        List<MaterialCoefficientVo> materialCoefficientList = materialCoefficientService.selectList(null);
        return materialCoefficientList;
    }
    
}