package com.lz.healthfood.Utils;

/**
 * @Description:
 * @author:LiuZhao
 * @Date:2014��10��15��
 */
public class StringUtils {
	/**
	 * �ж��Ƿ�Ϊ��
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isNullOrEmpty(String text) {
		if (text == null || "".equals(text.trim()) || text.trim().length() == 0
				|| "null".equals(text.trim())) {
			return true;
		} else {
			return false;
		}
	}
}
