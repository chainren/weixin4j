/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.exception.WeixinException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * <p>
 * Description： HTTP 请求工具类，用于发送http请求xml报文，返回服务器响应数据
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月11日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class HttpConnectionUtils {

	private static Logger logger = LoggerFactory
			.getLogger(HttpConnectionUtils.class);

	/**
	 * 发送请求，将请求结果返回
	 * 
	 * @param urlStr
	 *            服务器url
	 * @param xml
	 *            需要发送的xml报文
	 * @return 服务器响应的数据
	 */
	public static String httpRequest(String requestUrl, String requestMethod,
			String outputStr) throws WeixinException {
		URL url = null;
		HttpURLConnection conn = null;

		InputStream in = null;
		String resp = "";
		try {
			url = new URL(requestUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			conn.setConnectTimeout(WeixinConstants.REQUEST_TIMEOUT);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			/** 连接 **/
			conn.connect();
			if (StringUtils.isNotEmpty(outputStr)) {
				OutputStream out = conn.getOutputStream();
				/** 发送请求 **/
				out.write(outputStr.getBytes(WeixinConstants.ENCODING));
				out.flush();
				out.close();
			}
			/** 处理响应数据 **/
			in = conn.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			StringBuffer sbuff = new StringBuffer();
			String str = null;
			while ((str = reader.readLine()) != null) {
				sbuff.append(str);
			}
			// 关闭连接
			in.close();
			conn.disconnect();
			resp = sbuff.toString();
			logger.debug("respinfo:" + sbuff);
		} catch (Exception e) {
			logger.error("Can't open a http connection, please check the url formater."
					+ e);
			throw new WeixinException(
					"Can't open a http connection, please check the url formater.");
		}
		return resp;
	}

	/**
	 * 基于https的消息处理
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return
	 */
	public static JsonObject httpsRequest(String requestUrl,
			String requestMethod, String outputStr) throws WeixinException {
		JsonObject jsonObj = null;
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new WTrustManager() };
		try {
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url
					.openConnection();
			httpsURLConnection.setSSLSocketFactory(ssf);
			httpsURLConnection.setDoOutput(true);
			httpsURLConnection.setDoInput(true);
			httpsURLConnection.setUseCaches(false);
			// 请求方式
			httpsURLConnection.setRequestMethod(requestMethod);
			httpsURLConnection.connect();

			if (StringUtils.isNotEmpty(outputStr)) {
				OutputStream os = httpsURLConnection.getOutputStream();
				// 设置编码
				os.write(outputStr.getBytes(WeixinConstants.ENCODING));
				os.flush();
				os.close();
			}

			// 接收响应数据
			InputStream is = httpsURLConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,
					WeixinConstants.ENCODING);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sbuff = new StringBuffer();
			String str = null;
			while ((str = br.readLine()) != null) {
				sbuff.append(str);
			}
			isr.close();
			br.close();
			// 释放连接
			is.close();
			httpsURLConnection.disconnect();

			// 解析响应数据
			Gson gson = new Gson();
			jsonObj = gson.fromJson(sbuff.toString(), JsonObject.class);
			logger.debug(jsonObj.toString());
		} catch (Exception e) {
			logger.error("Can't open a http connection, please check the url formater."
					+ e);
			throw new WeixinException(
					"Can't open a http connection, please check the url formater.");
		}
		return jsonObj;
	}
}
