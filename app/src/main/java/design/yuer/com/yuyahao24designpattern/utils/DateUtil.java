package design.yuer.com.yuyahao24designpattern.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    public static String[] WEEK = new String[]{"天", "一", "二", "三", "四", "五",
            "六"};

    private static final long ONE_SECOND = 1000;
    private static final long ONE_MINUTE = ONE_SECOND * 60;
    private static final long ONE_HOUR = ONE_MINUTE * 60;
    private static final long ONE_DAY = ONE_HOUR * 24;

    /**
     * String 转换 Date
     *
     * @param str
     * @param format
     * @return
     */
    public static Date string2Date(String str, String format) {
        try {
            return new SimpleDateFormat(format).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * Date（long） 转换 String
     *
     * @param time
     * @param format
     * @return
     *
     */
    public static String date2String(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置时区
        String s = sdf.format(time);
        return s;
    }

    /**
     * 将不同类型的时间格式转化为另外一种类型的时间格式
     * string2Date("20160425","yyyyMMdd","yyyy-MM-dd");
     * @param str
     * @param formatCurrent
     * @param formatTarget
     * @return
     */
    public static String stringToString(String str, String formatCurrent,String formatTarget) {
        try {
            long time = new SimpleDateFormat(formatCurrent).parse(str).getTime();
            SimpleDateFormat sdf = new SimpleDateFormat(formatTarget);
            String s = sdf.format(time);
            return s;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 手环睡眠时间12点的时候分离前后
     *
     * @param time
     * @return
     */
    public static String date2StringTransfotlate12(long time) {
        String yearMonthDay = "";
        String yearAndMonth = new SimpleDateFormat("yyyy-MM").format(time * 1000);
        int hour = Integer.parseInt(date2String(time * 1000, "HH"));
        int day = Integer.parseInt(date2String(time * 1000, "dd"));
        if (hour > 12) {
            day = day + 1;
            yearMonthDay = yearAndMonth + "-" + String.valueOf(day);
        } else {
            yearMonthDay = date2String(time * 1000, "yyyy-MM-dd");
        }
        return yearMonthDay;
    }

    /**
     * long 去除 时分秒 时分秒全部为0
     *
     * @param date
     * @return
     */
    public static long getYearMonthDay(long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取目标时间和当前时间之间的差距
     *
     * @param date
     * @return
     */
    public static String getTimestampString(Date date) {
        Date curDate = new Date();
        long splitTime = curDate.getTime() - date.getTime();
        if (splitTime < (30 * ONE_DAY)) {
            if (splitTime < ONE_MINUTE) {
                return "刚刚";
            }
            if (splitTime < ONE_HOUR) {
                return String.format("%d分钟前", splitTime / ONE_MINUTE);
            }

            if (splitTime < ONE_DAY) {
                return String.format("%d小时前", splitTime / ONE_HOUR);
            }

            return String.format("%d天前", splitTime / ONE_DAY);
        }
        String result;
        result = "M月d日 HH:mm";
        return (new SimpleDateFormat(result, Locale.CHINA)).format(date);
    }

    /**
     * 24小时制 转换 12小时制
     *
     * @param time
     * @return
     */
    public static String time24To12(String time) {
        String str[] = time.split(":");
        int h = Integer.valueOf(str[0]);
        int m = Integer.valueOf(str[1]);
        String sx;
        if (h < 1) {
            h = 12;
            sx = "上午";
        } else if (h < 12) {
            sx = "上午";
        } else if (h < 13) {
            sx = "下午";
        } else {
            sx = "下午";
            h -= 12;
        }
        return String.format("%d:%02d%s", h, m, sx);
    }

    /**
     * Date 转换 HH
     *
     * @param date
     * @return
     */
    public static String date2HH(Date date) {
        return new SimpleDateFormat("HH").format(date);
    }

    /**
     * Date 转换 HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String date2HHmm(Date date) {
        return new SimpleDateFormat("HH:mm").format(date);
    }

    /**
     * Date 转换 HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String date2HHmmss(Date date) {
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }

    /**
     * Date 转换 HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String date2yyyyMMddHHmmss(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * Date 转换 MM.dd
     *
     * @param date
     * @return
     */
    public static String date2MMdd(Date date) {
        return new SimpleDateFormat("MM.dd").format(date);
    }

    /**
     * Date 转换 yyyy.MM.dd
     *
     * @param date
     * @return
     */
    public static String date2yyyyMMdd(Date date) {
        return new SimpleDateFormat("yyyy.MM.dd").format(date);
    }

    /**
     * Date 转换 MM月dd日 星期
     *
     * @param date
     * @return
     */
    public static String date2MMddWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return new SimpleDateFormat("MM月dd日 星期").format(date)
                + WEEK[dayOfWeek - 1];
    }

    /**
     * Date 转换 yyyy年MM月dd日 星期
     *
     * @param date
     * @return
     */
    public static String date2yyyyMMddWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return new SimpleDateFormat("yyyy年MM月dd日 星期").format(date)
                + WEEK[dayOfWeek - 1];
    }
    public static int getWeekNumByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0)
            dayOfWeek = 7;
        return dayOfWeek;
    }

    public static String date2yyyyMMddWeek2(String time) {
        //String time = "2016-5-28 17:00:00";
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date_util;
        try {
            date_util = sdf.parse(time);
            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());//转换为sql.date
            SimpleDateFormat strdate2 = new SimpleDateFormat("E");

            result = strdate2.format(date_sql);
            System.out.println(result);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //转换为util.date
        if (TextUtils.isEmpty(result)) {
            return "";
        } else if (result.equals("星期一")) {
            result = "周一";
        } else if (result.equals("星期二")) {
            result = "周二";
        } else if (result.equals("星期三")) {
            result = "周三";
        } else if (result.equals("星期四")) {
            result = "周四";
        } else if (result.equals("星期五")) {
            result = "周五";
        } else if (result.equals("星期六")) {
            result = "周六";
        } else if (result.equals("星期日")) {
            result = "周日";
        }
        return result;
    }

    public static String getWeekByDate(String dates) {
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        try {
            date = sdfInput.parse(dates);
        } catch (Exception e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0)
            dayOfWeek = 0;
        return (dayNames[dayOfWeek]);
    }
    static final String	  dayNames[]  = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };

    public static String getPutAndOutDateTypeString(String dates, String inputSimpleDateFormat,String outputSimpleDateFormat) {
        String result = "";
        SimpleDateFormat sdfInput = new SimpleDateFormat(inputSimpleDateFormat);
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        try {
            date = sdfInput.parse(dates);
            result =  date2String(date.getTime(),outputSimpleDateFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (result);
    }
    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;

    /******
     * 是否是同一天
     **********/
    public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY
                && interval > -1L * MILLIS_IN_DAY
                && toDay(ms1) == toDay(ms2);
    }

    /******
     * 判断是否当前你的时间是否大于当天的12点
     *********/
    public static boolean isBigger12DotPotionTime(final long ms1) {
        if (Integer.parseInt(date2String(ms1, "HH")) >= 12) {
            return true;
        }
        return false;
    }

    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }

    /************
     * 获得系统当前的时间：年月日
     *********/
    public static String getCurrentDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = sDateFormat.format(new Date());
        return date;
    }

    public static String getCurrentDate2() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sDateFormat.format(new Date());
        return date;
    }

    /**
     * 将long行的秒时间转化为分钟
     * 手环数据格式的毫秒值
     */
    public static String getMinute(String time) {
        String date = String.valueOf(Long.parseLong(time) / 60);
        return date;
    }

    /**
     * 将long行的秒时间转化为分钟
     * 手环数据格式的毫秒值
     */
    public static int getMinuteInt(long time) {
        int date = (int) (time / 60);
        return date;
    }

    public static int getMinuteInt2(long time) {
        double value = time / 60f;
        int result = (int) Math.round(value);
        return result;
    }

    /**
     * 获取毫秒值
     *
     * @param time
     * @param format
     * @return
     */
    public static long getLongToDate(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format,
                Locale.getDefault());
        Date date = new Date();
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 截取时间戳
     *
     * @param time
     */
    public static String gsubTimeForData(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss",
                Locale.getDefault());
        Date date = new Date();
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //String str = new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date(time));
        String str = new SimpleDateFormat(format).format(date);
        //String str =  sdf.format(date);
        return str;
    }

    public static String dateToString(Date date, String format) {
        String result = "";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            result = formater.format(date);
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * @param mss 要转换的毫秒值
     * @return 该毫秒数转换为 ?小时 后的格式
     * @author fy.zhang
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
//        return days + " days " + hours + " hours " + minutes + " minutes "
//                + seconds + " seconds ";
        return days * 24 + hours + "";
    }

    /**
     * 判断是否足够近
     * @param newTime
     * @param lastTime
     * @return
     */
    public static boolean isCloseEnough(long newTime,long lastTime){
        if((newTime - lastTime)>2*60*1000){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s,String format){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    /**
     * 将时间戳转换为时间
     */
    public static long stringToLongTime(String time,String format){
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss",
                Locale.getDefault());
        Date date = new Date();
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
    /**
     * 截取yyyy-MM-dd HH:mm:ss格式的字符串显示 时分秒
     * @param myContent
     * @return
     */

    public static String getMyDateToSubYearAndMonthAndDay(String myContent){
        String result = "";
        if(TextUtils.isEmpty(myContent)){
            return result;
        }
        String time [] = myContent.split(" ");
        if(time == null){
            return result;
        }
        if(time.length == 2){
            return time[1];
        }
        return  result;
    };

}
