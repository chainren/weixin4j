/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;

import java.io.Serializable;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 接收关注/取消关注公众账号事件消息
 * <p>
 * 消息示例：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[subscribe]]></Event> </xml>
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月16日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class SubscribeEventMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * 消息类型，event
	 */
	protected String MsgType = WeixinConstants.MSG_TYPE_EVENT;

	/**
	 * 事件类型
	 */
	protected String Event;

	public SubscribeEventMessage() {
		super();
		this.MsgType = WeixinConstants.MSG_TYPE_EVENT;
	}

	public SubscribeEventMessage(String toUserName, String fromUserName,
			Long createTime, String event) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		Event = event;
		this.MsgType = WeixinConstants.MSG_TYPE_EVENT;
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

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<xml>\n<ToUserName>\n");
		builder.append(ToUserName);
		builder.append("\n</ToUserName>\n<FromUserName>\n");
		builder.append(FromUserName);
		builder.append("\n</FromUserName>\n<CreateTime>\n");
		builder.append(CreateTime);
		builder.append("\n</CreateTime>\n<MsgType>\n");
		builder.append(MsgType);
		builder.append("\n</MsgType>\n<Event>\n");
		builder.append(Event);
		builder.append("\n</Event>\n</xml>");
		return builder.toString();
	}

}
