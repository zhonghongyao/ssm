package com.zhong.dao;

import com.zhong.entiry.TestDate;
import org.apache.ibatis.annotations.Param;

public interface TestDateMapper {

    public int insertTestDate(TestDate testDate);
    public TestDate selectTestDate(@Param("id") int id);
}
