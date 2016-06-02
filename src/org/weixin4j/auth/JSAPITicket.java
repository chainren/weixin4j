/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.auth;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.entity.WeixinInterface;
import org.weixin4j.exception.WeixinException;
import org.weixin4j.net.HttpConnectionUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * <p>
 * Description： 微信js接口实体
 * <p>
 * Create Date： 2015年11月23日
 * 
 * @author chenrg
 * @version 1.0
 * @since JDK1.7
 * 
 * 
 */
public class JSAPITicket implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(JSAPITicket.class);

	/**
	 * jsapi 票据
	 */
	private String ticket;
	/**
	 * 凭证有效时间，单位：秒
	 */
	private int expires_in;
	/**
	 * 错误码
	 */
	private String errcode;
	/**
	 * 错误信息
	 */
	private String errmsg;

	/**
	 * 最后一次更新时间
	 */
	private long lastChgangeTimeMills;

	public JSAPITicket() {

	}

	/**
	 * 获取jsapi 票据
	 * 
	 * @param accessToken
	 *            微信接口访问凭证
	 * @return
	 * @throws WeixinException
	 */
	public static JSAPITicket getJSAPITicket(String accessToken) throws WeixinException {
		JSAPITicket jsapiTicket = null;
		String urlToken = WeixinInterface.URL_JSAPI_TICKET.replace(WeixinConstants.REPLACE_ACCESS_TOKEN, accessToken);
		JsonObject jsapi_ticket = HttpConnectionUtils.httpsRequest(urlToken, WeixinConstants.REQUESTMETHOD_GET, null);
		if (jsapi_ticket != null) {
			Gson gson = new Gson();
			jsapiTicket = gson.fromJson(jsapi_ticket, JSAPITicket.class);
			jsapiTicket.setLastChgangeTimeMills(System.currentTimeMillis());// 更新最近一次获取凭证的时间
			logger.debug("accessToken:" + jsapiTicket);
		}
		return jsapiTicket;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public long getLastChgangeTimeMills() {
		return lastChgangeTimeMills;
	}

	public void setLastChgangeTimeMills(long lastChgangeTimeMills) {
		this.lastChgangeTimeMills = lastChgangeTimeMills;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"ticket\":\"");
		builder.append(ticket);
		builder.append("\", \"expires_in\":\"");
		builder.append(expires_in);
		builder.append("\", \"errcode\":\"");
		builder.append(errcode);
		builder.append("\", \"errmsg\":\"");
		builder.append(errmsg);
		builder.append("\", \"lastChgangeTimeMills\":\"");
		builder.append(lastChgangeTimeMills);
		builder.append("\"}");
		return builder.toString();
	}

}
