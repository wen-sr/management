package com.management.exception;

import com.management.common.ServerResponse;
import com.management.schedule.TaskSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle extends RuntimeException {
    private final static Logger logger = LoggerFactory.getLogger(TaskSchedule.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ServerResponse catchException(Exception e) {

        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            logger.error("【======系统异常======】{}", e);
            return ServerResponse.createByErrorCodeMessage(myException.getCode(), myException.getMessage());
        } else {
            logger.error("【======系统异常======】{}", e);
            return ServerResponse.createByErrorCodeMessage(-1, e.getMessage());
        }

    }
}
