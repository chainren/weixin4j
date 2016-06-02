/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.auth.AccessToken;
import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.exception.WeixinException;

/**
 * <p>
 * Description： 存储access_token
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年2月2日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class AccessTokenStorage {

	private static Logger logger = LoggerFactory
			.getLogger(AccessTokenStorage.class);

	/**
	 * 存储access_token
	 */
	private static AccessToken accessToken = null;

	/**
	 * 获取access_token，如果本地保存的有且没有失效，则返回。否则重新获取一次
	 * @param appid 
	 * @param appsecret
	 * @return
	 */
	public static String getAccessToken(String appid, String appsecret) {
		if (accessToken != null) {
			// 校验access_token是否失效
			long keepMills = System.currentTimeMillis()
					- accessToken.getLastChgangeTimeMills();
			if (WeixinConstants.EXPIRE_IN * 1000L < keepMills) {
				try {
					accessToken = AccessToken.getAccessToken(appid, appsecret);
				} catch (WeixinException e) {
					logger.error(e.getMessage());
				}
			}
		} else {
			// 为空时，立即获取一次
			try {
				accessToken = AccessToken.getAccessToken(appid, appsecret);
			} catch (WeixinException e) {
				logger.error(e.getMessage());
			}
		}
		return accessToken.getAccess_token();
	}
}
