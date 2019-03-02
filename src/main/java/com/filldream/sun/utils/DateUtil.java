package com.filldream.sun.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.filldream.sun.constants.ResultType;
import com.filldream.sun.sunEntity.SunCalendar;
import com.filldream.sun.sunEntity.jsonBean.calendar.Almanac;
import com.filldream.sun.sunEntity.jsonBean.calendar.CalendarBean;
import com.filldream.sun.sunEntity.jsonBean.calendar.Data;
import com.filldream.sun.sunEntity.jsonBean.calendar.Holiday;
import com.filldream.sun.sunEntity.jsonBean.calendar.Holidaylist;
import com.filldream.sun.sunEntity.jsonBean.calendar.Work;

import me.fishlord.common.utils.HttpUtils;

/**
 * 日期工具类
 * @author RickSun
 *
 */
public class DateUtil {
    public DateUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }
	
	private static final long ONE_MINUTE = 60000L;
	private static final long ONE_HOUR = 3600000L;
	private static final long ONE_DAY = 86400000L;
	private static final long ONE_WEEK = 604800000L;
	
	/**
	 * 日期转字符串
	 * @param date	日期
	 * @param format	格式
	 * @return	日期字符串
	 */
	public static String dateToStrng(Date date,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 字符串转日期
	 * @param date	日期字符串
	 * @param format	日期格式
	 * @return	日期类型
	 * @throws ParseException
	 */
	public static Date dateToStrng(String date,String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(format);
	}
	
	
	/**
	 * 比较两个时间的大小      时间越近值越大
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int CompareDateSize(Date date1, Date date2) {
		try {
			if (date1.getTime() > date2.getTime()) {
				return 1;
			}
			if (date1.getTime() < date2.getTime()) {
				return -1;
			}
			return 0;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return -2;
	}
	
	/**
	 * 比较两个时间的大小      时间越近值越大
	 * @param date1
	 * @param date2
	 * @param dateFormat
	 * @return
	 */
	public static int CompareDateSize(String date1, String date2, String dateFormat) {
		if ((SunCommon.isBlank(date1)) || (SunCommon.isBlank(date2)) || (SunCommon.isBlank(dateFormat))) {
			return -2;
		}
		Date leftDate = new Date();
		Date rightDate = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			leftDate = sdf.parse(date1);
			rightDate = sdf.parse(date2);
			if (leftDate.getTime() > rightDate.getTime()) {
				return 1;
			}
			if (leftDate.getTime() < rightDate.getTime()) {
				return -1;
			}
			return 0;
		} catch (Exception e) {
		}
		return -2;
	}
	
	/**
	 * 获取指定时间的累加时间，如指定日期的第五天
	 * @param date      指定时间
	 * @param number    天数，可以负数
	 * @return
	 */
	public static Date getDateByAddDay(Date date, Integer number) {
		return getDateByAddCalendar(date, Calendar.DAY_OF_MONTH, number);
	}
	
	/**
	 * 获取指定时间的累加分钟时间，正往前，负往后
	 * @param date
	 * @param addMinutes 
	 * @return
	 */
	public static Date getDateByAddMinute(Date date, int number) {
		return getDateByAddCalendar(date, Calendar.MINUTE, number);
	}
	
	/**
	 * 获取指定日期的指定字段的累加，正往前，负往后
	 * @param date         日期
	 * @param field        指定字段   Calendar.Year或Calendar.MONTH
	 * @param amount       累加数
	 * @return
	 */
	public static Date getDateByAddCalendar(Date date, int field, int number) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, number);
		return cal.getTime();
	}
	

	/**
	 * 获取两个时间相差多少秒
	 * @param oneDate
	 * @param twoDate
	 * @return
	 */
	public static Long getDateDifferenceBySecond(Date oneDate, Date twoDate) {
		try {
			return Long.valueOf((oneDate.getTime() - twoDate.getTime()) / 1000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取指定时间的指定组成部分
	 * @param time  时间，若为空则为当前时间
	 * @param calendarType  组成部分:Calendar的常量
	 * @return
	 */
	public static Integer getTimeSlice(Date time, Integer calendarType) {
		int result = -1;
		try {
			if (time == null) {
				time = new Date();
			}
			if (calendarType == null) {
				return -1;
			}
			Calendar ca = Calendar.getInstance();
			ca.setTime(time);

			result = ca.get(calendarType);
			
		} catch (Exception e) {
			return -1;
		}
		return result;
	}
	
    /**
     * 判断平年闰年
     * @param year
     * @return true表示闰年，false表示平年
     */
    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 != 0 && year % 4 == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * 将日期格式化成友好的字符串：几分钟前、几小时前、几天前、几月前、几年前、几秒前  包括未来时
     * @param date
     * @return
     */
    public static String formatFriendly(Date date) {
    	if(date == null) {
    		return "";
    	}
		long delta = new Date().getTime() - date.getTime();
//		System.out.println(delta);
		String type = "前";
        String dayName = "昨天";
        if(delta < 0) {
        	type = "后";
        	dayName = "明天";
        }
        delta = Math.abs(delta);
		if (delta < 1L * ONE_MINUTE) {
			long seconds = LongtoSeconds(delta);
			return (seconds <= 0 ? 1 : seconds) + "秒"+type;
		}
		if (delta < 60L * ONE_MINUTE) {
			long minutes = LongtoMinutes(delta);
			return (minutes <= 0 ? 1 : minutes) + "分钟"+type;
		}
		if (delta < 24L * ONE_HOUR) {
			long hours = LongtoHours(delta);
			return (hours <= 0 ? 1 : hours) + "小时"+type;
		}
		if (delta < 48L * ONE_HOUR) {
			return dayName;
		}
		if (delta < 30L * ONE_DAY) {
			long days = LongtoDays(delta);
			return (days <= 0 ? 1 : days) + "天"+type;
		}
		if (delta < 12L * 4L * ONE_WEEK) {
			long months = LongtoMonths(delta);
			return (months <= 0 ? 1 : months) + "个月"+type;
		} else {
			long years = LongtoYears(delta);
			return (years <= 0 ? 1 : years) + "年"+type;
		}
	}
    
    /**
     * 获取指定日期的起止时间 00:00:00和23:59:59
     * @param date    指定日期
     * @param type    起止时间     0-开始时间 1-结束时间
     * 		1、date为空时为当前日期
     *		2、type为空时为一天的开始时间00:00:00
     *		3、两个参数都为空时则代表当前日期的开始时间00:00:00
     * @return 起止时间yyyy-MM-dd 00:00:00或yyyy-MM-dd 23:59:59的Date格式
     */
    public static Date getMaxMinByDay(Date date,Integer type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		try {
			if(date == null) {  date = new Date(); }
			if(type == null) {type = 0;}
			if(type == 1) {
				sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			}
			String dateString = sdf.format(date);
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(dateString);
		}catch(Exception e) {
			return date;
		}
	}
    
    
    /**
     * long型时间转换为秒数，取整舍弃小数
     * @param date
     * @return
     */
    public static long LongtoSeconds(long date) {
		return date / 1000L;
	}
    /**
     * long型时间转换为分数，取整舍弃小数
     * @param date
     * @return
     */
    public static long LongtoMinutes(long date) {
		return LongtoSeconds(date) / 60L;
	}
    /**
     * long型时间转换为小时数，取整舍弃小数
     * @param date
     * @return
     */
    public static long LongtoHours(long date) {
		return LongtoMinutes(date) / 60L;
	}
    /**
     * long型时间转换为天数，取整舍弃小数
     * @param date
     * @return
     */
    public static long LongtoDays(long date) {
		return LongtoHours(date) / 24L;
	}
    /**
     * long型时间转换为月数，取整舍弃小数
     * @param date
     * @return
     */
    public static long LongtoMonths(long date) {
		return LongtoDays(date) / 30L;
	}
    /**
     * long型时间转换为年数，取整舍弃小数
     * @param date
     * @return
     */
    public static long LongtoYears(long date) {
		return LongtoDays(date) / 365L;
	}
    
    /**
     * 获取日期万年历
     * @param date
     * @return 返回SunCalendar类
     */
    public static SunCalendar  getDayInfo(Date date) {
    	String url = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?resource_id=6018&format=json&query="+DateUtil.dateToStrng(date, "yyyy年MM月");
    	String current = DateUtil.dateToStrng(date, "yyyy-MM-dd");
    	String content = null;
		try {
			content = UrlUtil.doGet(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	content = content.replaceAll("list#num#baidu", "listNum");
    	SunCalendar result = new SunCalendar();
    	CalendarBean calendarBean = JsonUtil.jsonToPojo(content, CalendarBean.class);
    	if(calendarBean.getStatus().equals("0")) {
    		List<Data> datas = calendarBean.getData();
    		for(Data data : datas) {
    			List<Almanac> almanacList = data.getAlmanac();
    			for(Almanac almanac : almanacList) {
    				if(DateUtil.dateToStrng(almanac.getDate(), "yyyy-MM-dd").equals(current)) {
    					result.setSuit(almanac.getSuit());
    					result.setAvoid(almanac.getAvoid());
    				}
    			}
    			
    			List<Holiday> holidayList = data.getHoliday();
    			for(Holiday holiday : holidayList) {
    				List<Work> list = holiday.getList();
    				for(Work work : list) {
    					if(DateUtil.dateToStrng(work.getDate(), "yyyy-MM-dd").equals(current)) {
        					result.setIsWork(Integer.valueOf(work.getStatus()));
        				}
    				}
    			}
    			
    			List<Holidaylist> holidaylists = data.getHolidaylist();
    			for(Holidaylist hList : holidaylists) {
    				if(DateUtil.dateToStrng(hList.getStartday(), "yyyy-MM-dd").equals(current)) {
    					result.setHoliday(hList.getName());
    				}
    			}
    		}
    	}
    	result.setIsWork(getDayIsWork(date));
    	return result;
    }
    
    /**
     * 获取日期的工作状态
     * @param date  日期
     * @return 0-工作日 1-节假日调休补班 2-休息日 
     * 异常失败为-1
     */
    public static Integer getDayIsWork(Date date) {
    	try {
			String workStr = UrlUtil.doGet("http://api.goseek.cn/Tools/holiday?date="+DateUtil.dateToStrng(date, "yyyyMMdd"));
			Work work = JsonUtil.jsonToPojo(workStr, Work.class);
			if(work.getCode().equals("10000")) {
				return work.getData();
			}
		} catch (IOException e) {
			return -1;
		}
    	return -1;
    }
    
    public static void main(String[] args) {
    	 SunCalendar dayInfo = getDayInfo(new Date());
    	 System.out.println(dayInfo);
	}
}
