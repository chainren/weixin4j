/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.msg;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.entity.WeixinConstants;

/**
 * <p>
 * Description：消息处理抽像类，在应用中继承该类，并实现具体的处理逻辑
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年4月6日
 *
 * @author chainren
 * @version
 * @since JDK1.7
 *
 *
 */
public abstract class AbstractMessageService {

	private static Logger logger = LoggerFactory.getLogger(AbstractMessageService.class);

	/**
	 *
	 */
	public AbstractMessageService() {
	}

	/**
	 * 接口处只需调用此方法，具体处理消息逻辑在具体方法里实现
	 */
	public String handleMessage(Map<String, Object> reqData) {
		logger.debug("消息处理分发器");
		String respMsgXml = "";
		String msgType = reqData.get("MsgType").toString();
		if (msgType.equals(WeixinConstants.MSG_TYPE_TEXT)) {
			respMsgXml = handleTextMessage(reqData);
		} else if (msgType.equals(WeixinConstants.MSG_TYPE_IMAGE)) {
			respMsgXml = handleImageMessage(reqData);
		} else if (msgType.equals(WeixinConstants.MSG_TYPE_LOCATION)) {
			respMsgXml = handleLocationMessage(reqData);
		} else if (msgType.equals(WeixinConstants.MSG_TYPE_LINK)) {
			respMsgXml = handleLinkMessage(reqData);
		} else if (msgType.equals(WeixinConstants.MSG_TYPE_VIDEO)) {
			respMsgXml = handleVideoMessage(reqData);
		} else if (msgType.equals(WeixinConstants.MSG_TYPE_VOICE)) {
			respMsgXml = handleVoiceMessage(reqData);
		} else if (msgType.equals(WeixinConstants.MSG_TYPE_EVENT)) {
			respMsgXml = handleEventMessage(reqData);
		}
		return respMsgXml;
	}

	/**
	 * 处理事件类消息
	 *
	 * @param reqData
	 * @return
	 */
	public abstract String handleEventMessage(Map<String, Object> reqData);

	/**
	 * 处理语音消息
	 *
	 * @param reqData
	 * @return
	 */
	public abstract String handleVoiceMessage(Map<String, Object> reqData);

	/**
	 * 处理视频消息
	 *
	 * @param reqData
	 * @return
	 */
	public abstract String handleVideoMessage(Map<String, Object> reqData);

	/**
	 * 处理链接消息
	 *
	 * @param reqData
	 * @return
	 */
	public abstract String handleLinkMessage(Map<String, Object> reqData);

	/**
	 * 处理位置消息
	 *
	 * @param reqData
	 * @return
	 */
	public abstract String handleLocationMessage(Map<String, Object> reqData);

	/**
	 * @param reqData
	 * @return
	 */
	public abstract String handleImageMessage(Map<String, Object> reqData);

	/**
	 * 处理文本消息
	 *
	 * @param reqData
	 * @return
	 */
	public abstract String handleTextMessage(Map<String, Object> reqData);

}
