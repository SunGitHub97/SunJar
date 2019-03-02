package com.filldream.sun.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filldream.sun.sunEntity.Area;

/**
 * 省市区工具类
 * @author RickSun
 *
 */
public class ChAddressUtil {
	/**
	 * 根据省市区获取下级所有行政单位
	 * @param level  1-省 2-市 3-区
	 * @param cityName 省市区名字
	 * @return
	 */
	public static Area getLowerCity(Integer level, String cityName) {


		URL url2 = ChAddressUtil.class.getResource("/file/area2.txt");
	
		String jsonText = FileIOUtil.FileToString(new File(url2.getFile()));
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
