package com.management.dao.prd1;

import com.management.pojo.prd1.Xsogroup;
import com.management.vo.prd1.LogisticsQueryVo;
import com.management.vo.prd1.ReceiptDto;
import com.management.vo.prd1.ReceiptVo;
import com.management.vo.prd1.RecordSkuDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XsogroupMapper {
    int deleteByPrimaryKey(String xsogroupkey);

    int insert(Xsogroup record);

    int insertSelective(Xsogroup record);

    Xsogroup selectByPrimaryKey(String xsogroupkey);

    int updateByPrimaryKeySelective(Xsogroup record);

    int updateByPrimaryKey(Xsogroup record);

    List<ReceiptDto> getReceiptToday();

    List<Xsogroup> getReceipt(@Param(value = "begin") String begin, @Param(value = "end") String end);

    List<RecordSkuDto> selectByBarcode(String barcode);

    List<LogisticsQueryVo> bookShip(LogisticsQueryVo logisticsQueryVo);

    String selectStorerById(String id);

    List<ReceiptVo> receiptQuery(ReceiptVo receiptVo);
}