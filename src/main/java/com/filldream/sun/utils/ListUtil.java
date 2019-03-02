package com.filldream.sun.utils;

import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 集合工具类
 * @author: Rick.sun
 */
public class ListUtil {

	private static final Logger logger = LoggerFactory.getLogger(ListUtil.class);

	
	/**
	 * 去掉基本 list中的重复值，且不保留顺序
	 * @param list 集合
	 */
	public static <E> void removeSame(List<E> list){
		HashSet<E> hSet  =   new  HashSet<E>(list);  
	    list.clear();  
	    list.addAll(hSet); 
	}
	
	/**
	 * 去掉基本 list中的重复值，且保留顺序
	 * @param list 集合
	 */
	public static <E> void removeSameKeepOrder(List<E> list) {
		Set<E> set = new HashSet<E>();
		List<E> newList = new ArrayList<E>();
		for (Iterator<E> iter = list.iterator(); iter.hasNext();) {
			E element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);
	}
	
	/**
	 * 根据属性去掉list中的重复对象
	 * @param list   集合
	 * @param name   字段名
	 * @return
	 * 注：Bean的属性为null时报错
	 */
	public static <T> List<T> removeSameByBeanList(List<T> list,String name){
		if(list.isEmpty()) {
			return Collections.emptyList();
		}
		try {
			Class<?> clazz = list.get(0).getClass();
			Field field = null;
			
				field = clazz.getDeclaredField(name);
				field.setAccessible(true);
			
			int num = list.size();
			
			List<T> result = new ArrayList<T>(num);
			result.addAll(list);
			
			for (int i = 0; i < num - 1; i++) {
				for (int j = num - 1; j > i; j--) {
					Object o1  = field.get(list.get(j));
					Object o2  = field.get(list.get(i));
					if( o1.equals(o2)) {
						result.remove(list.get(i));
					}
				}
			}
			return result;
		}catch(NoSuchFieldException e1){
			logger.debug("找不到去重的属性 "+e1);
		}catch (IllegalAccessException e2) {
			logger.debug("找不到该属性 " + e2);
		}catch(NullPointerException e3) {
			logger.debug("该Bean下属性为Null " + e3);
		}
		return list;
	}
	
	
	/**
	 * 获取list中的某个属性的集合
	 * @param list 集合
	 * @param paramName 字段名
	 * @return
	 */
	public static List<?> getParamList(List<?> list,String paramName){
		List<Object> resultList = new ArrayList<Object>();
		if(list.isEmpty()) {
			return Collections.emptyList();
		}
		try {
			Field field = list.get(0).getClass().getDeclaredField(paramName);
			field.setAccessible(true);  
			for(int i=0;i<list.size();i++) {
				Object obj = field.get(list.get(i));
				resultList.add(obj);
			}
		} catch (Exception e) {
			logger.debug("属性未找到，或属性作用域问题");
			return Collections.emptyList();
		}
		return resultList;
	}
	
	
	
	/**
	 * 基本类型list排序
	 * @param list 集合
	 * @param isAsc 是否升序 true升序 false降序
	 * @return
	 */
	public static <T> List<T> sortByBase(List<T> list,final Boolean isAsc){
		Collections.sort(list, new Comparator<T>() {
            public int compare(T a, T b) {
                
            	int ret;
    			String str1 = a.toString();
    			String str2 = b.toString();
    			if (a instanceof Number && b instanceof Number) {
    				int maxlen = Math.max(str1.length(), str2.length());
    				str1 = ListUtil.addZero2Str((Number) a, maxlen);
    				str2 = ListUtil.addZero2Str((Number) b, maxlen);
    			} else if (a instanceof Date && b instanceof Date) {
    				long time1 = ((Date) a).getTime();
    				long time2 = ((Date) b).getTime();
    				int maxlen = Long.toString(Math.max(time1, time2)).length();
    				str1 = ListUtil.addZero2Str(time1, maxlen);
    				str2 = ListUtil.addZero2Str(time2, maxlen);
    			}
    			if (isAsc) {
    				ret = str1.compareTo(str2);
    			} else {
    				ret = str2.compareTo(str1);
    			}
                return ret;
            }
        });
		return list;
	}
	
	
	
