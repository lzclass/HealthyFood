package com.lz.healthfood.net;

import java.util.HashMap;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

import com.lz.healthfood.Utils.UtilsLog;

/**
 * 网络管理类（需要可扩展）
 * 
 * @author:LZ
 * @Date:2014年5月21日
 */
public class NetManager {

	public static final String ENCODING = "UTF-8";
	public static final String HTTP_SAFETY_SCHEME = "https";
	public static final String HTTP_SCHEME = "http";

	public static final String METHOD = "aosservice.aspx";
	/** 请求接口 */
	public static final String HTTP_HOST = "erpapi.test.fang.com/";
	public static final String HTTP_URL = HTTP_SCHEME + "://" + HTTP_HOST;
	private HttpClient client;

	public NetManager() {
		client = getHttpClient();
	}

	/** 最大连接数 */
	protected final static int MAX_TOTAL_CONNECTIONS = 150;

	/** 连接池获取连接的最大等待时间 */
	protected final static int WAIT_TIMEOUT = 1000;

	/** 每个路由最大连接数 */
	protected final static int MAX_ROUTE_CONNECTIONS = 80;

	/** 设置连接超时时间 */
	protected final static int CONNECT_TIMEOUT = 12000;

	/** socket读取数据超时时间 */
	protected final static int READ_TIMEOUT = 20000;

	/**
	 * 用到新接口的几个参数
	 * 房源采集接口（手机),客源列表接口（手机）,客源详情接口（手机）,客源录入/修改接口（手机）,登陆接口（手机）,获取房客源自定制选项设置
	 * ,房源列表接口（手机）,房源详情接口（手机）,房源录入 /修改接口（手机）
	 */
	private static HashMap<String, String> mapHeads = new HashMap<String, String>();

	/**
	 * 获取HttpClient
	 * 
	 * @return
	 */
	public static synchronized DefaultHttpClient getHttpClient() {

		HttpParams params = createHttpParams();
		SchemeRegistry registry = new SchemeRegistry();
		registry.register(new Scheme(HTTP_SCHEME, PlainSocketFactory
				.getSocketFactory(), 80));
		registry.register(new Scheme(HTTP_SAFETY_SCHEME, SSLSocketFactory
				.getSocketFactory(), 443));

		ClientConnectionManager connectionManager = new ThreadSafeClientConnManager(
				params, registry);
		DefaultHttpClient httpclient = new DefaultHttpClient(connectionManager,
				params);

		return httpclient;
	}

	/**
	 * 设置HttpParams
	 * 
	 * @return
	 */
	private static final HttpParams createHttpParams() {
		HttpParams httpParams = new BasicHttpParams();
		HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
		// 设置最大连接数
		ConnManagerParams.setMaxTotalConnections(httpParams,
				MAX_TOTAL_CONNECTIONS);
		// 设置从连接池获取连接的最大等待时间
		ConnManagerParams.setTimeout(httpParams, WAIT_TIMEOUT);
		// 设置每个路由最大连接数
		ConnPerRouteBean connPerRoute = new ConnPerRouteBean(
				MAX_ROUTE_CONNECTIONS);
		ConnManagerParams.setMaxConnectionsPerRoute(httpParams, connPerRoute);
		// 设置连接超时时间
		HttpConnectionParams.setConnectionTimeout(httpParams, CONNECT_TIMEOUT);
		// 设置socket读取数据超时时间
		HttpConnectionParams.setSoTimeout(httpParams, READ_TIMEOUT);
		// 设置以Socket 缓存大小
		HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
		HttpConnectionParams.setStaleCheckingEnabled(httpParams, false);
		// 设置重定向，缺省为 true , 这里设置成不重定向
		HttpClientParams.setRedirecting(httpParams, false);
		return httpParams;
	}

	public void close() {
		try {
			client.getConnectionManager().shutdown();
		} catch (Exception e) {
			UtilsLog.w("AOS", e.getMessage());
		}
	}

}
