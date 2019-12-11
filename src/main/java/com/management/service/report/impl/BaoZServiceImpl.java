package com.management.service.report.impl;


import com.management.common.ServerResponse;
import com.management.dao.report.CaseDetailMapper;
import com.management.dao.report.CaseIdMapper;
import com.management.dao.report.JushouChanliangMapper;
import com.management.dao.report.PackCaseMapper;
import com.management.service.report.IBaoZService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class BaoZServiceImpl implements IBaoZService {
    @Autowired
    CaseDetailMapper caseDetailMapper;
    @Autowired
    CaseIdMapper caseIdMapper;
    @Autowired
    PackCaseMapper packCaseMapper;
    @Autowired
    JushouChanliangMapper jushouChanliangMapper;

    @Override
    public ServerResponse getBaoZData(String date_begin, String date_end) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        // 一般图书主配发货
        Map<String, Integer> map = new HashMap<>();
        int yzf = caseDetailMapper.getBaoZData(date_begin, date_end);
        map.put("yzf", yzf);
        int yzf1 = caseDetailMapper.getBaoZData1(date_begin, date_end);
        map.put("yzf1", yzf1);
        // 一般图书主配够包
        int yzg = caseDetailMapper.getBaoZData2(date_begin, date_end);
        map.put("yzg", yzg);
        int yzg1 = caseDetailMapper.getBaoZData3(date_begin, date_end);
        map.put("yzg1", yzg1);
        // 一般图书主配发货未完成
//        int yzw = packCaseMapper.getBaoZData4(date_begin, date_end);
//        map.put("yzw", yzw);
        int yzw1 = packCaseMapper.getBaoZData5(date_begin, date_end);
        map.put("yzw1", yzw1);
        // 一般图书请配发货
        int yqf = caseDetailMapper.getBaoZData6(date_begin, date_end);
        map.put("yqf", yqf);
        int yqf1 = caseDetailMapper.getBaoZData7(date_begin, date_end);
        map.put("yqf1", yqf1);
        // 一般图书请配够包
        int yqg = caseDetailMapper.getBaoZData8(date_begin, date_end);
        map.put("yqg", yqg);
        int yqg1 = caseDetailMapper.getBaoZData9(date_begin, date_end);
        map.put("yqg1", yqg1);
        // 一般图书请配发货未完成
//        int yqw = packCaseMapper.getBaoZData10(date_begin, date_end);
//        map.put("yqw", yqw);
        int yqw1 = packCaseMapper.getBaoZData11(date_begin, date_end);
        map.put("yqw1", yqw1);
        // 一般图书退货发货
        int ytf = caseDetailMapper.getBaoZData12(date_begin, date_end);
        map.put("ytf", ytf);
        int ytf1 = caseDetailMapper.getBaoZData13(date_begin, date_end);
        map.put("ytf1", ytf1);
//       // 一般图书退货够包
        int ytg = caseDetailMapper.getBaoZData14(date_begin, date_end);
        map.put("ytg", ytg);
        int ytg1 = caseDetailMapper.getBaoZData15(date_begin, date_end);
        map.put("ytg1", ytg1);
        // 一般图书退货发货未完成
//        int ytw = packCaseMapper.getBaoZData16(date_begin, date_end);
//        map.put("ytw", ytw);
        int ytw1 = packCaseMapper.getBaoZData17(date_begin, date_end);
        map.put("ytw1", ytw1);
        // 农家书屋主配发货
        int nzf = caseDetailMapper.getBaoZData18(date_begin, date_end);
        map.put("nzf", nzf);
        int nzf1 = caseDetailMapper.getBaoZData19(date_begin, date_end);
        map.put("nzf1", nzf1);
         //农家书屋主配够包
        int nzg = caseDetailMapper.getBaoZData20(date_begin, date_end);
        map.put("nzg", nzg);
        int nzg1 = caseDetailMapper.getBaoZData21(date_begin, date_end);
        map.put("nzg1", nzg1);
        // 农家书屋主配发货未完成
//        int nzw = packCaseMapper.getBaoZData22(date_begin, date_end);
//        map.put("nzw", nzw);
        int nzw1 = packCaseMapper.getBaoZData23(date_begin, date_end);
        map.put("nzw1", nzw1);
        //手工单主配拒收
        int zj = caseIdMapper.getBaoZData27(date_begin,date_end);
        map.put("zj",zj);
        //手工单客退拒收
        int kj = jushouChanliangMapper.getBaoZData24(date_begin,date_end);
        map.put("kj",kj);
        int kj1 = jushouChanliangMapper.getBaoZData28(date_begin,date_end);
        map.put("kj1",kj1);
        //大中专退货发货
        int dtf = caseDetailMapper.getBaoZData25(date_begin, date_end);
        map.put("dtf", dtf);
        int dtf1 = caseDetailMapper.getBaoZData26(date_begin, date_end);
        map.put("dtf1", dtf1);
        return ServerResponse.createBySuccess(map);

    }
}
