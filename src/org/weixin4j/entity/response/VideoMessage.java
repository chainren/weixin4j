/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 回复视频消息的实体
 * <p>
 * 视频消息示例：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1357290913</CreateTime> <MsgType><![CDATA[video]]></MsgType>
 * <Video> <MediaId><![CDATA[media_id]]></MediaId>
 * <Title><![CDATA[title]]></Title>
 * <Description><![CDATA[description]]></Description> </Video> </xml>
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
public class VideoMessage extends RespBaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 回复视频消息中的视频消息实体
	 */
	protected Video Video;

	public VideoMessage() {
		super();
		MsgType = WeixinConstants.MSG_TYPE_VIDEO;
	}

	public VideoMessage(String toUserName, String fromUserName, Long createTime) {
		super(toUserName, fromUserName, createTime);
		MsgType = WeixinConstants.MSG_TYPE_VIDEO;
	}

	public VideoMessage(String toUserName, String fromUserName, Long createTime, Video video, int funcFlag) {
		super(toUserName, fromUserName, createTime);
		Video = video;
		MsgType = WeixinConstants.MSG_TYPE_VIDEO;
	}

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
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
		builder.append("\n</MsgType>\n<Video>\n");
		builder.append(Video);
		builder.append("\n</Video>\n</xml>");
		return builder.toString();
	}

}
