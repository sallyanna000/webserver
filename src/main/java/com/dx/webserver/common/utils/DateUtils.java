package com.dx.webserver.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 16:43
 */
public class DateUtils {

    /**
     * 获取DateUtils实例
     * @return DateUtils实例
     */
    public static DateUtils getInstance() {
        return new DateUtils();
    }

    /**
     * 获取当前时间，并格式化输出
     *
     * @param formatString 日期格式
     * @return 格式化后的当前时间
     */
    public String getCurrentTime(String formatString) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatDate2String(calendar.getTime(), formatString);
    }

    /**
     * 将Date日期格式化显示为string
     *
     * @param date 要显示的日期
     * @param formatString 要格式化的形式
     * @return 格式化后的日期
     */
    public String formatDate2String(Date date, String formatString) {
        DateFormat df = new SimpleDateFormat(formatString);
        return df.format(date);
    }
}
