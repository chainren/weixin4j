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
 * Description： 接收上报地理位置事件消息实体
 * <p>
 * 消息示例：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[LOCATION]]></Event> <Latitude>23.137466</Latitude>
 * <Longitude>113.352425</Longitude> <Precision>119.385040</Precision> </xml>
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
public class LocationEventMessage extends SubscribeEventMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 地理位置纬度
	 */
	protected String Latitude;
	/**
	 * 地理位置经度
	 */
	protected String Longitude;

	/**
	 * 地理位置精度
	 */
	protected String Precision;

	public LocationEventMessage() {
		super();
		this.Event = WeixinConstants.EVENT_TYPE_LOCATION;
	}

	public LocationEventMessage(String toUserName, String fromUserName,
			Long createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
		this.Event = WeixinConstants.EVENT_TYPE_LOCATION;
	}

	public LocationEventMessage(String toUserName, String fromUserName,
			Long createTime, String event, String Latitude, String Longitude,
			String Precision) {
		super(toUserName, fromUserName, createTime, event);
		this.Event = WeixinConstants.EVENT_TYPE_LOCATION;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
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
		builder.append("\n</Event>\n<Latitude>\n");
		builder.append(Latitude);
		builder.append("\n</Latitude>\n<Longitude>\n");
		builder.append(Longitude);
		builder.append("\n</Longitude>\n<Precision>\n");
		builder.append(Precision);
		builder.append("\n</Precision>\n</xml>");
		return builder.toString();
	}

}
