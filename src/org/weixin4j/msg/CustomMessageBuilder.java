/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.msg;

import java.util.List;

import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.entity.response.Article;
import org.weixin4j.entity.response.Music;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * <p>
 * Description： 客服消息处理
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年3月1日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class CustomMessageBuilder {

	/**
	 * 创建文本客服消息
	 * 
	 * @param kf_account
	 *            客服账号
	 * @param openid
	 * @param text
	 * @return
	 */
	public static String buildCustomTextMsg(String kf_account, String openid,
			String text) {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("touser", openid);
		jsonObj.addProperty("msgtype", WeixinConstants.MSG_TYPE_TEXT);
		jsonObj.addProperty("text", text);
		jsonObj.add("customservice", buildCustomservice(kf_account));
		Gson gson = new Gson();
		return gson.toJson(jsonObj);
	}

	/**
	 * 创建图片客服消息
	 * 
	 * @param kf_account
	 *            客服账号
	 * @param openid
	 * @param media_id
	 * @return
	 */
	public static String buildCustomImageMsg(String kf_account, String openid,
			String media_id) {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("touser", openid);
		jsonObj.addProperty("msgtype", WeixinConstants.MSG_TYPE_IMAGE);
		JsonObject voiceJsonObj = new JsonObject();
		voiceJsonObj.addProperty("media_id", media_id);
		jsonObj.add("image", voiceJsonObj);
		jsonObj.add("customservice", buildCustomservice(kf_account));
		Gson gson = new Gson();
		return gson.toJson(jsonObj);
	}

	/**
	 * 创建语音客服消息
	 * 
	 * @param kf_account
	 *            客服账号
	 * @param openid
	 * @param media_id
	 * @return
	 */
	public static String buildCustomVoiceMsg(String kf_account, String openid,
			String media_id) {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("touser", openid);
		jsonObj.addProperty("msgtype", WeixinConstants.MSG_TYPE_VOICE);
		JsonObject voiceJsonObj = new JsonObject();
		voiceJsonObj.addProperty("media_id", media_id);
		jsonObj.add("voice", voiceJsonObj);
		jsonObj.add("customservice", buildCustomservice(kf_account));
		Gson gson = new Gson();
		return gson.toJson(jsonObj);
	}

	/**
	 * 创建视频客服消息
	 * 
	 * @param kf_account
	 *            客服账号
	 * @param openid
	 * @param media_id
	 * @param thumb_media_id
	 * @param title
	 * @param description
	 * @return
	 */
	public static String buildCustomVideoMsg(String kf_account, String openid,
			String media_id, String thumb_media_id, String title,
			String description) {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("touser", openid);
		jsonObj.addProperty("msgtype", WeixinConstants.MSG_TYPE_VIDEO);
		JsonObject videoJsonObj = new JsonObject();
		videoJsonObj.addProperty("media_id", media_id);
		videoJsonObj.addProperty("thumb_media_id", thumb_media_id);
		videoJsonObj.addProperty("title", title);
		videoJsonObj.addProperty("description", description);
		jsonObj.add("video", videoJsonObj);
		jsonObj.add("customservice", buildCustomservice(kf_account));
		Gson gson = new Gson();
		return gson.toJson(jsonObj);
	}

	/**
	 * 创建音乐客服消息
	 * 
	 * @param kf_account
	 *            客服账号
	 * @param openid
	 * @param music
	 * @return
	 */
	public static String buildCustomMusicMsg(String kf_account, String openid,
			Music music) {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("touser", openid);
		jsonObj.addProperty("msgtype", WeixinConstants.MSG_TYPE_MUSIC);
		JsonObject musicJsonObj = new JsonObject();
		musicJsonObj.addProperty("title", music.getTitle());
		musicJsonObj.addProperty("description", music.getDescription());
		musicJsonObj.addProperty("musicurl", music.getMusicUrl());
		musicJsonObj.addProperty("hqmusicurl", music.getHQMusicUrl());
		musicJsonObj.addProperty("thumb_media_id", music.getThumbMediaId());
		jsonObj.add("music", musicJsonObj);
		jsonObj.add("customservice", buildCustomservice(kf_account));
		Gson gson = new Gson();
		return gson.toJson(jsonObj);
	}

	/**
	 * 创建图文客服消息
	 * 
	 * @param kf_account
	 *            客服账号
	 * @param openid
	 * @param articles
	 * @return
	 */
	public static String buildCustomNewsMsg(String kf_account, String openid,
			List<Article> articles) {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("touser", openid);
		jsonObj.addProperty("msgtype", WeixinConstants.MSG_TYPE_NEWS);
		JsonObject newsJsonObj = new JsonObject();
		JsonArray articlesJsonObj = new JsonArray();
		JsonObject articleJsonObj = null;
		for (Article article : articles) {
			articleJsonObj = new JsonObject();
			articleJsonObj.addProperty("title", article.getTitle());
			articleJsonObj.addProperty("description", article.getDescription());
			articleJsonObj.addProperty("url", article.getUrl());
			articleJsonObj.addProperty("picurl", article.getPicUrl());
			articlesJsonObj.add(articleJsonObj);
		}
		newsJsonObj.add("articles", articlesJsonObj);
		jsonObj.add("news", newsJsonObj);
		jsonObj.add("customservice", buildCustomservice(kf_account));
		Gson gson = new Gson();
		return gson.toJson(jsonObj);
	}

	/**
	 * @param kf_account
	 *            客服账号
	 * @return
	 */
	private static JsonElement buildCustomservice(String kf_account) {
		JsonObject customserviceJsonObj = new JsonObject();
		customserviceJsonObj.addProperty("kf_account", kf_account);
		return customserviceJsonObj;
	}

}
