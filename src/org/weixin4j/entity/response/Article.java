/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

/**
 * <p>
 * Description： 回复多图文消息的多图文实体，，它是 {@link ArticleMessage}的一个内部属性
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月14日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class Article {
	/**
	 * 图文消息标题
	 */
	private String Title;
	/**
	 * 图文消息描述
	 */
	private String Description;
	/**
	 * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	private String PicUrl;
	/**
	 * 点击图文消息跳转链接
	 */
	private String Url;

	public Article() {
		super();
	}

	public Article(String title, String description, String picUrl, String url) {
		super();
		Title = title;
		Description = description;
		PicUrl = picUrl;
		Url = url;
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

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
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
		builder.append("<Title>\n");
		builder.append(Title);
		builder.append("\n</Title>\n<Description>\n");
		builder.append(Description);
		builder.append("\n</Description>\n<PicUrl>\n");
		builder.append(PicUrl);
		builder.append("\n</PicUrl>\n<Url>\n");
		builder.append(Url);
		builder.append("\n</Url>");
		return builder.toString();
	}
}
