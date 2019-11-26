package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.importexport.entity.ImportItemHis;
import com.hidm.importexport.vo.ImportItemHisSearchVo;
import com.hidm.importexport.vo.ImportItemHisVo;

@Mapper
public interface ImportItemHisDao {
    public int insert(ImportItemHis importItemHis);

    public List<ImportItemHisVo> selectByItemId(ImportItemHisSearchVo vo);

    public int countByItemId(ImportItemHisSearchVo vo);

}
