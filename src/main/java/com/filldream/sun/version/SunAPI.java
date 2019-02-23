package com.filldream.sun.version;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import com.filldream.sun.sunEntity.AliSms;

/**
 * @Description:主要功能: SunJar API
 * @Prject: SunJar
 * @Package: com.filldream.sun.version
 * @Author: Rick.sun
 * @Date: 2018年11月17日
 * @EditDate: 2018年11月17日
 * @Copyright: Rick.sun
 * @Company:FillDream
 * @Version: 0.5.3.39
 * @Remark:
 *    1、SunAPI仅发布常用的封装类，并不是全部的API
 *    2、SunAPI不仅仅发布API还会有SunJar的修改日志在其中
 *    3、若API太长，可以尝试用编辑器自带的搜索功能进行模糊查询
 *    4、SunJar百度网盘：
 *			连接：https://pan.baidu.com/s/15NLYKh5AGFSGStZoy2-TLA 
 *			密码：vbjf
 * 
 */
public class SunAPI {

	//--------------(一)、com.filldream.sun.utils.DateUtil.java--------------
	
	
	
	/**
	 * 比较两个时间的大小      时间越近值越大
	 * @param date1
	 * @param date2
	 * @return
	 * 
	 * public static int CompareDateSize(Date date1, Date date2) {}
	 */
	
	
	/**
	 * 比较两个时间的大小      时间越近值越大
	 * @param date1
	 * @param date2
	 * @param dateFormat
	 * @return
	 * 
	 * public static int CompareDateSize(String date1, String date2, String dateFormat) {}
	 */
	
	
	/**
	 * 获取指定时间的累加时间，如指定日期的第五天
	 * @param date      指定时间
	 * @param number    天数，可以负数
	 * @return
	 * 
	 * public static Date getDateByAddDay(Date date, Integer number) {}
	 */
	
	
	
	/**
	 * 获取指定时间的累加分钟时间，正往前，负往后
	 * @param date
	 * @param addMinutes 
	 * @return
	 * 
	 * public static Date getDateByAddMinute(Date date, int addMinutes) {}
	 */
	
	
	
	/**
	 * 获取指定日期的指定字段的累加，正往前，负往后
	 * @param date         日期
	 * @param field        指定字段   Calendar.Year或Calendar.MONTH
	 * @param amount       累加数
	 * @return
	 * 
	 * public static Date getDateByCalendar(Date date, int field, int amount) {}
	 */
	
	
	
	/**
	 * 获取两个时间相差多少秒
	 * @param oneDate
	 * @param twoDate
	 * @return
	 * 
	 * public static Long getDateDifferenceBySecond(Date oneDate, Date twoDate) {}
	 */
	
	
	
	/**
	 * 获取指定时间的指定组成部分
	 * @param time  时间，若为空则为当前时间
	 * @param calendarType  组成部分:Calendar的常量
	 * @return
	 * 
	 * public static Integer getTimeSlice(Date time, Integer calendarType) {}
	 */
	
	
	
	 /**
     * 判断平年闰年
     * @param year
     * @return true表示闰年，false表示平年
     * 
     * public boolean isLeapYear(int year) {}
     */
    
	
	
	/**
     * 将日期格式化成友好的字符串：几分钟前、几小时前、几天前、几月前、几年前、几秒前  包括未来时
     * @param date
     * @return
     * 
     * public static String formatFriendly(Date date) {}
     */
    
	
	
	/**
     * 获取指定日期的起止时间 00:00:00和23:59:59
     * @param date    指定日期
     * @param type    起止时间     0-开始时间 1-结束时间
     * 		1、date为空时为当前日期
     *		2、type为空时为一天的开始时间00:00:00
     *		3、两个参数都为空时则代表当前日期的开始时间00:00:00
     * @return 起止时间yyyy-MM-dd 00:00:00或yyyy-MM-dd 23:59:59的Date格式
     * 
     * public static Date getMaxMinByDay(Date date,Integer type) {}
     */
    
	
	
	
	
	
	
	
	
	
	
	//--------------(二)、com.filldream.sun.utils.MapUtil.java--------------
	
	/**
     * 计算地球上任意两点(经纬度)距离
     *
     * @param long1 第一点经度
     * @param lat1  第一点纬度
     * @param long2 第二点经度
     * @param lat2  第二点纬度
     * @return 返回距离 单位：米
     * 
     * public final static double distance(double long1, double lat1, double long2, double lat2) {}
     */
    
	
	
	
	
	//--------------(三)、com.filldream.sun.utils.FileIOUtil.java--------------
	
