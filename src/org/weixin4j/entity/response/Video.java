/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

/**
 * <p>
 * Description： 回复视频消息中的视频信息节点实体，它是 {@link VideoMessage}的一个内部属性
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月14日
 * 
 * @author chainren
 * @version 1.0
 * @since JDK1.7
 * 
 * 
 */
public class Video {
	/**
	 * 通过上传多媒体文件，得到的id。
	 */
	private String MediaId;
	/**
	 * 视频消息的标题
	 */
	private String Title;
	/**
	 * 视频消息的描述
	 */
	private String Description;

	public Video() {
		super();
	}

	public Video(String mediaId, String title, String description) {
		super();
		MediaId = mediaId;
		Title = title;
		Description = description;
	}

	/**
	 * @return the mediaId
	 */
	public String getMediaId() {
		return MediaId;
	}

	/**
	 * @param mediaId
	 *            the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<MediaId>\n");
		builder.append(MediaId);
		builder.append("\n</MediaId>\n<Title>\n");
		builder.append(Title);
		builder.append("\n</Title>\n<Description>\n");
		builder.append(Description);
		builder.append("\n</Description>");
		return builder.toString();
	}
}
