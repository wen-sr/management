package com.management.dao.xhwl;


import com.management.pojo.xhwl.RecordSku;

public interface RecordSkuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RecordSku record);

    int insertSelective(RecordSku record);

    RecordSku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RecordSku record);

    int updateByPrimaryKey(RecordSku record);
}