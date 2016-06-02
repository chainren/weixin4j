/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity;

import java.io.Serializable;
import java.util.List;



import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * Description： 自定义菜单按钮
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年1月25日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class Button implements Serializable {
	/**
	 * 菜单标题，不超过16个字节，子菜单不超过40个字节
	 */
	private String name;
	/**
	 * 菜单的响应动作类型
	 */
	private String type;
	/**
	 * 菜单KEY值，用于消息接口推送，不超过128字节
	 */
	private String key;
	/**
	 * 网页链接，用户点击菜单可打开链接，不超过256字节
	 */
	private String url;
	/**
	 * 二级菜单数组，个数应为1~5个
	 */
	private List<Button> sub_button;

	public Button() {
		super();
	}

	public Button(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Button(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	/**
	 * 为了支持两种类型的Button构造器:flag=1（type,name,url）;flag=2（type,name,key）
	 * 
	 * @param type
	 * @param name
	 * @param multp
	 *            flag=1 url;flag=2 key
	 * @param flag
	 *            1或2
	 */
	public Button(String type, String name, String multp, int flag) {
		super();
		this.type = type;
		this.name = name;
		if (flag == 1) {
			this.url = multp;
		} else if (flag == 2) {
			this.key = multp;
		}
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the sub_button
	 */
	public List<Button> getSub_button() {
		return sub_button;
	}

	/**
	 * @param sub_button
	 *            the sub_button to set
	 */
	public void setSub_button(List<Button> sub_button) {
		this.sub_button = sub_button;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		Gson gson =  new GsonBuilder().disableHtmlEscaping().create();
		String jsonObj = gson.toJson(this.toJsonObject());
		return jsonObj;
	}

	/**
	 * 将按钮封装成JsonObject对象
	 * 
	 * @return
	 */
	public JsonObject toJsonObject() {
		JsonObject jsonObject = new JsonObject();
		if (StringUtils.isNotEmpty(this.name)) {
			jsonObject.addProperty("name", name);
		}
		if (StringUtils.isNotEmpty(this.type)) {
			jsonObject.addProperty("type", type);
		}
		if (StringUtils.isNotEmpty(this.key)) {
			jsonObject.addProperty("key", key);
		}
		if (StringUtils.isNotEmpty(this.url)) {
			jsonObject.addProperty("url", url);
		}
		if (sub_button != null) {
			JsonArray jsonArray = new JsonArray();
			for (Button subbtn : sub_button) {
				jsonArray.add(subbtn.toJsonObject());
			}
			jsonObject.add("sub_button", jsonArray);
		}
		return jsonObject;
	}

}
