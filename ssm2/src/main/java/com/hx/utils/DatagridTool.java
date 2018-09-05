package com.hx.utils;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

public class DatagridTool {
	public static String listToJson(List list) {
		String baseJson = JSONArray.toJSONString(list);
		StringBuffer datagridFrame = new StringBuffer("{\"rows\":");
		datagridFrame.append(baseJson).append("}");
		return datagridFrame.toString();
	}
}
