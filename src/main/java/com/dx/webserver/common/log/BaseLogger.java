package com.dx.webserver.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 日志记录类
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:07
 */
public abstract class BaseLogger {

    /** 日志记录*/
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
