package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.entity.Vendor;
import com.hidm.coo.vo.VendorSearchVo;
import com.hidm.coo.vo.VendorVo;

@Mapper
public interface VendorDao {

    public int insert(Vendor vendor);
    
    public void updateById(Vendor vendor);
    
    public int count(VendorSearchVo vendorSearchVo);
    
    public List<VendorVo> selectList(VendorSearchVo vendorSearchVO);
    
    public void deleteByIds(Long[] ids);

    public List<VendorVo> selectAll();

    public List<VendorVo> selectInfoByIds(Long[] ids);
    
    public List<VendorVo> selectCheckData(VendorSearchVo vo);

    public VendorVo selectByName(String vendor);
    
}
