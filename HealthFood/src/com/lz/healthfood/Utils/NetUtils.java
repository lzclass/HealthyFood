package com.lz.healthfood.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @Description:网络检测类
 * @author:LiuZhao
 * @Date:2014年10月15日
 */
public class NetUtils {

	/**
	 * @Description:是否联网
	 * @param context
	 * @return
	 * @author: LiuZhao
	 * @date:2014年10月15日
	 */

	public static boolean isNetConn(Context context) {
		try {
			ConnectivityManager connectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo info = connectivityManager.getActiveNetworkInfo();
			if (info != null && info.isAvailable()) {
				String name = info.getTypeName();
				UtilsLog.v("isNetConn", "联网方式" + name);
				return true;
			} else {
				UtilsLog.v("isNetConn", "断网");
				return false;
			}
		} catch (Exception e) {
			UtilsLog.w("NetUtils", e.toString());
		}
		return false;
	}
}
