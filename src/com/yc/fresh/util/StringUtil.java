package com.yc.fresh.util;

public class StringUtil {
	/**
	 * 判空
	 * @param strs
	 * @return
	 */
	public static boolean checkNull(String ... strs) {
		if (strs == null || strs.length <= 0) {
			return true;
		}
		
		for (String str : strs) {
			if (str == null || "".equals(str)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean checkNull(Object ... objs) {
		if (objs == null || objs.length <= 0) {
			return true;
		}
		
		for (Object obj : objs) {
			if (obj == null || "".equals(obj)) {
				return true;
			}
		}
		
		return false;
	}


}
