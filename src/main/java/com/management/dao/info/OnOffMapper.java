package com.management.dao.info;

import com.management.pojo.info.OnOff;

import java.util.List;

public interface OnOffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OnOff record);

    int insertSelective(OnOff record);

    OnOff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnOff record);

    int updateByPrimaryKey(OnOff record);

    String getFlagByName(String name);

    List<OnOff> selectAll();

    void updateOnOffByName(OnOff onOff);
}