	/**
	 * 对list进行排序，list类型为实体对象
	 * 
	 * @param list 源集合
	 * @param field 对象属性
	 * @param sort 排序方式,"desc false"或"asc true"
	 * @return
	 */
	public static <T> List<T> sortByBean(List<T> list, final String sortField, final Boolean isAsc) throws Exception{
		Collections.sort(list, new Comparator<T>() {
            public int compare(T a, T b) {
                //默认flag值1，默认是升序，如果返回是为-flag则是降序
                int flag= compareObject(sortField, isAsc, a, b);
                if(flag<0){
                    return -1;
                }
                if(flag==0){
                    return 0;
                }
                return 1;
            }
        });
		return list;
	}
	
	/**
	 * list多个属性按照一个规则排序
	 * @param list       源集合
	 * @param fieldName  多个属性
	 * @param isAsc 是否升序
	 */
	public static <E> void sort(List<E> list, final boolean isAsc,  final String... fieldName) {
		Collections.sort(list, new Comparator<E>() {
			public int compare(E a, E b) {
				int ret = 0;
				try {
					for (int i = 0; i < fieldName.length; i++) {
						ret = ListUtil.compareObject(fieldName[i], isAsc, a, b);
						if (0 != ret) {
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return ret;
			}
		});
	}
	

	/**
	 * 给list的每个属性都指定是升序还是降序
	 * 
	 * @param list
	 * @param sortnameArr
	 *            参数数组
	 * @param typeArr
	 *            每个属性对应的升降序数组， true升序，false降序
	 */

	public static <E> void sortByMoreParam(List<E> list, final String[] filedNameArr, final Boolean[] sortArr) {
		if (filedNameArr.length != sortArr.length) {
			throw new RuntimeException("属性数组元素个数和升降序数组元素个数不相等");
		}
		Collections.sort(list, new Comparator<E>() {
			public int compare(E a, E b) {
				int ret = 0;
				try {
					for (int i = 0; i < filedNameArr.length; i++) {
						ret = ListUtil.compareObject(filedNameArr[i], sortArr[i], a, b);
						if (0 != ret) {
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return ret;
			}
		});
	}

	/**
	 * 分页list
	 * @param list
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static <E> List<E> limitList (List<E> list, Integer pageNo, Integer pageSize){
        Integer total = list.size();
        if(total < 1){
            list = Collections.emptyList();
        }
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = total;
        }else if(pageSize < 1){
            pageSize = total;
        }

        if(total < 1){
            total = 1;
        }

        Integer startNo = 0;
        Integer endNo = total;
        startNo = (pageNo-1)*pageSize;
        endNo = pageNo * pageSize;

        if(startNo > total){
            list = Collections.emptyList();
        }
        if(endNo > total){
            endNo = total;
        }
        if(!list.isEmpty()){
        	return  list.subList(startNo,endNo);
        }else{
        	return Collections.emptyList();
        }
    }

	/**
	 * 分页List
	 * @param list
	 * @param pageNo
	 * @param pageSize
	 * @return 返回Map
	 */
	public static <E> Map<String, Object> limitListResult (List<E> list, Integer pageNo, Integer pageSize){
        Map<String,Object> map = new ConcurrentHashMap<String, Object>();
        map.put("pageSize",pageSize);
	    map.put("pageNo",pageNo);
        
        map.put("rows",Collections.emptyList());
        map.put("total",0);
        map.put("pages",0);
	    
        int total = list.size();
        list = ListUtil.limitList(list, pageNo, pageSize);
        
        
        if(total > 0){
            int pages = 0;
            if(total%pageSize == 0){
                pages = total/pageSize;
            }else{
                pages = (total/pageSize)+1;
            }
            map.put("pages",pages);
            map.put("rows", list);
            map.put("total", total);
        }
        return map;
    }
	
	/**
	 * 将字符串转换成list
	 * @param commaArrStr  逗号数组
	 * @return List<String>
	 * 
	 * 例如：
	 *   将"1,2,3,4" 转换为list
	 */
	public static List<String> commaArrToList (String commaArrStr){
		List<String> list = new ArrayList<String>(); 
		String[] arr = commaArrStr.split(",");
		if(arr.length < 1) {
			return Collections.emptyList();
		}
		for(String s : arr) {
			if(!SunCommon.isBlank(s)) {
				list.add(s);
			}
		}
		return  list;
	}

	
	
	//--------------辅助方法-----------2019-01-26
		/**
		 * 对2个对象按照指定属性名称进行排序
		 * 
		 * @param sortname
		 *            属性名称
		 * @param isAsc
		 *            true升序，false降序
		 * @param a
		 * @param b
		 * @return
		 * @throws Exception
		 */
		private static <E> int compareObject(final String sortname, final boolean isAsc, E a, E b) {
			try {
			int ret;
			Object value1 = ListUtil.forceGetFieldValue(a, sortname);
			Object value2 = ListUtil.forceGetFieldValue(b, sortname);
			String str1 = value1.toString();
			String str2 = value2.toString();
			if (value1 instanceof Number && value2 instanceof Number) {
				int maxlen = Math.max(str1.length(), str2.length());
				str1 = ListUtil.addZero2Str((Number) value1, maxlen);
				str2 = ListUtil.addZero2Str((Number) value2, maxlen);
			} else if (value1 instanceof Date && value2 instanceof Date) {
				long time1 = ((Date) value1).getTime();
				long time2 = ((Date) value2).getTime();
				int maxlen = Long.toString(Math.max(time1, time2)).length();
				str1 = ListUtil.addZero2Str(time1, maxlen);
				str2 = ListUtil.addZero2Str(time2, maxlen);
			}
			if (isAsc) {
				ret = str1.compareTo(str2);
			} else {
				ret = str2.compareTo(str1);
			}
			
			return ret;
			}catch (Exception e) {
				return 0;
			}
		}
		
		/**
		 * 给数字对象按照指定长度在左侧补0.
		 * 
		 * 使用案例: addZero2Str(11,4) 返回 "0011", addZero2Str(-18,6)返回 "-000018"
		 * 
		 * @param numObj
		 *            数字对象
		 * @param length
		 *            指定的长度
		 * @return
		 */
		private static String addZero2Str(Number numObj, int length) {
			NumberFormat nf = NumberFormat.getInstance();
			// 设置是否使用分组
			nf.setGroupingUsed(false);
			// 设置最大整数位数
			nf.setMaximumIntegerDigits(length);
			// 设置最小整数位数
			nf.setMinimumIntegerDigits(length);
			return nf.format(numObj);
		}

		/**
		 * 获取指定对象的指定属性值（去除private,protected的限制）
		 * 
		 * @param obj
		 *            属性名称所在的对象
		 * @param fieldName
		 *            属性名称
		 * @return
		 * @throws Exception
		 */
		private static Object forceGetFieldValue(Object obj, String fieldName) throws Exception {
			Field field = obj.getClass().getDeclaredField(fieldName);
			Object object = null;
			boolean accessible = field.isAccessible();
			if (!accessible) {
				// 如果是private,protected修饰的属性，需要修改为可以访问的
				field.setAccessible(true);
				object = field.get(obj);
				// 还原private,protected属性的访问性质
				field.setAccessible(accessible);
				return object;
			}
			object = field.get(obj);
			return object;
		}
		
		//--------------辅助方法-----------End 2019-01-26
	
}
