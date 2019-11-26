package com.hidm.importexport.controller;

import java.util.Arrays;
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

import com.hidm.importexport.constant.ImportInfoConstant;
import com.hidm.importexport.constant.ReceiveConstant;
import com.hidm.importexport.entity.ImportInfo;
import com.hidm.importexport.entity.ImportItem;
import com.hidm.importexport.entity.User;
import com.hidm.importexport.service.ImportBatchService;
import com.hidm.importexport.service.ImportInfoService;
import com.hidm.importexport.service.ImportItemService;
import com.hidm.importexport.util.LoginUtil;
import com.hidm.importexport.vo.ImportBatchSearchVo;
import com.hidm.importexport.vo.ImportBatchVo;
import com.hidm.importexport.vo.ImportInfoSearchVo;
import com.hidm.importexport.vo.ImportInfoVo;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportItemVo;
import com.hidm.importexport.vo.PaginationVo;
import com.hidm.importexport.vo.ReceiveVo;
 /**
  *  
 *Description: 处理收货相关业务
 *@author GuoRong
 *@date 2018年11月29日
 *@version 1.0
 *
  */
@Controller
public class ReceiveController {
    private static final Logger log = LoggerFactory.getLogger(ReceiveController.class);
    
    @Autowired
    private ImportInfoService importInfoService;
    
    @Autowired
    private ImportBatchService importBatchService;
    
    @Autowired
    private ImportItemService importItemService;
    
    @RequestMapping("receive/release/manage")
    public String manage(Model model, HttpSession session) {
        return "/receive/release/manage";
    }
    
    @RequestMapping("receive/receive/manage")
    public String manage2(Model model, HttpSession session) {
        return "/receive/receive/manage";
    }
    
    @RequestMapping("receive/received/manage")
    public String received(Model model, HttpSession session) {
        return "/receive/received/manage";
    }
    
    @RequestMapping("receive/unreceive/manage")
    public String unreceive(Model model, HttpSession session) {
        return "/receive/unreceive/manage";
    }
    
