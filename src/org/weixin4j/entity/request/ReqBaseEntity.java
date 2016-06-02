/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;

import java.io.Serializable;

/**
 * <p>
 * Description： 微信公共平台接口信息实体的基类，包含基础的公有属性
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月8日
 * 
 * @author chainren
 * @version 1.0
 * @since JDK1.7
 * 
 * 
 */
public abstract class ReqBaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 633539550597561342L;

	/**
	 * 开发者微信号
	 * 
	 */
	protected String ToUserName;

	/**
	 * 发送方帐号（一个OpenID）
	 */
	protected String FromUserName;

	/**
	 * 消息创建时间 （整型）
	 */
	protected Long CreateTime;

	/**
	 * 消息类型，微信接口中定义的几种消息类型：text|image|voice|video|location|link
	 */
	protected String MsgType;

	/**
	 * 消息id，64位整型
	 */
	protected Long MsgId;

	public ReqBaseEntity() {
		super();
	}

	public ReqBaseEntity(String toUserName, String fromUserName,
			Long createTime,Long msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgId = msgId;
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

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

}
