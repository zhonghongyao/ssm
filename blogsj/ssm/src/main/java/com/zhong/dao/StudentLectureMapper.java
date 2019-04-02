package com.zhong.dao;

import com.zhong.entiry.StudentLecture;

import java.util.List;

public interface StudentLectureMapper {

    public List<StudentLecture> findStudentLectureByStudentId(int id);

}
