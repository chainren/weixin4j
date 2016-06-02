/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 接收语音消息的实体<p>
 * <p>语音消息示例： 
 * <p>
 * <xml>
 *		<ToUserName><![CDATA[toUser]]></ToUserName>
 *		<FromUserName><![CDATA[fromUser]]></FromUserName>
 *		<CreateTime>1357290913</CreateTime>
 *		<MsgType><![CDATA[voice]]></MsgType>
 *		<MediaId><![CDATA[media_id]]></MediaId>
 *		<Format><![CDATA[Format]]></Format>
 *		<MsgId>1234567890123456</MsgId>
 *	</xml>
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
public class VoiceMessage extends ReqBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	protected String MediaId;
	/**
	 * 语音格式，如amr，speex等
	 */
	protected String Format;

	public VoiceMessage() {
		super();
		this.MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}

	public VoiceMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId) {
		super(toUserName, fromUserName, createTime, msgId);
		this.MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}
	

	public VoiceMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId,String MediaId,String Format) {
		super(toUserName, fromUserName, createTime, msgId);
		this.MediaId= MediaId;
		this.Format =Format;
		this.MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
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
		builder.append("\n</MediaId>\n<Format>\n");
		builder.append(Format);
		builder.append("\n</Format>\n</xml>");
		return builder.toString();
	}
}
