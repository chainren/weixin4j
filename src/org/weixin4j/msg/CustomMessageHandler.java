/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.msg;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.entity.Errmsg;
import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.entity.WeixinInterface;
import org.weixin4j.entity.request.KfAccount;
import org.weixin4j.entity.request.KfAccountInfo;
import org.weixin4j.exception.WeixinException;
import org.weixin4j.net.HttpConnectionUtils;

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
public class CustomMessageHandler {

	private static Logger logger = LoggerFactory
			.getLogger(CustomMessageHandler.class);

	/**
	 * 发送客服消息
	 * 
	 * @param access_token
	 * @param customMsg
	 * @return
	 */
	public static boolean sendCustomMessage(String access_token,
			String customMsg) {
		boolean flag = false;
		logger.debug("发送客服消息：" + customMsg);
		String requestUrl = WeixinInterface.URL_KF_SEND.replace(
				WeixinConstants.REPLACE_ACCESS_TOKEN, access_token);
		try {
			JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl,
					WeixinConstants.REQUESTMETHOD_POST, customMsg);
			Gson gson = new Gson();
			Errmsg errmsg = gson.fromJson(jsonObj, Errmsg.class);
			logger.error("发送客服消息返回：" + errmsg);
			if (WeixinConstants.RETURN_CODE_OK.equals(errmsg.getErrcode())) {
				// 成功发送客服消息
				flag = true;
			}
		} catch (WeixinException e) {
			logger.error("发送客服消息异常：" + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 添加客服帐号
	 * 
	 * @param access_token
	 * @param kfaccount
	 * @return
	 */
	public static boolean addKfaccount(String access_token, KfAccount kfaccount) {
		boolean flag = false;
		logger.debug("添加客服帐号");
		String requestUrl = WeixinInterface.URL_KFACCOUNT_ADD.replace(
				WeixinConstants.REPLACE_ACCESS_TOKEN, access_token);
		try {
			JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl,
					WeixinConstants.REQUESTMETHOD_POST, kfaccount.toString());
			Gson gson = new Gson();
			Errmsg errmsg = gson.fromJson(jsonObj, Errmsg.class);
			logger.debug("添加客服帐号返回：" + errmsg);
			if (WeixinConstants.RETURN_CODE_OK.equals(errmsg.getErrcode())) {
				flag = true;
			}
		} catch (WeixinException e) {
			logger.error("添加客服账号异常：" + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 修改客服帐号
	 * 
	 * @param access_token
	 * @param kfaccount
	 * @return
	 */
	public static boolean updateKfaccount(String access_token,
			KfAccount kfaccount) {
		boolean flag = false;
		logger.debug("修改客服帐号");
		String requestUrl = WeixinInterface.URL_KFACCOUNT_UPDATE.replace(
				WeixinConstants.REPLACE_ACCESS_TOKEN, access_token);
		try {
			JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl,
					WeixinConstants.REQUESTMETHOD_POST, kfaccount.toString());
			Gson gson = new Gson();
			Errmsg errmsg = gson.fromJson(jsonObj, Errmsg.class);
			logger.debug("修改客服帐号返回：" + errmsg);
			if (WeixinConstants.RETURN_CODE_OK.equals(errmsg.getErrcode())) {
				flag = true;
			}
		} catch (WeixinException e) {
			logger.error("修改客服账号异常：" + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 删除客服帐号
	 * 
	 * @param access_token
	 * @param kfaccount
	 * @return
	 */
	public static boolean delKfaccount(String access_token, KfAccount kfaccount) {
		boolean flag = false;
		logger.debug("删除客服帐号");
		String requestUrl = WeixinInterface.URL_KFACCOUNT_DEL.replace(
				WeixinConstants.REPLACE_ACCESS_TOKEN, access_token);
		try {
			JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl,
					WeixinConstants.REQUESTMETHOD_GET, kfaccount.toString());
			Gson gson = new Gson();
			Errmsg errmsg = gson.fromJson(jsonObj, Errmsg.class);
			logger.debug("删除客服帐号返回：" + errmsg);
			if (WeixinConstants.RETURN_CODE_OK.equals(errmsg.getErrcode())) {
				flag = true;
			}
		} catch (WeixinException e) {
			logger.error("删除客服帐号异常：" + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 获取客服列表
	 * 
	 * @param access_token
	 * @return
	 */
	public static List<KfAccountInfo> getKflist(String access_token) {
		logger.debug("获取客服列表");
		List<KfAccountInfo> kfList = new ArrayList<KfAccountInfo>();
		String requestUrl = WeixinInterface.URL_KFLIST_GET.replace(
				WeixinConstants.REPLACE_ACCESS_TOKEN, access_token);
		try {
			JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl,
					WeixinConstants.REQUESTMETHOD_GET, null);
			Gson gson = new Gson();
			if (jsonObj.getAsString().contains("kf_list")) {
				JsonArray jsonArr = jsonObj.getAsJsonArray("kf_list");
				KfAccountInfo kfAccountInfo = null;
				for (JsonElement jsonElement : jsonArr) {
					kfAccountInfo = gson.fromJson(jsonElement,
							KfAccountInfo.class);
					kfList.add(kfAccountInfo);
				}
			}
		} catch (WeixinException e) {
			logger.error("获取客服列表异常：" + e.getMessage());
			e.printStackTrace();
		}
		return kfList;
	}

	/**
	 * 获取客服列表
	 * 
	 * @param access_token
	 * @return
	 */
	public static List<KfAccountInfo> getKfOnlinelist(String access_token) {
		logger.debug("获取在线客服列表");
		List<KfAccountInfo> kfList = new ArrayList<KfAccountInfo>();
		String requestUrl = WeixinInterface.URL_KFONLINELIST_GET.replace(
				WeixinConstants.REPLACE_ACCESS_TOKEN, access_token);
		try {
			JsonObject jsonObj = HttpConnectionUtils.httpsRequest(requestUrl,
					WeixinConstants.REQUESTMETHOD_GET, null);
			Gson gson = new Gson();
			if (jsonObj.getAsString().contains("kf_online_list")) {
				JsonArray jsonArr = jsonObj.getAsJsonArray("kf_online_list");
				KfAccountInfo kfAccountInfo = null;
				for (JsonElement jsonElement : jsonArr) {
					kfAccountInfo = gson.fromJson(jsonElement,
							KfAccountInfo.class);
					kfList.add(kfAccountInfo);
				}
			}
		} catch (WeixinException e) {
			logger.error("获取在线客服列表异常：" + e.getMessage());
			e.printStackTrace();
		}
		return kfList;
	}
}
