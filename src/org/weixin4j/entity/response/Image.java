/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity.response;

/**
 * <p>
 * Description： 回复图片消息中的图片信息节点实体，它是 {@link ImageMessage}的一个内部属性
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
public class Image {
	/**
	 * 通过上传多媒体文件，得到的id。
	 */
	private String MediaId;

	public Image() {
		super();
	}

	public Image(String mediaId) {
		super();
		MediaId = mediaId;
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
		builder.append("<MediaId>\n");
		builder.append(MediaId);
		builder.append("\n</MediaId>");
		return builder.toString();
	}
}
