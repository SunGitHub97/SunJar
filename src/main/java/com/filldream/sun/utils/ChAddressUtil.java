package com.filldream.sun.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filldream.sun.sunEntity.Area;

public class ChAddressUtil {
	/**
	 * 根据省市区获取下级所有行政单位
	 * @param level  1-省 2-市 3-区
	 * @param cityName 省市区名字
	 * @return
	 */
	public static Area getLowerCity(Integer level, String cityName) {
		// 创建文件
		
//		String fileName = ChAddressUtil.class.getClassLoader().getResource("/file/area2.txt").getPath();//获取文件路径
//		File file = new File(fileName);

		// 读取json文件，格式为txt
//		String jsonText = FileIOUtil.FileToString(file);
		String jsonText = "[\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"110000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"北京\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"010\",\r\n" + 
				"        \"adcode\": \"110100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"北京\",\r\n" + 
				"        \"fullname\": \"北京市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110101\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"朝阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石景山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海淀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"门头沟区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"房山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"顺义区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大兴区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110116\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"怀柔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110117\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平谷区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110118\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"密云区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"110119\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"延庆区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"120000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"天津\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"022\",\r\n" + 
				"        \"adcode\": \"120100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"天津\",\r\n" + 
				"        \"fullname\": \"天津市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120101\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南开区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120110\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东丽区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西青区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"津南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北辰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武清区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝坻区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120116\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滨海新区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120117\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120118\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"静海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"120119\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蓟州区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"130000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"河北\",\r\n" + 
				"    \"fullname\": \"河北省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0311\",\r\n" + 
				"        \"adcode\": \"130100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"石家庄\",\r\n" + 
				"        \"fullname\": \"石家庄市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桥西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"井陉矿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"裕华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"藁城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130110\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹿泉区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"栾城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"井陉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"正定县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"行唐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵寿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高邑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"深泽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赞皇县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130130\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"无极县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130131\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130132\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"元氏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130133\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"辛集市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130183\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"晋州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130184\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新乐市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0315\",\r\n" + 
				"        \"adcode\": \"130200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"唐山\",\r\n" + 
				"        \"fullname\": \"唐山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"路南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"路北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古冶区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130207\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130208\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰润区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130209\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曹妃甸区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滦南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐亭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"迁西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130229\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"遵化市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130283\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"迁安市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0335\",\r\n" + 
				"        \"adcode\": \"130300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"秦皇岛\",\r\n" + 
				"        \"fullname\": \"秦皇岛市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海港区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"山海关区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北戴河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青龙满族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌黎县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130306\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"抚宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卢龙县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0310\",\r\n" + 
				"        \"adcode\": \"130400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"邯郸\",\r\n" + 
				"        \"fullname\": \"邯郸市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邯山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丛台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"复兴区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130406\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"峰峰矿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临漳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"成安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大名县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"磁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肥乡区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130429\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永年区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130430\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邱县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130431\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鸡泽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130432\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130433\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"馆陶县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130434\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"魏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130435\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曲周县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武安市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0319\",\r\n" + 
				"        \"adcode\": \"130500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"邢台\",\r\n" + 
				"        \"fullname\": \"邢台市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桥东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桥西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邢台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"内丘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柏乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆尧县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"任县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁晋县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130529\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巨鹿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130530\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130531\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广宗县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130532\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130533\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"威县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130534\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130535\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南宫市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130582\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙河市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0312\",\r\n" + 
				"        \"adcode\": \"130600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"保定\",\r\n" + 
				"        \"fullname\": \"保定市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"竞秀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130606\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莲池区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130607\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"满城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130608\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清苑区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涞水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阜平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130609\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"徐水区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定兴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"唐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130628\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130629\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"容城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130630\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涞源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130631\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"望都县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130632\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安新县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130633\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"易县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130634\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曲阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130635\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蠡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130636\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"顺平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130637\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博野县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130638\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雄县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涿州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130682\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130683\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安国市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130684\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高碑店市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0313\",\r\n" + 
				"        \"adcode\": \"130700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"张家口\",\r\n" + 
				"        \"fullname\": \"张家口市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桥东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桥西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130705\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宣化区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130706\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"下花园区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"张北县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"康保县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沽源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尚义县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蔚县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳原县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130728\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"怀安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130708\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万全区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130730\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"怀来县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130731\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涿鹿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130732\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赤城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130709\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崇礼区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0314\",\r\n" + 
				"        \"adcode\": \"130800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"承德\",\r\n" + 
				"        \"fullname\": \"承德市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双滦区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130804\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹰手营子矿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"承德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴隆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平泉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滦平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰宁满族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宽城满族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"围场满族蒙古族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0317\",\r\n" + 
				"        \"adcode\": \"130900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"沧州\",\r\n" + 
				"        \"fullname\": \"沧州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"运河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沧县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东光县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海兴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肃宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南皮县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130928\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吴桥县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130929\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"献县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130930\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"孟村回族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泊头市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130982\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"任丘市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130983\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄骅市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"130984\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河间市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0316\",\r\n" + 
				"        \"adcode\": \"131000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"廊坊\",\r\n" + 
				"        \"fullname\": \"廊坊市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安次区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"固安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永清县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"香河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"文安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131028\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大厂回族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霸州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131082\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三河市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0318\",\r\n" + 
				"        \"adcode\": \"131100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"衡水\",\r\n" + 
				"        \"fullname\": \"衡水市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桃城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"枣强县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武邑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武强县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"饶阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"故城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"景县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阜城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"冀州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"131182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"深州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"140000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"山西\",\r\n" + 
				"    \"fullname\": \"山西省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0351\",\r\n" + 
				"        \"adcode\": \"140100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"太原\",\r\n" + 
				"        \"fullname\": \"太原市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"小店区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"迎泽区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杏花岭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尖草坪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万柏林区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140110\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"晋源区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清徐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳曲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"娄烦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古交市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0352\",\r\n" + 
				"        \"adcode\": \"140200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"大同\",\r\n" + 
				"        \"fullname\": \"大同市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"矿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140211\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南郊区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140212\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新荣区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳高县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天镇县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广灵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵丘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浑源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"左云县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大同县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0353\",\r\n" + 
				"        \"adcode\": \"140300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阳泉\",\r\n" + 
				"        \"fullname\": \"阳泉市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"矿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郊区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平定县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盂县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0355\",\r\n" + 
				"        \"adcode\": \"140400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"长治\",\r\n" + 
				"        \"fullname\": \"长治市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140411\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郊区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"襄垣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"屯留县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平顺县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黎城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"壶关县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长子县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140429\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140430\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140431\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沁源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潞城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0356\",\r\n" + 
				"        \"adcode\": \"140500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"晋城\",\r\n" + 
				"        \"fullname\": \"晋城市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沁水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陵川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泽州县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高平市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0349\",\r\n" + 
				"        \"adcode\": \"140600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"朔州\",\r\n" + 
				"        \"fullname\": \"朔州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"朔城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平鲁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"山阴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"应县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"右玉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"怀仁县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0354\",\r\n" + 
				"        \"adcode\": \"140700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"晋中\",\r\n" + 
				"        \"fullname\": \"晋中市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"榆次区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"榆社县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"左权县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和顺县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昔阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"寿阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太谷县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"祁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140728\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平遥县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140729\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵石县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"介休市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0359\",\r\n" + 
				"        \"adcode\": \"140800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"运城\",\r\n" + 
				"        \"fullname\": \"运城市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临猗县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万荣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"闻喜县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"稷山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新绛县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绛县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"垣曲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"夏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140829\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平陆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140830\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芮城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永济市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140882\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河津市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0350\",\r\n" + 
				"        \"adcode\": \"140900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"忻州\",\r\n" + 
				"        \"fullname\": \"忻州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"忻府区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定襄县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"代县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"繁峙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁武县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"静乐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"神池县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140928\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五寨县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140929\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岢岚县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140930\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河曲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140931\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"保德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140932\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"偏关县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"140981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"原平市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0357\",\r\n" + 
				"        \"adcode\": \"141000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"临汾\",\r\n" + 
				"        \"fullname\": \"临汾市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尧都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曲沃县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"翼城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"襄汾县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洪洞县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安泽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141027\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浮山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141028\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141029\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乡宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141030\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141031\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141032\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141033\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蒲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141034\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汾西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"侯马市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141082\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霍州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0358\",\r\n" + 
				"        \"adcode\": \"141100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"吕梁\",\r\n" + 
				"        \"fullname\": \"吕梁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"离石区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"文水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"交城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柳林县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石楼县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岚县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"方山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141130\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"交口县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"孝义市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"141182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汾阳市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"150000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"内蒙古\",\r\n" + 
				"    \"fullname\": \"内蒙古自治区\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0471\",\r\n" + 
				"        \"adcode\": \"150100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"呼和浩特\",\r\n" + 
				"        \"fullname\": \"呼和浩特市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"回民区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉泉区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赛罕区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"土默特左旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"托克托县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和林格尔县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清水河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武川县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0472\",\r\n" + 
				"        \"adcode\": \"150200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"包头\",\r\n" + 
				"        \"fullname\": \"包头市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昆都仑区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石拐区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150206\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白云鄂博矿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150207\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"九原区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"土默特右旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"固阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"达尔罕茂明安联合旗\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0473\",\r\n" + 
				"        \"adcode\": \"150300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"乌海\",\r\n" + 
				"        \"fullname\": \"乌海市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海勃湾区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌达区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0476\",\r\n" + 
				"        \"adcode\": \"150400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"赤峰\",\r\n" + 
				"        \"fullname\": \"赤峰市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"元宝山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"松山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿鲁科尔沁旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴林左旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴林右旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"林西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"克什克腾旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"翁牛特旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"喀喇沁旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150429\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150430\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"敖汉旗\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0475\",\r\n" + 
				"        \"adcode\": \"150500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"通辽\",\r\n" + 
				"        \"fullname\": \"通辽市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"科尔沁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"科尔沁左翼中旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"科尔沁左翼后旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开鲁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"库伦旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"奈曼旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扎鲁特旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霍林郭勒市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0477\",\r\n" + 
				"        \"adcode\": \"150600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"鄂尔多斯\",\r\n" + 
				"        \"fullname\": \"鄂尔多斯市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东胜区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"康巴什区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"达拉特旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"准格尔旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄂托克前旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄂托克旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杭锦旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌审旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伊金霍洛旗\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0470\",\r\n" + 
				"        \"adcode\": \"150700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"呼伦贝尔\",\r\n" + 
				"        \"fullname\": \"呼伦贝尔市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海拉尔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扎赉诺尔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿荣旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莫力达瓦达斡尔族自治旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄂伦春自治旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄂温克族自治旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陈巴尔虎旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新巴尔虎左旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新巴尔虎右旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"满洲里市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150782\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"牙克石市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150783\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扎兰屯市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150784\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"额尔古纳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150785\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"根河市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0478\",\r\n" + 
				"        \"adcode\": \"150800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"巴彦淖尔\",\r\n" + 
				"        \"fullname\": \"巴彦淖尔市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五原县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"磴口县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌拉特前旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌拉特中旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌拉特后旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杭锦后旗\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0474\",\r\n" + 
				"        \"adcode\": \"150900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"乌兰察布\",\r\n" + 
				"        \"fullname\": \"乌兰察布市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"集宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卓资县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"化德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"商都县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凉城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"察哈尔右翼前旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"察哈尔右翼中旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150928\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"察哈尔右翼后旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150929\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"四子王旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"150981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰镇市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0482\",\r\n" + 
				"        \"adcode\": \"152200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"兴安盟\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152201\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌兰浩特市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿尔山市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"科尔沁右翼前旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"科尔沁右翼中旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扎赉特旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"突泉县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0479\",\r\n" + 
				"        \"adcode\": \"152500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"锡林郭勒\",\r\n" + 
				"        \"fullname\": \"锡林郭勒盟\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152501\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"二连浩特市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"锡林浩特市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿巴嘎旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"苏尼特左旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"苏尼特右旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东乌珠穆沁旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西乌珠穆沁旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太仆寺旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镶黄旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152529\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"正镶白旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152530\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"正蓝旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152531\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"多伦县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0483\",\r\n" + 
				"        \"adcode\": \"152900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阿拉善盟\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿拉善左旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿拉善右旗\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"152923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"额济纳旗\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"210000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"辽宁\",\r\n" + 
				"    \"fullname\": \"辽宁省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"024\",\r\n" + 
				"        \"adcode\": \"210100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"沈阳\",\r\n" + 
				"        \"fullname\": \"沈阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沈河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"皇姑区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"苏家屯区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浑南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沈北新区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"于洪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"辽中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"康平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"法库县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新民市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0411\",\r\n" + 
				"        \"adcode\": \"210200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"大连\",\r\n" + 
				"        \"fullname\": \"大连市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西岗区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙河口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210211\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"甘井子区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210212\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"旅顺口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210213\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长海县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瓦房店市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210214\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"普兰店区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210283\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庄河市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0412\",\r\n" + 
				"        \"adcode\": \"210300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"鞍山\",\r\n" + 
				"        \"fullname\": \"鞍山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"立山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"千山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"台安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岫岩满族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0413\",\r\n" + 
				"        \"adcode\": \"210400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"抚顺\",\r\n" + 
				"        \"fullname\": \"抚顺市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新抚区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东洲区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"望花区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210411\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"顺城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"抚顺县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新宾满族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清原满族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0414\",\r\n" + 
				"        \"adcode\": \"210500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"本溪\",\r\n" + 
				"        \"fullname\": \"本溪市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"溪湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210504\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"明山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210505\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南芬区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"本溪满族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桓仁满族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0415\",\r\n" + 
				"        \"adcode\": \"210600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"丹东\",\r\n" + 
				"        \"fullname\": \"丹东市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"元宝区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"振兴区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210604\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"振安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宽甸满族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东港市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210682\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0416\",\r\n" + 
				"        \"adcode\": \"210700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"锦州\",\r\n" + 
				"        \"fullname\": \"锦州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古塔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凌河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210711\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太和区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黑山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"义县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凌海市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210782\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北镇市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0417\",\r\n" + 
				"        \"adcode\": \"210800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"营口\",\r\n" + 
				"        \"fullname\": \"营口市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"站前区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西市区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210804\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鲅鱼圈区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210811\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"老边区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盖州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210882\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大石桥市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0418\",\r\n" + 
				"        \"adcode\": \"210900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阜新\",\r\n" + 
				"        \"fullname\": \"阜新市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新邱区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210904\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210905\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清河门区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210911\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"细河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阜新蒙古族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"210922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"彰武县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0419\",\r\n" + 
				"        \"adcode\": \"211000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"辽阳\",\r\n" + 
				"        \"fullname\": \"辽阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白塔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"文圣区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211004\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宏伟区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211005\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"弓长岭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211011\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太子河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"辽阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灯塔市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0427\",\r\n" + 
				"        \"adcode\": \"211100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"盘锦\",\r\n" + 
				"        \"fullname\": \"盘锦市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双台子区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴隆台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大洼区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盘山县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0410\",\r\n" + 
				"        \"adcode\": \"211200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"铁岭\",\r\n" + 
				"        \"fullname\": \"铁岭市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"银州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁岭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌图县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"调兵山市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开原市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0421\",\r\n" + 
				"        \"adcode\": \"211300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"朝阳\",\r\n" + 
				"        \"fullname\": \"朝阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双塔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"朝阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"喀喇沁左翼蒙古族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北票市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211382\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凌源市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0429\",\r\n" + 
				"        \"adcode\": \"211400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"葫芦岛\",\r\n" + 
				"        \"fullname\": \"葫芦岛市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"连山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙港区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南票区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绥中县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"211481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"220000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"吉林\",\r\n" + 
				"    \"fullname\": \"吉林省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0431\",\r\n" + 
				"        \"adcode\": \"220100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"长春\",\r\n" + 
				"        \"fullname\": \"长春市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南关区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宽城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"朝阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"二道区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绿园区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"九台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"农安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"榆树市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220183\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德惠市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0432\",\r\n" + 
				"        \"adcode\": \"220200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"吉林\",\r\n" + 
				"        \"fullname\": \"吉林市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌邑区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙潭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"船营区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220211\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰满区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永吉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蛟河市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桦甸市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220283\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"舒兰市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220284\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"磐石市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0434\",\r\n" + 
				"        \"adcode\": \"220300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"四平\",\r\n" + 
				"        \"fullname\": \"四平市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梨树县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伊通满族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"公主岭市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220382\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双辽市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0437\",\r\n" + 
				"        \"adcode\": \"220400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"辽源\",\r\n" + 
				"        \"fullname\": \"辽源市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东辽县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0435\",\r\n" + 
				"        \"adcode\": \"220500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"通化\",\r\n" + 
				"        \"fullname\": \"通化市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东昌区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"二道江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"辉南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柳河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梅河口市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220582\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"集安市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0439\",\r\n" + 
				"        \"adcode\": \"220600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"白山\",\r\n" + 
				"        \"fullname\": \"白山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浑江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220605\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江源区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"抚松县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"靖宇县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长白朝鲜族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临江市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0438\",\r\n" + 
				"        \"adcode\": \"220700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"松原\",\r\n" + 
				"        \"fullname\": \"松原市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"前郭尔罗斯蒙古族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长岭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乾安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扶余市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0436\",\r\n" + 
				"        \"adcode\": \"220800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"白城\",\r\n" + 
				"        \"fullname\": \"白城市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洮北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇赉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通榆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洮南市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"220882\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大安市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1433\",\r\n" + 
				"        \"adcode\": \"222400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"延边\",\r\n" + 
				"        \"fullname\": \"延边朝鲜族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"222401\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"延吉市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"222402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"图们市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"222403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"敦化市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"222404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"珲春市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"222405\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙井市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"222406\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和龙市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"222424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汪清县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"222426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安图县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"230000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"黑龙江\",\r\n" + 
				"    \"fullname\": \"黑龙江省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0451\",\r\n" + 
				"        \"adcode\": \"230100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"哈尔滨\",\r\n" + 
				"        \"fullname\": \"哈尔滨市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"道里区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南岗区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"道外区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平房区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"松北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230110\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"香坊区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"呼兰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"依兰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"方正县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宾县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴彦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"木兰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"延寿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230183\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尚志市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230184\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五常市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0452\",\r\n" + 
				"        \"adcode\": \"230200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"齐齐哈尔\",\r\n" + 
				"        \"fullname\": \"齐齐哈尔市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙沙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁锋区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昂昂溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230206\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富拉尔基区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230207\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"碾子山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230208\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梅里斯达斡尔族区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"依安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泰来县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"甘南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富裕县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230229\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"克山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230230\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"克东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230231\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"拜泉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"讷河市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0467\",\r\n" + 
				"        \"adcode\": \"230300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"鸡西\",\r\n" + 
				"        \"fullname\": \"鸡西市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鸡冠区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"恒山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滴道区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230305\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梨树区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230306\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城子河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230307\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麻山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鸡东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"虎林市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230382\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"密山市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0468\",\r\n" + 
				"        \"adcode\": \"230400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"鹤岗\",\r\n" + 
				"        \"fullname\": \"鹤岗市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"向阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"工农区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230405\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230406\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230407\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"萝北县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绥滨县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0469\",\r\n" + 
				"        \"adcode\": \"230500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"双鸭山\",\r\n" + 
				"        \"fullname\": \"双鸭山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尖山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岭东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230505\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"四方台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230506\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"集贤县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"友谊县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝清县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"饶河县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0459\",\r\n" + 
				"        \"adcode\": \"230600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"大庆\",\r\n" + 
				"        \"fullname\": \"大庆市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"萨尔图区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙凤区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230604\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"让胡路区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230605\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红岗区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230606\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大同区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肇州县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肇源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"林甸县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杜尔伯特蒙古族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0458\",\r\n" + 
				"        \"adcode\": \"230700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"伊春\",\r\n" + 
				"        \"fullname\": \"伊春市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伊春区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南岔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230704\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"友好区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230705\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西林区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230706\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"翠峦区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230707\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新青区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230708\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"美溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230709\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金山屯区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230710\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五营区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230711\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌马河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230712\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汤旺河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230713\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"带岭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230714\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌伊岭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230715\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红星区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230716\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上甘岭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嘉荫县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁力市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0454\",\r\n" + 
				"        \"adcode\": \"230800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"佳木斯\",\r\n" + 
				"        \"fullname\": \"佳木斯市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"向阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230804\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"前进区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230805\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东风区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230811\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郊区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桦南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桦川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汤原县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230883\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"抚远市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"同江市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230882\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富锦市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0464\",\r\n" + 
				"        \"adcode\": \"230900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"七台河\",\r\n" + 
				"        \"fullname\": \"七台河市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新兴区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桃山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230904\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"茄子河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"230921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"勃利县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0453\",\r\n" + 
				"        \"adcode\": \"231000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"牡丹江\",\r\n" + 
				"        \"fullname\": \"牡丹江市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳明区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231004\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"爱民区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231005\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231086\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东宁市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"林口县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绥芬河市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231083\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海林市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231084\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁安市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231085\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"穆棱市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0456\",\r\n" + 
				"        \"adcode\": \"231100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"黑河\",\r\n" + 
				"        \"fullname\": \"黑河市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"爱辉区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嫩江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"逊克县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"孙吴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北安市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五大连池市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0455\",\r\n" + 
				"        \"adcode\": \"231200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"绥化\",\r\n" + 
				"        \"fullname\": \"绥化市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北林区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"望奎县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兰西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青冈县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庆安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"明水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绥棱县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安达市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肇东市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"231283\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海伦市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0457\",\r\n" + 
				"        \"adcode\": \"232700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"大兴安岭\",\r\n" + 
				"        \"fullname\": \"大兴安岭地区\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"232701\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"加格达奇区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"232721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"呼玛县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"232722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"塔河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"232723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"漠河县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"310000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"上海\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"021\",\r\n" + 
				"        \"adcode\": \"310100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"上海\",\r\n" + 
				"        \"fullname\": \"上海市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310101\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄浦区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"徐汇区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"静安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"普陀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"虹口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310110\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杨浦区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"闵行区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嘉定区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浦东新区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310116\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310117\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"松江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310118\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青浦区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310120\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"奉贤区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"310151\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崇明区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"320000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"江苏\",\r\n" + 
				"    \"fullname\": \"江苏省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"025\",\r\n" + 
				"        \"adcode\": \"320100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"南京\",\r\n" + 
				"        \"fullname\": \"南京市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玄武区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秦淮区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建邺区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鼓楼区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浦口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"栖霞区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雨花台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320116\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"六合区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320117\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"溧水区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320118\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高淳区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0510\",\r\n" + 
				"        \"adcode\": \"320200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"无锡\",\r\n" + 
				"        \"fullname\": \"无锡市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320213\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梁溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320214\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新吴区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"锡山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320206\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320211\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滨湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江阴市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜兴市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0516\",\r\n" + 
				"        \"adcode\": \"320300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"徐州\",\r\n" + 
				"        \"fullname\": \"徐州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鼓楼区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云龙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320305\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贾汪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泉山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320312\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铜山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沛县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"睢宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新沂市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320382\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邳州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0519\",\r\n" + 
				"        \"adcode\": \"320400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"常州\",\r\n" + 
				"        \"fullname\": \"常州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"钟楼区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320411\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320412\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武进区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"溧阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320413\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金坛区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0512\",\r\n" + 
				"        \"adcode\": \"320500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"苏州\",\r\n" + 
				"        \"fullname\": \"苏州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320505\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"虎丘区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320506\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吴中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320507\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"相城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320508\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"姑苏区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320509\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吴江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"常熟市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320582\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"张家港市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320583\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昆山市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320585\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太仓市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0513\",\r\n" + 
				"        \"adcode\": \"320600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"南通\",\r\n" + 
				"        \"fullname\": \"南通市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崇川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320611\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"港闸区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320612\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"如东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"启东市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320682\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"如皋市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320684\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海门市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0518\",\r\n" + 
				"        \"adcode\": \"320700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"连云港\",\r\n" + 
				"        \"fullname\": \"连云港市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"连云区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320706\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320707\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赣榆区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东海县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灌云县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灌南县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0517\",\r\n" + 
				"        \"adcode\": \"320800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"淮安\",\r\n" + 
				"        \"fullname\": \"淮安市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清江浦区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淮安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320804\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淮阴区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涟水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320813\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洪泽区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320830\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盱眙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320831\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金湖县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0515\",\r\n" + 
				"        \"adcode\": \"320900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"盐城\",\r\n" + 
				"        \"fullname\": \"盐城市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"亭湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"响水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滨海县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阜宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"射阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建湖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东台市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"320904\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大丰区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0514\",\r\n" + 
				"        \"adcode\": \"321000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"扬州\",\r\n" + 
				"        \"fullname\": \"扬州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邗江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321012\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝应县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仪征市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321084\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高邮市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0511\",\r\n" + 
				"        \"adcode\": \"321100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"镇江\",\r\n" + 
				"        \"fullname\": \"镇江市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"京口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"润州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丹徒区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丹阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扬中市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321183\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"句容市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0523\",\r\n" + 
				"        \"adcode\": \"321200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"泰州\",\r\n" + 
				"        \"fullname\": \"泰州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高港区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"姜堰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴化市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"靖江市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321283\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泰兴市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0527\",\r\n" + 
				"        \"adcode\": \"321300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宿迁\",\r\n" + 
				"        \"fullname\": \"宿迁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宿城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宿豫区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沭阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泗阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"321324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泗洪县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"330000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"浙江\",\r\n" + 
				"    \"fullname\": \"浙江省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0571\",\r\n" + 
				"        \"adcode\": \"330100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"杭州\",\r\n" + 
				"        \"fullname\": \"杭州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"下城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江干区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"拱墅区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滨江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"萧山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330110\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"余杭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桐庐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淳安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建德市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330185\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临安市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0574\",\r\n" + 
				"        \"adcode\": \"330200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宁波\",\r\n" + 
				"        \"fullname\": \"宁波市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海曙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330206\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北仑区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330211\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330212\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄞州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"象山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁海县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"余姚市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"慈溪市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330283\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"奉化区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0577\",\r\n" + 
				"        \"adcode\": \"330300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"温州\",\r\n" + 
				"        \"fullname\": \"温州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹿城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙湾区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瓯海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330305\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洞头区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永嘉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"苍南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"文成县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泰顺县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瑞安市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330382\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐清市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0573\",\r\n" + 
				"        \"adcode\": \"330400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"嘉兴\",\r\n" + 
				"        \"fullname\": \"嘉兴市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330411\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秀洲区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嘉善县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海盐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海宁市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330482\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平湖市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330483\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桐乡市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0572\",\r\n" + 
				"        \"adcode\": \"330500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"湖州\",\r\n" + 
				"        \"fullname\": \"湖州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吴兴区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南浔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德清县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长兴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安吉县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0575\",\r\n" + 
				"        \"adcode\": \"330600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"绍兴\",\r\n" + 
				"        \"fullname\": \"绍兴市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"越城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柯桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330604\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上虞区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"诸暨市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330683\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嵊州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0579\",\r\n" + 
				"        \"adcode\": \"330700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"金华\",\r\n" + 
				"        \"fullname\": \"金华市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"婺城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武义县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浦江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"磐安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兰溪市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330782\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"义乌市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330783\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330784\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永康市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0570\",\r\n" + 
				"        \"adcode\": \"330800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"衢州\",\r\n" + 
				"        \"fullname\": \"衢州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柯城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"衢江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"常山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙游县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江山市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0580\",\r\n" + 
				"        \"adcode\": \"330900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"舟山\",\r\n" + 
				"        \"fullname\": \"舟山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"普陀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岱山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"330922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嵊泗县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0576\",\r\n" + 
				"        \"adcode\": \"331000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"台州\",\r\n" + 
				"        \"fullname\": \"台州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"椒江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄岩区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331004\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"路桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉环县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三门县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仙居县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"温岭市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331082\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临海市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0578\",\r\n" + 
				"        \"adcode\": \"331100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"丽水\",\r\n" + 
				"        \"fullname\": \"丽水市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莲都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"缙云县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"遂昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"松阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庆元县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"景宁畲族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"331181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙泉市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"340000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"安徽\",\r\n" + 
				"    \"fullname\": \"安徽省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0551\",\r\n" + 
				"        \"adcode\": \"340100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"合肥\",\r\n" + 
				"        \"fullname\": \"合肥市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瑶海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庐阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蜀山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"包河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肥东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肥西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庐江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巢湖市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0553\",\r\n" + 
				"        \"adcode\": \"340200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"芜湖\",\r\n" + 
				"        \"fullname\": \"芜湖市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镜湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"弋江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340207\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鸠江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340208\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芜湖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"繁昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"无为县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0552\",\r\n" + 
				"        \"adcode\": \"340300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"蚌埠\",\r\n" + 
				"        \"fullname\": \"蚌埠市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙子湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蚌山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"禹会区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淮上区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"怀远县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"固镇县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0554\",\r\n" + 
				"        \"adcode\": \"340400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"淮南\",\r\n" + 
				"        \"fullname\": \"淮南市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大通区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"田家庵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"谢家集区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340405\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"八公山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340406\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潘集区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"寿县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0555\",\r\n" + 
				"        \"adcode\": \"340500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"马鞍山\",\r\n" + 
				"        \"fullname\": \"马鞍山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"花山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340504\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雨山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340506\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博望区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"当涂县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"含山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0561\",\r\n" + 
				"        \"adcode\": \"340600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"淮北\",\r\n" + 
				"        \"fullname\": \"淮北市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杜集区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"相山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340604\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"烈山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"濉溪县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0562\",\r\n" + 
				"        \"adcode\": \"340700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"铜陵\",\r\n" + 
				"        \"fullname\": \"铜陵市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340705\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铜官区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340711\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郊区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340706\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"义安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"枞阳县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0556\",\r\n" + 
				"        \"adcode\": \"340800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"安庆\",\r\n" + 
				"        \"fullname\": \"安庆市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"迎江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大观区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340811\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜秀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"怀宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潜山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太湖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宿松县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"望江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岳西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"340881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桐城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0559\",\r\n" + 
				"        \"adcode\": \"341000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"黄山\",\r\n" + 
				"        \"fullname\": \"黄山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"屯溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341004\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"徽州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"歙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"休宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黟县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"祁门县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0550\",\r\n" + 
				"        \"adcode\": \"341100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"滁州\",\r\n" + 
				"        \"fullname\": \"滁州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"琅琊区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南谯区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"来安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"全椒县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定远县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天长市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"明光市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1558\",\r\n" + 
				"        \"adcode\": \"341200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阜阳\",\r\n" + 
				"        \"fullname\": \"阜阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"颍州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"颍东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"颍泉区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临泉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阜南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"颍上县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"界首市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0557\",\r\n" + 
				"        \"adcode\": \"341300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宿州\",\r\n" + 
				"        \"fullname\": \"宿州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"埇桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"砀山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"萧县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵璧县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泗县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0564\",\r\n" + 
				"        \"adcode\": \"341500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"六安\",\r\n" + 
				"        \"fullname\": \"六安市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"裕安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341504\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"叶集区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霍邱县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"舒城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金寨县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霍山县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0558\",\r\n" + 
				"        \"adcode\": \"341600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"亳州\",\r\n" + 
				"        \"fullname\": \"亳州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"谯城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涡阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蒙城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"利辛县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0566\",\r\n" + 
				"        \"adcode\": \"341700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"池州\",\r\n" + 
				"        \"fullname\": \"池州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贵池区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东至县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青阳县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0563\",\r\n" + 
				"        \"adcode\": \"341800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宣城\",\r\n" + 
				"        \"fullname\": \"宣城市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宣州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郎溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泾县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绩溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"旌德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"341881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁国市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"350000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"福建\",\r\n" + 
				"    \"fullname\": \"福建省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0591\",\r\n" + 
				"        \"adcode\": \"350100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"福州\",\r\n" + 
				"        \"fullname\": \"福州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鼓楼区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"台江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仓山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"马尾区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"晋安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"闽侯县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"连江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"闽清县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永泰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平潭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福清市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长乐市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0592\",\r\n" + 
				"        \"adcode\": \"350200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"厦门\",\r\n" + 
				"        \"fullname\": \"厦门市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"思明区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海沧区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350206\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湖里区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350211\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"集美区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350212\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"同安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350213\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"翔安区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0594\",\r\n" + 
				"        \"adcode\": \"350300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"莆田\",\r\n" + 
				"        \"fullname\": \"莆田市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城厢区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涵江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荔城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350305\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秀屿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仙游县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0598\",\r\n" + 
				"        \"adcode\": \"350400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"三明\",\r\n" + 
				"        \"fullname\": \"三明市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梅列区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三元区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"明溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清流县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尤溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"将乐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350429\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泰宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350430\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永安市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0595\",\r\n" + 
				"        \"adcode\": \"350500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"泉州\",\r\n" + 
				"        \"fullname\": \"泉州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鲤城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰泽区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350504\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洛江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350505\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泉港区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永春县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金门县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石狮市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350582\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"晋江市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350583\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南安市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0596\",\r\n" + 
				"        \"adcode\": \"350600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"漳州\",\r\n" + 
				"        \"fullname\": \"漳州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芗城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙文区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云霄县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"漳浦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"诏安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长泰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南靖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350628\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350629\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙海市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0599\",\r\n" + 
				"        \"adcode\": \"350700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"南平\",\r\n" + 
				"        \"fullname\": \"南平市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"延平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"顺昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浦城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"光泽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"松溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"政和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邵武市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350782\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武夷山市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350783\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建瓯市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0597\",\r\n" + 
				"        \"adcode\": \"350800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"龙岩\",\r\n" + 
				"        \"fullname\": \"龙岩市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新罗区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永定区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长汀县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上杭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"连城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"漳平市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0593\",\r\n" + 
				"        \"adcode\": \"350900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宁德\",\r\n" + 
				"        \"fullname\": \"宁德市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蕉城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霞浦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"屏南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"寿宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"周宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柘荣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福安市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"350982\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福鼎市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"360000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"江西\",\r\n" + 
				"    \"fullname\": \"江西省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0791\",\r\n" + 
				"        \"adcode\": \"360100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"南昌\",\r\n" + 
				"        \"fullname\": \"南昌市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青云谱区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湾里区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青山湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新建区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安义县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"进贤县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0798\",\r\n" + 
				"        \"adcode\": \"360200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"景德镇\",\r\n" + 
				"        \"fullname\": \"景德镇市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"珠山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浮梁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐平市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0799\",\r\n" + 
				"        \"adcode\": \"360300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"萍乡\",\r\n" + 
				"        \"fullname\": \"萍乡市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安源区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360313\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湘东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莲花县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上栗县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芦溪县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0792\",\r\n" + 
				"        \"adcode\": \"360400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"九江\",\r\n" + 
				"        \"fullname\": \"九江市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"濂溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浔阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"九江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"修水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永修县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庐山市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"都昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360429\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湖口县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360430\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"彭泽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瑞昌市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360482\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"共青城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0790\",\r\n" + 
				"        \"adcode\": \"360500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"新余\",\r\n" + 
				"        \"fullname\": \"新余市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"渝水区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"分宜县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0701\",\r\n" + 
				"        \"adcode\": \"360600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"鹰潭\",\r\n" + 
				"        \"fullname\": \"鹰潭市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"月湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"余江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贵溪市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0797\",\r\n" + 
				"        \"adcode\": \"360700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"赣州\",\r\n" + 
				"        \"fullname\": \"赣州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"章贡区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南康区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赣县区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"信丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大余县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上犹县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崇义县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安远县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360728\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360729\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"全南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360730\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁都县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360731\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"于都县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360732\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴国县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360733\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"会昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360734\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"寻乌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360735\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瑞金市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0796\",\r\n" + 
				"        \"adcode\": \"360800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"吉安\",\r\n" + 
				"        \"fullname\": \"吉安市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青原区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"峡江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新干县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泰和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"遂川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360829\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安福县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360830\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永新县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"井冈山市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0795\",\r\n" + 
				"        \"adcode\": \"360900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宜春\",\r\n" + 
				"        \"fullname\": \"宜春市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"袁州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"奉新县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万载县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上高县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"靖安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铜鼓县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰城市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360982\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"樟树市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"360983\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高安市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0794\",\r\n" + 
				"        \"adcode\": \"361000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"抚州\",\r\n" + 
				"        \"fullname\": \"抚州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黎川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崇仁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜黄县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361027\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361028\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"资溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361029\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361030\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广昌县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0793\",\r\n" + 
				"        \"adcode\": \"361100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"上饶\",\r\n" + 
				"        \"fullname\": \"上饶市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"信州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广丰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上饶县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铅山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"横峰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"弋阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"余干县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄱阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万年县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361130\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"婺源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"361181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德兴市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"370000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"山东\",\r\n" + 
				"    \"fullname\": \"山东省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0531\",\r\n" + 
				"        \"adcode\": \"370100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"济南\",\r\n" + 
				"        \"fullname\": \"济南市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"历下区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"市中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"槐荫区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"历城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长清区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平阴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"济阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"商河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"章丘区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0532\",\r\n" + 
				"        \"adcode\": \"370200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"青岛\",\r\n" + 
				"        \"fullname\": \"青岛市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"市南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"市北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370211\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄岛区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370212\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崂山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370213\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"李沧区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370214\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"胶州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"即墨市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370283\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平度市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370285\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莱西市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0533\",\r\n" + 
				"        \"adcode\": \"370300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"淄博\",\r\n" + 
				"        \"fullname\": \"淄博市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淄川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"张店区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370305\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临淄区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370306\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"周村区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桓台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高青县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沂源县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0632\",\r\n" + 
				"        \"adcode\": \"370400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"枣庄\",\r\n" + 
				"        \"fullname\": \"枣庄市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"市中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"薛城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"峄城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370405\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"台儿庄区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370406\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"山亭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滕州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0546\",\r\n" + 
				"        \"adcode\": \"370500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"东营\",\r\n" + 
				"        \"fullname\": \"东营市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东营区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370505\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"垦利区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"利津县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广饶县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0535\",\r\n" + 
				"        \"adcode\": \"370600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"烟台\",\r\n" + 
				"        \"fullname\": \"烟台市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芝罘区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370611\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370612\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"牟平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370613\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莱山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370634\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长岛县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙口市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370682\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莱阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370683\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莱州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370684\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蓬莱市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370685\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"招远市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370686\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"栖霞市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370687\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海阳市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0536\",\r\n" + 
				"        \"adcode\": \"370700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"潍坊\",\r\n" + 
				"        \"fullname\": \"潍坊市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潍城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"寒亭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370704\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"坊子区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370705\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"奎文区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临朐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌乐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370782\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"诸城市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370783\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"寿光市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370784\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安丘市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370785\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高密市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370786\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌邑市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0537\",\r\n" + 
				"        \"adcode\": \"370800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"济宁\",\r\n" + 
				"        \"fullname\": \"济宁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370811\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"任城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370812\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兖州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"微山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鱼台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370829\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嘉祥县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370830\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汶上县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370831\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泗水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370832\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梁山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曲阜市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370883\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邹城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0538\",\r\n" + 
				"        \"adcode\": \"370900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"泰安\",\r\n" + 
				"        \"fullname\": \"泰安市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泰山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370911\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岱岳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370982\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新泰市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"370983\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肥城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0631\",\r\n" + 
				"        \"adcode\": \"371000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"威海\",\r\n" + 
				"        \"fullname\": \"威海市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"环翠区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"文登区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371082\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荣成市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371083\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乳山市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0633\",\r\n" + 
				"        \"adcode\": \"371100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"日照\",\r\n" + 
				"        \"fullname\": \"日照市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东港区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岚山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五莲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莒县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0634\",\r\n" + 
				"        \"adcode\": \"371200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"莱芜\",\r\n" + 
				"        \"fullname\": \"莱芜市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莱城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"钢城区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0539\",\r\n" + 
				"        \"adcode\": \"371300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"临沂\",\r\n" + 
				"        \"fullname\": \"临沂市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兰山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗庄区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371312\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沂南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郯城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沂水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兰陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"费县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平邑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莒南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蒙阴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临沭县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0534\",\r\n" + 
				"        \"adcode\": \"371400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"德州\",\r\n" + 
				"        \"fullname\": \"德州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陵城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁津县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庆云县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临邑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"齐河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平原县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"夏津县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐陵市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371482\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"禹城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0635\",\r\n" + 
				"        \"adcode\": \"371500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"聊城\",\r\n" + 
				"        \"fullname\": \"聊城市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东昌府区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳谷县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"茌平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东阿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"冠县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高唐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临清市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0543\",\r\n" + 
				"        \"adcode\": \"371600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"滨州\",\r\n" + 
				"        \"fullname\": \"滨州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滨城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沾化区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠民县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳信县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"无棣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博兴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邹平县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0530\",\r\n" + 
				"        \"adcode\": \"371700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"菏泽\",\r\n" + 
				"        \"fullname\": \"菏泽市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"牡丹区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曹县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"单县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"成武县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巨野县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郓城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄄城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定陶区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"371728\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东明县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"410000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"河南\",\r\n" + 
				"    \"fullname\": \"河南省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0371\",\r\n" + 
				"        \"adcode\": \"410100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"郑州\",\r\n" + 
				"        \"fullname\": \"郑州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中原区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"二七区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"管城回族区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金水区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上街区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠济区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中牟县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巩义市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荥阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410183\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新密市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410184\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新郑市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410185\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"登封市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0378\",\r\n" + 
				"        \"adcode\": \"410200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"开封\",\r\n" + 
				"        \"fullname\": \"开封市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙亭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"顺河回族区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鼓楼区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"禹王台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410212\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"祥符区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杞县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通许县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尉氏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兰考县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0379\",\r\n" + 
				"        \"adcode\": \"410300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"洛阳\",\r\n" + 
				"        \"fullname\": \"洛阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"老城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西工区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瀍河回族区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410305\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涧西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410306\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉利区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洛龙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"孟津县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"栾川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嵩县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汝阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洛宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伊川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"偃师市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0375\",\r\n" + 
				"        \"adcode\": \"410400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"平顶山\",\r\n" + 
				"        \"fullname\": \"平顶山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卫东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石龙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410411\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湛河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"叶县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鲁山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"舞钢市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410482\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汝州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0372\",\r\n" + 
				"        \"adcode\": \"410500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"安阳\",\r\n" + 
				"        \"fullname\": \"安阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"文峰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北关区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410505\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"殷都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410506\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汤阴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"滑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"内黄县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"林州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0392\",\r\n" + 
				"        \"adcode\": \"410600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"鹤壁\",\r\n" + 
				"        \"fullname\": \"鹤壁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹤山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"山城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410611\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淇滨区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浚县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淇县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0373\",\r\n" + 
				"        \"adcode\": \"410700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"新乡\",\r\n" + 
				"        \"fullname\": \"新乡市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红旗区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卫滨区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410704\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤泉区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410711\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"牧野区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"获嘉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"原阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"延津县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"封丘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410728\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长垣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卫辉市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410782\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"辉县市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0391\",\r\n" + 
				"        \"adcode\": \"410800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"焦作\",\r\n" + 
				"        \"fullname\": \"焦作市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"解放区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中站区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410804\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"马村区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410811\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"山阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"修武县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博爱县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武陟县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"温县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410882\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沁阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410883\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"孟州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0393\",\r\n" + 
				"        \"adcode\": \"410900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"濮阳\",\r\n" + 
				"        \"fullname\": \"濮阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华龙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南乐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"范县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"台前县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"410928\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"濮阳县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0374\",\r\n" + 
				"        \"adcode\": \"411000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"许昌\",\r\n" + 
				"        \"fullname\": \"许昌市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"魏都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄢陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"襄城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"禹州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411082\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长葛市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0395\",\r\n" + 
				"        \"adcode\": \"411100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"漯河\",\r\n" + 
				"        \"fullname\": \"漯河市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"源汇区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郾城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"召陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"舞阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临颍县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0398\",\r\n" + 
				"        \"adcode\": \"411200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"三门峡\",\r\n" + 
				"        \"fullname\": \"三门峡市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湖滨区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陕州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"渑池县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卢氏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"义马市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵宝市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0377\",\r\n" + 
				"        \"adcode\": \"411300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"南阳\",\r\n" + 
				"        \"fullname\": \"南阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宛城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卧龙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南召县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"方城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西峡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"内乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淅川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"社旗县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"唐河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新野县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411330\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桐柏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邓州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0370\",\r\n" + 
				"        \"adcode\": \"411400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"商丘\",\r\n" + 
				"        \"fullname\": \"商丘市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梁园区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"睢阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"民权县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"睢县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柘城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"虞城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"夏邑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0376\",\r\n" + 
				"        \"adcode\": \"411500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"信阳\",\r\n" + 
				"        \"fullname\": \"信阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浉河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"光山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"商城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"固始县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潢川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淮滨县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"息县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0394\",\r\n" + 
				"        \"adcode\": \"411600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"周口\",\r\n" + 
				"        \"fullname\": \"周口市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"川汇区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扶沟县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西华县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"商水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沈丘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郸城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淮阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太康县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411628\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹿邑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"项城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0396\",\r\n" + 
				"        \"adcode\": \"411700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"驻马店\",\r\n" + 
				"        \"fullname\": \"驻马店市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"驿城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上蔡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平舆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"正阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"确山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泌阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汝南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411728\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"遂平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"411729\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新蔡县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1391\",\r\n" + 
				"        \"adcode\": \"419001\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"济源\",\r\n" + 
				"        \"fullname\": \"济源市\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"420000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"湖北\",\r\n" + 
				"    \"fullname\": \"湖北省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"027\",\r\n" + 
				"        \"adcode\": \"420100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"武汉\",\r\n" + 
				"        \"fullname\": \"武汉市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江岸区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江汉区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"硚口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汉阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武昌区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洪山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东西湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汉南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蔡甸区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江夏区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420116\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄陂区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420117\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新洲区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0714\",\r\n" + 
				"        \"adcode\": \"420200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"黄石\",\r\n" + 
				"        \"fullname\": \"黄石市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄石港区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西塞山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"下陆区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳新县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大冶市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0719\",\r\n" + 
				"        \"adcode\": \"420300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"十堰\",\r\n" + 
				"        \"fullname\": \"十堰市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"茅箭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"张湾区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郧阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郧西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"竹山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"竹溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"房县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丹江口市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0717\",\r\n" + 
				"        \"adcode\": \"420500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宜昌\",\r\n" + 
				"        \"fullname\": \"宜昌市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伍家岗区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420504\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"点军区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420505\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"猇亭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420506\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"夷陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"远安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秭归县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长阳土家族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420529\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五峰土家族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜都市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420582\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"当阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420583\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"枝江市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0710\",\r\n" + 
				"        \"adcode\": \"420600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"襄阳\",\r\n" + 
				"        \"fullname\": \"襄阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"襄城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420606\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"樊城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420607\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"襄州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南漳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"谷城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"保康县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420682\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"老河口市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420683\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"枣阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420684\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜城市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0711\",\r\n" + 
				"        \"adcode\": \"420700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"鄂州\",\r\n" + 
				"        \"fullname\": \"鄂州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梁子湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华容区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420704\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄂城区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0724\",\r\n" + 
				"        \"adcode\": \"420800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"荆门\",\r\n" + 
				"        \"fullname\": \"荆门市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东宝区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420804\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"掇刀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"京山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙洋县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"钟祥市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0712\",\r\n" + 
				"        \"adcode\": \"420900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"孝感\",\r\n" + 
				"        \"fullname\": \"孝感市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"孝南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"孝昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大悟县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云梦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"应城市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420982\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安陆市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"420984\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汉川市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0716\",\r\n" + 
				"        \"adcode\": \"421000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"荆州\",\r\n" + 
				"        \"fullname\": \"荆州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙市区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荆州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"公安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"监利县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石首市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421083\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洪湖市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421087\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"松滋市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0713\",\r\n" + 
				"        \"adcode\": \"421100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"黄冈\",\r\n" + 
				"        \"fullname\": \"黄冈市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"团风县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"英山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浠水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蕲春县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄梅县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麻城市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武穴市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0715\",\r\n" + 
				"        \"adcode\": \"421200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"咸宁\",\r\n" + 
				"        \"fullname\": \"咸宁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"咸安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嘉鱼县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崇阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赤壁市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0722\",\r\n" + 
				"        \"adcode\": \"421300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"随州\",\r\n" + 
				"        \"fullname\": \"随州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曾都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"随县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"421381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广水市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0718\",\r\n" + 
				"        \"adcode\": \"422800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"恩施\",\r\n" + 
				"        \"fullname\": \"恩施土家族苗族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"422801\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"恩施市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"422802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"利川市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"422822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建始县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"422823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"422825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宣恩县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"422826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"咸丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"422827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"来凤县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"422828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹤峰县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0728\",\r\n" + 
				"        \"adcode\": \"429004\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"仙桃\",\r\n" + 
				"        \"fullname\": \"仙桃市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"2728\",\r\n" + 
				"        \"adcode\": \"429005\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"潜江\",\r\n" + 
				"        \"fullname\": \"潜江市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1728\",\r\n" + 
				"        \"adcode\": \"429006\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"天门\",\r\n" + 
				"        \"fullname\": \"天门市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1719\",\r\n" + 
				"        \"adcode\": \"429021\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"神农架\",\r\n" + 
				"        \"fullname\": \"神农架林区\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"430000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"湖南\",\r\n" + 
				"    \"fullname\": \"湖南省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0731\",\r\n" + 
				"        \"adcode\": \"430100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"长沙\",\r\n" + 
				"        \"fullname\": \"长沙市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芙蓉区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天心区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岳麓区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开福区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雨花区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"望城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长沙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浏阳市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0733\",\r\n" + 
				"        \"adcode\": \"430200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"株洲\",\r\n" + 
				"        \"fullname\": \"株洲市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荷塘区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芦淞区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石峰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430211\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天元区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"株洲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"攸县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"茶陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"炎陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"醴陵市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0732\",\r\n" + 
				"        \"adcode\": \"430300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"湘潭\",\r\n" + 
				"        \"fullname\": \"湘潭市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雨湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岳塘区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湘潭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湘乡市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430382\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"韶山市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0734\",\r\n" + 
				"        \"adcode\": \"430400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"衡阳\",\r\n" + 
				"        \"fullname\": \"衡阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430405\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"珠晖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430406\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雁峰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430407\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石鼓区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430408\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蒸湘区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430412\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南岳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"衡阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"衡南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"衡山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"衡东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"祁东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"耒阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430482\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"常宁市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0739\",\r\n" + 
				"        \"adcode\": \"430500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"邵阳\",\r\n" + 
				"        \"fullname\": \"邵阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双清区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大祥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430511\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北塔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邵东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新邵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邵阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆回县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洞口县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绥宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430529\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城步苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武冈市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0730\",\r\n" + 
				"        \"adcode\": \"430600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"岳阳\",\r\n" + 
				"        \"fullname\": \"岳阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岳阳楼区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430611\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"君山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岳阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华容县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湘阴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汨罗市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430682\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临湘市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0736\",\r\n" + 
				"        \"adcode\": \"430700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"常德\",\r\n" + 
				"        \"fullname\": \"常德市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鼎城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汉寿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"澧县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临澧县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桃源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石门县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"津市市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0744\",\r\n" + 
				"        \"adcode\": \"430800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"张家界\",\r\n" + 
				"        \"fullname\": \"张家界市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永定区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430811\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武陵源区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"慈利县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桑植县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0737\",\r\n" + 
				"        \"adcode\": \"430900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"益阳\",\r\n" + 
				"        \"fullname\": \"益阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"资阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赫山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桃江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"430981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沅江市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0735\",\r\n" + 
				"        \"adcode\": \"431000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"郴州\",\r\n" + 
				"        \"fullname\": \"郴州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"苏仙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桂阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜章县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永兴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嘉禾县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临武县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汝城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431027\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桂东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431028\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安仁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"资兴市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0746\",\r\n" + 
				"        \"adcode\": \"431100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"永州\",\r\n" + 
				"        \"fullname\": \"永州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"零陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"冷水滩区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"祁阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双牌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"道县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江永县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁远县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蓝山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江华瑶族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0745\",\r\n" + 
				"        \"adcode\": \"431200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"怀化\",\r\n" + 
				"        \"fullname\": \"怀化市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹤城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中方县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沅陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"辰溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"溆浦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"会同县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麻阳苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新晃侗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431228\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芷江侗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431229\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"靖州苗族侗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431230\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通道侗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洪江市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0738\",\r\n" + 
				"        \"adcode\": \"431300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"娄底\",\r\n" + 
				"        \"fullname\": \"娄底市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"娄星区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双峰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"冷水江市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"431382\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涟源市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0743\",\r\n" + 
				"        \"adcode\": \"433100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"湘西\",\r\n" + 
				"        \"fullname\": \"湘西土家族苗族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"433101\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉首市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"433122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泸溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"433123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤凰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"433124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"花垣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"433125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"保靖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"433126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古丈县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"433127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永顺县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"433130\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙山县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"440000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"广东\",\r\n" + 
				"    \"fullname\": \"广东省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"020\",\r\n" + 
				"        \"adcode\": \"440100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"广州\",\r\n" + 
				"        \"fullname\": \"广州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荔湾区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"越秀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海珠区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白云区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄埔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"番禺区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"花都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南沙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440117\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"从化区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440118\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"增城区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0751\",\r\n" + 
				"        \"adcode\": \"440200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"韶关\",\r\n" + 
				"        \"fullname\": \"韶关市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浈江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曲江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"始兴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仁化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440229\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"翁源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440232\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乳源瑶族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440233\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐昌市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440282\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南雄市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0755\",\r\n" + 
				"        \"adcode\": \"440300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"深圳\",\r\n" + 
				"        \"fullname\": \"深圳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福田区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440305\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440306\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440307\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙岗区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440308\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐田区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440309\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440310\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"坪山区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0756\",\r\n" + 
				"        \"adcode\": \"440400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"珠海\",\r\n" + 
				"        \"fullname\": \"珠海市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"香洲区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"斗门区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金湾区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0754\",\r\n" + 
				"        \"adcode\": \"440500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"汕头\",\r\n" + 
				"        \"fullname\": \"汕头市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440507\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440511\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440512\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"濠江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440513\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潮阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440514\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潮南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440515\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"澄海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南澳县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0757\",\r\n" + 
				"        \"adcode\": \"440600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"佛山\",\r\n" + 
				"        \"fullname\": \"佛山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440604\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"禅城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440605\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440606\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"顺德区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440607\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三水区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440608\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高明区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0750\",\r\n" + 
				"        \"adcode\": \"440700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"江门\",\r\n" + 
				"        \"fullname\": \"江门市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蓬江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440704\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440705\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新会区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"台山市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440783\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开平市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440784\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹤山市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440785\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"恩平市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0759\",\r\n" + 
				"        \"adcode\": \"440800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"湛江\",\r\n" + 
				"        \"fullname\": \"湛江市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赤坎区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霞山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440804\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"坡头区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440811\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麻章区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"遂溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"徐闻县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"廉江市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440882\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雷州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440883\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吴川市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0668\",\r\n" + 
				"        \"adcode\": \"440900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"茂名\",\r\n" + 
				"        \"fullname\": \"茂名市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"茂南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440904\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"电白区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440982\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"化州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"440983\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"信宜市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0758\",\r\n" + 
				"        \"adcode\": \"441200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"肇庆\",\r\n" + 
				"        \"fullname\": \"肇庆市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"端州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鼎湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"怀集县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"封开县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德庆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高要区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441284\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"四会市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0752\",\r\n" + 
				"        \"adcode\": \"441300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"惠州\",\r\n" + 
				"        \"fullname\": \"惠州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博罗县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙门县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0753\",\r\n" + 
				"        \"adcode\": \"441400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"梅州\",\r\n" + 
				"        \"fullname\": \"梅州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梅江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梅县区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大埔县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰顺县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五华县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平远县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蕉岭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴宁市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0660\",\r\n" + 
				"        \"adcode\": \"441500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"汕尾\",\r\n" + 
				"        \"fullname\": \"汕尾市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陆河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陆丰市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0762\",\r\n" + 
				"        \"adcode\": \"441600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"河源\",\r\n" + 
				"        \"fullname\": \"河源市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"源城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"紫金县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"连平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东源县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0662\",\r\n" + 
				"        \"adcode\": \"441700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阳江\",\r\n" + 
				"        \"fullname\": \"阳江市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441704\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳春市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0763\",\r\n" + 
				"        \"adcode\": \"441800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"清远\",\r\n" + 
				"        \"fullname\": \"清远市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清新区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"佛冈县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"连山壮族瑶族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"连南瑶族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"英德市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"441882\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"连州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0769\",\r\n" + 
				"        \"adcode\": \"441900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"东莞\",\r\n" + 
				"        \"fullname\": \"东莞市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0760\",\r\n" + 
				"        \"adcode\": \"442000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"中山\",\r\n" + 
				"        \"fullname\": \"中山市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0768\",\r\n" + 
				"        \"adcode\": \"445100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"潮州\",\r\n" + 
				"        \"fullname\": \"潮州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湘桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潮安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"饶平县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0663\",\r\n" + 
				"        \"adcode\": \"445200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"揭阳\",\r\n" + 
				"        \"fullname\": \"揭阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"榕城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"揭东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"揭西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠来县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"普宁市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0766\",\r\n" + 
				"        \"adcode\": \"445300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"云浮\",\r\n" + 
				"        \"fullname\": \"云浮市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新兴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郁南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"445381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗定市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"450000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"广西\",\r\n" + 
				"    \"fullname\": \"广西壮族自治区\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0771\",\r\n" + 
				"        \"adcode\": \"450100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"南宁\",\r\n" + 
				"        \"fullname\": \"南宁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青秀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西乡塘区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"良庆区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邕宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450110\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武鸣区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"马山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上林县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宾阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"横县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0772\",\r\n" + 
				"        \"adcode\": \"450200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"柳州\",\r\n" + 
				"        \"fullname\": \"柳州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鱼峰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柳南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柳北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柳江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柳城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹿寨县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"融安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"融水苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三江侗族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0773\",\r\n" + 
				"        \"adcode\": \"450300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"桂林\",\r\n" + 
				"        \"fullname\": \"桂林市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秀峰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"叠彩区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"象山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450305\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"七星区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雁山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450312\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临桂区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阳朔县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"全州县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永福县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灌阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙胜各族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"资源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450330\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平乐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450331\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荔浦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450332\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"恭城瑶族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0774\",\r\n" + 
				"        \"adcode\": \"450400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"梧州\",\r\n" + 
				"        \"fullname\": \"梧州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万秀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450405\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长洲区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450406\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙圩区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"苍梧县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"藤县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蒙山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岑溪市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0779\",\r\n" + 
				"        \"adcode\": \"450500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"北海\",\r\n" + 
				"        \"fullname\": \"北海市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"银海区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450512\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铁山港区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"合浦县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0770\",\r\n" + 
				"        \"adcode\": \"450600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"防城港\",\r\n" + 
				"        \"fullname\": \"防城港市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"港口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"防城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"上思县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东兴市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0777\",\r\n" + 
				"        \"adcode\": \"450700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"钦州\",\r\n" + 
				"        \"fullname\": \"钦州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"钦南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"钦北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浦北县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1755\",\r\n" + 
				"        \"adcode\": \"450800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"贵港\",\r\n" + 
				"        \"fullname\": \"贵港市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"港北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"港南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450804\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"覃塘区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450881\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桂平市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0775\",\r\n" + 
				"        \"adcode\": \"450900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"玉林\",\r\n" + 
				"        \"fullname\": \"玉林市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福绵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"容县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陆川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博白县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴业县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"450981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北流市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0776\",\r\n" + 
				"        \"adcode\": \"451000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"百色\",\r\n" + 
				"        \"fullname\": \"百色市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"右江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"田阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"田东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平果县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德保县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451081\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"靖西市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"那坡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451027\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凌云县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451028\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐业县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451029\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"田林县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451030\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西林县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451031\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆林各族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1774\",\r\n" + 
				"        \"adcode\": \"451100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"贺州\",\r\n" + 
				"        \"fullname\": \"贺州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"八步区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平桂区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昭平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"钟山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富川瑶族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0778\",\r\n" + 
				"        \"adcode\": \"451200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"河池\",\r\n" + 
				"        \"fullname\": \"河池市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金城江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南丹县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天峨县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东兰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗城仫佬族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"环江毛南族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴马瑶族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451228\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"都安瑶族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451229\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大化瑶族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451281\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1772\",\r\n" + 
				"        \"adcode\": \"451300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"来宾\",\r\n" + 
				"        \"fullname\": \"来宾市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴宾区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"忻城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"象州县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武宣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金秀瑶族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"合山市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1771\",\r\n" + 
				"        \"adcode\": \"451400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"崇左\",\r\n" + 
				"        \"fullname\": \"崇左市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扶绥县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁明县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙州县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大新县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天等县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"451481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凭祥市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"460000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"海南\",\r\n" + 
				"    \"fullname\": \"海南省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0898\",\r\n" + 
				"        \"adcode\": \"460100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"海口\",\r\n" + 
				"        \"fullname\": \"海口市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秀英区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"琼山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"美兰区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0899\",\r\n" + 
				"        \"adcode\": \"460200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"三亚\",\r\n" + 
				"        \"fullname\": \"三亚市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海棠区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天涯区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崖州区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"2898\",\r\n" + 
				"        \"adcode\": \"460300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"三沙\",\r\n" + 
				"        \"fullname\": \"三沙市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西沙群岛\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南沙群岛\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"460323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中沙群岛的岛礁及其海域\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0805\",\r\n" + 
				"        \"adcode\": \"460400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"儋州\",\r\n" + 
				"        \"fullname\": \"儋州市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1897\",\r\n" + 
				"        \"adcode\": \"469001\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"五指山\",\r\n" + 
				"        \"fullname\": \"五指山市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1894\",\r\n" + 
				"        \"adcode\": \"469002\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"琼海\",\r\n" + 
				"        \"fullname\": \"琼海市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1893\",\r\n" + 
				"        \"adcode\": \"469005\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"文昌\",\r\n" + 
				"        \"fullname\": \"文昌市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1898\",\r\n" + 
				"        \"adcode\": \"469006\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"万宁\",\r\n" + 
				"        \"fullname\": \"万宁市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0807\",\r\n" + 
				"        \"adcode\": \"469007\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"东方\",\r\n" + 
				"        \"fullname\": \"东方市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0806\",\r\n" + 
				"        \"adcode\": \"469021\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"定安县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1892\",\r\n" + 
				"        \"adcode\": \"469022\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"屯昌县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0804\",\r\n" + 
				"        \"adcode\": \"469023\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"澄迈县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1896\",\r\n" + 
				"        \"adcode\": \"469024\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"临高县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0802\",\r\n" + 
				"        \"adcode\": \"469025\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"白沙\",\r\n" + 
				"        \"fullname\": \"白沙黎族自治县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0803\",\r\n" + 
				"        \"adcode\": \"469026\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"昌江\",\r\n" + 
				"        \"fullname\": \"昌江黎族自治县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"2802\",\r\n" + 
				"        \"adcode\": \"469027\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"乐东\",\r\n" + 
				"        \"fullname\": \"乐东黎族自治县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0809\",\r\n" + 
				"        \"adcode\": \"469028\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"陵水\",\r\n" + 
				"        \"fullname\": \"陵水黎族自治县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0801\",\r\n" + 
				"        \"adcode\": \"469029\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"保亭\",\r\n" + 
				"        \"fullname\": \"保亭黎族苗族自治县\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1899\",\r\n" + 
				"        \"adcode\": \"469030\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"琼中\",\r\n" + 
				"        \"fullname\": \"琼中黎族苗族自治县\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"500000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"重庆\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"023\",\r\n" + 
				"        \"adcode\": \"500100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"重庆\",\r\n" + 
				"        \"fullname\": \"重庆市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500101\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涪陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"渝中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大渡口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙坪坝区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"九龙坡区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南岸区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北碚区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500110\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"綦江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大足区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"渝北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黔江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长寿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500116\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江津区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500117\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"合川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500118\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500119\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500120\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"璧山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500151\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"铜梁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500152\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潼南区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500153\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荣昌区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500154\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500228\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梁平区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500229\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城口县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500230\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丰都县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500231\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"垫江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500232\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武隆区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500233\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"忠县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500235\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500236\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"奉节县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500237\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巫山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500238\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巫溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500240\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石柱土家族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500241\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秀山土家族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500242\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"酉阳土家族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"500243\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"彭水苗族土家族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"510000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"四川\",\r\n" + 
				"    \"fullname\": \"四川省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"028\",\r\n" + 
				"        \"adcode\": \"510100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"成都\",\r\n" + 
				"        \"fullname\": \"成都市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"锦江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青羊区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金牛区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武侯区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510108\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"成华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙泉驿区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青白江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"温江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金堂县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510116\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双流区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"郫都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大邑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510131\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蒲江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510132\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新津县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510180\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"简阳市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"都江堰市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510182\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"彭州市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510183\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邛崃市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510184\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崇州市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0813\",\r\n" + 
				"        \"adcode\": \"510300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"自贡\",\r\n" + 
				"        \"fullname\": \"自贡市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"自流井区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贡井区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510311\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沿滩区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富顺县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0812\",\r\n" + 
				"        \"adcode\": \"510400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"攀枝花\",\r\n" + 
				"        \"fullname\": \"攀枝花市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510411\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仁和区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"米易县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐边县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0830\",\r\n" + 
				"        \"adcode\": \"510500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"泸州\",\r\n" + 
				"        \"fullname\": \"泸州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"纳溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510504\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙马潭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泸县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"合江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"叙永县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古蔺县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0838\",\r\n" + 
				"        \"adcode\": \"510600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"德阳\",\r\n" + 
				"        \"fullname\": \"德阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"旌阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广汉市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510682\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"什邡市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510683\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绵竹市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0816\",\r\n" + 
				"        \"adcode\": \"510700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"绵阳\",\r\n" + 
				"        \"fullname\": \"绵阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"涪城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510704\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"游仙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐亭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510705\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梓潼县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"北川羌族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平武县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江油市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0839\",\r\n" + 
				"        \"adcode\": \"510800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"广元\",\r\n" + 
				"        \"fullname\": \"广元市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"利州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510811\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昭化区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510812\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"朝天区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"旺苍县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"剑阁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"苍溪县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0825\",\r\n" + 
				"        \"adcode\": \"510900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"遂宁\",\r\n" + 
				"        \"fullname\": \"遂宁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"船山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510904\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安居区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蓬溪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"射洪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"510923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大英县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1832\",\r\n" + 
				"        \"adcode\": \"511000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"内江\",\r\n" + 
				"        \"fullname\": \"内江市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"市中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511011\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东兴区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"威远县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"资中县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511028\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆昌县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0833\",\r\n" + 
				"        \"adcode\": \"511100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"乐山\",\r\n" + 
				"        \"fullname\": \"乐山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"市中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙湾区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五通桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金口河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"犍为县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"井研县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"夹江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沐川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511132\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"峨边彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511133\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"马边彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"峨眉山市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0817\",\r\n" + 
				"        \"adcode\": \"511300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"南充\",\r\n" + 
				"        \"fullname\": \"南充市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"顺庆区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高坪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嘉陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南部县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"营山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蓬安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仪陇县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西充县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阆中市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1833\",\r\n" + 
				"        \"adcode\": \"511400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"眉山\",\r\n" + 
				"        \"fullname\": \"眉山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东坡区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"彭山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仁寿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洪雅县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丹棱县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青神县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0831\",\r\n" + 
				"        \"adcode\": \"511500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宜宾\",\r\n" + 
				"        \"fullname\": \"宜宾市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"翠屏区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜宾县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"珙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"筠连县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴文县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511529\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"屏山县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0826\",\r\n" + 
				"        \"adcode\": \"511600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"广安\",\r\n" + 
				"        \"fullname\": \"广安市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"前锋区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岳池县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武胜县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"邻水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511681\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华蓥市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0818\",\r\n" + 
				"        \"adcode\": \"511700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"达州\",\r\n" + 
				"        \"fullname\": \"达州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511703\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"达川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宣汉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大竹县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"渠县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511781\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万源市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0835\",\r\n" + 
				"        \"adcode\": \"511800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"雅安\",\r\n" + 
				"        \"fullname\": \"雅安市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雨城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"名山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荥经县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汉源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石棉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天全县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芦山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝兴县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0827\",\r\n" + 
				"        \"adcode\": \"511900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"巴中\",\r\n" + 
				"        \"fullname\": \"巴中市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511903\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"恩阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"511923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平昌县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0832\",\r\n" + 
				"        \"adcode\": \"512000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"资阳\",\r\n" + 
				"        \"fullname\": \"资阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"512002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雁江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"512021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安岳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"512022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐至县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0837\",\r\n" + 
				"        \"adcode\": \"513200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阿坝\",\r\n" + 
				"        \"fullname\": \"阿坝藏族羌族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汶川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"理县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"茂县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"松潘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"九寨沟县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"小金县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513228\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黑水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513201\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"马尔康市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513230\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"壤塘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513231\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿坝县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513232\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"若尔盖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513233\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红原县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0836\",\r\n" + 
				"        \"adcode\": \"513300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"甘孜\",\r\n" + 
				"        \"fullname\": \"甘孜藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513301\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"康定市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泸定县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丹巴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"九龙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雅江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"道孚县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"炉霍县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"甘孜县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新龙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513330\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德格县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513331\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白玉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513332\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石渠县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513333\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"色达县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513334\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"理塘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513335\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴塘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513336\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乡城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513337\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"稻城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513338\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"得荣县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0834\",\r\n" + 
				"        \"adcode\": \"513400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"凉山\",\r\n" + 
				"        \"fullname\": \"凉山彝族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513401\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西昌市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"木里藏族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"会理县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"会东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"普格县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513429\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"布拖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513430\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513431\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昭觉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513432\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"喜德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513433\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"冕宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513434\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"越西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513435\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"甘洛县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513436\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"美姑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"513437\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雷波县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"520000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"贵州\",\r\n" + 
				"    \"fullname\": \"贵州省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0851\",\r\n" + 
				"        \"adcode\": \"520100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"贵阳\",\r\n" + 
				"        \"fullname\": \"贵阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南明区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云岩区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"花溪区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌当区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白云区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"观山湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"息烽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"修文县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清镇市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0858\",\r\n" + 
				"        \"adcode\": \"520200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"六盘水\",\r\n" + 
				"        \"fullname\": \"六盘水市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520201\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"钟山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"六枝特区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"水城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盘县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0852\",\r\n" + 
				"        \"adcode\": \"520300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"遵义\",\r\n" + 
				"        \"fullname\": \"遵义市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红花岗区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汇川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"播州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桐梓县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绥阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"正安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"道真仡佬族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"务川仡佬族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤冈县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湄潭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"余庆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520330\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"习水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赤水市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520382\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仁怀市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0853\",\r\n" + 
				"        \"adcode\": \"520400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"安顺\",\r\n" + 
				"        \"fullname\": \"安顺市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西秀区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平坝区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"普定县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇宁布依族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"关岭布依族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"紫云苗族布依族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0857\",\r\n" + 
				"        \"adcode\": \"520500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"毕节\",\r\n" + 
				"        \"fullname\": \"毕节市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"七星关区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大方县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黔西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金沙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"织金县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"纳雍县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"威宁彝族回族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"赫章县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0856\",\r\n" + 
				"        \"adcode\": \"520600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"铜仁\",\r\n" + 
				"        \"fullname\": \"铜仁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"碧江区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520603\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"万山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江口县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉屏侗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石阡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"思南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"印江土家族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沿河土家族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"520628\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"松桃苗族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0859\",\r\n" + 
				"        \"adcode\": \"522300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"黔西南\",\r\n" + 
				"        \"fullname\": \"黔西南布依族苗族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522301\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴义市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴仁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"普安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"晴隆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贞丰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"望谟县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"册亨县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安龙县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0855\",\r\n" + 
				"        \"adcode\": \"522600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"黔东南\",\r\n" + 
				"        \"fullname\": \"黔东南苗族侗族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522601\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凯里市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"施秉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三穗县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇远县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岑巩县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天柱县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522628\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"锦屏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522629\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"剑河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522630\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"台江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522631\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黎平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522632\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"榕江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522633\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"从江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522634\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雷山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522635\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麻江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522636\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丹寨县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0854\",\r\n" + 
				"        \"adcode\": \"522700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"黔南\",\r\n" + 
				"        \"fullname\": \"黔南布依族苗族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522701\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"都匀市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福泉市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"荔波县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贵定县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瓮安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"独山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平塘县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522728\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗甸县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522729\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长顺县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522730\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙里县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522731\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"522732\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三都水族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"530000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"云南\",\r\n" + 
				"    \"fullname\": \"云南省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0871\",\r\n" + 
				"        \"adcode\": \"530100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"昆明\",\r\n" + 
				"        \"fullname\": \"昆明市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"五华区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盘龙区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"官渡区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"呈贡区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"晋宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富民县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜良县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石林彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嵩明县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"禄劝彝族苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"寻甸回族彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安宁市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0874\",\r\n" + 
				"        \"adcode\": \"530300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"曲靖\",\r\n" + 
				"        \"fullname\": \"曲靖市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麒麟区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"马龙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陆良县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"师宗县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"罗平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"会泽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沾益区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宣威市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0877\",\r\n" + 
				"        \"adcode\": \"530400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"玉溪\",\r\n" + 
				"        \"fullname\": \"玉溪市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红塔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"澄江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通海县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"易门县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"峨山彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新平彝族傣族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"元江哈尼族彝族傣族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0875\",\r\n" + 
				"        \"adcode\": \"530500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"保山\",\r\n" + 
				"        \"fullname\": \"保山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"施甸县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"腾冲市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"龙陵县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌宁县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0870\",\r\n" + 
				"        \"adcode\": \"530600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"昭通\",\r\n" + 
				"        \"fullname\": \"昭通市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昭阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鲁甸县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巧家县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐津县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大关县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永善县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绥江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇雄县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530628\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"彝良县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530629\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"威信县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530630\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"水富县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0888\",\r\n" + 
				"        \"adcode\": \"530700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"丽江\",\r\n" + 
				"        \"fullname\": \"丽江市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉龙纳西族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永胜县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华坪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁蒗彝族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0879\",\r\n" + 
				"        \"adcode\": \"530800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"普洱\",\r\n" + 
				"        \"fullname\": \"普洱市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"思茅区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁洱哈尼族彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"墨江哈尼族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"景东彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"景谷傣族彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇沅彝族哈尼族拉祜族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江城哈尼族彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"孟连傣族拉祜族佤族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"澜沧拉祜族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530829\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西盟佤族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0883\",\r\n" + 
				"        \"adcode\": \"530900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"临沧\",\r\n" + 
				"        \"fullname\": \"临沧市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临翔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤庆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇康县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双江拉祜族佤族布朗族傣族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"耿马傣族佤族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"530927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沧源佤族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0878\",\r\n" + 
				"        \"adcode\": \"532300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"楚雄\",\r\n" + 
				"        \"fullname\": \"楚雄彝族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532301\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"楚雄市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双柏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"牟定县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南华县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"姚安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大姚县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永仁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"元谋县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武定县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532331\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"禄丰县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0873\",\r\n" + 
				"        \"adcode\": \"532500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"红河\",\r\n" + 
				"        \"fullname\": \"红河哈尼族彝族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532501\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"个旧市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"开远市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蒙自市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532504\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"弥勒市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"屏边苗族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"建水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石屏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泸西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"元阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532529\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532530\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金平苗族瑶族傣族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532531\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绿春县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532532\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河口瑶族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0876\",\r\n" + 
				"        \"adcode\": \"532600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"文山\",\r\n" + 
				"        \"fullname\": \"文山壮族苗族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532601\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"文山市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"砚山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西畴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麻栗坡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"马关县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丘北县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532628\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富宁县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0691\",\r\n" + 
				"        \"adcode\": \"532800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"西双版纳\",\r\n" + 
				"        \"fullname\": \"西双版纳傣族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532801\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"景洪市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"勐海县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"勐腊县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0872\",\r\n" + 
				"        \"adcode\": \"532900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"大理\",\r\n" + 
				"        \"fullname\": \"大理白族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532901\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大理市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"漾濞彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"祥云县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宾川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"弥渡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南涧彝族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巍山彝族回族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532928\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532929\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"云龙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532930\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洱源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532931\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"剑川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"532932\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鹤庆县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0692\",\r\n" + 
				"        \"adcode\": \"533100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"德宏\",\r\n" + 
				"        \"fullname\": \"德宏傣族景颇族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瑞丽市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芒市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"梁河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盈江县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陇川县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0886\",\r\n" + 
				"        \"adcode\": \"533300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"怒江\",\r\n" + 
				"        \"fullname\": \"怒江傈僳族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533301\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泸水市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福贡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贡山独龙族怒族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兰坪白族普米族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0887\",\r\n" + 
				"        \"adcode\": \"533400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"迪庆\",\r\n" + 
				"        \"fullname\": \"迪庆藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533401\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"香格里拉市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德钦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"533423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"维西傈僳族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"540000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"西藏\",\r\n" + 
				"    \"fullname\": \"西藏自治区\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0891\",\r\n" + 
				"        \"adcode\": \"540100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"拉萨\",\r\n" + 
				"        \"fullname\": \"拉萨市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城关区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"林周县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"当雄县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尼木县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曲水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"堆龙德庆区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"达孜县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"墨竹工卡县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0892\",\r\n" + 
				"        \"adcode\": \"540200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"日喀则\",\r\n" + 
				"        \"fullname\": \"日喀则市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桑珠孜区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南木林县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江孜县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定日县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"萨迦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"拉孜县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昂仁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"谢通门县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540228\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白朗县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540229\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仁布县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540230\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"康马县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540231\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定结县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540232\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"仲巴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540233\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"亚东县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540234\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉隆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540235\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"聂拉木县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540236\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"萨嘎县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540237\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岗巴县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0895\",\r\n" + 
				"        \"adcode\": \"540300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"昌都\",\r\n" + 
				"        \"fullname\": \"昌都市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卡若区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"江达县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贡觉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"类乌齐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丁青县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"察雅县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"八宿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"左贡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"芒康县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洛隆县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540330\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"边坝县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0893\",\r\n" + 
				"        \"adcode\": \"540500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"山南\",\r\n" + 
				"        \"fullname\": \"山南市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乃东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扎囊县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贡嘎县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"桑日县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"琼结县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曲松县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"措美县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洛扎县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"加查县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540529\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆子县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540530\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"错那县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540531\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"浪卡子县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0896\",\r\n" + 
				"        \"adcode\": \"542400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"那曲\",\r\n" + 
				"        \"fullname\": \"那曲地区\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"那曲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"嘉黎县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"比如县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"聂荣县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安多县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"申扎县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"索县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"班戈县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542429\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴青县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542430\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尼玛县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542431\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"双湖县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0897\",\r\n" + 
				"        \"adcode\": \"542500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阿里\",\r\n" + 
				"        \"fullname\": \"阿里地区\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"普兰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"札达县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"噶尔县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"日土县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"革吉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"改则县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"542527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"措勤县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0894\",\r\n" + 
				"        \"adcode\": \"540400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"林芝\",\r\n" + 
				"        \"fullname\": \"林芝市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴宜区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"工布江达县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"米林县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"墨脱县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"波密县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"察隅县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"540426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"朗县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"610000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"陕西\",\r\n" + 
				"    \"fullname\": \"陕西省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"029\",\r\n" + 
				"        \"adcode\": \"610100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"西安\",\r\n" + 
				"        \"fullname\": \"西安市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"碑林区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莲湖区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灞桥区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610112\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"未央区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610113\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"雁塔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610114\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阎良区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610115\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临潼区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610116\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610117\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蓝田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"周至县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄠邑区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0919\",\r\n" + 
				"        \"adcode\": \"610200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"铜川\",\r\n" + 
				"        \"fullname\": \"铜川市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"王益区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"印台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"耀州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜君县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0917\",\r\n" + 
				"        \"adcode\": \"610300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"宝鸡\",\r\n" + 
				"        \"fullname\": \"宝鸡市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"渭滨区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610304\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陈仓区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤翔县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岐山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"扶风县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"眉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陇县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"千阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610329\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麟游县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610330\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凤县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610331\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"太白县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0910\",\r\n" + 
				"        \"adcode\": \"610400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"咸阳\",\r\n" + 
				"        \"fullname\": \"咸阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秦都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杨陵区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610404\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"渭城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"三原县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泾阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乾县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"礼泉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610426\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永寿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610427\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"彬县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610428\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"长武县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610429\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"旬邑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610430\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"淳化县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610431\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武功县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610481\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴平市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0913\",\r\n" + 
				"        \"adcode\": \"610500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"渭南\",\r\n" + 
				"        \"fullname\": \"渭南市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临渭区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"潼关县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大荔县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"合阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"澄城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610526\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"蒲城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610527\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610528\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富平县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610581\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"韩城市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610582\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华阴市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0911\",\r\n" + 
				"        \"adcode\": \"610600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"延安\",\r\n" + 
				"        \"fullname\": \"延安市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宝塔区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"延长县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"延川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"子长县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安塞区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"志丹县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吴起县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610627\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"甘泉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610628\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610629\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洛川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610630\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宜川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610631\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄龙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610632\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"黄陵县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0916\",\r\n" + 
				"        \"adcode\": \"610700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"汉中\",\r\n" + 
				"        \"fullname\": \"汉中市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汉台区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"南郑县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城固县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洋县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西乡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"勉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁强县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610727\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"略阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610728\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇巴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610729\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"留坝县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610730\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"佛坪县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0912\",\r\n" + 
				"        \"adcode\": \"610800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"榆林\",\r\n" + 
				"        \"fullname\": \"榆林市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"榆阳区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"神木县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"府谷县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610803\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"横山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"靖边县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"定边县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"绥德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"米脂县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"佳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610829\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吴堡县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610830\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清涧县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610831\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"子洲县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0915\",\r\n" + 
				"        \"adcode\": \"610900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"安康\",\r\n" + 
				"        \"fullname\": \"安康市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汉滨区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"汉阴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"石泉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁陕县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"紫阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岚皋县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平利县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇坪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610928\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"旬阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"610929\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白河县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0914\",\r\n" + 
				"        \"adcode\": \"611000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"商洛\",\r\n" + 
				"        \"fullname\": \"商洛市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"611002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"商州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"611021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洛南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"611022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"丹凤县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"611023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"商南县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"611024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"山阳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"611025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"611026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柞水县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"620000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"甘肃\",\r\n" + 
				"    \"fullname\": \"甘肃省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0931\",\r\n" + 
				"        \"adcode\": \"620100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"兰州\",\r\n" + 
				"        \"fullname\": \"兰州市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城关区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"七里河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西固区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安宁区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620111\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红古区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永登县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"皋兰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"榆中县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1937\",\r\n" + 
				"        \"adcode\": \"620200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"嘉峪关\",\r\n" + 
				"        \"fullname\": \"嘉峪关市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0935\",\r\n" + 
				"        \"adcode\": \"620300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"金昌\",\r\n" + 
				"        \"fullname\": \"金昌市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永昌县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0943\",\r\n" + 
				"        \"adcode\": \"620400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"白银\",\r\n" + 
				"        \"fullname\": \"白银市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白银区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620403\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平川区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"靖远县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"会宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"景泰县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0938\",\r\n" + 
				"        \"adcode\": \"620500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"天水\",\r\n" + 
				"        \"fullname\": \"天水市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秦州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620503\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麦积区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"清水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"秦安县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"甘谷县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"张家川回族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1935\",\r\n" + 
				"        \"adcode\": \"620600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"武威\",\r\n" + 
				"        \"fullname\": \"武威市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620602\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"凉州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"民勤县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"古浪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天祝藏族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0936\",\r\n" + 
				"        \"adcode\": \"620700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"张掖\",\r\n" + 
				"        \"fullname\": \"张掖市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"甘州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620721\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肃南裕固族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"民乐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临泽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"山丹县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0933\",\r\n" + 
				"        \"adcode\": \"620800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"平凉\",\r\n" + 
				"        \"fullname\": \"平凉市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崆峒区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泾川县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"崇信县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华亭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庄浪县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"静宁县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0937\",\r\n" + 
				"        \"adcode\": \"620900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"酒泉\",\r\n" + 
				"        \"fullname\": \"酒泉市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620902\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肃州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金塔县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"瓜州县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"肃北蒙古族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿克塞哈萨克族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620981\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉门市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"620982\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"敦煌市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0934\",\r\n" + 
				"        \"adcode\": \"621000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"庆阳\",\r\n" + 
				"        \"fullname\": \"庆阳市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西峰区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"庆城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"环县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"华池县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"合水县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"正宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621027\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"镇原县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0932\",\r\n" + 
				"        \"adcode\": \"621100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"定西\",\r\n" + 
				"        \"fullname\": \"定西市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"安定区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"通渭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"陇西县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"渭源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临洮县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"漳县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岷县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"2935\",\r\n" + 
				"        \"adcode\": \"621200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"陇南\",\r\n" + 
				"        \"fullname\": \"陇南市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"武都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"成县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"文县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"宕昌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"康县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"礼县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"徽县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"621228\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"两当县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0930\",\r\n" + 
				"        \"adcode\": \"622900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"临夏\",\r\n" + 
				"        \"fullname\": \"临夏回族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"622901\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临夏市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"622921\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临夏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"622922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"康乐县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"622923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永靖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"622924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"广河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"622925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和政县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"622926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"东乡族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"622927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"积石山保安族东乡族撒拉族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0941\",\r\n" + 
				"        \"adcode\": \"623000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"甘南\",\r\n" + 
				"        \"fullname\": \"甘南藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"623001\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"合作市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"623021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"临潭县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"623022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"卓尼县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"623023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"舟曲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"623024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"迭部县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"623025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玛曲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"623026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"碌曲县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"623027\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"夏河县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"630000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"青海\",\r\n" + 
				"    \"fullname\": \"青海省\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0971\",\r\n" + 
				"        \"adcode\": \"630100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"西宁\",\r\n" + 
				"        \"fullname\": \"西宁市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城中区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城西区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"城北区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大通回族土族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湟中县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"湟源县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0972\",\r\n" + 
				"        \"adcode\": \"630200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"海东\",\r\n" + 
				"        \"fullname\": \"海东市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乐都区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平安区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"民和回族土族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"互助土族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"化隆回族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"630225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"循化撒拉族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0970\",\r\n" + 
				"        \"adcode\": \"632200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"海北\",\r\n" + 
				"        \"fullname\": \"海北藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"门源回族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"祁连县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海晏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"刚察县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0973\",\r\n" + 
				"        \"adcode\": \"632300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"黄南\",\r\n" + 
				"        \"fullname\": \"黄南藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"同仁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尖扎县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泽库县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"河南蒙古族自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0974\",\r\n" + 
				"        \"adcode\": \"632500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"海南\",\r\n" + 
				"        \"fullname\": \"海南藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"共和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"同德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632523\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贵德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632524\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴海县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632525\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贵南县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0975\",\r\n" + 
				"        \"adcode\": \"632600\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"果洛\",\r\n" + 
				"        \"fullname\": \"果洛藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632621\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玛沁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632622\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"班玛县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632623\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"甘德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632624\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"达日县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632625\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"久治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632626\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玛多县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0976\",\r\n" + 
				"        \"adcode\": \"632700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"玉树\",\r\n" + 
				"        \"fullname\": \"玉树藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632701\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玉树市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"杂多县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"称多县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632724\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"治多县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632725\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"囊谦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632726\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"曲麻莱县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0977\",\r\n" + 
				"        \"adcode\": \"632800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"海西\",\r\n" + 
				"        \"fullname\": \"海西蒙古族藏族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632801\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"格尔木市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632802\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"德令哈市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632821\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌兰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"都兰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天峻县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"632825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海西蒙古族藏族自治州直辖\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"640000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"宁夏\",\r\n" + 
				"    \"fullname\": \"宁夏回族自治区\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0951\",\r\n" + 
				"        \"adcode\": \"640100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"银川\",\r\n" + 
				"        \"fullname\": \"银川市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"兴庆区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西夏区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"金凤区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"永宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"贺兰县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640181\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"灵武市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0952\",\r\n" + 
				"        \"adcode\": \"640200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"石嘴山\",\r\n" + 
				"        \"fullname\": \"石嘴山市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"大武口区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"惠农区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"平罗县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0953\",\r\n" + 
				"        \"adcode\": \"640300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"吴忠\",\r\n" + 
				"        \"fullname\": \"吴忠市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"利通区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640303\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"红寺堡区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"盐池县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"同心县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640381\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青铜峡市\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0954\",\r\n" + 
				"        \"adcode\": \"640400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"固原\",\r\n" + 
				"        \"fullname\": \"固原市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"原州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"西吉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640423\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"隆德县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640424\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泾源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640425\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"彭阳县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1953\",\r\n" + 
				"        \"adcode\": \"640500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"中卫\",\r\n" + 
				"        \"fullname\": \"中卫市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙坡头区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"中宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"640522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"海原县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"adcode\": \"650000\",\r\n" + 
				"    \"level\": \"province\",\r\n" + 
				"    \"name\": \"新疆\",\r\n" + 
				"    \"fullname\": \"新疆维吾尔自治区\",\r\n" + 
				"    \"districts\": [\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0991\",\r\n" + 
				"        \"adcode\": \"650100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"乌鲁木齐\",\r\n" + 
				"        \"fullname\": \"乌鲁木齐市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650102\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"天山区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650103\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙依巴克区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650104\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新市区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650105\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"水磨沟区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650106\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"头屯河区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650107\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"达坂城区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650109\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"米东区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌鲁木齐县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0990\",\r\n" + 
				"        \"adcode\": \"650200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"克拉玛依\",\r\n" + 
				"        \"fullname\": \"克拉玛依市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"独山子区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650203\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"克拉玛依区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650204\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"白碱滩区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650205\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌尔禾区\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0995\",\r\n" + 
				"        \"adcode\": \"650400\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"吐鲁番\",\r\n" + 
				"        \"fullname\": \"吐鲁番市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650402\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"高昌区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650421\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"鄯善县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650422\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"托克逊县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0902\",\r\n" + 
				"        \"adcode\": \"650500\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"哈密\",\r\n" + 
				"        \"fullname\": \"哈密市\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650502\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伊州区\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650521\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴里坤哈萨克自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"650522\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伊吾县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0994\",\r\n" + 
				"        \"adcode\": \"652300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"昌吉\",\r\n" + 
				"        \"fullname\": \"昌吉回族自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652301\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昌吉市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652302\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阜康市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"呼图壁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"玛纳斯县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"奇台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652327\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉木萨尔县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652328\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"木垒哈萨克自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0909\",\r\n" + 
				"        \"adcode\": \"652700\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"博尔塔拉\",\r\n" + 
				"        \"fullname\": \"博尔塔拉蒙古自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652701\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博乐市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652702\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿拉山口市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652722\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"精河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652723\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"温泉县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0996\",\r\n" + 
				"        \"adcode\": \"652800\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"巴州\",\r\n" + 
				"        \"fullname\": \"巴音郭楞蒙古自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652801\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"库尔勒市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652822\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"轮台县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652823\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尉犁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652824\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"若羌县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652825\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"且末县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652826\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"焉耆回族自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652827\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和静县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652828\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和硕县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652829\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"博湖县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0997\",\r\n" + 
				"        \"adcode\": \"652900\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阿克苏\",\r\n" + 
				"        \"fullname\": \"阿克苏地区\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652901\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿克苏市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652922\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"温宿县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652923\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"库车县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652924\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙雅县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652925\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新和县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652926\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"拜城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652927\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌什县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652928\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿瓦提县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"652929\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"柯坪县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0908\",\r\n" + 
				"        \"adcode\": \"653000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"克州\",\r\n" + 
				"        \"fullname\": \"克孜勒苏柯尔克孜自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653001\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿图什市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿克陶县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿合奇县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌恰县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0998\",\r\n" + 
				"        \"adcode\": \"653100\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"喀什\",\r\n" + 
				"        \"fullname\": \"喀什地区\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653101\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"喀什市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653121\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"疏附县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653122\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"疏勒县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653123\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"英吉沙县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653124\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"泽普县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653125\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"莎车县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653126\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"叶城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653127\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"麦盖提县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653128\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"岳普湖县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653129\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伽师县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653130\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巴楚县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653131\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"塔什库尔干塔吉克自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0903\",\r\n" + 
				"        \"adcode\": \"653200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"和田\",\r\n" + 
				"        \"fullname\": \"和田地区\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653201\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和田市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653222\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"墨玉县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"皮山县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"洛浦县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"策勒县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"于田县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"653227\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"民丰县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0999\",\r\n" + 
				"        \"adcode\": \"654000\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"伊犁\",\r\n" + 
				"        \"fullname\": \"伊犁哈萨克自治州\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654002\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伊宁市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654003\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"奎屯市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654004\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霍尔果斯市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654021\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"伊宁县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654022\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"察布查尔锡伯自治县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654023\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"霍城县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654024\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"巩留县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654025\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"新源县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654026\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"昭苏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654027\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"特克斯县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654028\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"尼勒克县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0901\",\r\n" + 
				"        \"adcode\": \"654200\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"塔城\",\r\n" + 
				"        \"fullname\": \"塔城地区\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654201\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"塔城市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654202\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"乌苏市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654221\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"额敏县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654223\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"沙湾县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654224\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"托里县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654225\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"裕民县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654226\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"和布克赛尔蒙古自治县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0906\",\r\n" + 
				"        \"adcode\": \"654300\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阿勒泰\",\r\n" + 
				"        \"fullname\": \"阿勒泰地区\",\r\n" + 
				"        \"districts\": [\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654301\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"阿勒泰市\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654321\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"布尔津县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654322\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"富蕴县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654323\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"福海县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654324\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"哈巴河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654325\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"青河县\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"adcode\": \"654326\",\r\n" + 
				"            \"level\": \"district\",\r\n" + 
				"            \"name\": \"吉木乃县\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"0993\",\r\n" + 
				"        \"adcode\": \"659001\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"石河子\",\r\n" + 
				"        \"fullname\": \"石河子市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1997\",\r\n" + 
				"        \"adcode\": \"659002\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"阿拉尔\",\r\n" + 
				"        \"fullname\": \"阿拉尔市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1998\",\r\n" + 
				"        \"adcode\": \"659003\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"图木舒克\",\r\n" + 
				"        \"fullname\": \"图木舒克市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1994\",\r\n" + 
				"        \"adcode\": \"659004\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"五家渠\",\r\n" + 
				"        \"fullname\": \"五家渠市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1906\",\r\n" + 
				"        \"adcode\": \"659005\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"北屯\",\r\n" + 
				"        \"fullname\": \"北屯市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1996\",\r\n" + 
				"        \"adcode\": \"659006\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"铁门关\",\r\n" + 
				"        \"fullname\": \"铁门关市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1909\",\r\n" + 
				"        \"adcode\": \"659007\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"双河\",\r\n" + 
				"        \"fullname\": \"双河市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1999\",\r\n" + 
				"        \"adcode\": \"659008\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"可克达拉\",\r\n" + 
				"        \"fullname\": \"可克达拉市\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"citycode\": \"1903\",\r\n" + 
				"        \"adcode\": \"659009\",\r\n" + 
				"        \"level\": \"city\",\r\n" + 
				"        \"name\": \"昆玉\",\r\n" + 
				"        \"fullname\": \"昆玉市\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";

		// 获取所有的省JSON
		JSONArray ja = new JSONArray(jsonText);

		// 创建返回实体类
		Area area = new Area();
		List<Area> addDistricts = new ArrayList<Area>();

		for (int i = 0; i < ja.length(); i++) {
			// 省json字符---
			String shenText = ja.getJSONObject(i).toString();

			// 省名称
			String shenName = ja.getJSONObject(i).get("name").toString();
			if (level == 1 && shenName.equals(cityName)) {
				area.setName(shenName);
				area.setAdcode(ja.getJSONObject(i).get("adcode").toString());
				area.setLevel("province");
			}

			// 市json
			JSONObject shiJson = new JSONObject(shenText);
			int shiNum = shiJson.getJSONArray("districts").length();
			if (shiNum < 1) {
				continue;
			}
			// 市json字符串
			String shiText = shiJson.getJSONArray("districts").toString();

			// System.out.println("市："+shiText);
			for (int j = 0; j < shiNum; j++) {
				// 具体市json----
				JSONArray shiJson2 = new JSONArray(shiText);
				// 具体市json字符
				String shiText2 = shiJson2.getJSONObject(j).toString();
				// System.out.println(shiText2);
				if (level == 1) {
					if (shenName.equals(cityName)) {
						String adcode = shiJson2.getJSONObject(j).get("adcode").toString();
						String citylevel = shiJson2.getJSONObject(j).get("level").toString();
						String name = shiJson2.getJSONObject(j).get("name").toString();
						String fullname = "";
						try {
							fullname = shiJson2.getJSONObject(j).get("fullname").toString();
						} catch (Exception e) {
							fullname = name;
						}
						Area tempArea = new Area();
						tempArea.setAdcode(adcode);
						tempArea.setFullname(fullname);
						tempArea.setLevel(citylevel);
						tempArea.setName(name);
						addDistricts.add(tempArea);
					}
				}

				String shiName = null;
				try {
					shiName = shiJson2.getJSONObject(j).get("fullname").toString();
				} catch (JSONException e1) {
					shiName = shiJson2.getJSONObject(j).get("name").toString();
				}

				if (level == 2 && shiName.equals(cityName)) {
					area.setName(shiName);
					area.setAdcode(shiJson2.getJSONObject(j).get("adcode").toString());
					area.setLevel("city");
				}

				// 所有区json
				JSONObject quAllJson = new JSONObject(shiText2);
				// 所有区字符串
				String quAllText = "";
				int quNum = 0;
				try {
					quNum = quAllJson.getJSONArray("districts").length();
					if (quNum >= 1) {
						quAllText = quAllJson.getJSONArray("districts").toString();
					} else {
						continue;
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					continue;
				}

				for (int k = 0; k < quAllJson.getJSONArray("districts").length(); k++) {
					// // 具体区json
					JSONArray quJson = new JSONArray(quAllText);
					// 具体json字符
//					String quText = quJson.getJSONObject(k).toString();

					if (level == 2) {
						if (shiName.equals(cityName)) {
							String adcode = quJson.getJSONObject(k).get("adcode").toString();
							String citylevel = quJson.getJSONObject(k).get("level").toString();
							String name = quJson.getJSONObject(k).get("name").toString();
							Area tempArea = new Area();
							tempArea.setAdcode(adcode);
							tempArea.setLevel(citylevel);
							tempArea.setName(name);
							addDistricts.add(tempArea);
						}
					}
					String quName = quJson.getJSONObject(k).get("name").toString();
					if (quName.equals(cityName) && level == 3) {
						area.setAdcode(quJson.getJSONObject(k).get("adcode").toString());
						area.setLevel(quJson.getJSONObject(k).get("level").toString());
						area.setName(quName);
					}
				}

			}

		}
		area.setDistricts(addDistricts);
		return area;
	}
}
