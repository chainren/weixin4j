/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * <p>
 * Description： 二维码
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年4月4日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class QRCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过1800。
	 */
	private long expire_seconds = 1800;

	/**
	 * 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
	 */
	private String action_name;

	/**
	 * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 */
	private int scene_id;

	/**
	 * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
	 */
	private String scene_str;

	/**
	 * 
	 */
	public QRCode() {

	}
	
	
	/**
	 * 临时二维码构造器
	 * @param expire_seconds
	 * @param action_name
	 * @param scene_id
	 */
	public QRCode(long expire_seconds, String action_name, int scene_id) {
		super();
		this.expire_seconds = expire_seconds;
		this.action_name = action_name;
		this.scene_id = scene_id;
	}
	
	/**
	 * 永久二维码构造器
	 * @param action_name
	 * @param scene_id
	 */
	public QRCode(String action_name, int scene_id) {
		super();
		this.action_name = action_name;
		this.scene_id = scene_id;
	}

	/**
	 * 永久二维码构造器
	 * @param action_name
	 * @param scene_str
	 */
	public QRCode(String action_name, String scene_str) {
		super();
		this.action_name = action_name;
		this.scene_str = scene_str;
	}


	/**
	 * @return the expire_seconds
	 */
	public long getExpire_seconds() {
		return expire_seconds;
	}

	/**
	 * @param expire_seconds
	 *            the expire_seconds to set
	 */
	public void setExpire_seconds(long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	/**
	 * @return the action_name
	 */
	public String getAction_name() {
		return action_name;
	}

	/**
	 * @param action_name
	 *            the action_name to set
	 */
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	/**
	 * @return the scene_id
	 */
	public int getScene_id() {
		return scene_id;
	}

	/**
	 * @param scene_id
	 *            the scene_id to set
	 */
	public void setScene_id(int scene_id) {
		this.scene_id = scene_id;
	}

	/**
	 * @return the scene_str
	 */
	public String getScene_str() {
		return scene_str;
	}

	/**
	 * @param scene_str
	 *            the scene_str to set
	 */
	public void setScene_str(String scene_str) {
		this.scene_str = scene_str;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"expire_seconds\":\"");
		builder.append(expire_seconds);
		builder.append("\", \"action_name\":\"");
		builder.append(action_name);
		builder.append("\", \"scene_id\":\"");
		builder.append(scene_id);
		builder.append("\", \"scene_str\":\"");
		builder.append(scene_str);
		builder.append("\"}");
		return builder.toString();
	}

	/** 组装临时二维码参数 **/
	public String toJsonQRScene() {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("expire_seconds", expire_seconds);
		jsonObj.addProperty("action_name", action_name);
		JsonObject sceneid = new JsonObject();
		sceneid.addProperty("scene_id", scene_id);
		JsonObject scene = new JsonObject();
		scene.add("scene", sceneid);
		jsonObj.add("action_info", scene);
		Gson gson = new Gson();
		return gson.toJson(jsonObj);
	}

	/**
	 * 组装永久二维码参数 str为空，创建的json串为：{"action_name": "QR_LIMIT_SCENE", "action_info": {"scene": {"scene_id": 123}}}
	 * str不为空，则创建json:{"action_name": "QR_LIMIT_STR_SCENE", "action_info": {"scene": {"scene_str": "123"}}}
	 * 
	 * */
	public String toJsonQRLimitScene(String str) {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("action_name", action_name);
		JsonObject sceneid = new JsonObject();
		if (str != null) {
			sceneid.addProperty("scene_str", scene_str);
		} else {
			sceneid.addProperty("scene_id", scene_id);
		}
		JsonObject scene = new JsonObject();
		scene.add("scene", sceneid);
		jsonObj.add("action_info", scene);
		Gson gson = new Gson();
		return gson.toJson(jsonObj);
	}

	public static void main(String[] args) {
		QRCode qrcode = new QRCode(1000,WeixinConstants.QR_SCENE,123123);
		System.out.println(qrcode);
		String qrscene = qrcode.toJsonQRScene();
		System.out.println(qrscene);
		String qrlimitscene = qrcode.toJsonQRLimitScene(null);
		System.out.println(qrlimitscene);
	}

}
