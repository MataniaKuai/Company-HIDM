package com.hidm.importexport.entity;

import java.util.Date;

public class ImportItemHis {
    private Long id;
    
    private Long importItemId;
    
    private String relatedMoveType;
    
    private String moveType;
    
    private String relatedGrNo;

    private String grNo;

    private String grYear;

    private String relatedGrYear;
    
    private Integer status;
    
    private Date addTime;
    
    private String addUser;
    
    private Integer delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImportItemId() {
        return importItemId;
    }

    public void setImportItemId(Long importItemId) {
        this.importItemId = importItemId;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public String getRelatedMoveType() {
        return relatedMoveType;
    }

    public void setRelatedMoveType(String relatedMoveType) {
        this.relatedMoveType = relatedMoveType;
    }

    public String getRelatedGrNo() {
        return relatedGrNo;
    }

    public void setRelatedGrNo(String relatedGrNo) {
        this.relatedGrNo = relatedGrNo;
    }

    public String getGrNo() {
        return grNo;
    }

    public void setGrNo(String grNo) {
        this.grNo = grNo;
    }

    public String getGrYear() {
        return grYear;
    }

    public void setGrYear(String grYear) {
        this.grYear = grYear;
    }

    public String getRelatedGrYear() {
        return relatedGrYear;
    }

    public void setRelatedGrYear(String relatedGrYear) {
        this.relatedGrYear = relatedGrYear;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

}
