/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity.request;

import java.io.Serializable;

import org.weixin4j.util.EncoderHandler;

/**
 * <p>
 * Description： 客服账号,用于客服账号新增、修改、删除操作
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年2月28日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class KfAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 账号 账号前缀@公众号微信号 **/
	private String kf_account;
	/** 昵称 最长6个汉字或12个英文字符 **/
	private String nickname;
	/** 密码 **/
	private String password;

	/**
	 * 
	 */
	public KfAccount() {

	}

	public KfAccount(String kf_account, String nickname, String password) {
		super();
		this.kf_account = kf_account;
		this.nickname = nickname;
		this.password = EncoderHandler.encodeByMD5(password);
	}

	/**
	 * @return the kf_account
	 */
	public String getKf_account() {
		return kf_account;
	}

	/**
	 * @param kf_account
	 *            the kf_account to set
	 */
	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = EncoderHandler.encodeByMD5(password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"kf_account\":\"");
		builder.append(kf_account);
		builder.append("\", \"nickname\":\"");
		builder.append(nickname);
		builder.append("\", \"password\":\"");
		builder.append(password);
		builder.append("\"}");
		return builder.toString();
	}

}
