package com.wyb.utils.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by FE on 2016/6/28.
 */
public class DateUtil {

    public static final String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_YY_MM_DD = "yyyy-MM-dd";

    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";

    public static Date addDay(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);// 让日期加1
        calendar.get(Calendar.DATE);// 加1之后的日期Top
        return calendar.getTime();
    }

    /**
     * 返回两个日期相差的天数
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static long daySub(Date fDate, Date oDate) {
        long to = fDate.getTime();
        long from = oDate.getTime();
        long dayTime = 1000 * 60 * 60 * 24;
        return (to - from) / (dayTime);
    }

    /**
     * 返回两个日期相差的秒数
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static long daySubToSecond(Date fDate, Date oDate) {
        long to = fDate.getTime();
        long from = oDate.getTime();
        long dayTime = 1000;
        return (to - from) / (dayTime);
    }

    public static String transferLongToDate(String dateFormat,Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date= new Date(millSec);
        return sdf.format(date);
    }
    /**
     * @param _date
     * @return
     */
    public static String formatDate(Date _date) {
        if (_date == null) {
            return "1970-01-01";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(_date);
    }

    /**
     * @param _date
     * @return
     */
    public static String formatSimple(Date _date, String patten) {
        if (_date == null || StringUtils.isBlank(patten)) {
            throw new NullPointerException();
        }
        return new SimpleDateFormat(patten).format(_date);
    }


    /**
     * 获取两个时间的时间查 如1天2小时30分钟
     */
    public static Map<String, Integer> subDateMap(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new NullPointerException("时间不能为空！");
        }
        Map<String, Integer> dateMap = new HashMap<String, Integer>();
        long dayTimes = 1000 * 24 * 60 * 60;
        long hourTimes = 1000 * 60 * 60;
        long mineTimes = 1000 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        int day = (int) (diff / dayTimes);
        // 计算差多少小时
        int hour = (int) (diff % dayTimes / hourTimes);
        // 计算差多少分钟
        int min = (int) (diff % dayTimes % hourTimes / mineTimes);
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        dateMap.put("days", day);
        dateMap.put("hour", hour);
        dateMap.put("min", min);
        dateMap.put("compareTo", endDate.compareTo(startDate));
        return dateMap;
    }

    /**
     * 格式化时间戳(秒数)，并按指定格式返回
     *
     * @param timestamp
     * @param pattern
     * @return
     */
    public static final String formatTimeStamp(long timestamp, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(timestamp * 1000));
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println(subDateMap(new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-05"), new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-05")));
//    }
    public static final Date stringToDate(String s){
        //为空处理
        if (null==s || StringUtils.isBlank(s)){
            return null;
        }
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            System.out.println("发生异常："+e.getMessage());
        }
        return null;
    }

    public static final Date stringToDateWithoutSecond(String s){
        //为空处理
        if (null==s || StringUtils.isBlank(s)){
            return null;
        }
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            System.out.println("发生异常："+e.getMessage());
        }
        return null;
    }

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒剩余截止";
    private static final String ONE_MINUTE_AGO = "分钟剩余截止";
    private static final String ONE_HOUR_AGO = "小时剩余截止";
    private static final String ONE_DAY_AGO = "天剩余截止";
    private static final String ONE_MONTH_AGO = "月剩余截止";
    private static final String ONE_YEAR_AGO = "年剩余截止";

    public static String format(Date date) {
        long delta = date.getTime() - new Date().getTime();
        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
        }
        if (delta < 45L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        else {
            long days = toDays(delta);
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        }
    }

    public static long toSeconds(long date) {
        return date / 1000L;
    }

    public static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    public static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    public static long toDays(long date) {
        return toHours(date) / 24L;
    }

    public static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    public static long toYears(long date) {
        return toMonths(date) / 365L;
    }
}
