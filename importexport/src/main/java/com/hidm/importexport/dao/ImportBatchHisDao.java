package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.importexport.entity.ImportBatchHis;
import com.hidm.importexport.vo.ImportBatchHisSearchVo;
import com.hidm.importexport.vo.ImportBatchHisVo;

@Mapper
public interface ImportBatchHisDao {
    public int insert(ImportBatchHis importBatchHis);

    public List<ImportBatchHisVo> selectByItemHisId(ImportBatchHisSearchVo vo);
}
