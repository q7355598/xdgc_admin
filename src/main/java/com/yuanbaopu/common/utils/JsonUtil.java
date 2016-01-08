package com.yuanbaopu.common.utils;

import org.apache.commons.lang.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	/**
	 * 对象转JSON字符串
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String writeAsString(Object data) throws Exception {
		if (data == null)
			return null;
		ObjectMapper jsonOM = new ObjectMapper();
		return jsonOM.writeValueAsString(data);
	}

	/**
	 * JSON字符串转对象
	 * 
	 * @param json
	 * @param targetC
	 * @return
	 * @throws Exception
	 */
	public static <T> T readAsObject(String json, Class<T> targetC) throws Exception {
		if (targetC == null || StringUtils.isEmpty(json))
			return null;
		ObjectMapper jsonOM = new ObjectMapper();
		return (T) jsonOM.readValue(json, targetC);
	}

}
