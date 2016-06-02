/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.auth;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.entity.Errmsg;
import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.entity.WeixinInterface;
import org.weixin4j.exception.WeixinException;
import org.weixin4j.net.HttpConnectionUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * <p>
 * Description： 网页授权获取的access_token，不同于其它接口的access_token
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年3月4日
 *
 * @author chainren
 * @version
 * @since JDK1.7
 *
 *
 */
public class OAuth2AccessToken implements Serializable {

	private static Logger logger = LoggerFactory.getLogger(OAuth2AccessToken.class);
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** 网页授权接口调用凭证 **/
	private String access_token;
	/** access_token接口调用凭证超时时间，单位（秒） **/
	private int expires_in;
	/** 用户刷新access_token **/
	private String refresh_token;
	/** 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID **/
	private String openid;
	/** 用户授权的作用域，使用逗号（,）分隔 **/
	private String scope;
	/** 返回错误码 **/
	private String errcode;
	/** 返回错误信息 **/
	private String errmsg;
	/**最后一次更新时间**/
	private long lastChgangeTimeMills;
	/**只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）**/
	private String unionid;


	public OAuth2AccessToken() {

	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
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

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"access_token\":\"");
		builder.append(access_token);
		builder.append("\", \"expires_in\":\"");
		builder.append(expires_in);
		builder.append("\", \"refresh_token\":\"");
		builder.append(refresh_token);
		builder.append("\", \"openid\":\"");
		builder.append(openid);
		builder.append("\", \"scope\":\"");
		builder.append(scope);
		builder.append("\", \"unionid\":\"");
		builder.append(unionid);
		builder.append("\", \"errcode\":\"");
		builder.append(errcode);
		builder.append("\", \"errmsg\":\"");
		builder.append(errmsg);
		builder.append("\"}");
		return builder.toString();
	}

	/**
	 * oauth2授权，用户在第一步中同意授权后，获取返回的code，然后通过该方法获取访问用户信息凭证
	 * @param appid
	 * @param appsecret
	 * @param code
	 * @return 返回oauth2授权信息，如果失败，则包含错误信息
	 * @throws WeixinException
	 */
	public static OAuth2AccessToken getOAuth2AccessToken(String appid,String appsecret,String code)throws WeixinException{
		OAuth2AccessToken oAuth2AccessToken = null;
		String requestUrl = WeixinInterface.URL_OAUTH2_ACCESS_TOKEN.replace(WeixinConstants.REPLACE_APPID, appid)
				.replace(WeixinConstants.REPLACE_SECRET, appsecret).replace(WeixinConstants.REPLACE_CODE, code);
		JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl, WeixinConstants.REQUESTMETHOD_GET, null);
		if(jsonObj!=null){
			Gson gson = new Gson();
			oAuth2AccessToken = gson.fromJson(jsonObj, OAuth2AccessToken.class);
			oAuth2AccessToken.setLastChgangeTimeMills(System.currentTimeMillis());// 更新最近一次获取凭证的时间
			logger.debug("oAuth2AccessToken:" + oAuth2AccessToken);
		}
		return oAuth2AccessToken;
	}

	/**
	 * 刷新oauth2授权的access_token
	 * @param appid
	 * @param refresh_token 上次获取的token中的refresh_token
	 * @return 返回oauth2授权信息，如果失败，则包含错误信息
	 * @throws WeixinException
	 */
	public static OAuth2AccessToken refreshOAuth2AccessToken(String appid,String refresh_token)throws WeixinException{
		OAuth2AccessToken oAuth2AccessToken = null;
		String requestUrl = WeixinInterface.URL_OAUTH2_RERESH_TOKEN.replace(WeixinConstants.REPLACE_APPID, appid)
				.replace(WeixinConstants.REPLACE_REFRESH_TOKEN, refresh_token);
		JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl, WeixinConstants.REQUESTMETHOD_GET, null);
		if(jsonObj!=null){
			Gson gson = new Gson();
			oAuth2AccessToken = gson.fromJson(jsonObj, OAuth2AccessToken.class);
			oAuth2AccessToken.setLastChgangeTimeMills(System.currentTimeMillis());// 更新最近一次获取凭证的时间
			logger.debug("oAuth2AccessToken:" + oAuth2AccessToken);
		}
		return oAuth2AccessToken;
	}

	/**
	 * 检验授权凭证（access_token）是否有效
	 * @param access_token
	 * @param openid
	 * @return
	 * @throws WeixinException
	 */
	public static Errmsg checkOAuth2AccessToken(String access_token,String openid)throws WeixinException{
		Errmsg errmsg = null;
		String requestUrl = WeixinInterface.URL_OAUTH2_CHECK_AUTH.replace(WeixinConstants.REPLACE_ACCESS_TOKEN, access_token)
				.replace(WeixinConstants.REPLACE_OPENID, openid);
		JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl, WeixinConstants.REQUESTMETHOD_GET, null);
		if(jsonObj!=null){
			Gson gson = new Gson();
			errmsg = gson.fromJson(jsonObj, Errmsg.class);
			logger.debug("检验授权凭证返回："+errmsg);
		}
		return errmsg;
	}

}
