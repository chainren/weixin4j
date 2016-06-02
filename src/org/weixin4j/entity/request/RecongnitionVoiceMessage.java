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
 * Description： 开通语音识别功能，用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，增加一个Recongnition字段。
 * 注：由于客户端缓存，开发者开启或者关闭语音识别功能，对新关注者立刻生效，对已关注用户需要24小时生效。开发者可以重新关注此帐号进行测试。
 * <p>
 * 消息示例：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1357290913</CreateTime> <MsgType><![CDATA[voice]]></MsgType>
 * <MediaId><![CDATA[media_id]]></MediaId> <Format><![CDATA[Format]]></Format>
 * <Recognition><![CDATA[腾讯微信团队]]></Recognition> <MsgId>1234567890123456</MsgId>
 * </xml>
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
public class RecongnitionVoiceMessage extends VoiceMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 语音识别结果，UTF8编码
	 */
	protected String Recognition;

	public RecongnitionVoiceMessage() {
		super();
		this.MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}

	public RecongnitionVoiceMessage(String toUserName, String fromUserName,
			Long createTime, Long msgId, String MediaId, String Format) {
		super(toUserName, fromUserName, createTime, msgId, MediaId, Format);
		this.MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}

	public RecongnitionVoiceMessage(String toUserName, String fromUserName,
			Long createTime, Long msgId, String MediaId, String Format,
			String Recognition) {
		super(toUserName, fromUserName, createTime, msgId, MediaId, Format);
		this.Recognition = Recognition;
		this.MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<xml>\n<MediaId>\n");
		builder.append(MediaId);
		builder.append("\n</MediaId>\n<Format>\n");
		builder.append(Format);
		builder.append("\n</Format>\n<ToUserName>\n");
		builder.append(ToUserName);
		builder.append("\n</ToUserName>\n<FromUserName>\n");
		builder.append(FromUserName);
		builder.append("\n</FromUserName>\n<CreateTime>\n");
		builder.append(CreateTime);
		builder.append("\n</CreateTime>\n<MsgType>\n");
		builder.append(MsgType);
		builder.append("\n</MsgType>\n<MsgId>\n");
		builder.append(MsgId);
		builder.append("\n</MsgId>\n<Recognition>\n");
		builder.append(Recognition);
		builder.append("\n</Recognition>\n</xml>");
		return builder.toString();
	}

}
