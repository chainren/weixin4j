/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;

import java.io.Serializable;

/**
 * <p>
 * Description： 自定义菜单事件消息实体
 * <p>
 * 点击菜单拉取消息时的事件推送 ：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[CLICK]]></Event> <EventKey><![CDATA[EVENTKEY]]></EventKey>
 * </xml>
 * 
 * <p>
 * 点击菜单跳转链接时的事件推送 ：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[VIEW]]></Event> <EventKey><![CDATA[www.qq.com]]></EventKey>
 * </xml>
 * 
 * Company ：
 * <p>
 * Create Date： 2014年6月16日
 * 
 * @author chainren
 * @version 1.0
 * @since JDK1.7
 * 
 * 
 */
public class MenuEventMessage extends SubscribeEventMessage implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当event=click时，表示事件KEY值，与自定义菜单接口中KEY值对应 ；当event=view时，事件KEY值，设置的跳转URL
	 */
	protected String EventKey;

	public MenuEventMessage() {
		super();
	}

	public MenuEventMessage(String toUserName, String fromUserName,
			Long createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
	}

	public MenuEventMessage(String toUserName, String fromUserName,
			Long createTime, String event, String EventKey) {
		super(toUserName, fromUserName, createTime, event);
		this.EventKey = EventKey;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		builder.append("\n</Event>\n<EventKey>\n");
		builder.append(EventKey);
		builder.append("\n</EventKey>\n</xml>");
		return builder.toString();
	}

}
