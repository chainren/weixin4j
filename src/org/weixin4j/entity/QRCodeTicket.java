/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity;

import java.io.Serializable;

/**
 * <p>Description： 二维码票据，用于换取二维码
 * <p>Company    ：
 * <p>Create Date： 2015年4月4日
 * 
 * @author chainren
 * @version 
 * @since JDK1.7 
 * 
 * 
 */
public class QRCodeTicket extends Errmsg implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码**/
	private String ticket;
	
	/**二维码的有效时间，以秒为单位。最大不超过1800。**/
	private long expire_seconds;
	
	/** 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片**/
	private String url;
	
	/**
	 * 
	 */
	public QRCodeTicket() {
		
	}

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the expire_seconds
	 */
	public long getExpire_seconds() {
		return expire_seconds;
	}

	/**
	 * @param expire_seconds the expire_seconds to set
	 */
	public void setExpire_seconds(long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"ticket\":\"");
		builder.append(ticket);
		builder.append("\", \"expire_seconds\":\"");
		builder.append(expire_seconds);
		builder.append("\", \"url\":\"");
		builder.append(url);
		builder.append("\", \"errcode\":\"");
		builder.append(errcode);
		builder.append("\", \"errmsg\":\"");
		builder.append(errmsg);
		builder.append("\"}");
		return builder.toString();
	}

}

