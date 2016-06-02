/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;

import java.io.Serializable;

/**
 * <p>
 * Description： 扫描带参数二维码事件
 * <p>
 * 用户未关注时，进行关注后的事件推送 :
 * <p>
 * <xml><ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[subscribe]]></Event>
 * <EventKey><![CDATA[qrscene_123123]]></EventKey>
 * <Ticket><![CDATA[TICKET]]></Ticket> </xml>
 * 
 * <p>
 * 用户已关注时的事件推送:
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[SCAN]]></Event> <EventKey><![CDATA[SCENE_VALUE]]></EventKey>
 * <Ticket><![CDATA[TICKET]]></Ticket> </xml>
 * 
 * <p>
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
public class ScanQRCodeEventMessage extends SubscribeEventMessage implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	 */
	protected String EventKey;

	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	protected String Ticket;

	public ScanQRCodeEventMessage() {
		super();
	}

	public ScanQRCodeEventMessage(String toUserName, String fromUserName,
			Long createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
	}

	public ScanQRCodeEventMessage(String toUserName, String fromUserName,
			Long createTime, String event, String EventKey, String Ticket) {
		super(toUserName, fromUserName, createTime, event);
		this.EventKey = EventKey;
		this.Ticket = Ticket;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
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
		builder.append("\n</Event>\n<EventKey>\n");
		builder.append(EventKey);
		builder.append("\n</EventKey>\n<Ticket>\n");
		builder.append(Ticket);
		builder.append("\n</Ticket>\n</xml>");
		return builder.toString();
	}

}
