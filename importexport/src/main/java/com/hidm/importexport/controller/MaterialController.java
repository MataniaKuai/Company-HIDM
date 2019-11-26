package com.hidm.importexport.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hidm.importexport.constant.BusinessConstant;
import com.hidm.importexport.entity.Material;
import com.hidm.importexport.entity.User;
import com.hidm.importexport.service.BusinessHisService;
import com.hidm.importexport.service.MaterialService;
import com.hidm.importexport.util.FileUtil;
import com.hidm.importexport.util.LoginUtil;
import com.hidm.importexport.vo.MaterialSearchVo;
import com.hidm.importexport.vo.MaterialVo;
import com.hidm.importexport.vo.PaginationVo;
  
@Controller
public class MaterialController {
    private static final Logger log = LoggerFactory.getLogger(MaterialController.class);
    
    @Value("${file.root.path}")
    private String rootPath;
    
    @Value("${file.material.path}")
    private String materialPath;
    
    @Autowired
    private MaterialService materialService;
    
    @Autowired
    private BusinessHisService businessHisService;
    
    @RequestMapping("material/manage")
    public String manageSystem(Model model, HttpSession session) {
        model.addAttribute("user", LoginUtil.getUserInfo());
        return "/material/manage";
    }
    
    /**
     * 
    *Description: 查询原材料记录信息
    *@param material
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("material/search")
    @ResponseBody
    public Map<String, Object> search(Material material, PaginationVo page, Model model, HttpSession session) {
        MaterialSearchVo vo = new MaterialSearchVo();
        vo.setMaterial(material);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = materialService.count(vo);
        List<MaterialVo> list = materialService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("material/getDescription")
    @ResponseBody
    public String getDescription(String materialNo) {
        String decription = materialService.getDecription(materialNo);
        return decription;
    }
    
    /**
     * 
    *Description: 新增或更新原材料记录信息同时保存操作日志记录
    *@param material
    *@return String 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("material/save")
    @ResponseBody
    public String save(Material material, Model model, HttpSession session) {
        User user = LoginUtil.getUserInfo();
        if (user != null) {
            material.setEmployeeNo(user.getUserName());
        }
        int action;
        if (null == material.getId() || 0 == material.getId()) {
            materialService.insert(material);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
            materialService.updateById(material);
            action = BusinessConstant.BUSINESS_UPDATE;
        }
        
        businessHisService.insert(String.valueOf(material.getId()), material.getMaterialNo(), 
                BusinessConstant.BUSINESS_TYPE_MATERIAL, action, material);
        
        return "true";
    }
    
    /**
     * 
    *Description: 删除原材料记录信息同时保存操作日志记录
    *@param ids Long[]
    *@return boolean
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("material/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        materialService.deleteByIds(ids);
        return true;
    }
    
    /**
     * 
    *Description: 新增用户删除原材料记录信息
    *@param ids 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void deleteBusiness(Long[] ids) {
        try {
            List<Material> list = materialService.selectMaterialByIds(ids);
            for (Material material : list) {
                businessHisService.insert(String.valueOf(material.getId()), material.getMaterialNo(), 
                        BusinessConstant.BUSINESS_TYPE_MATERIAL, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. materialIds：" + ids, e);
        }
    }
    
    /**
     * 
    *Description: 处理原材料上传附件信息
    *@param file
    *@param id
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("material/fileUpload")
    @ResponseBody 
    public String fileUpload(@RequestParam("fileName") MultipartFile file, @RequestParam("id") Long id) {
        if (file.isEmpty()) {
            return "false";
        }
        
        FileUtil.createDir(rootPath);
        FileUtil.createDir(rootPath + materialPath);
        
        String fileName = file.getOriginalFilename();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String destName = timeInMillis + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        String filePath = materialPath + "/" + destName;
        
        File dest = new File(rootPath + filePath);
        try {
            file.transferTo(dest);
            materialService.savePhotoInfo(fileName, filePath, id);
            
            return "true";
        } catch (IllegalStateException e) {
            log.error("Failed to upload file. id:" + id, e);
            return "false";
        } catch (IOException e) {
            log.error("Failed to upload file. id:" + id, e);
            return "false";
        }
    }
}