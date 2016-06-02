/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.msg;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.entity.QRCodeTicket;
import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.entity.WeixinInterface;
import org.weixin4j.exception.WeixinException;
import org.weixin4j.net.HttpConnectionUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * <p>
 * Description： 二维码调用处理类
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年4月4日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class QRCodeHandler {
	private static Logger logger = LoggerFactory.getLogger(QRCodeHandler.class);

	/**
	 * 
	 */
	public QRCodeHandler() {

	}

	/**
	 * 调用创建二维码接口，并获取返回二维码兑换ticket
	 * 
	 * @param access_token
	 * @param qrjson
	 * @return
	 */
	public static QRCodeTicket createQrcode(String access_token, String qrjson)
			throws WeixinException {
		logger.debug("调用创建二维码接口：" + qrjson);
		if (StringUtils.isNotEmpty(qrjson)) {
			String requestUrl = WeixinInterface.URL_QRCODE_CREATE.replace(
					WeixinConstants.REPLACE_TOKEN, access_token);
			JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl,
					WeixinConstants.REQUESTMETHOD_POST, qrjson);
			if (jsonObj != null) {
				Gson gson = new Gson();
				QRCodeTicket ticket = gson
						.fromJson(jsonObj, QRCodeTicket.class);
				return ticket;
			}
		}
		return null;
	}

	/**
	 * 获取二维码图片，并保存到本地路径
	 * 
	 * @param ticket
	 * @param savePath
	 *            在应用中最好定义常量
	 * @return
	 */
	public static String getQrcode(String ticket, String savePath)
			throws WeixinException {
		logger.debug("获取二维码，兑换码：" + ticket);
		String filePath = null;
		if (StringUtils.isNotEmpty(ticket)) {
			String encodeTicket = null;
			try {
				encodeTicket = URLEncoder.encode(ticket,
						WeixinConstants.ENCODING);
				String requestUrl = WeixinInterface.URL_QRCODE_SHOW.replace(
						WeixinConstants.REPLACE_TICKET, encodeTicket);
				URL url = new URL(requestUrl);
				HttpsURLConnection conn = (HttpsURLConnection) url
						.openConnection();
				conn.setDoInput(true);
				conn.setRequestMethod(WeixinConstants.REQUESTMETHOD_GET);
				if (!savePath.endsWith("/")) {
					savePath += "/";
				}
				filePath = savePath + ticket + ".jpg";// 拼接文件路径
				BufferedInputStream bis = new BufferedInputStream(
						conn.getInputStream());
				FileOutputStream fos = new FileOutputStream(new File(filePath));
				byte[] buf = new byte[8096];// 4M缓存
				int size = 0;
				while ((size = bis.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}
				fos.close();
				bis.close();
				conn.disconnect();
				logger.error("获取二维码成功，路径：" + filePath);
			} catch (Exception e) {
				logger.error("二维码ticket URL编码操作异常：" + e.getMessage());
				e.printStackTrace();
				throw new WeixinException(e);
			}
		}
		return filePath;
	}
}
