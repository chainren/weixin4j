/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity;

import java.io.Serializable;

/**
 * <p>
 * Description： 返回消息
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年3月1日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class Errmsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 错误码 **/
	protected String errcode;
	/** 错误信息 **/
	protected String errmsg;

	/**
	 * 
	 */
	public Errmsg() {

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"errcode\":\"");
		builder.append(errcode);
		builder.append("\", \"errmsg\":\"");
		builder.append(errmsg);
		builder.append("\"}");
		return builder.toString();
	}

}
