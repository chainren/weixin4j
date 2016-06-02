/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 接收微信文本消息实体<p>
 * <p>消息示例：
 * <xml>
 *	  	<ToUserName><![CDATA[toUser]]></ToUserName>
 *	 	<FromUserName><![CDATA[fromUser]]></FromUserName> 
 *	 	<CreateTime>1348831860</CreateTime>
 *	 	<MsgType><![CDATA[text]]></MsgType>
 *	 	<Content><![CDATA[this is a test]]></Content>
 *	 	<MsgId>1234567890123456</MsgId>
 *	</xml>
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
public class TextMessage extends ReqBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 文本消息内容
	 */
	protected String Content;

	public TextMessage() {
		super();
		this.MsgType = WeixinConstants.MSG_TYPE_TEXT;
	}

	public TextMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId) {
		super(toUserName, fromUserName, createTime, msgId);
		this.MsgType = WeixinConstants.MSG_TYPE_TEXT;
	}

	public TextMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId,String content) {
		super(toUserName, fromUserName, createTime, msgId);
		this.Content = content;
		this.MsgType = WeixinConstants.MSG_TYPE_TEXT;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
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
		builder.append("\n</MsgId>\n<Content>\n");
		builder.append(Content);
		builder.append("\n</Content>\n</xml>");
		return builder.toString();
	}

}
