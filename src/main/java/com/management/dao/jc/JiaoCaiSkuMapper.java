package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiSku;
import com.management.pojo.jc.JiaoCaiSkuKey;
import com.management.vo.jc.JiaoCaiSkuVo;

import java.util.List;

public interface JiaoCaiSkuMapper {
    int deleteByPrimaryKey(JiaoCaiSkuKey key);

    int insert(JiaoCaiSku record);

    int insertSelective(JiaoCaiSku record);

    JiaoCaiSku selectByPrimaryKey(JiaoCaiSkuKey key);

    int updateByPrimaryKeySelective(JiaoCaiSku record);

    int updateByPrimaryKey(JiaoCaiSku record);

    List<JiaoCaiSku> findAll(JiaoCaiSkuVo jiaoCaiSku);
}