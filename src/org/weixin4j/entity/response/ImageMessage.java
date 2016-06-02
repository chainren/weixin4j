/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 回复图片消息的实体
 * <p>
 * <p>
 * 图片消息示例
 * <p>
 * <xml>
 * 	<ToUserName><![CDATA[toUser]]></ToUserName>
 * 	<FromUserName><![CDATA[fromUser]]></FromUserName>
 * 	<CreateTime>1348831860</CreateTime>
 * 	<MsgType><![CDATA[image]]></MsgType>
 * 	<Image>
 * 		<MediaId><![CDATA[media_id]]></MediaId>
 * 	</Image>
 * </xml>
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
public class ImageMessage extends RespBaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 包含的图片实体信息
	 */
	protected Image Image;

	public ImageMessage() {
		super();
		MsgType = WeixinConstants.MSG_TYPE_IMAGE;
	}

	public ImageMessage(String toUserName, String fromUserName,
			Long createTime) {
		super(toUserName, fromUserName, createTime);
		MsgType = WeixinConstants.MSG_TYPE_IMAGE;
	}

	public ImageMessage(String toUserName, String fromUserName,
			Long createTime, Image image) {
		super(toUserName, fromUserName, createTime);
		Image = image;
		MsgType = WeixinConstants.MSG_TYPE_IMAGE;
	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
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
		builder.append("\n</MsgType>\n<Image>\n");
		builder.append(Image);
		builder.append("\n</Image>\n</xml>");
		return builder.toString();
	}

}
