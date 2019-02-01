package com.management.dao.jc;

import com.management.pojo.jc.AllowAllocate;

import java.util.List;

public interface AllowAllocateMapper {
    int insert(AllowAllocate record);

    int insertSelective(AllowAllocate record);

    List<AllowAllocate> findAll(AllowAllocate allowAllocate);
}