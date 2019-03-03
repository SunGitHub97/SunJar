package com.filldream.sun.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.filldream.sun.constants.FinalConstants;
import com.filldream.sun.sunEntity.SunCalendar;
import com.filldream.sun.sunEntity.jsonBean.calendar.Almanac;
import com.filldream.sun.sunEntity.jsonBean.calendar.CalendarBean;
import com.filldream.sun.sunEntity.jsonBean.calendar.Data;
import com.filldream.sun.sunEntity.jsonBean.calendar.Holiday;
import com.filldream.sun.sunEntity.jsonBean.calendar.Holidaylist;
import com.filldream.sun.sunEntity.jsonBean.calendar.Holidays;
import com.filldream.sun.sunEntity.jsonBean.calendar.Work;

import me.fishlord.common.utils.JacksonUtils;


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
     * @return 
     * 正常工作日为 0, 法定节假日为 1, 节假日调休补班为 2，休息日为 3 
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
     * @throws ParseException
     */
    public static SunCalendar  getDayInfo(Date date) throws ParseException{
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
    		}
    	}
    	result.setIsWork(getDayIsWork(date));
    	result.setHoliday(getHoliday(date));
    	result.setLunar(getLunar(date));
    	return result;
    }
    
    /**
     * 获取24节气
     * @param year	年份
     * @param month 月份
     * @param date 日期
     * @return	节气名称
     */
    public static String getTermName(int year, int month, int date) {
		Map<String, String> map = getYearTermMap(year);
		if (map == null || map.isEmpty()) {
			return null;
		}
		return map.get(getTermKey(month, date));
	}
    
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
	 * 获取日期的节假日
	 * @param date
	 * @return
	 */
	public static String getHoliday(Date date) throws ParseException{
		Integer year = DateUtil.getTimeSlice(date, Calendar.YEAR);
		Integer month = DateUtil.getTimeSlice(date, Calendar.MONTH)+1;
		Integer day = DateUtil.getTimeSlice(date, Calendar.DAY_OF_MONTH);
		
		String lundar = getLunar(date);
		String cMonth = lundar.substring(lundar.length()-4,lundar.length()-2);
		String cDay = lundar.substring(lundar.length()-2,lundar.length());
		
		URL url = ChAddressUtil.class.getResource("/file/holiday.txt");
		
		String jsonText = FileIOUtil.FileToString(new File(url.getFile()));
		
		List<Holidays> list =JsonUtil.jsonToList(jsonText, Holidays.class);
		String result = "";
		
		for(Holidays holiday : list) {
			String wheres = holiday.getWheres();
			String m = holiday.getMonth();
			String d = holiday.getDay();
			
			
			
			
			if(wheres.equals("final")) {
				if(month.toString().equals(m) && day.toString().equals(d)) {
					result += holiday.getName()+"+";
				}
				if(cMonth.equals(m) && cDay.equals(d) ) {
					result += holiday.getName()+"+";
				}
			}else {
				if(wheres.indexOf("afterJQ") > -1) {
					String value = wheres.split("-")[1].split(":")[0];
					Integer addNum = Integer.valueOf(wheres.split(":")[1]);
					Map<String, String> map = getYearTermMap(year);
					
					List<String> keyList = new ArrayList<String>();
				    for(String key: map.keySet()){
				        if(map.get(key).equals(value)){
				            keyList.add(key);
				        }
				    }
					
				    String holidayDate = year+keyList.get(0);//0808春分
				    Date hDate = DateUtil.getDateByAddDay(DateUtil.stringToDate(holidayDate, "yyyyMMdd"), addNum);
				    if(DateUtil.CompareDateSize(hDate, date) == 0) {
				    	result += holiday.getName() + "+";
				    }
				    
				}else if(wheres.indexOf(":") == 1) {
					String[] values = wheres.split(":");
					if(values[0].equals("0") && month.toString().equals(m)) {
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(date);
						int weekSum = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
						
						List<String> weekList = DateUtil.dayInWeekInMonth(date);
						boolean isLast = false;
						if(weekList.get(0).equals(String.valueOf(weekSum)) && weekList.get(1).equals(values[1])  && isLast==false) {
							result += holiday.getName() + "+";
							isLast = true;
						}
						weekSum-=1;
						if(weekList.get(0).equals(String.valueOf(weekSum)) && weekList.get(1).equals(values[1])  && isLast==false) {
							result += holiday.getName() + "+";
						}
					}else if(month.toString().equals(m)){
						List<String> weekList = DateUtil.dayInWeekInMonth(date);
						if(weekList.get(0).equals(values[0]) && weekList.get(1).equals(values[1])  ) {
							result += holiday.getName() + "+";
						}
					}
					
				}else if(wheres.equals("lastday")) {
					if(month.toString().equals(m)){
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(date);
						if(calendar.getActualMaximum(Calendar.DAY_OF_MONTH) == day) {
							result += holiday.getName() + "+";
						}
					}
				}else if(wheres.equals("lastyear")) {
					String lastDay = getChinaDayString(monthDays(year-1, 12));
					if(cMonth.toString().equals(m)  && lastDay.equals(cDay) ){
						result += holiday.getName() + "+";
					}
				}
			}
		}
		if(result.length() < 1) {
			return result;
		}
		return result.substring(0,result.length()-1);
	}
	
	
	//------以下是私有辅助方法-------
	
    
    
    //农历算法
    /**
     * 获取农历日期
     * @param cal	日期
     * @return	农历字符串
     */
    private static String getLunar(Calendar cal) {
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
        
        return year + "年" + (leap ? "闰" : "") + getChinaMonth(month)
        + getChinaDayString(day);
    }
    
    /**
     * 获取农历月读法
     * @param month
     * @return
     */
    private static String getChinaMonth(int month) {
    	String resultMonth = FinalConstants.CHINESENUMBER[month - 1];
        if(resultMonth.equals("一")) {
        	resultMonth = "正";
        }else if(resultMonth.equals("十二")) {
        	resultMonth = "腊";
        }
        return resultMonth+"月";
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
    
    
    //------------24节气算法-------------
    
    //节气D值
  	private static final double D = 0.2422;
  	//20世纪气节C值
  	private static final double[] C_20 = { 6.11, 20.84, 4.6295, 19.4599, 6.3826, 21.4155, 5.59, 20.888, 6.318, 21.86,
  			6.5, 22.2, 7.928, 23.65, 8.35, 23.95, 8.44, 23.822, 9.098, 24.218, 8.218, 23.08, 7.9, 22.6 };
  	//21世纪气节C值
  	private static final double[] C_21 = { 5.4055, 20.12, 3.87, 18.73, 5.63, 20.646, 4.81, 20.1, 5.52, 21.04, 5.678,
  			21.37, 7.108, 22.83, 7.5, 23.13, 7.646, 23.042, 8.318, 23.438, 7.438, 22.36, 7.18, 21.94 };

  	private static Map<Integer, Map<String, String>> termMap = new HashMap<Integer, Map<String, String>>();

	private static Map<String, String> getYearTermMap(int year) {
		double[] c = null;
		if (year > 1900 && year <= 2000) {
			c = C_20;
		} else if (year > 2000 && year <= 2100) {
			c = C_21;
		} else {
			throw new RuntimeException("不支持的年份:" + year + ",目前只支持1901年到2100年的时间范围");
		}
		// 从节气表中取
		Map<String, String> map = termMap.get(year);
		if (map != null) {
			return map;
		}
		// 节气表中无对应的节气数据，则计算生成
		synchronized (FinalConstants.TERM) {
			map = termMap.get(year);
			if (map == null) {
				int y = year % 100;
				map = new HashMap<String, String>();
				for (int k = 0; k < 24; k++) {
					// 计算节气日期，计算公式：[Y*D+C]-L
					int date = 0;
					if (k < 2 || k > 22) {
						date = (int) (y * D + c[k]) - (int) ((y - 1) / 4);
					} else {
						date = (int) (y * D + c[k]) - (int) (y / 4);
					}
					// 记录计算结果
					map.put(getTermKey(k / 2 + 1, date), FinalConstants.TERM[k]);
				}
				// 计算结果添加到节气表
				termMap.put(year, map);
			}
		}
		return map;
	}

	private static String getTermKey(int month, int date) {
		String key = String.valueOf(month);
		if (month < 10) {
			key = "0" + key;
		}
		if (date < 10) {
			key += "0";
		}
		key += date;
		return key;
	}
  	
    //end 24节气算法
    
}
