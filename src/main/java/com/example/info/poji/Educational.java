package com.example.info.poji;

import java.util.Date;

public class Educational {
    private int educationalId;
    private String educationalName;
    private String description;
    private String creator;
    private Date createDate;
    private boolean isDel;

    public int getEducationalId() {
        return educationalId;
    }

    public void setEducationalId(int educationalId) {
        this.educationalId = educationalId;
    }

    public String getEducationalName() {
        return educationalName;
    }

    public void setEducationalName(String educationalName) {
        this.educationalName = educationalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }
}
