package com.management.schedule;

import base.BaseJunitTest;
import com.management.pojo.wechat.UserInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestTaskSchedule extends BaseJunitTest {
    private final static Logger logger = LoggerFactory.getLogger(TestTaskSchedule.class);

    @Autowired
    TaskSchedule taskSchedule;

    @Test
    public void wmsErrorMsg() {
        taskSchedule.wmsErrorMsg();
    }

    @Test
    public void findByroleId() {
        List<UserInfo> userInfoList =  taskSchedule.findByroleId(1);
        for(UserInfo userInfo : userInfoList){
            logger.info(userInfo.getNickname() + ":" + userInfo.getOpenid());
        }
    }
}