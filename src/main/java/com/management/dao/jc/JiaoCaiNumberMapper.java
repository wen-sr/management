package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiNumber;

public interface JiaoCaiNumberMapper {
    int insert(JiaoCaiNumber record);

    int insertSelective(JiaoCaiNumber record);
}