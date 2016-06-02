/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity.request;

import java.io.Serializable;

/**
 * <p>
 * Description： 获取客服列表的客服信息
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
public class KfAccountInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 客服账号 **/
	private String kf_account;
	/** 客服昵称 **/
	private String kf_nick;
	/** 客服工号 **/
	private String kf_id;
	/** 客服头像地址 **/
	private String headimg;
	/** 客服在线状态 1：pc在线，2：手机在线。若pc和手机同时在线则为 1+2=3 **/
	private String status;
	/** 客服设置的最大自动接入数 **/
	private String auto_accept;
	/** 客服当前正在接待的会话数 **/
	private String accepted_case;

	/**
	 * 
	 */
	public KfAccountInfo() {

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
	 * @return the kf_nick
	 */
	public String getKf_nick() {
		return kf_nick;
	}

	/**
	 * @param kf_nick
	 *            the kf_nick to set
	 */
	public void setKf_nick(String kf_nick) {
		this.kf_nick = kf_nick;
	}

	/**
	 * @return the kf_id
	 */
	public String getKf_id() {
		return kf_id;
	}

	/**
	 * @param kf_id
	 *            the kf_id to set
	 */
	public void setKf_id(String kf_id) {
		this.kf_id = kf_id;
	}

	/**
	 * @return the headimg
	 */
	public String getHeadimg() {
		return headimg;
	}

	/**
	 * @param headimg
	 *            the headimg to set
	 */
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the auto_accept
	 */
	public String getAuto_accept() {
		return auto_accept;
	}

	/**
	 * @param auto_accept
	 *            the auto_accept to set
	 */
	public void setAuto_accept(String auto_accept) {
		this.auto_accept = auto_accept;
	}

	/**
	 * @return the accepted_case
	 */
	public String getAccepted_case() {
		return accepted_case;
	}

	/**
	 * @param accepted_case
	 *            the accepted_case to set
	 */
	public void setAccepted_case(String accepted_case) {
		this.accepted_case = accepted_case;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"kf_account\":\"");
		builder.append(kf_account);
		builder.append("\", \"kf_nick\":\"");
		builder.append(kf_nick);
		builder.append("\", \"kf_id\":\"");
		builder.append(kf_id);
		builder.append("\", \"headimg\":\"");
		builder.append(headimg);
		builder.append("\", \"status\":\"");
		builder.append(status);
		builder.append("\", \"auto_accept\":\"");
		builder.append(auto_accept);
		builder.append("\", \"accepted_case\":\"");
		builder.append(accepted_case);
		builder.append("\"}");
		return builder.toString();
	}

}
