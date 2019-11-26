package com.hidm.importexport.vo;

import com.hidm.importexport.util.JsonUtil;

public class PortalUserVo {
    private String dept;
    
    private String edept;
    
    private String department;
    
    private String edepartment;
    
    private String username;
    
    private String division;
    
    private String edivision;
    
    private String section;
    
    private String esection;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEdept() {
        return edept;
    }

    public void setEdept(String edept) {
        this.edept = edept;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEdepartment() {
        return edepartment;
    }

    public void setEdepartment(String edepartment) {
        this.edepartment = edepartment;
    }
    
    public String toString() {
        return JsonUtil.toJson(this);
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEdivision() {
        return edivision;
    }

    public void setEdivision(String edivision) {
        this.edivision = edivision;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getEsection() {
        return esection;
    }

    public void setEsection(String esection) {
        this.esection = esection;
    }
    
    
}
