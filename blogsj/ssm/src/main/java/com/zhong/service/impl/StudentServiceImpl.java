package com.zhong.service.impl;

import com.zhong.dao.StudentMapper;
import com.zhong.entiry.StudentBean;
import com.zhong.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentBean getStudent(int id) {
        return studentMapper.getStudent(id);
    }
}
