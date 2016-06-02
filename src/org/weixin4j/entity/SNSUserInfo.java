/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity;

import java.io.Serializable;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.exception.WeixinException;
import org.weixin4j.net.HttpConnectionUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * <p>Description： 通过oauth2授权获取的用户信息
 * <p>Company    ：
 * <p>Create Date： 2015年3月5日
 * 
 * @author chainren
 * @version 
 * @since JDK1.7 
 * 
 * 
 */
public class SNSUserInfo implements Serializable {
	private static Logger logger = LoggerFactory.getLogger(SNSUserInfo.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**用户的唯一标识**/
	private String openid;
	/**用户昵称 **/
	private String nickname;
	/**用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 **/
	private int sex;
	/**用户个人资料填写的省份**/
	private String province;
	/**普通用户个人资料填写的城市**/
	private String city;
	/**国家，如中国为CN**/
	private String country;
	/**用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。 **/
	private String headimgurl;
	/**用户特权信息，json 数组，如微信沃卡用户为（chinaunicom） **/
	private ArrayList<String> privilege;
	/**只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段**/
	private String unionid;
	/**错误码**/
	private String errcode;
	/**错误信息**/
	private String errmsg;
	
	/**
	 * 
	 */
	public SNSUserInfo() {
		
	}

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the headimgurl
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}

	/**
	 * @param headimgurl the headimgurl to set
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	/**
	 * @return the privilege
	 */
	public ArrayList<String> getPrivilege() {
		return privilege;
	}

	/**
	 * @param privilege the privilege to set
	 */
	public void setPrivilege(ArrayList<String> privilege) {
		this.privilege = privilege;
	}

	/**
	 * @return the unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @param unionid the unionid to set
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	/**
	 * @return the errcode
	 */
	public String getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode the errcode to set
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
	 * @param errmsg the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"openid\":\"");
		builder.append(openid);
		builder.append("\", \"nickname\":\"");
		builder.append(nickname);
		builder.append("\", \"sex\":\"");
		builder.append(sex);
		builder.append("\", \"province\":\"");
		builder.append(province);
		builder.append("\", \"city\":\"");
		builder.append(city);
		builder.append("\", \"country\":\"");
		builder.append(country);
		builder.append("\", \"headimgurl\":\"");
		builder.append(headimgurl);
		builder.append("\", \"privilege\":\"");
		builder.append(privilege);
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
	 * 获取用户信息
	 * @param access_token
	 * @param openid
	 * @return
	 * @throws WeixinException
	 */
	public static SNSUserInfo getSNSUserInfo(String access_token,String openid)throws WeixinException {
		SNSUserInfo snsUserInfo = null;
		String requestUrl = WeixinInterface.URL_OAUTH2_USERINFO.replace(WeixinConstants.REPLACE_ACCESS_TOKEN, access_token)
				.replace(WeixinConstants.REPLACE_OPENID, openid);
		JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl, WeixinConstants.REQUESTMETHOD_GET, null);
		if(jsonObj!=null){
			Gson gson = new Gson();
			snsUserInfo = gson.fromJson(jsonObj, SNSUserInfo.class);
			logger.debug("snsUserInfo:" + snsUserInfo);
		}
		return snsUserInfo;
	}

}

