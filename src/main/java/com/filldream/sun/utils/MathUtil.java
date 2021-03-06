package com.filldream.sun.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数学工具类
 * @author RickSun
 *
 */
public class MathUtil {
    
    /**
     *  四舍五入保留位数
     * @param value        待处理的数字
     * @param savePoint    保留位数,0为四舍五入到整数
     * @return  字符串型的Double
     */
    public static String Rounding45(double value,int savePoint) {
    	if(savePoint < 0) {savePoint = 0;}
    	BigDecimal b = new BigDecimal(String.valueOf(value));
    	double f1 = b.setScale(savePoint,RoundingMode.HALF_UP).doubleValue();
    	return f1 + "";
    }
    
    /**
     * 去掉小数位，不做四舍五入保留
     * @param value
     * @return  字符串型的Double
     */
    public static String RoundingByRemoveDecimal(double value) {
    	BigDecimal b = new BigDecimal(String.valueOf(value));
    	double f1 = b.setScale(0,RoundingMode.DOWN).doubleValue();
    	return f1 + "";
    }
}
