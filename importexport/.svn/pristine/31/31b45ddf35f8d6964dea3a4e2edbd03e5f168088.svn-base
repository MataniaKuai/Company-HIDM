package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.importexport.entity.ImportInfo;
import com.hidm.importexport.entity.ImportItem;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportItemVo;

@Mapper
public interface ImportItemDao {
    public int insert(ImportItem importItem);
    
    public void insertBatch(List<ImportItem> list);
    
    public void updateById(ImportItem importItem);
    
    public int count(ImportItemSearchVo importItem);
    
    public List<ImportItemVo> selectList(ImportItemSearchVo importItem);
    
    public int countByImportIds(Long[] ids);
    
    public void deleteByIds(Long[] ids);
    
    public void unReceiveByIds(Long[] ids);
    
    public int countUnReceived(ImportItemSearchVo importItem);
    
    public int countReceived(ImportItemSearchVo importItem);

    public List<ImportItemVo> selectListByGrNo(ImportItemSearchVo vo);

    public List<ImportItemVo> selectById(@Param(value="itemId")Long[] itemIds);

    public int selectCountByGrNo(ImportItemSearchVo vo);

    public void insertItems(List<ImportItem> items);

    public List<ImportItemVo> selectByIds(Long[] itemIds);

	public List<ImportItem> checkVendor(ImportInfo importInfo);
}
