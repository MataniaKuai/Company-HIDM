package com.hidm.importexport.dao;

import com.hidm.importexport.entity.ControlDetail;
import com.hidm.importexport.vo.ControlDetailSearchVo;
import com.hidm.importexport.vo.ControlDetailVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ControlDetailDao {
    public int insert(ControlDetail controlDetail);
    
    public void updateById(ControlDetail controlDetail);
    
    public int count(ControlDetailSearchVo controlDetail);
    
    public List<ControlDetailVo> selectList(ControlDetailSearchVo controlDetail);
    
    public List<ControlDetailVo> selectExport(ControlDetailSearchVo controlDetail);
    
    public void deleteByIds(Long[] ids);

    public List<ControlDetailVo> selectReportList(ControlDetailSearchVo vo);

    public int countReportList(ControlDetailSearchVo vo);

    public List<ControlDetailVo> selectManageExport(ControlDetailSearchVo vo);

    public List<ControlDetailVo> selectDetailByIds(Long[] ids);
}
