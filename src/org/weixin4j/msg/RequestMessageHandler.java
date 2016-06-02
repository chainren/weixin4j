/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.msg;

import java.util.Map;

import org.weixin4j.entity.request.ImageMessage;
import org.weixin4j.entity.request.LinkMessage;
import org.weixin4j.entity.request.LocationEventMessage;
import org.weixin4j.entity.request.LocationMessage;
import org.weixin4j.entity.request.MenuEventMessage;
import org.weixin4j.entity.request.RecongnitionVoiceMessage;
import org.weixin4j.entity.request.ScanQRCodeEventMessage;
import org.weixin4j.entity.request.SubscribeEventMessage;
import org.weixin4j.entity.request.TextMessage;
import org.weixin4j.entity.request.VideoMessage;
import org.weixin4j.entity.request.VoiceMessage;

/**
 * <p>
 * Description： 接收的消息处理器，将请求xml转化成对应的消息实体
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
public class RequestMessageHandler {

	/**
	 * 构建请求的文本消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 文本消息对象
	 */
	public static TextMessage parseTextMessage(Map<String, Object> map) {
		TextMessage textMsg = new TextMessage();
		textMsg.setToUserName(map.get("ToUserName").toString());
		textMsg.setFromUserName(map.get("FromUserName").toString());
		textMsg.setMsgId(Long.valueOf(map.get("MsgId").toString()));
		textMsg.setMsgType(map.get("MsgType").toString());
		textMsg.setCreateTime(Long.valueOf(map.get("CreateTime").toString()));
		textMsg.setContent(map.get("Content").toString());
		return textMsg;
	}

	/**
	 * 构建请求的图片消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 图片消息对象
	 */
	public static ImageMessage parseImageMessage(Map<String, Object> map) {
		ImageMessage imageMsg = new ImageMessage();
		imageMsg.setToUserName(map.get("ToUserName").toString());
		imageMsg.setFromUserName(map.get("FromUserName").toString());
		imageMsg.setMsgId(Long.valueOf(map.get("MsgId").toString()));
		imageMsg.setMsgType(map.get("MsgType").toString());
		imageMsg.setCreateTime(Long.valueOf(map.get("CreateTime").toString()));
		imageMsg.setMediaId(map.get("MediaId").toString());
		imageMsg.setPicUrl(map.get("PicUrl").toString());
		return imageMsg;
	}

	/**
	 * 构建请求的链接消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 链接消息对象
	 */
	public static LinkMessage parseLinkMessage(Map<String, Object> map) {
		LinkMessage linkMsg = new LinkMessage();
		linkMsg.setToUserName(map.get("ToUserName").toString());
		linkMsg.setFromUserName(map.get("FromUserName").toString());
		linkMsg.setMsgId(Long.valueOf(map.get("MsgId").toString()));
		linkMsg.setMsgType(map.get("MsgType").toString());
		linkMsg.setCreateTime(Long.valueOf(map.get("CreateTime").toString()));
		linkMsg.setTitle(map.get("Title").toString());
		linkMsg.setDescription(map.get("Description").toString());
		linkMsg.setUrl(map.get("Url").toString());
		return linkMsg;
	}

	/**
	 * 构建请求的位置消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 位置消息对象
	 */
	public static LocationMessage parseLocationMessage(Map<String, Object> map) {
		LocationMessage locationMsg = new LocationMessage();
		locationMsg.setToUserName(map.get("ToUserName").toString());
		locationMsg.setFromUserName(map.get("FromUserName").toString());
		locationMsg.setMsgId(Long.valueOf(map.get("MsgId").toString()));
		locationMsg.setMsgType(map.get("MsgType").toString());
		locationMsg.setCreateTime(Long
				.valueOf(map.get("CreateTime").toString()));
		locationMsg.setLocation_X(map.get("Location_X").toString());
		locationMsg.setLocation_Y(map.get("Location_Y").toString());
		locationMsg.setLabel(map.get("Label").toString());
		locationMsg.setScale(map.get("Scale").toString());
		return locationMsg;
	}

	/**
	 * 构建请求的视频消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 视频消息对象
	 */
	public static VideoMessage parseVideoMessage(Map<String, Object> map) {
		VideoMessage videoMsg = new VideoMessage();
		videoMsg.setToUserName(map.get("ToUserName").toString());
		videoMsg.setFromUserName(map.get("FromUserName").toString());
		videoMsg.setMsgId(Long.valueOf(map.get("MsgId").toString()));
		videoMsg.setMsgType(map.get("MsgType").toString());
		videoMsg.setCreateTime(Long.valueOf(map.get("CreateTime").toString()));
		videoMsg.setMediaId(map.get("MediaId").toString());
		videoMsg.setThumbMediaId(map.get("ThumbMediaId").toString());
		return videoMsg;
	}

	/**
	 * 构建请求的语音消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 语音消息对象
	 */
	public static VoiceMessage parseVoiceMessage(Map<String, Object> map) {
		VoiceMessage voiceMsg = new VoiceMessage();
		voiceMsg.setToUserName(map.get("ToUserName").toString());
		voiceMsg.setFromUserName(map.get("FromUserName").toString());
		voiceMsg.setMsgId(Long.valueOf(map.get("MsgId").toString()));
		voiceMsg.setMsgType(map.get("MsgType").toString());
		voiceMsg.setCreateTime(Long.valueOf(map.get("CreateTime").toString()));
		voiceMsg.setFormat(map.get("Format").toString());
		voiceMsg.setMediaId(map.get("MediaId").toString());
		return voiceMsg;
	}

	/**
	 * 构建请求的接收语音识别消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 语音识别消息
	 */
	public static RecongnitionVoiceMessage parseRecongnitionVoiceMessage(
			Map<String, Object> map) {
		RecongnitionVoiceMessage recongnitionVoiceMsg = new RecongnitionVoiceMessage();
		recongnitionVoiceMsg.setToUserName(map.get("ToUserName").toString());
		recongnitionVoiceMsg
				.setFromUserName(map.get("FromUserName").toString());
		recongnitionVoiceMsg
				.setMsgId(Long.valueOf(map.get("MsgId").toString()));
		recongnitionVoiceMsg.setMsgType(map.get("MsgType").toString());
		recongnitionVoiceMsg.setCreateTime(Long.valueOf(map.get("CreateTime")
				.toString()));
		recongnitionVoiceMsg.setFormat(map.get("Format").toString());
		recongnitionVoiceMsg.setMediaId(map.get("MediaId").toString());
		recongnitionVoiceMsg.setRecognition(map.get("Recognition").toString());
		return recongnitionVoiceMsg;
	}

	/**
	 * 构建关注/取消公众号事件消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 关注/取消公众号事件消息
	 */
	public static SubscribeEventMessage parseSubscribeEventMessage(
			Map<String, Object> map) {
		SubscribeEventMessage subscribeEventMsg = new SubscribeEventMessage();
		subscribeEventMsg.setToUserName(map.get("ToUserName").toString());
		subscribeEventMsg.setFromUserName(map.get("FromUserName").toString());
		subscribeEventMsg.setMsgType(map.get("MsgType").toString());
		subscribeEventMsg.setCreateTime(Long.valueOf(map.get("CreateTime")
				.toString()));
		subscribeEventMsg.setEvent(map.get("Event").toString());
		return subscribeEventMsg;
	}

	/**
	 * 扫描二维码事件，有两种情况，1.如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
	 * 2.如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 扫描二维码事件消息对象
	 */
	public static ScanQRCodeEventMessage parseScanQRCodeEventMessage(
			Map<String, Object> map) {
		ScanQRCodeEventMessage scanQRCodeEventMsg = new ScanQRCodeEventMessage();
		scanQRCodeEventMsg.setToUserName(map.get("ToUserName").toString());
		scanQRCodeEventMsg.setFromUserName(map.get("FromUserName").toString());
		scanQRCodeEventMsg.setMsgType(map.get("MsgType").toString());
		scanQRCodeEventMsg.setCreateTime(Long.valueOf(map.get("CreateTime")
				.toString()));
		scanQRCodeEventMsg.setEvent(map.get("Event").toString());
		scanQRCodeEventMsg.setEventKey(map.get("EventKey").toString());
		scanQRCodeEventMsg.setTicket(map.get("Ticket").toString());
		return scanQRCodeEventMsg;
	}

	/**
	 * 上报地理位置事件
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 地理位置事件消息对象
	 */
	public static LocationEventMessage parseLocationEventMessage(Map<String, Object> map) {
		LocationEventMessage locationEventMsg = new LocationEventMessage();
		locationEventMsg.setToUserName(map.get("ToUserName").toString());
		locationEventMsg.setFromUserName(map.get("FromUserName").toString());
		locationEventMsg.setMsgType(map.get("MsgType").toString());
		locationEventMsg.setCreateTime(Long.valueOf(map.get("CreateTime")
				.toString()));
		locationEventMsg.setEvent(map.get("Event").toString());
		locationEventMsg.setLatitude(map.get("Latitude").toString());
		locationEventMsg.setLongitude(map.get("Longitude").toString());
		locationEventMsg.setPrecision(map.get("Precision").toString());
		return locationEventMsg;
	}

	/**
	 * 菜单点击事件消息
	 * 
	 * @param map
	 *            请求消息数据
	 * @return 菜单点击事件消息对象
	 */
	public static MenuEventMessage parseMenuEventMessage(Map<String, Object> map) {
		MenuEventMessage menuEventMsg = new MenuEventMessage();
		menuEventMsg.setToUserName(map.get("ToUserName").toString());
		menuEventMsg.setFromUserName(map.get("FromUserName").toString());
		menuEventMsg.setMsgType(map.get("MsgType").toString());
		menuEventMsg.setCreateTime(Long.valueOf(map.get("CreateTime")
				.toString()));
		menuEventMsg.setEvent(map.get("Event").toString());
		menuEventMsg.setEventKey(map.get("EventKey").toString());
		return menuEventMsg;
	}
}
