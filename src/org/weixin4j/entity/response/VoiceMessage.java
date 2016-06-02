/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 回复语音消息的实体
 * <p>
 * <p>
 * 语音消息示例：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1357290913</CreateTime> <MsgType><![CDATA[voice]]></MsgType>
 * <Voice> <MediaId><![CDATA[media_id]]></MediaId> </Voice> </xml>
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
public class VoiceMessage extends RespBaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 回复语音消息中的语音实体
	 */
	protected Voice Voice;

	public VoiceMessage() {
		super();
		MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}

	public VoiceMessage(String toUserName, String fromUserName, Long createTime) {
		super(toUserName, fromUserName, createTime);
		MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}

	public VoiceMessage(String toUserName, String fromUserName, Long createTime, Voice voice, int funcFlag) {
		super(toUserName, fromUserName, createTime);
		Voice = voice;
		MsgType = WeixinConstants.MSG_TYPE_VOICE;
	}

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
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
		builder.append("\n</MsgType>\n<Voice>\n");
		builder.append(Voice);
		builder.append("\n</Voice>\n</xml>");
		return builder.toString();
	}

}
