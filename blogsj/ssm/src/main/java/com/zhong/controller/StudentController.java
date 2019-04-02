package com.zhong.controller;

import com.zhong.entiry.StudentBean;
import com.zhong.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/select")
    public String getStudent(Model model,int id){

        StudentBean studentBean=studentService.getStudent(id);
        model.addAttribute("studentBean",studentBean);
        return "student";

    }


    @RequestMapping("/selectLecture")
    public String getStudentLecture(Model model,int id){

        StudentBean studentBean=studentService.getStudent(id);
        model.addAttribute("studentBean",studentBean);
        return "studentLecture";
    }
}
