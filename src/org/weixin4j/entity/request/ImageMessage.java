/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;


import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 接收图片消息的实体<p>
 * <p>图片消息示例
 * <xml>
 *	 <ToUserName><![CDATA[toUser]]></ToUserName>
 *	 <FromUserName><![CDATA[fromUser]]></FromUserName>
 *	 <CreateTime>1348831860</CreateTime>
 *	 <MsgType><![CDATA[image]]></MsgType>
 *	 <PicUrl><![CDATA[this is a url]]></PicUrl>
 *	 <MediaId><![CDATA[media_id]]></MediaId>
 *	 <MsgId>1234567890123456</MsgId>
 * 	</xml>
 *
 * <p>
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
public class ImageMessage extends ReqBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 图片的url路径
	 */
	protected String PicUrl;
	/**
	 * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	protected String MediaId;

	public ImageMessage() {
		super();
		this.MsgType = WeixinConstants.MSG_TYPE_IMAGE;
	}

	public ImageMessage(String toUserName, String fromUserName, Long createTime,
			String msgType, Long msgId) {
		super(toUserName, fromUserName, createTime, msgId);
		this.MsgType = WeixinConstants.MSG_TYPE_IMAGE;
	}
	
	public ImageMessage(String toUserName, String fromUserName, Long createTime, Long msgId,String picUrl,String mediaId) {
		super(toUserName, fromUserName, createTime,  msgId);
		this.PicUrl = picUrl;
		this.MediaId = mediaId;
		this.MsgType = WeixinConstants.MSG_TYPE_IMAGE;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
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
		builder.append("\n</MsgId>\n<PicUrl>\n");
		builder.append(PicUrl);
		builder.append("\n</PicUrl>\n<MediaId>\n");
		builder.append(MediaId);
		builder.append("\n</MediaId>\n</xml>");
		return builder.toString();
	}

}
