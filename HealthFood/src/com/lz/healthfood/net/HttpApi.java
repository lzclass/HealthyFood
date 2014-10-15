package com.lz.healthfood.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

import com.lz.healthfood.Utils.StringUtils;
import com.lz.healthfood.Utils.UtilsLog;

/**
 * @Description:网络请求工具类,服务器连接接口用
 * @author:LiuZhao
 * @Date:2014年10月15日
 */
public class HttpApi {

	/** log日志标识类 */
	private final static String TAG = HttpApi.class.getSimpleName();

	/**
	 * 通过网络返回实体
	 * 
	 * @param user
	 * @param pass
	 * @return
	 * @return
	 */
	public static <T> T getLogin(String user, String pass) {

		String result = null;
		HttpGet request = new HttpGet(NetManager.HTTP_URL + "?username=" + user
				+ "&password=" + pass);
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpResponse response;
		try {
			response = httpClient.execute(request);

			if (response.getStatusLine().getStatusCode() == 200) {

				HttpEntity responseEntity = response.getEntity();
				result = EntityUtils.toString(responseEntity);

//				return JsonUtils.praseLogin(result);

			}

		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;

	}

}
