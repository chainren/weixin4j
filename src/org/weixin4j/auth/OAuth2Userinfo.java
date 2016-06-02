/**
 * Copyright(c) 2014~ by tongweisu.com Inc.
 * All Rights Reserved
 */
package org.weixin4j.auth;

import java.io.Serializable;

/**
 * <p>
 * Description：用户授权回调用户信息
 *
 * @author chenrg
 * @version 1.0
 * @since JDK1.7
 *
 *
 */
public class OAuth2Userinfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 用户的唯一标识 **/
	private String openid;
	/** 用户昵称 **/
	private String nickname;
	/** 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 **/
	private String sex;
	/** 省份 **/
	private String province;
	/** 城市 **/
	private String city;
	/** 国家 **/
	private String country;
	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。
	 * 若用户更换头像，原有头像URL将失效。
	 **/
	private String headimgurl;
	/** 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom） **/
	private String[] privilege;
	/** 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制） **/
	private String unionid;
	/** 返回错误码 **/
	private String errcode;
	/** 返回错误信息 **/
	private String errmsg;

	public OAuth2Userinfo() {
		super();
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String[] getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
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

}
