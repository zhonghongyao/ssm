package com.zhong.entiry;

public class StudentLecture {
    private int id;
    private int student_id;
    private int lecture_id;
    private double grade;
    private String note;
    private LectureBean lectureBean;

    public LectureBean getLectureBean() {

        return lectureBean;
    }

    public void setLectureBean(LectureBean lectureBean) {
        this.lectureBean = lectureBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
