package com.hidm.importexport.vo;

public class MaterialAssetVo {    
//    private String assetNo;
//    private String materialNo;
//    private String goodsCode;
//    private Integer hiTech;
//    private String bondCla1;
//    private String bondCla2;
    
    private MaterialVo materialVo;
    private AssetVo assetVo;
    public MaterialVo getMaterialVo() {
        return materialVo;
    }
    public void setMaterialVo(MaterialVo materialVo) {
        this.materialVo = materialVo;
    }
    public AssetVo getAssetVo() {
        return assetVo;
    }
    public void setAssetVo(AssetVo assetVo) {
        this.assetVo = assetVo;
    }

    
}
