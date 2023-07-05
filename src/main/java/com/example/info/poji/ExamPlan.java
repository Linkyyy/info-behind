package com.example.info.poji;

import java.util.Date;

public class ExamPlan {
    private String creator;
    private Date createDate;
    private boolean isDel;

    private int id;
    private int paperId;
    private int gradeId;

    private Date beginTime;

    private Date endTime;

    public int getPaperId(){ return paperId; }

    public void setPaperId(int paperId){ this.paperId = paperId; }

    public int getGradeId(){ return gradeId; }

    public void setGradeId(int gradeId){ this.gradeId = gradeId; }

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
