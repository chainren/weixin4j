/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.msg;

import java.util.ArrayList;
import java.util.List;

import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.entity.request.TextMessage;
import org.weixin4j.entity.response.Article;
import org.weixin4j.entity.response.ArticleMessage;
import org.weixin4j.entity.response.Image;
import org.weixin4j.entity.response.ImageMessage;
import org.weixin4j.entity.response.Music;
import org.weixin4j.entity.response.MusicMessage;
import org.weixin4j.entity.response.Video;
import org.weixin4j.entity.response.VideoMessage;
import org.weixin4j.entity.response.Voice;
import org.weixin4j.entity.response.VoiceMessage;

import com.thoughtworks.xstream.XStream;

/**
 * <p>
 * Description： xml消息生成工具，负责将微信接口实体数据生成符合微信接口报文标准的xml报文。
 *
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月10日
 *
 * @author chainren
 * @version 1.0
 * @since JDK1.7
 *
 *
 */
public class MessageBuilder {

	/**
	 * <p>
	 * 对接口实体数据进行组装，生成符合微信接口的xml报文。
	 * <p>
	 * 该接口方法只能处理简单的接口实体，属性的为简单的数据类型(8种基本类型，String类型).
	 *
	 * @param obj
	 *            接口实体数据对象，由应用进行封装,
	 * @return 符合微信接口的xml报文。
	 */
	public static String buildSimpleXML(Object obj) {
		XStream xs = UserDefinedXStream.createUserDefXStream();
		xs.alias("xml", obj.getClass());
		return xs.toXML(obj);
	}

	/**
	 *
	 * @param obj
	 *            实体对象
	 * @param subClz
	 *            实体中属性属于自定义属性的，指定该属性在xml中的标签名为类名，默认是类的全路径。
	 * @param subClzAlias
	 *            指定实体中自定义属性的节点名，顺序跟subClz对应
	 * @param toIgnoreClz
	 *            针对集合属性，在xml中忽略属性名标签
	 * @param toIgnoreTag
	 *            集合属性的属性名
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String buildCustomXML(Object obj, Class[] subClz, String[] subClzAlias, Class[] toIgnoreClz,
			String[] toIgnoreTag) {
		XStream xs = UserDefinedXStream.createUserDefXStream();
		xs.alias("xml", obj.getClass());
		if (subClz != null && subClz.length > 0) {
			if (subClzAlias != null) {
				for (int i = 0; i < subClz.length; i++) {
					xs.alias(subClzAlias[i], subClz[i]);
				}
			} else {
				for (Class clz : subClz) {
					xs.alias(clz.getSimpleName(), clz);
				}
			}
		}
		/** 针对实体中的集合属性，去除集合属性名称 **/
		if (toIgnoreTag != null && toIgnoreTag.length > 0) {
			for (int i = 0; i < toIgnoreTag.length; i++) {
				xs.addImplicitCollection(toIgnoreClz[i], toIgnoreTag[i], toIgnoreClz[i].getSimpleName(), toIgnoreClz[i]);
			}
		}
		return xs.toXML(obj);
	}

	public static void main(String[] args) {
		TextMessage msg = new TextMessage("qinglv2007", "chainren", System.currentTimeMillis(), 1323423L,
				"欢迎注册微信公众平台，这里有你想不到惊喜哦~");
		System.out.println(buildSimpleXML(msg));
		System.out.println("==========================回复文本消息xml格式===================================");
		org.weixin4j.entity.response.TextMessage respTextMsg = new org.weixin4j.entity.response.TextMessage(
				"rengui756", "itumei", System.currentTimeMillis(), WeixinConstants.MSG_TYPE_TEXT);
		respTextMsg.setContent("回复的文本消息");
		String respTextMsgXml = buildSimpleXML(respTextMsg);
		System.out.println(respTextMsgXml);
		System.out.println("==========================回复图片消息xml格式===================================");
		ImageMessage respImageMsg = new ImageMessage("rengui756", "itumei", System.currentTimeMillis());
		respImageMsg.setImage(new Image("xxxesdf732432"));
		String respImageMsgXml = buildCustomXML(respImageMsg, new Class[] { Image.class }, null, null, null);
		System.out.println(respImageMsgXml);
		System.out.println("==========================回复语音消息xml格式===================================");
		VoiceMessage respVoiceMsg = new VoiceMessage("rengui756", "itumei", System.currentTimeMillis());
		respVoiceMsg.setVoice(new Voice("xdfs32391x"));
		String respVoiceMsgXml = buildCustomXML(respVoiceMsg, new Class[] { Voice.class }, null, null, null);
		System.out.println(respVoiceMsgXml);

		System.out.println("==========================回复视频消息xml格式===================================");
		VideoMessage respVideoMsg = new VideoMessage("rengui756", "itumei", System.currentTimeMillis());
		respVideoMsg.setVideo(new Video("xd320nhds", "这是视频消息", "视频视频视频啊啊啊啊"));
		String respVideoMsgXml = buildCustomXML(respVideoMsg, new Class[] { Voice.class }, null, null, null);
		System.out.println(respVideoMsgXml);

		System.out.println("==========================回复音乐消息xml格式===================================");
		MusicMessage respMusicMsg = new MusicMessage("rengui756", "itumei", System.currentTimeMillis());
		respMusicMsg.setMusic(new Music("音乐", "回复音乐消息", "http://kugou.com/music=mg.mp3",
				"http://kugou.com/music=mgh.mp3", "xds232"));
		String respMusicMsgXml = buildCustomXML(respMusicMsg, new Class[] { Voice.class }, null, null, null);
		System.out.println(respMusicMsgXml);

		System.out.println("==========================回复多图文消息xml格式===================================");
		ArticleMessage respArticleMsg = new ArticleMessage("rengui756", "itumei", System.currentTimeMillis());
		List<Article> articles = new ArrayList<Article>();
		articles.add(new Article("文章1", "回复多图文第一篇", "http://pic/pic1.jpg", "http://article/article1"));
		articles.add(new Article("文章2", "回复多图文第二篇", "http://pic/pic2.jpg", "http://article/article2"));
		articles.add(new Article("文章3", "回复多图文第三篇", "http://pic/pic3.jpg", "http://article/article3"));
		respArticleMsg.setArticles(articles);
		respArticleMsg.setArticleCount(3);
		String respArticleMsgXml = buildCustomXML(respArticleMsg, new Class[] { Article.class },
				new String[] { "Item" }, null, null);
		System.out.println(respArticleMsgXml);
	}

}
