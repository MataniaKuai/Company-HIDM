package com.hidm.coo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.vo.ReportSearchVo;
import com.hidm.coo.vo.ReportVo;

@Mapper
public interface ReportDao {    
    public List<ReportVo> selectList(ReportSearchVo report);

	public ArrayList<ReportVo> selectListById(Long id);

	public ArrayList<ReportVo> selectStatusById(Long id);
}
