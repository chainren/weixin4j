/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;


import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 接收地理位置消息的实体
 * <p>位置消息示例：
 * <p>
 * <xml>
 *	<ToUserName><![CDATA[toUser]]></ToUserName>
 *	<FromUserName><![CDATA[fromUser]]></FromUserName>
 *	<CreateTime>1351776360</CreateTime>
 *	<MsgType><![CDATA[location]]></MsgType>
 *	<Location_X>23.134521</Location_X>
 *	<Location_Y>113.358803</Location_Y>
 *	<Scale>20</Scale>
 *	<Label><![CDATA[位置信息]]></Label>
 *	<MsgId>1234567890123456</MsgId>
 * </xml> 
 *
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
public class LocationMessage extends ReqBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 地理位置维度
	 */
	protected String Location_X;
	/**
	 * 地理位置经度
	 */
	protected String Location_Y;
	/**
	 * 地图缩放大小
	 */
	protected String Scale;
	/**
	 * 地理位置信息
	 */
	protected String Label;

	public LocationMessage() {
		super();
		this.MsgType = WeixinConstants.MSG_TYPE_LOCATION;
	}

	public LocationMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId) {
		super(toUserName, fromUserName, createTime, msgId);
		this.MsgType = WeixinConstants.MSG_TYPE_LOCATION;
	}
	
	public LocationMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId,String Location_X,String Location_Y,String Scale,String Label) {
		super(toUserName, fromUserName, createTime, msgId);
		this.Location_X = Location_X;
		this.Location_Y = Location_Y;
		this.Scale = Scale;
		this.Label = Label;
		this.MsgType = WeixinConstants.MSG_TYPE_LOCATION;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
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
		builder.append("\n</MsgType>\n<MsgId>\n");
		builder.append(MsgId);
		builder.append("\n</MsgId>\n<Location_X>\n");
		builder.append(Location_X);
		builder.append("\n</Location_X>\n<Location_Y>\n");
		builder.append(Location_Y);
		builder.append("\n</Location_Y>\n<Scale>\n");
		builder.append(Scale);
		builder.append("\n</Scale>\n<Label>\n");
		builder.append(Label);
		builder.append("\n</Label>\n</xml>");
		return builder.toString();
	}

}
