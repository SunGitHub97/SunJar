package com.filldream.sun.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.filldream.sun.constants.FinalConstants;
import com.filldream.sun.sunEntity.SunCalendar;
import com.filldream.sun.sunEntity.jsonBean.calendar.Almanac;
import com.filldream.sun.sunEntity.jsonBean.calendar.CalendarBean;
import com.filldream.sun.sunEntity.jsonBean.calendar.Data;
import com.filldream.sun.sunEntity.jsonBean.calendar.Holiday;
import com.filldream.sun.sunEntity.jsonBean.calendar.Holidaylist;
import com.filldream.sun.sunEntity.jsonBean.calendar.Work;


/**
 * 万年历工具类
 * @author RickSun
 *
 */
public class LunarUtil {
    public LunarUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
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
    
    
    //中国日期
    
    /**
     * 获取生肖
     * @param year	年份
     * @return	生肖
     */
    public static String animalsYear(Integer year) {
    	return FinalConstants.ANIMALS[(year - 4) % 12];
    }
    
    /**
     * 获取农历读法
     * @param day	日期
     * @return	农历读法
     */
    public static String getChinaDayString(int day) {
        int n = day % 10 == 0 ? 9 : day % 10 - 1;
        if (day > 30)
            return "";
        if (day == 10)
            return "初十";
        else
            return FinalConstants.CHINESETEN[day / 10] + FinalConstants.CHINESENUMBER[n];
    }
    
    /**
     * 获取天干地支
     * @param num	数字
     * @param isYear	true-为年	false-月份或日数
     * @return 天干地支
     */
    public static String cyclicalm(int num,boolean isYear) {
    	if(isYear) {
    		num = num - 1900 + 36;
    	}
        return (FinalConstants.GAN[num % 10] + FinalConstants.ZHI[num % 12]);
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
    
    //农历算法
    
    /**
     * 获取农历日期
     * @param date	日期
     * @return	农历字符串
     * 	例如：2019-03-03的农历为2019年一月廿七
     */
    public static String getLunar(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	return getLunar(calendar);
    }
    
    /**
     * 获取农历日期
     * @param cal	日期
     * @return	农历字符串
     */
    public static String getLunar(Calendar cal) {
    	SimpleDateFormat chineseDateFormat = new SimpleDateFormat(
                "yyyy年MM月dd日");
    	
        @SuppressWarnings("unused")
        int yearCyl, monCyl, dayCyl;
        int leapMonth = 0;
        Date baseDate = null;
        int year;
        int month;
        int day;
        boolean leap;
        
        try {
            baseDate = chineseDateFormat.parse("1900年1月31日");
        } catch (ParseException e) {
            e.printStackTrace(); // To change body of catch statement use
                                    // Options | File Templates.
        }
        // 求出和1900年1月31日相差的天数
        int offset = (int) ((cal.getTime().getTime() - baseDate.getTime()) / 86400000L);
        dayCyl = offset + 40;
        monCyl = 14;
        // 用offset减去每农历年的天数
        // 计算当天是农历第几天
        // i最终结果是农历的年份
        // offset是当年的第几天
        int iYear, daysOfYear = 0;
        for (iYear = 1900; iYear < 2050 && offset > 0; iYear++) {
            daysOfYear = yearDays(iYear);
            offset -= daysOfYear;
            monCyl += 12;
        }
        if (offset < 0) {
            offset += daysOfYear;
            iYear--;
            monCyl -= 12;
        }
        // 农历年份
        year = iYear;
        yearCyl = iYear - 1864;
        leapMonth = leapMonth(iYear); // 闰哪个月,1-12
        leap = false;
        // 用当年的天数offset,逐个减去每月（农历）的天数，求出当天是本月的第几天
        int iMonth, daysOfMonth = 0;
        for (iMonth = 1; iMonth < 13 && offset > 0; iMonth++) {
            // 闰月
            if (leapMonth > 0 && iMonth == (leapMonth + 1) && !leap) {
                --iMonth;
                leap = true;
                daysOfMonth = leapDays(year);
            } else
                daysOfMonth = monthDays(year, iMonth);
            offset -= daysOfMonth;
            // 解除闰月
            if (leap && iMonth == (leapMonth + 1))
                leap = false;
            if (!leap)
                monCyl++;
        }
        // offset为0时，并且刚才计算的月份是闰月，要校正
        if (offset == 0 && leapMonth > 0 && iMonth == leapMonth + 1) {
            if (leap) {
                leap = false;
            } else {
                leap = true;
                --iMonth;
                --monCyl;
            }
        }
        // offset小于0时，也要校正
        if (offset < 0) {
            offset += daysOfMonth;
            --iMonth;
            --monCyl;
        }
        month = iMonth;
        day = offset + 1;
        
        return year + "年" + (leap ? "闰" : "") + FinalConstants.CHINESENUMBER[month - 1] + "月"
        + getChinaDayString(day);
    }
    
    /**
     * 农历年天数
     * @param year 年份
     * @return	天数
     */
    final private static int yearDays(int year) {
        int i, sum = 348;
        for (i = 0x8000; i > 0x8; i >>= 1) {
            if ((FinalConstants.LUNARINFO[year - 1900] & i) != 0)
                sum += 1;
        }
        return (sum + leapDays(year));
    }
    
    /**
     * 农历闰月天数
     * @param y	年份
     * @return	闰月天数
     */
    private static int leapDays(int y) {
        if (leapMonth(y) != 0) {
            if ((FinalConstants.LUNARINFO[y - 1900] & 0x10000) != 0)
                return 30;
            else
                return 29;
        } else
            return 0;
    }
    
    /**
     * 农历闰几月
     * @param y	年份
     * @return	闰月月份
     * 无返回0
     */
    final private static int leapMonth(int y) {
        return (int) (FinalConstants.LUNARINFO[y - 1900] & 0xf);
    }
  
    /**
     * 农历年份的某月的天数
     * @param y	年份
     * @param m	月份
     * @return	天数
     */
    final private static int monthDays(int y, int m) {
        if ((FinalConstants.LUNARINFO[y - 1900] & (0x10000 >> m)) == 0)
            return 29;
        else
            return 30;
    }
    //end农历算法
    
}
