package com.hidm.importexport.dao;

import com.hidm.importexport.entity.Department;
import com.hidm.importexport.vo.DepartmentSearchVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDao {
    public int insert(Department department);
    
    public void updateById(Department department);
    
    public int count(DepartmentSearchVo department);
    
    public List<Department> selectList(DepartmentSearchVo department);
    
    public List<Department> listCenter();
    
    public void deleteByIds(Long[] ids);
}
