/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

/**
 * <p>
 * Description： 回复音乐消息中的音乐信息节点实体，它是 {@link MusicMessage}的一个内部属性
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
public class Music {
	/**
	 * 音乐标题
	 */
	private String Title;
	/**
	 * 音乐描述
	 */
	private String Description;
	/**
	 * 音乐链接
	 */
	private String MusicUrl;
	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	private String HQMusicUrl;
	/**
	 * 缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	private String ThumbMediaId;

	public Music() {
		super();
	}

	public Music(String title, String description, String musicUrl,
			String hQMusicUrl, String thumbMediaId) {
		super();
		Title = title;
		Description = description;
		MusicUrl = musicUrl;
		HQMusicUrl = hQMusicUrl;
		ThumbMediaId = thumbMediaId;
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

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
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
		builder.append("\n</Description>\n<MusicUrl>\n");
		builder.append(MusicUrl);
		builder.append("\n</MusicUrl>\n<HQMusicUrl>\n");
		builder.append(HQMusicUrl);
		builder.append("\n</HQMusicUrl>\n<ThumbMediaId>\n");
		builder.append(ThumbMediaId);
		builder.append("\n</ThumbMediaId>");
		return builder.toString();
	}

}
