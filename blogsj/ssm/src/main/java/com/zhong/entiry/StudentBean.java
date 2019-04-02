package com.zhong.entiry;

import java.util.List;

public class StudentBean {
    private int id;
    private String cnname;
    private int sex;
    private int selfcard_no;
    private String note;
    private StudentLecture studentLecture;
    private StudentSeifcard studentSeifcard;
    private List<StudentLecture> studentLectureList;

    public List<StudentLecture> getStudentLectureList() {
        return studentLectureList;
    }

    public void setStudentLectureList(List<StudentLecture> studentLectureList) {
        this.studentLectureList = studentLectureList;
    }

    public StudentSeifcard getStudentSeifcard() {
        return studentSeifcard;
    }

    public void setStudentSeifcard(StudentSeifcard studentSeifcard) {
        this.studentSeifcard = studentSeifcard;
    }

    public StudentLecture getStudentLecture() {
        return studentLecture;
    }

    public void setStudentLecture(StudentLecture studentLecture) {
        this.studentLecture = studentLecture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSelfcard_no() {
        return selfcard_no;
    }

    public void setSelfcard_no(int selfcard_no) {
        this.selfcard_no = selfcard_no;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
