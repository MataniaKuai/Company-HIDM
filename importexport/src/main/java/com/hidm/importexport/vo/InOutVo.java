package com.hidm.importexport.vo;

import com.hidm.importexport.entity.InOut;

public class InOutVo extends InOut {
    private String goodsCodeName;
    
    private String controlStatusName;
    
    private String relieveModeName;
    
    private String outReasonName;
    
    private String reexportReasonName;

    public String getGoodsCodeName() {
        return goodsCodeName;
    }

    public void setGoodsCodeName(String goodsCodeName) {
        this.goodsCodeName = goodsCodeName;
    }

    public String getControlStatusName() {
        return controlStatusName;
    }

    public void setControlStatusName(String controlStatusName) {
        this.controlStatusName = controlStatusName;
    }

    public String getRelieveModeName() {
        return relieveModeName;
    }

    public void setRelieveModeName(String relieveModeName) {
        this.relieveModeName = relieveModeName;
    }

    public String getOutReasonName() {
        return outReasonName;
    }

    public void setOutReasonName(String outReasonName) {
        this.outReasonName = outReasonName;
    }

    public String getReexportReasonName() {
        return reexportReasonName;
    }

    public void setReexportReasonName(String reexportReasonName) {
        this.reexportReasonName = reexportReasonName;
    }
}
