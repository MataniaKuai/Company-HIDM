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
import com.hidm.importexport.entity.Asset;
import com.hidm.importexport.entity.User;
import com.hidm.importexport.service.AssetService;
import com.hidm.importexport.service.BusinessHisService;
import com.hidm.importexport.util.LoginUtil;
import com.hidm.importexport.vo.AssetSearchVo;
import com.hidm.importexport.vo.AssetVo;
import com.hidm.importexport.vo.PaginationVo;
  
@Controller
public class AssetController {
    private static final Logger log = LoggerFactory.getLogger(AssetController.class);
    
    @Value("${file.root.path}")
    private String rootPath;
    
    @Value("${file.asset.path}")
    private String assetPath;
    
    @Autowired
    private AssetService assetService;
    
    @Autowired
    private BusinessHisService businessHisService;
    
    @RequestMapping("/asset/manage")
    public String manageSystem(Model model, HttpSession session) {
        model.addAttribute("user", LoginUtil.getUserInfo());
        return "/asset/manage";
    }
    
    /**
     * 
    *Description: 根据页面条件查询
    *@param asset
    *@param page
    *@return Map<String, Object> "total"为记录的数量，"rows"为每条记录对应的对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("/asset/search")
    @ResponseBody
    public Map<String, Object> search(Asset asset, PaginationVo page, Model model, HttpSession session) {
        AssetSearchVo vo = new AssetSearchVo();
        vo.setAsset(asset);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = assetService.count(vo);
        List<AssetVo> list = assetService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 保存或者更新asset记录
    *@param asset 
    *@return String
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("/asset/save")
    @ResponseBody
    public String save(Asset asset, Model model, HttpSession session) {
        User user = LoginUtil.getUserInfo();
        if (user != null) {
            asset.setEmployeeNo(user.getUserName());
        }
        
        int action;
        if (null == asset.getId() || 0 == asset.getId()) {
            assetService.insert(asset);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
            assetService.updateById(asset);
            action = BusinessConstant.BUSINESS_UPDATE;
        }
        businessHisService.insert(String.valueOf(asset.getId()), asset.getAssetNo(), 
                BusinessConstant.BUSINESS_TYPE_ASSET, action, asset);
        return "true";
    }
    
    /**
     * 
    *Description: 根据asset的id删除记录，同时添加操作日志
    *@param ids Long[] 
    *@return boolean 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("/asset/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        assetService.deleteByIds(ids);
        return true;
    }
    
    /**
     * 
    *Description: 记录删除的asset信息日志
    *@param ids Long[]
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void deleteBusiness(Long[] ids) {
        try {
            List<Asset> list = assetService.selectAssetByIds(ids);
            for (Asset asset : list) {
                businessHisService.insert(String.valueOf(asset.getId()), asset.getAssetNo(), 
                        BusinessConstant.BUSINESS_TYPE_ASSET, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. assetIds：" + ids, e);
        }
    }
    
    /**
     * 
    *Description: 保存用户上传的asset附件信息
    *@param file 
    *@param id Long 为附件记录主键
    *@return String 返回上传状态  false为上传异常，true为上传成功
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("/asset/fileUpload")
    @ResponseBody 
    public String fileUpload(@RequestParam("fileName") MultipartFile file, @RequestParam("id") Long id) {
        if (file.isEmpty()) {
            return "false";
        }
        
        String fileName = file.getOriginalFilename();
        
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String filePath = assetPath + "/" + timeInMillis + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        File dest = new File(rootPath + filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            assetService.savePhotoInfo(fileName, filePath, id);
            
            return "true";
        } catch (IllegalStateException e) {
            log.error("Failed to upload file. id:" + id, e);
            return "false";
        } catch (IOException e) {
            log.error("Failed to upload file. id:" + id, e);
            return "false";
        }
    }
    
    /**
     * 
    *Description: 根据资产编号获取asset的描述信息
    *@param assetNo 资产编号
    *@return String 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("asset/getDescription")
    @ResponseBody
    public String getDescription(String assetNo) {
        String decription = assetService.getDecription(assetNo);
        return decription;
    }
}