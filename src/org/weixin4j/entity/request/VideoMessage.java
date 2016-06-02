/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 接收视频消息的实体
 * <p>视频消息示例： 
 * <p>
 * <xml>
 *	<ToUserName><![CDATA[toUser]]></ToUserName>
 *	<FromUserName><![CDATA[fromUser]]></FromUserName>
 *	<CreateTime>1357290913</CreateTime>
 *	<MsgType><![CDATA[video]]></MsgType>
 *	<MediaId><![CDATA[media_id]]></MediaId>
 *	<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
 *	<MsgId>1234567890123456</MsgId>
 *  </xml>
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
public class VideoMessage extends ReqBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	protected String MediaId;
	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	protected String ThumbMediaId;

	public VideoMessage() {
		super();
		this.MsgType = WeixinConstants.MSG_TYPE_VIDEO;
	}

	public VideoMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId) {
		super(toUserName, fromUserName, createTime, msgId);
		this.MsgType = WeixinConstants.MSG_TYPE_VIDEO;
	}
	
	public VideoMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId,String MediaId,String ThumbMediaId) {
		super(toUserName, fromUserName, createTime, msgId);
		this.MediaId = MediaId;
		this.ThumbMediaId = ThumbMediaId;
		this.MsgType = WeixinConstants.MSG_TYPE_VIDEO;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
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
		builder.append("\n</MsgId>\n<MediaId>\n");
		builder.append(MediaId);
		builder.append("\n</MediaId>\n<ThumbMediaId>\n");
		builder.append(ThumbMediaId);
		builder.append("\n</ThumbMediaId>\n</xml>");
		return builder.toString();
	}

}
