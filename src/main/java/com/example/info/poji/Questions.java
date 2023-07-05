package com.example.info.poji;

import java.util.Date;

public class Questions {

    private int  questionsId;
    private String content;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    private String category;
    private String answer;

    private String creator;
    private Date createDate;
    private boolean isDel;

    public int getQuestionsId(){ return questionsId; }
    public void setQuestionsId(int questionsId){ this.questionsId = questionsId; }

    public String getContent(){ return content; }
    public void setContent(String content){ this.content = content; }

    public String getOptionA(){ return optionA; }
    public void setOptionA(String optionA){ this.optionA = optionA; }
    public String getOptionB(){ return optionB; }
    public void setOptionB(String optionB){ this.optionB = optionB; }
    public String getOptionC(){ return optionC; }
    public void setOptionC(String optionC){ this.optionC = optionC; }

    public String getOptionD(){ return optionD; }
    public void setCategory(String category){ this.category = category; }
    public String getAnswer(){ return answer; }
    public void setAnswer(String answer){ this.answer = answer; }

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
