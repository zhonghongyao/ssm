package com.zhong.service.impl;

import com.zhong.dao.TestDateMapper;
import com.zhong.entiry.TestDate;

import com.zhong.service.TestDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testDao")
public class TestDateServiceImpl implements TestDateService {

    @Autowired
    TestDateMapper testDateMapper;

    @Override
    public boolean insertTestDate(TestDate testDate) {
        int result=testDateMapper.insertTestDate(testDate);
        if(result>0){
            return true;

        }
        return false;

    }
}
