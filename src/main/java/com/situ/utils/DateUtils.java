package com.situ.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把一个字符串解析成一个Date类型的实例，
 * 日期格式，不包括时间
 * @author 浅墨~~
 * @date  2021年12月7日
 */
public final class DateUtils {
    /**
     * 把一个字符串解析成一个Date类型的实例
     * ，日期格式，不包括时间
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        // 简易日期格式化类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期格式转换异常");
        }
        return d;
    }
}
