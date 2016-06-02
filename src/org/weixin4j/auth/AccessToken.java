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
 * Description： 访问凭证
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年1月29日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class AccessToken implements Serializable {

	private static Logger logger = LoggerFactory.getLogger(AccessToken.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 获取到的凭证
	 */
	private String access_token;
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

	public AccessToken() {
		super();
	}

	public AccessToken(String access_token, int expires_in) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
	}

	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token
	 *            the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return the expires_in
	 */
	public int getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in
	 *            the expires_in to set
	 */
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * @return the errcode
	 */
	public String getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode
	 *            the errcode to set
	 */
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @param errmsg
	 *            the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/**
	 * @return the lastChgangeTimeMills
	 */
	public long getLastChgangeTimeMills() {
		return lastChgangeTimeMills;
	}

	/**
	 * @param lastChgangeTimeMills
	 *            the lastChgangeTimeMills to set
	 */
	public void setLastChgangeTimeMills(long lastChgangeTimeMills) {
		this.lastChgangeTimeMills = lastChgangeTimeMills;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"access_token\":\"");
		builder.append(access_token);
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

	/**
	 * 获取凭证
	 * 
	 * @param appid
	 * @param appsecret
	 * @return
	 * @throws WeixinException
	 */
	public static AccessToken getAccessToken(String appid, String appsecret)
			throws WeixinException {
		AccessToken accessToken = null;
		String urlToken = WeixinInterface.URL_TOKEN.replace(
				WeixinConstants.REPLACE_APPID, appid).replace(
				WeixinConstants.REPLACE_APPSECRET, appsecret);
		JsonObject access_token = HttpConnectionUtils.httpsRequest(urlToken,
				WeixinConstants.REQUESTMETHOD_POST, null);
		if (access_token != null) {
			Gson gson = new Gson();
			accessToken = gson.fromJson(access_token, AccessToken.class);
			accessToken.setLastChgangeTimeMills(System.currentTimeMillis());// 更新最近一次获取凭证的时间
			logger.debug("accessToken:" + accessToken);
		}
		return accessToken;
	}

}
