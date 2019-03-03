package com.filldream.sun.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.filldream.sun.constants.FinalConstants;

/**
 * 校验工具类
 * @author RickSun
 *
 */
public class CheckUtil {
	private static final Logger logger = LoggerFactory.getLogger(CheckUtil.class);
	
	
	/**
	 * 判断是否是56个民族
	 * @param nation  要判断的民族
	 * @param addClan  是否加"族"字
	 * @return true-是 false-否
	 */
	public static boolean checkNation(String nation,Boolean addClan) {
		String[] nations = FinalConstants.NATION.split(",");
		if(addClan == false) {
			for(String simNation : nations) {
				if(simNation.equals(nation)) {
					return true;
				}
			}
		}else {
			for(String simNation : nations) {
				if((simNation+"族").equals(nation)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 验证邮箱格式
	 * @param email  邮箱
	 * @return true-是 false-否
	 */
	public static boolean checkEmail(String email) {
		if(email==null) {return false;}
		String regexMail = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";
		return email.matches(regexMail);
	}
	
	/**
	 * 是否是质数
	 * @param number  数字
	 * @return true-是 false-否
	 */
	public static boolean isPrimeNum(Integer number) {
		boolean isPrime=true;
		int len=number/2;
		for(int i=2;i<len;i++){
			if(number%i==0){
				isPrime=false;
				break;
			}
		}
		return isPrime;
	}
	
	/**
	 * 验证手机号码
	 * @param callnumber  手机号
	 * @return true-是 false-否
	 * <br>注意号码段的更新，新的号码段可能不适用
	 */
	public static boolean checkPhone(String callnumber) {
		if(callnumber==null) {return false;}
		String regexStr = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		return Pattern.matches(regexStr, callnumber);
	}

	
	
	/**
	 * 验证是否是中文汉字
	 * @param chstring  中文字符串
	 * @return true-是 false-否
	 */
	public static boolean checkChineseString(String chstring) {
		if(chstring==null) {return false;}
		String regexStr = "^[\u4e00-\u9fa5]+";
		return Pattern.matches(regexStr, chstring);
	}
	
	
	/**
	 * 验证中国身份证是否合法
	 * @param IDNumber  身份证号码
	 * @return true-是 false-否
	 */
	public static boolean checkChinaIDNumber(String IDNumber) {
	  	if (IDNumber == null || "".equals(IDNumber)) {
            return false;
        }
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression =
        "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
        "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾


        boolean matches = IDNumber.matches(regularExpression);

        //判断第18位校验值
        if (matches) {

            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        logger.info("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() + 
                                "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                        return false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    logger.warn("异常:" + IDNumber);
                    return false;
                }
            }

        }
        return matches;
    }//end checkChinaIDNumber
	
	
	/**
	 * 验证IP地址的合法性
	 * @param ipstr  ip地址
	 * @return true-是 false-否
	 */
	public static boolean checkIP(String ipstr) {
		if(ipstr==null) {return false;}
		Pattern pattern = Pattern.compile( "^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$" );  
	    return pattern.matcher(ipstr).matches();  
	}
	
	
	
	/**
	 * 验证HTTP开头的URL,且验证带参的网址
	 * @param URLstr  网址
	 * @return true-是 false-否
	 */
	public static boolean checkHttpURL(String URLstr) {
		if(URLstr==null) {return false;}
		String regex = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$";
		Pattern pattern = Pattern.compile(regex);
		if (pattern.matcher(URLstr).matches()) {
			return true;
		}else {
			return false;
		}
	}
	

	
	
	
	
	
	//----------以下只做单纯验证，以上是应用验证------------
	
	
	
	
	/**
	 * 验证是否纯数字
	 * @param number  数字字符串，必须将验证对象转换成字符串验证
	 * @return true-是 false-否
	 */
	public static boolean checkArabicNumerals(String number) {
		String regexInteger = "[0-9]+";
		return number.matches(regexInteger);
	}
	
	
	
	/**
	 * 是否整型
	 * @param number  数字字符串，必须将验证对象转换成字符串验证
	 * @return true-是 false-否
	 */
	public static boolean checkInteger(String number) {
		if(number==null) {return false;}
		Matcher mer = Pattern.compile("^[+-]?[0-9]+$").matcher(number);
		return mer.find();
	}
	
	
	/**
	 * 是否小数
	 * @param number  小数字符串，必须将验证对象转换成字符串验证
	 * @return true-是 false-否
	 */
	public static boolean checkFloat(String number) {
		if(number==null) {return false;}
		Matcher mer = Pattern.compile("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$").matcher(number);
		return mer.find();
	}

	
	
	/**
	 * 是否是字母组成的字符串
	 * @param str  字符串
	 * @return true-是 false-否
	 */
	public static boolean checkAlphabet(String str) {
		if(str==null) {return false;}
		return str.matches("[a-zA-Z]+");
	}
	
	/**
	 * 验证数学区间
	 * @param interval  区间字符串，例如：(1,100]
	 * @param data 待验证数字
	 * @author RickSun
	 * @return
	 * 	<p>返回一个Map</p>
	 *  <p><b>map的key：</b></p>
	 *  	<p>code:  0:范围正确  -1：范围错误</p>
	 *  	<p>msg：    错误信息</p>
	 *  	<p>compare:对比结果    0：属于  -1：不属于</p>
	 *  	<p>leftBracket:左括号包含状态 0：不包含  1：包含</p>
	 *  	<p>rightBracket:右括号包含状态 0：不包含  1：包含</p>
	 *  	<p>leftNumber:左数字</p>
	 *  	<p>rightNumber:右数字</p>
	 *  <br>
	 *  <p><b>注意：</b></p>
	 *  	<p>1、当区间范围的数字为正数时请勿输入“+”正号，否则报错</p>
	 *  	<p>2、当需要比较的数字为空时默认为0.0</p>
	 *  <p>创建于2018-08-25</p>
	 */
	public static Map<String,String> checkInterval(String interval,Double data){
		Map<String,String> map = new HashMap<String,String>();
		String leftBracket = new String();
		String rightBrachet = new String();
		Double leftNumber = 0.0;
		Double rightNumber = 0.0;
		Integer len = interval.length();
		if(data == null) {
			data = 0.0;
		}
		
		
		if(len < 5) {
			map.put("code", "-1");
			map.put("msg", "区间长度不够，数据不规范");
			map.put("compare", "-1");
			return map;
		}
		
		//获取左右括号
		leftBracket = interval.substring(0,1);
		rightBrachet = interval.substring(len-1,len);
		
		//判断括号的合法性
		if(leftBracket.equals("[") || leftBracket.equals("(") || leftBracket.equals("（")) {
			if(leftBracket.equals("[")) {
				map.put("leftBracket", "1");
			}else{
				map.put("leftBracket", "0");
			}
		}else {
			map.put("code", "-1");
			map.put("msg", "左区间符号错误或不存在");
			map.put("compare", "-1");
			return map;
		}
		
		if(rightBrachet.equals("]") || rightBrachet.equals(")") || rightBrachet.equals("）")) {
			if(rightBrachet.equals("]")) {
				map.put("rightBrachet", "1");
			}else {
				map.put("rightBrachet", "0");
			}
		}else {
			map.put("code", "-1");
			map.put("msg", "右区间符号错误或不存在");
			map.put("compare", "-1");
			return map;
		}
		//判断括号的合法性 end
		
		
		//去掉左右括号
		String allNumber = interval.substring(1,len-1);
		//获取左右数字
		String[] numbers = allNumber.split(",");
		if(numbers == null || numbers.length<1 || numbers.length>2) {
			map.put("code", "-1");
			map.put("msg", "分隔符不合法或数据不合法");
			map.put("compare", "-1");
			return map;
		}
		
		Pattern mer1 = null;
		try {
			mer1 = Pattern.compile("-[0-9]+(.[0-9]+)?|[0-9]+(.[0-9]+)?");
		}catch(Exception e){
			map.put("code", "-1");
			map.put("msg", "区间不合法");
			map.put("compare", "-1");
			return map;
		}
		
		//左数字合法性
		if(numbers[0].equals("+")) {
			leftNumber = Double.POSITIVE_INFINITY;
		}else if(numbers[0].equals("-")){
			leftNumber = Double.NEGATIVE_INFINITY;
		}else {
			if(mer1.matcher(numbers[0]).matches() == false) {
				map.put("code", "-1");
				map.put("msg", "左区间数字不合法或不存在");
				map.put("compare", "-1");
				return map;
			}else {
				try {
					leftNumber = Double.valueOf(numbers[0]);
				}catch(Exception e) {
					map.put("code", "-1");
					map.put("msg", "区间不合法");
					map.put("compare", "-1");
					return map;
				}
			}
		}
		//右数字合法性
		if(numbers[1].equals("+")) {
			rightNumber = Double.POSITIVE_INFINITY;
		}else if(numbers[1].equals("-")){
			rightNumber = Double.NEGATIVE_INFINITY;
		}else {
			if(mer1.matcher(numbers[1]).matches() == false) {
				map.put("code", "-1");
				map.put("msg", "右区间数字不合法或不存在");
				map.put("compare", "-1");
				return map;
			}else {
				try {
					rightNumber = Double.valueOf(numbers[1]);
				}catch(Exception e) {
					map.put("code", "-1");
					map.put("msg", "区间不合法");
					map.put("compare", "-1");
					return map;
				}
			}
		}
		
		

		if(leftNumber.equals(rightNumber)) {
			map.put("code", "-1");
			map.put("msg", "左区间不能等于右区间的数字");
			map.put("compare", "-1");
			return map;
		}
		//（28，-79]
		if(leftNumber > rightNumber) {
			Double tempNumber = leftNumber;
			leftNumber = rightNumber;
			rightNumber = tempNumber;
			
			String tempBrachet = leftBracket;
			leftBracket = rightBrachet;
			rightBrachet = tempBrachet;
			
			String tempMapBrachet = map.get("leftBracket");
			map.put("leftBracket", map.get("rightBrachet"));
			map.put("rightBrachet", tempMapBrachet);
		}
		

		//end判断左右括号和左右数字的合法性 end

		


		if(map.get("leftBracket") == "0" && map.get("rightBrachet") == "0") { //()
			if(data>leftNumber && data<rightNumber) {
				map.put("compare", "0");
			}else {
				map.put("compare", "-1");
			}
		}else if(map.get("leftBracket") == "0" && map.get("rightBrachet") == "1") {//(]
			if(data>leftNumber && data<=rightNumber) {
				map.put("compare", "0");
			}else {
				map.put("compare", "-1");
			}
		}else if(map.get("leftBracket") == "1" && map.get("rightBrachet") == "0") { //[)
			if(data>=leftNumber && data<rightNumber) {
				map.put("compare", "0");
			}else {
				map.put("compare", "-1");
			}
		}else if(map.get("leftBracket") == "1" && map.get("rightBrachet") == "1") { //[]
			if(data>=leftNumber && data<=rightNumber) {
				map.put("compare", "0");
			}else {
				map.put("compare", "-1");
			}
		}else {
			map.put("code", "-1");
			map.put("compare", "-1");
			map.put("msg", "数据不完整");
			return map;
		}
		
		
		map.put("leftNumber", leftNumber.toString());
		map.put("rightNumber", rightNumber.toString());
		
		if(map.get("compare").equals("0")) {
			map.put("msg", "区间正确，数字符合区间要求");
		}else if(map.get("compare").equals("-1")) {
			map.put("msg", "区间正确，数字不符合区间要求");
		}
		map.put("code", "0");
		
		
		return map;
	}
	
	
	
}
