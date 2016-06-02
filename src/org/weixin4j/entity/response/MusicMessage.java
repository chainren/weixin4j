/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 回复音乐消息实体
 * <p>
 * 音乐消息示例：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[music]]></MsgType>
 * <Music> <Title><![CDATA[TITLE]]></Title>
 * <Description><![CDATA[DESCRIPTION]]></Description>
 * <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
 * <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
 * <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId> </Music> </xml> Company ：
 * <p>
 * Create Date： 2014年6月9日
 *
 * @author chainren
 * @version 1.0
 * @since JDK1.7
 *
 *
 */
public class MusicMessage extends RespBaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 音乐回复中的音乐消息实体
	 */
	protected Music Music;

	public MusicMessage() {
		super();
		MsgType = WeixinConstants.MSG_TYPE_MUSIC;
	}

	public MusicMessage(String toUserName, String fromUserName, Long createTime) {
		super(toUserName, fromUserName, createTime);
		MsgType = WeixinConstants.MSG_TYPE_MUSIC;
	}

	public MusicMessage(String toUserName, String fromUserName, Long createTime, Music music) {
		super(toUserName, fromUserName, createTime);
		Music = music;
		MsgType = WeixinConstants.MSG_TYPE_MUSIC;
	}

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
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
		builder.append("\n</MsgType>\n<Music>\n");
		builder.append(Music);
		builder.append("\n</Music>\n</xml>");
		return builder.toString();
	}

}
