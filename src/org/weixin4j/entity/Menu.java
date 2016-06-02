/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * Description： 自定义菜单
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
public class Menu implements Serializable {
	private List<Button> button;

	public Menu() {
		super();
	}

	public Menu(List<Button> button) {
		super();
		this.button = button;
	}

	/**
	 * @return the button
	 */
	public List<Button> getButton() {
		return button;
	}

	/**
	 * @param button
	 *            the button to set
	 */
	public void setButton(List<Button> button) {
		this.button = button;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Gson gson =  new GsonBuilder().disableHtmlEscaping().create();
		String jsonObj = gson.toJson(this.toJsonObject());
		return jsonObj;
	}

	/**
	 * 将菜单封装成JsonObject对象
	 * @return
	 */
	public JsonObject toJsonObject() {
		JsonObject jsonObject = new JsonObject();
		if (button != null) {
			JsonArray btnArr = new JsonArray();
			for (Button btn : button) {
				btnArr.add(btn.toJsonObject());
			}
			jsonObject.add("button", btnArr);
		}
		return jsonObject;
	}

}
