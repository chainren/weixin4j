/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.request;


import org.weixin4j.entity.WeixinConstants;
/**
 * <p>
 * Description： 接收链接消息的实体
 * <p>链接消息示例：
 * <p>
 * <xml>
 *	<ToUserName><![CDATA[toUser]]></ToUserName>
 *	<FromUserName><![CDATA[fromUser]]></FromUserName>
 *	<CreateTime>1351776360</CreateTime>
 *	<MsgType><![CDATA[link]]></MsgType>
 *	<Title><![CDATA[公众平台官网链接]]></Title>
 *	<Description><![CDATA[公众平台官网链接]]></Description>
 *	<Url><![CDATA[url]]></Url>
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
public class LinkMessage extends ReqBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 消息标题
	 */
	protected String Title;
	/**
	 * 消息描述
	 */
	protected String Description;
	/**
	 * 消息链接
	 */
	protected String Url;

	public LinkMessage() {
		super();
		this.MsgType = WeixinConstants.MSG_TYPE_LINK;
	}

	public LinkMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId,String title,String description,String url) {
		super(toUserName, fromUserName, createTime,  msgId);
		this.Title = title;
		this.Description = description;
		this.Url = url;
		this.MsgType = WeixinConstants.MSG_TYPE_LINK;
	}


	public LinkMessage(String toUserName, String fromUserName, Long createTime,
			Long msgId) {
		super(toUserName, fromUserName, createTime,  msgId);
		this.MsgType = WeixinConstants.MSG_TYPE_LINK;
	}
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
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
		builder.append("\n</MsgId>\n<Title>\n");
		builder.append(Title);
		builder.append("\n</Title>\n<Description>\n");
		builder.append(Description);
		builder.append("\n</Description>\n<Url>\n");
		builder.append(Url);
		builder.append("\n</Url>\n</xml>");
		return builder.toString();
	}

}
