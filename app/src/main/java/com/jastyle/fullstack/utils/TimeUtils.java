package com.jastyle.fullstack.utils;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * author jastyle
 * description:
 * date 2017/9/28  下午12:12
 */

public class TimeUtils {
    public static final int ONE_MINUTE_MILLIONS = 60*1000;
    public static final int ONE_HOURE_MILLIONS = 60*ONE_MINUTE_MILLIONS;
    public static final int ONE_DAY_MILLIONS = 24*ONE_HOURE_MILLIONS;
    /*获取格式化时间*/
    public static String getFormatTime(long millis) {
        Date newsDate = new Date(millis);
        Date curDate = new Date();
        String formatTime = "";
        long durTime = curDate.getTime() - newsDate.getTime();
        LogUtils.d("durTime", "newsDate:"+newsDate.getTime()+":"+"curDate:"+curDate.getTime()+":"+"时间间隔:"+durTime);
        int dayStatus = caculateDateStatus(newsDate,curDate);
        if (durTime<=ONE_MINUTE_MILLIONS) {
            formatTime = "刚刚";
        }else if (durTime<ONE_HOURE_MILLIONS) {
            formatTime = durTime/ONE_MINUTE_MILLIONS+"分钟前";
        }else if (durTime<ONE_DAY_MILLIONS) {
            formatTime = durTime/ONE_HOURE_MILLIONS+"小时前";
        }else {
            if (dayStatus == -1) {
                formatTime = "昨天"+ DateFormat.format("HH:mm",newsDate);
            }else if (dayStatus == -2) {
                formatTime = "前天"+ DateFormat.format("HH:mm", newsDate);
            }else if (dayStatus<-2&&Math.abs(dayStatus)<30) {
                formatTime = Math.abs(dayStatus)+"天前";
            }else if (Math.abs(dayStatus)>=30) {
                formatTime = Math.abs(dayStatus)/30+"月前";
            }
        }
        return formatTime;
    }

    /*计算相差几天*/
    public static int caculateDateStatus(Date newsDate, Date curDate) {
        Calendar newsCalendar = Calendar.getInstance();
        newsCalendar.setTime(newsDate);
        int newsDateOfYear = newsCalendar.get(Calendar.DAY_OF_YEAR);
        Calendar curDateCalendar = Calendar.getInstance();
        curDateCalendar.setTime(curDate);
        int curDateOfYear = curDateCalendar.get(Calendar.DAY_OF_YEAR);
        return newsDateOfYear- curDateOfYear;
    }

    /*将视频时间格式化*/
    public static String sec2Formate(int seconds) {
        String formate = "00:00";
        if (seconds<=0)
            return formate;
        else {
            int minute = seconds/60;
            if (minute<60) {
                formate = unitFormate(minute)+":"+unitFormate(seconds%60);
            }else {
                int houre = minute/60;
                formate = unitFormate(houre)+":"+unitFormate(minute%60)+":"+unitFormate(seconds%60);
            }
        }
        return formate;
    }

    public static String unitFormate(int time) {
        String str = "";
        if (time>=0&&time<10) {
            str = "0"+time;
        }else str = time+"";
        return str;
    }

}
