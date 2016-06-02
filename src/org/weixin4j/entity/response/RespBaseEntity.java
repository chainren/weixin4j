/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

import java.io.Serializable;

/**
 * <p>
 * Description：响应消息基类
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月9日
 *
 * @author chainren
 * @version 1.0
 * @since JDK1.7
 *
 *
 */
public abstract class RespBaseEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 消息接收方微信id
	 *
	 */
	protected String ToUserName;

	/**
	 * 开发者微信号
	 */
	protected String FromUserName;

	/**
	 * 消息创建时间 （整型）
	 */
	protected Long CreateTime;

	/**
	 * 响应消息类型，微信接口中定义的几种消息类型：text|image|voice|video|music|news
	 */
	protected String MsgType;

	public RespBaseEntity() {
		super();
	}

	public RespBaseEntity(String toUserName, String fromUserName, Long createTime) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
