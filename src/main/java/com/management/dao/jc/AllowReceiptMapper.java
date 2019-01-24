package com.management.dao.jc;

import com.management.pojo.jc.AllowReceipt;

import java.util.List;

public interface AllowReceiptMapper {
    int insert(AllowReceipt record);

    int insertSelective(AllowReceipt record);

    List<AllowReceipt> findAll(AllowReceipt allowReceipt);
}