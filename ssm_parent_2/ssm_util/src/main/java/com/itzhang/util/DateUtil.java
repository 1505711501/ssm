package com.itzhang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String formatDateToStr(Date date){

        //创建日期格式化类
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 接受字符串返回日期
     * @param dateStr
     * @return
     */

    public static Date parseStrToDate(String dateStr) {
        //创建日期格式化类
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
