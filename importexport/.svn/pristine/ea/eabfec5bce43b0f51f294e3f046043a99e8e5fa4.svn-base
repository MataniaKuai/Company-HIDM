package com.hidm.importexport.dao;

import com.hidm.importexport.entity.ImportInfo;
import com.hidm.importexport.vo.ImportInfoSearchVo;
import com.hidm.importexport.vo.ImportInfoVo;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportReportVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ImportInfoDao {
    public int insert(ImportInfo importInfo);
    
    public void updateById(ImportInfo importInfo);
    
    public int count(ImportInfoSearchVo importInfo);
    
    public List<ImportInfoVo> selectList(ImportInfoSearchVo importInfo);
    
    public int reportCount(ImportItemSearchVo vo);
    
    public List<ImportReportVo> selectReportList(ImportItemSearchVo vo);
    
    public List<ImportReportVo> selectExport(ImportItemSearchVo vo);
    
    public void deleteByIds(Long[] ids);

    public ImportInfoVo selectByIrNo(@Param(value="irNo") String irNo);

    public void insertImports(List<ImportInfo> imports);

    public List<ImportInfoVo> selectAll();

    public List<ImportInfoVo> selectImportInfoByIds(Long[] ids);
}
