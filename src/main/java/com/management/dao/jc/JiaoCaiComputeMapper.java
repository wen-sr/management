package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiCompute;
import com.management.vo.jc.JiaoCaiComputeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface JiaoCaiComputeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiCompute record);

    int insertSelective(JiaoCaiCompute record);

    JiaoCaiCompute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiCompute record);

    int updateByPrimaryKey(JiaoCaiCompute record);

    void getComputeNo(Map<String, Integer> map);

    List<JiaoCaiCompute> findAll(JiaoCaiCompute jiaoCaiCompute);

    List<JiaoCaiComputeVo> wholeShipInfoTotal(JiaoCaiCompute jiaoCaiCompute);

    void getBatchno(Map<String, Integer> map);

    void getShipno(Map<String, Integer> map);

    int updateBatchnoByIds(@Param(value = "ids")List<Long> ids, @Param(value = "batchno")String batchno);

    int updateShipnoByBatchno(JiaoCaiCompute jiaoCaiCompute);

    List<JiaoCaiComputeVo> wholeShipInfo(JiaoCaiCompute jiaoCaiCompute);

    List<JiaoCaiComputeVo> pickInfoTotal(JiaoCaiCompute jiaoCaiCompute);

    void getPickno(Map<String, Integer> map);

    List<JiaoCaiComputeVo> pickInfo(JiaoCaiCompute jiaoCaiCompute);

    List<JiaoCaiComputeVo> selectOddPackTips(JiaoCaiCompute jiaoCaiCompute);

    void getTaskno(Map<String, Integer> map);

    void getTaskid(Map<String, Integer> map);
}