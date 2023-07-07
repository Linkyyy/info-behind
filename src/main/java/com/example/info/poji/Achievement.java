package com.example.info.poji;

public class Achievement {
    private int resultId;
    private Student student;
    private ExamPlan examPlan;
    private Testpaper testpaper;
    private int score;

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Testpaper getTestpaper(){ return  testpaper; }

    public void setTestpaper(Testpaper testpaper){ this.testpaper = testpaper; }

    public ExamPlan getExamPlan() {
        return examPlan;
    }

    public void setExamPlan(ExamPlan examPlan) {
        this.examPlan = examPlan;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}