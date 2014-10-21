package com.lz.healthfood.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lz.healthfood.entity.FoodList;
import com.lz.healthfood.entity.ReslutList;

/**
 * @Description:网络请求工具类,服务器连接接口用
 * @author:LiuZhao
 * @Date:2014年10月15日
 */
public class HttpApi {

	/** log日志标识类 */
	private final static String TAG = HttpApi.class.getSimpleName();

	@SuppressWarnings("unchecked")
	public static ReslutList<FoodList> getListData() {
		ReslutList<FoodList> reslutList = new ReslutList<FoodList>();
		reslutList = (ReslutList<FoodList>) getNetDataBean("list",
				ReslutList.class);

		return reslutList;
	}

	/**
	 * @param
	 * @return
	 */
	public static <T> T getNetDataBean(String param1, Class<T> clszz) {

		String result = null;
		HttpGet request = new HttpGet(NetManager.HTTP_URL + param1);
		request.setHeader("Accept", "application/json");

		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpResponse response;
		try {
			response = httpClient.execute(request);

			if (response.getStatusLine().getStatusCode() == 200) {

				HttpEntity responseEntity = response.getEntity();
				result = EntityUtils.toString(responseEntity);
				Gson gson = new Gson();
				// TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换
				// List<T> list = gson.fromJson(result, new TypeToken<List<T>>()
				// {
				// }.getType());
				T t = gson.fromJson(result, clszz);
				return t;

			}

		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;

	}

}