    /**
     * 
    *Description: 根据前台页面条件查询符合条件的进口信息记录，并对记录进行分页将结果返回给前台
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
    *@parameter
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
     */
    @RequestMapping("receive/search")
    @ResponseBody
    public Map<String, Object> search(@RequestParam(value = "statusArray[]", required=false) int[] statusArray, ImportInfo importInfo, PaginationVo page, Model model, HttpSession session) {
        ImportInfoSearchVo vo = new ImportInfoSearchVo();
        vo.setImportInfo(importInfo);
        vo.setStatusArray(statusArray);
        if (null != page && null != page.getPage() && null != page.getRows()) {
            vo.setPage(page);
            page.setRowStart((page.getPage() - 1) * page.getRows());
        }
        
        int total = importInfoService.count(vo);
        List<ImportInfoVo> list = importInfoService.selectList(vo);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 对进口数据执行release操作，改变importInfo的status状态；同时更新当前操作人的信息
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
    *@parameter
    *@return String
     */
    @RequestMapping("receive/release")
    @ResponseBody
    public Map<String, String> release(ImportInfo importInfo, Model model, HttpSession session) {
    	Map<String, String> map = new HashMap<String, String>();
        if (null == importInfo.getId() || 0 == importInfo.getId()) {
        	map.put("status", "0");
        	map.put("msg", "id为空");
            return map;
        }
        
        String msg = importInfoService.checkVendor(importInfo);
        if (msg != null) {
        	map.put("status", "-1");
        	map.put("msg", msg);
        	return map;
        }
        
        importInfo.setStatus(ImportInfoConstant.STATUS_RELEASED);
        User user = LoginUtil.getUserInfo();
        importInfoService.releaseUpdate(importInfo, user.getUserName());
        map.put("status", "1");
        return map;
    }
    
    /**
     * 
    *Description: 对进口数据执行unrelease操作，改变importInfo的status状态；同时更新当前操作人的信息
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
    *@parameter
    *@return String
     */
    @RequestMapping("receive/unRelease")
    @ResponseBody
    public String unRelease(ImportInfo importInfo, Model model, HttpSession session) {
        if (null == importInfo.getId() || 0 == importInfo.getId()) {
            return "1";
        }
        
        ImportItemSearchVo vo  = new ImportItemSearchVo();
        ImportItem importItem = new ImportItem();
        importItem.setImportId(importInfo.getId());
        vo.setImportItem(importItem);
        List<ImportItemVo> list = importItemService.selectList(vo);
        if (null != list) {
            for (ImportItemVo item : list) {
                if (item.getStatus() == ReceiveConstant.STATUS_RECEIVED) {
                    return "2";
                }
            }
        }
        
        importInfo.setStatus(ImportInfoConstant.STATUS_SAVED);
        
        User user = LoginUtil.getUserInfo();
        importInfoService.unreleaseUpdate(importInfo, user.getUserName());
        return "0";
    }
    
    /**
     * Description: 对进口信息执行收货操作。
     * @param itemIds  每条importItem的id数组
     * @param stocks   每条importItem的库存地点数组
     * @param importId  当前importItem对应的importId
     * @param isBatch  是否是按批次收货  值为1按批次  否则不按批次
     * @param model 
     * @param session  
     * @return  ReceiveVo 向页面传递错误信息
     */
    @RequestMapping("receive/receive")
    @ResponseBody
    public ReceiveVo receive(@RequestParam(value = "itemIds[]") Long[] itemIds, @RequestParam(value = "stocks[]") String[] stocks,
            @RequestParam(value = "importId")  Long  importId, @RequestParam(value = "isBatch")  Integer  isBatch,
            Model model, HttpSession session) {
        ReceiveVo receiveVo = new ReceiveVo();
        
        if (null == itemIds || 0 == itemIds.length) {
            log.error("No itemIds. itemIds: " + Arrays.asList(itemIds) + ", importId: " + importId);
            receiveVo.setStatus(ReceiveConstant.RECEIVE_PARAMETER_ERROR);
            return receiveVo;
        }
        
        List<Long> itemIdList = Arrays.asList(itemIds);
        if (isBatch == 1) {
            List<ImportItemVo> qtyErrors = importBatchService.checkQty(importId, itemIdList);
            List<ImportBatchVo> overdueErrors = importBatchService.checkOverdue(importId, itemIdList);
            
            if (!qtyErrors.isEmpty()) {
                log.error("Qty error. itemIds: " + Arrays.asList(itemIds) + ", importId: " + importId);
                receiveVo.setStatus(ReceiveConstant.RECEIVE_OVERDUE_ERROR);
                receiveVo.setQtyErrors(qtyErrors);
            }
            
            if (!overdueErrors.isEmpty()) {
                log.error("Overdue error. itemIds: " + Arrays.asList(itemIds) + ", importId: " + importId);
                receiveVo.setStatus(ReceiveConstant.RECEIVE_OVERDUE_ERROR);
                receiveVo.setOverdueErrors(overdueErrors);
            }
        }
        
        if (ReceiveConstant.RECEIVE_OK == receiveVo.getStatus()) {
            receiveVo = importInfoService.receive(itemIdList, importId, isBatch, stocks);
        }
        
        return receiveVo;
    }
    
    /**
     * 
    *Description: 对进口信息执行取消收货操作
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
    *@parameter
    *@return String
     */
    @RequestMapping("receive/unReceive")
    @ResponseBody
    public String unReceiveItem(@RequestParam(value = "itemIds[]")  Long[]  itemIds, Model model, HttpSession session) {
        if (null == itemIds || 0 == itemIds.length) {
            return "请选择记录";
        }
        String errorMessage = "";
        // 根据itemid查询对象
        List<ImportItemVo> itemList = importItemService.selectByIds(itemIds);
        if (itemList != null) {
            // 根据grNo获取sap取消收货的信息
            errorMessage = importInfoService.unReceive(itemList);
        } else {
            errorMessage = "系统错误";
        }
        if (errorMessage.length() > 0) {
            return errorMessage;
        } else {
            return "0";
        }
    }
    
    /**
     * 
    *Description: 根据irNo查询批次信息是否存在，进而确定isBatch的值
    *@param  irNo 进口编号
    *@param  model 模型域
    *@param  session session域
    *@return String 页面跳转路径
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("receive/receive_manage")
    public String receiveManage(@RequestParam(value = "irNo")  String  irNo, Model model, HttpSession session) {
        importBatchService.deleteImportBatchByIrNo(irNo);
        ImportBatchSearchVo importBatch = new ImportBatchSearchVo();
        importBatch.setIrNo(irNo);
        int isBatch;
        int count = importBatchService.count(importBatch);
        if (count > 0) {
            isBatch = 1;
        } else {
            isBatch = 0;
        }
        model.addAttribute("irNo", irNo);
        model.addAttribute("isBatch", isBatch);
        return "/receive/receive/receive_manage";
    }
}