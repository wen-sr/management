package com.management.dao.jc;

import com.management.pojo.jc.AllowDistribution;

import java.util.List;

public interface AllowDistributionMapper {
    int insert(AllowDistribution record);

    int insertSelective(AllowDistribution record);

    List<AllowDistribution> findAll(AllowDistribution allowDistribution);

}