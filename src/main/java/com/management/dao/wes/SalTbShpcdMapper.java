package com.management.dao.wes;

import com.management.pojo.wes.SalTbShpcd;
import com.management.vo.salTbShpcd.BxVo;

import java.util.List;

public interface SalTbShpcdMapper {
    int deleteByPrimaryKey(Integer pkid);

    int insert(SalTbShpcd record);

    int insertSelective(SalTbShpcd record);

    SalTbShpcd selectByPrimaryKey(Integer pkid);

    int updateByPrimaryKeySelective(SalTbShpcd record);

    int updateByPrimaryKey(SalTbShpcd record);
    List<BxVo> bx(BxVo bxVo);
}