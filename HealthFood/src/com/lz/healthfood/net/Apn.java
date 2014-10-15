package com.lz.healthfood.net;

import java.util.HashMap;
import java.util.Map;

public class Apn {
	// APN 名称
	public static String APN_CMWAP = "cmwap";// 中国移动
	public static String APN_CMNET = "cmnet";
	public static String APN_3GWAP = "3gwap";// 联通接入点
	public static String APN_3GNET = "3gnet";
	public static String APN_UNIWAP = "uniwap";// Unicom Net的缩写,它是中国联通GPRS网络接入点
	public static String APN_UNINET = "uninet";
	public static String APN_CTWAP = "ctwap";// 中国电信
	public static String APN_CTNET = "ctnet";
	/** 手机串号 */
	public static String imei = "";
	/** 手机号码 */
	public static String phoneNumber = "";
	/** 版本号 */
	public static String version = "";
	/** 手机系统版本 */
	public static final String osVersion = android.os.Build.VERSION.RELEASE;
	/** 手机型号 */
	public static final String model = android.os.Build.MODEL;
	/** 联网方式 */
	public static String conn_mode = "";
	/** 编码方式 */
	public static final String ENCODING_UTF8 = "UTF-8";

	public static Map<String, String> getHeads() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Accept-Encoding", ENCODING_UTF8);// 压缩方式
		return map;
	}

}