	/**
	 * 将文件读取为字符串
	 * @param file
	 * @return
	 * 
	 * public static String FileToString(File file) {}
	 */
	
	
	
	/**
	 * 根据文件名称来判断文件的后缀类型
	 * @param fileName 文件名
	 * @return
	 * 
	 * public static String getSuffixByFileName(String fileName) {}
	 */
	
	
	
	/**
	 * 删除文件或文件夹
	 * @param fileName
	 * @return
	 * 
	 * public static boolean deleteFiles(String fileName) {}
	 */
	
	
	
	
	/**
	 * 删除单个文件
	 * @param fileName
	 * @return
	 * 
	 * public static boolean deleteFile(String fileName) {}
	 */
	
	
	
	/**
	 * 删除目录以及目录下所有文件
	 * @param dir
	 * @return
	 * 
	 * public static boolean deleteDirectory(String dir) {}
	 */
	
	
	 /**
	  * 获取文件的名字
	  * @param fileURI   文件地址
	  * @return
	  * @Example:getFileNameNoSuffix("d:\\filldream\\sunjar,jar")  == sunjar
	  * 
	  * public static String getFileNameNoSuffix( String fileURI) {
	 */
		
	
	
	/**
	 * 获取文件大小
	 * @param path
	 * @return    错误返回0
	 * 
	 * public static Object getFileSize(String path, String sizeName) {}
	 */
	
	
	/**
	 * 创建空文件
	 * @param fileURI     文件路径，待文件名
	 * @param rewrite     是否覆盖原文件
	 * @return
	 * 
	 * public static Boolean createEmptyFile( String fileURI,Boolean rewrite) {}
	 */
	
	
	
	/**
	 * 添加文件
	 * @param bfile
	 * @param fileURI
	 * 
	 * public static void addFile(byte[] bfile, String fileURI) {}
	 */
    
	
	
	 /**
     * 创建多重文件夹
     * @param path
     * @return
     * 
     * public static Boolean newDirectory (String path) {}
     */
    
	
	
	/**
     * 重命名文件、文件夹
     * @param url         文件地址
     * @param new_name    新名称
     * @return
     * 
     * public static boolean renameFiles(String url, String new_name){}
     */
    
	
	
	/**
     * 下载网络资源
     * @param urlStr           网络URL
     * @param fileName         自定义文件名称
     * @param savePath         存储位置，文件夹
     * @throws IOException
     * 
     * public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{}
     */
    
	
	
	/**
     * 获取用户默认系统地址
     * @return  返回String地址
     * 
     * public static String getUserDirPath() {}
     */
    
	
	 /**
     * 获取用户默认系统文件夹地址
     * @return  返回File类
     * 
     * public static File getUserDirFile() {}
     */
    
	
	
	 /**
     * 将输入流转换为byte数组
     * @param inputStream
     * @return
     * @throws IOException
     * 
     * public static  byte[] readInputStreamToBytes(InputStream inputStream) throws IOException {}
     */
    
	
	
	
	//--------------(四)、com.filldream.sun.utils.SmsUtil--------------
	
	/**
	 * 使用单例配置发送短信
	 * @param aliSms         配置类
	 * @param templateCode   短信模板
	 * @param messageMap     短信参数
	 * @param mobile         手机号
	 * @return
	 * 
		public static  Map<String, Object> sendNormalMsgByAlisms(
			AliSms aliSms,
			String templateCode,
			Map<String, String> messageMap, 
			String mobile
			) {}
		*/
	
	
	/**
	 * 详细配置发送短信
	 * @param keyId           阿里keyId
	 * @param keySecret       阿里keySecret
	 * @param signName        阿里签没signName
	 * @param templateCode    短信模板
	 * @param messageMap      短信参数
	 * @param mobile          手机号
	 * @return
	 * 
	 * public static  Map<String, Object> sendNormalMsg(
			String keyId,String keySecret,String signName,String templateCode,
			Map<String, String> messageMap, String mobile) {
	 */
	
		
	
	
	
	
	
	//--------------SunJar错误报告和更新日志--------------
	
	/**
	 
	 2018-11-17：
	 1、SunJar部分功能需要依赖第三方Jar包，若您是JavaSE的用户请在给定的百度网盘链接上下载相关方法的依赖Jar包，或复制SunJar的pom文件
	 2、若您是安卓开发者部分功能将无法兼容
	 3、SunJar已将Log4j转换为slf4j
	 
	 2018-11-30：
	 1、添加压缩文件夹功能
	 2、添加发送短信功能(文本短信)
	 
	 
	 
	 
	 
	 */
	
}
