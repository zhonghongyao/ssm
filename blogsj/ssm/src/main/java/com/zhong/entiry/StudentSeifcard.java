package com.zhong.entiry;

import java.util.Date;

public class StudentSeifcard {
    private int id;
    private int student_id;
    private String native_1;
    private Date issue_date;
    private Date end_date;
    private String note;


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

    public String getNative_1() {
        return native_1;
    }

    public void setNative_1(String native_1) {
        this.native_1 = native_1;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
