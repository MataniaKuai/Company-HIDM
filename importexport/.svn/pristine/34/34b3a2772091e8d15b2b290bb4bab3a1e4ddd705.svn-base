package com.hidm.importexport.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.importexport.constant.LoginConstant;
import com.hidm.importexport.entity.Department;
import com.hidm.importexport.service.DepartmentService;
import com.hidm.importexport.vo.DepartmentSearchVo;
import com.hidm.importexport.vo.PaginationVo;  
  
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    @RequestMapping("department/list")
    public String list(Model model, HttpSession session) {
        return "/department/list";
    }
    
    /**
     * 
    *Description: 查询部门记录信息
    *@param department
    *@param page 分页对象
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("department/search")
    @ResponseBody
    public Map<String, Object> search(Department department, PaginationVo page, Model model, HttpSession session) {
        DepartmentSearchVo vo = new DepartmentSearchVo();
        vo.setDepartment(department);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = departmentService.count(vo);
        List<Department> list = departmentService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 查询中心记录
    *@param department
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("department/public/listcenter")
    @ResponseBody
    public Map<String, Object> listCenter(Department department, PaginationVo page, Model model, HttpSession session) {
        List<Department> list = departmentService.listCenter();
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 查询部门信息
    *@param department
    *@param page
    *@return List<Department> 
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("department/allcenter")
    @ResponseBody
    public List<Department> allCenter(Department department, PaginationVo page, Model model, HttpSession session) {
        List<Department> list = departmentService.listCenter();
        return list;
    }
    
    /**
     * 
    *Description: 转发页面路径
    *@return String 目标页面路径
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("department/add")
    public String add(Model model, HttpSession session) {
        return "/department/edit";
    }
    
    /**
     * 
    *Description: 新增或更新部门记录信息
    *@param department 
    *@return boolean
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("department/save")
    @ResponseBody
    public boolean save(Department department, Model model, HttpSession session) {
        if (null == department.getId() || 0 == department.getId()) {
            departmentService.insert(department);
        } else {
            departmentService.updateById(department);
        }
        
        return true;
    }
    
    /**
     * 
    *Description: 根据部门id删除部门记录
    *@param ids Long[]
    *@return boolean
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("department/delete")
    @ResponseBody
    public boolean delete(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        departmentService.deleteByIds(ids);
        model.addAttribute(LoginConstant.CURRENT_USER_NAME, session.getAttribute(LoginConstant.CURRENT_USER_NAME));
        return true;
    }
}