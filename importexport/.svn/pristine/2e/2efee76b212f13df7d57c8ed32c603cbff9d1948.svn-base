package com.hidm.importexport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.DepartmentDao;
import com.hidm.importexport.entity.Department;
import com.hidm.importexport.service.DepartmentService;
import com.hidm.importexport.vo.DepartmentSearchVo;

@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    
    public int insert(Department department) {
        return departmentDao.insert(department);
    }
    
    public void updateById(Department department) {
        departmentDao.updateById(department);
    }
    
    public int count(DepartmentSearchVo department) {
        return departmentDao.count(department);
    }
    
    public List<Department> selectList(DepartmentSearchVo department) {
        return departmentDao.selectList(department);
    }
    
    public List<Department> listCenter() {
        return departmentDao.listCenter();
    }
    
    public void deleteByIds(Long[] ids) {
        if (null != ids && ids.length > 0) {
            departmentDao.deleteByIds(ids);
        }
    }
}
