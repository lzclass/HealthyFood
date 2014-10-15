package com.lz.healthfood.Utils;

import android.util.Log;

/**
 * @Description:打印日志
 * @author:LiuZhao  
 * @Date:2014年10月15日
 */
public class UtilsLog {

	private static final boolean LOG = true;// true
	// 用来防止msg为空时的异常
	private static final String NULL_STR = "msg is null!";

	public static void v(String tag, String msg) {
		if (LOG)
			Log.v(tag, msg != null ? msg : NULL_STR);

	}

	public static void v(String tag, String msg, Throwable tr) {
		if (LOG)
			Log.v(tag, msg != null ? msg : NULL_STR, tr);
	}

	public static void d(String tag, String msg) {
		if (LOG)
			Log.d(tag, msg != null ? msg : NULL_STR);
	}

	public static void d(String tag, String msg, Throwable tr) {
		if (LOG)
			Log.d(tag, msg != null ? msg : NULL_STR, tr);
	}

	public static void i(String tag, String msg) {
		if (LOG)
			Log.i(tag, msg != null ? msg : NULL_STR);
	}

	public static void i(String tag, String msg, Throwable tr) {
		if (LOG)
			Log.i(tag, msg != null ? msg : NULL_STR, tr);
	}

	public static void w(String tag, String msg) {
		if (LOG)
			Log.w(tag, msg != null ? msg : NULL_STR);
	}

	public static void w(String tag, String msg, Throwable tr) {
		if (LOG)
			Log.w(tag, msg != null ? msg : NULL_STR, tr);
	}

	public static void e(String tag, String msg) {
		if (LOG)
			Log.e(tag, msg != null ? msg : NULL_STR);
	}

}
