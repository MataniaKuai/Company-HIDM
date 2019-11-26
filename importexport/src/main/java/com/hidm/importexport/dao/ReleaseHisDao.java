package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.importexport.entity.ReleaseHis;
import com.hidm.importexport.vo.ReleaseHisSearchVo;
import com.hidm.importexport.vo.ReleaseHisVo;

@Mapper
public interface ReleaseHisDao {

    public void insert(ReleaseHis releaseHis);
    public int count(ReleaseHisSearchVo releaseHis);
    public List<ReleaseHisVo> selectReportList(ReleaseHisSearchVo releaseHis);
    public List<ReleaseHisVo> selectExport(ReleaseHisSearchVo release);
}
