package com.hidm.coo.vo;

import com.hidm.coo.util.JsonUtil;

public class PortalDeptVo {
    private String dept;
    
    private String edept;
    
    private String department;
    
    private String edepartment;

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
}
