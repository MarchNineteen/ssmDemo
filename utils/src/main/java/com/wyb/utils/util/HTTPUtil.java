package com.wyb.utils.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.SSLProtocolSocketFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: RequestUtils
 * @Description: 请求工具类
 *
 */
public final class HTTPUtil {
	
	private static final Logger logger = Logger.getLogger(HTTPUtil.class);
	private final static String GET = "get";
	private final static String POST = "post";

	/**
	 * post请求
	 * 
	 * @param uri
	 * @return
	 */
	public static String post(String uri, String postbody) {
		return post(uri, null, postbody);
	}

	/**
	 * post请求
	 * 
	 * @param uri
	 * @param params
	 * @return
	 */
	public static String post(String uri, Map<String, String> params) {
		return post(uri, params, null);
	}

	/**
	 * post请求
	 * 
	 * @param uri
	 * @param params
	 * @return
	 */
	public static String post(String uri, Map<String, String> params,String postbody) {
		return requestString(uri, POST, params, postbody);
	}

	/**
	 * GET请求
	 * 
	 * @param uri
	 * @param params
	 * @return
	 */
	public static String get(String uri, Map<String, String> params) {
		return requestString(uri, GET, params, null);
	}
	
	/**
	 * GET请求
	 * 
	 * @param uri
	 * @param params
	 * @return
	 */
	public static JSONObject requestJSON(String uri, Map<String, String> params) {
		String res = requestString(uri, GET, params, null);
		return JSON.parseObject(res);
	}

	/**
	 * 发送请求
	 * 
	 * @param uri
	 * @param method
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String requestString(String uri,String method,Map<String, String> params,String postbody) {
		String result = "";
		HttpMethodBase httpMethod = null;
		try {
			if (StringUtils.startsWith(uri, "https")) {
				ProtocolSocketFactory protocolSocketFactory = new SSLProtocolSocketFactory();
				Protocol https = new Protocol("https", protocolSocketFactory,443);
				Protocol.registerProtocol("https", https);
			}
			HttpClient httpClient = new HttpClient();
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
			httpMethod = initMethod(uri, method, params, postbody);
			int statusCode = httpClient.executeMethod(httpMethod);
			BufferedReader in = new BufferedReader(new InputStreamReader(httpMethod.getResponseBodyAsStream(), "UTF-8"));
			String line = "";
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.error("http request==================================================");
			logger.error("http request url :"+ uri);
			logger.error("http request response :" + result);
			logger.error("http request==================================================");
		} catch (UnsupportedEncodingException e) {
			logger.error("请求" + uri + "异常", e);
		} catch (HttpException e) {
			logger.error("请求" + uri + "异常", e);
		} catch (IOException e) {
			logger.error("请求" + uri + "异常", e);
		} finally {
			if (null != httpMethod)
				httpMethod.releaseConnection();
		}
		return result;
	}

	/**
	 * 
	 * @Title: initMethod
	 * @Description: 初始化请求方式
	 * @param uri
	 * @param method
	 * @param params
	 * @param postbody
	 * @return
	 * @throws UnsupportedEncodingException
	 * @return HttpMethodBase
	 * @throws
	 */
	private static HttpMethodBase initMethod(String uri, String method, Map<String, String> params, String postbody)
			throws UnsupportedEncodingException {
		if (StringUtils.equalsIgnoreCase(GET, method)) {
			return new GetMethod(formatMapToUrl(uri, params));
		} else if (StringUtils.equalsIgnoreCase(POST, method)) {
			PostMethod httpMethod = new PostMethod(formatMapToUrl(uri, params));
			if (null != params && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				Iterator<String> it = params.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					pairs.add(new NameValuePair(key, params.get(key)));
				}
				httpMethod.addParameters(pairs.toArray(new NameValuePair[0]));
			}
			if (StringUtils.isNotEmpty(postbody)) {
				RequestEntity requestEntity = new StringRequestEntity(postbody,
						null, "utf-8");
				httpMethod.setRequestEntity(requestEntity);
			}
			return httpMethod;
		}
		return null;
	}

	/**
	 * @throws UnsupportedEncodingException
	 * 
	 * @Title: formatMapToUrl
	 * @Description: URL拼接
	 * @param uri
	 * @param params
	 * @return
	 * @return String
	 * @throws
	 */
	private static String formatMapToUrl(String uri, Map<String, String> params)
			throws UnsupportedEncodingException {
		StringBuilder urlBuilder = new StringBuilder(uri);
		if (null != params && !params.isEmpty()) {
			urlBuilder.append("?");
			Iterator<String> it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				urlBuilder.append(key).append("=").append(URLEncoder.encode(params.get(key), "UTF-8"));
				if (it.hasNext())
					urlBuilder.append("&");
			}
		}
		return urlBuilder.toString();
	}
	
	/**
	 * 向后台发送post请求
	 * @param param
	 * @param url
	 * @return
	 */
	public static String postJson(String param, String url) {
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(50000);
			conn.setReadTimeout(50000);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "token");
			conn.setRequestProperty("tag", "htc_new");

			conn.connect();
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(param);

			out.flush();
			out.close();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}


	public static String getIpAddr(HttpServletRequest request){
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
		// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
}
