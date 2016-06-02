/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

import java.util.List;

import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description： 回复图文消息，一篇中可以包含多条图文消息内容，最多不能超过10条。
 * <p>
 * 消息示例：
 * <p>
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[news]]></MsgType>
 * <ArticleCount>2</ArticleCount> <Articles> <item>
 * <Title><![CDATA[title1]]></Title>
 * <Description><![CDATA[description1]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item> <item>
 * <Title><![CDATA[title]]></Title>
 * <Description><![CDATA[description]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
 * </Articles> </xml> Company ：
 * <p>
 * Create Date： 2014年6月9日
 *
 * @author chainren
 * @version 1.0
 * @since JDK1.7
 *
 *
 */
public class ArticleMessage extends RespBaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 图文消息个数，限制为10条以内
	 */
	protected int ArticleCount;

	/**
	 * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	 */
	protected List<Article> Articles;

	public ArticleMessage() {
		super();
		MsgType = WeixinConstants.MSG_TYPE_NEWS;
	}

	public ArticleMessage(String toUserName, String fromUserName, Long createTime) {
		super(toUserName, fromUserName, createTime);
		MsgType = WeixinConstants.MSG_TYPE_NEWS;
	}

	public ArticleMessage(String toUserName, String fromUserName, Long createTime, int ArticleCount,
			List<Article> Articles) {
		super(toUserName, fromUserName, createTime);
		this.ArticleCount = ArticleCount;
		this.Articles = Articles;
		MsgType = WeixinConstants.MSG_TYPE_NEWS;
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
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
		builder.append("\n</MsgType>\n<ArticleCount>\n");
		builder.append(ArticleCount);
		builder.append("\n</ArticleCount>\n<Articles>\n");
		builder.append(Articles);
		builder.append("\n</Articles>\n</xml>");
		return builder.toString();
	}

}
