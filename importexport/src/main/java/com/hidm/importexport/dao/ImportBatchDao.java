package com.hidm.importexport.dao;

import com.hidm.importexport.entity.ImportBatch;
import com.hidm.importexport.vo.ImportBatchSearchVo;
import com.hidm.importexport.vo.ImportBatchVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImportBatchDao {
    public int insert(ImportBatch importBatch);
    
    public void insertBatch(List<ImportBatch> list);
    
    public void updateById(ImportBatch importBatch);
    
    public int count(ImportBatchSearchVo importBatch);
    
    public List<ImportBatchVo> selectList(ImportBatchSearchVo importBatch);
    
    public int countByImportIds(Long[] ids);
    
    public void deleteByIds(Long[] ids);

    public void deleteImportBatchByIrNo(String irNo);
}
