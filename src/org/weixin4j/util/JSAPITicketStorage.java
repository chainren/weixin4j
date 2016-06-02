/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.auth.JSAPITicket;
import org.weixin4j.entity.WeixinConstants;
import org.weixin4j.exception.WeixinException;

/**
 * <p>
 * Description： 存储jsapi_ticket
 * <p>
 * Create Date： 2015年11月23日
 * 
 * @author chenrg
 * @version 1.0
 * @since JDK1.7
 * 
 * 
 */
public class JSAPITicketStorage {
	private static Logger logger = LoggerFactory.getLogger(JSAPITicketStorage.class);

	/**
	 * 存储jsapi_ticket
	 */
	private static JSAPITicket jsapiTicket = null;

	/**
	 * 获取jsapi_ticket，如果本地保存的有且没有失效，则返回。否则重新获取一次
	 * 
	 * @param accessToken
	 * @return
	 */
	public static String getJSAPITicket(String accessToken) {
		if (jsapiTicket != null) {
			// 校验jsapi_ticket是否失效
			long keepMills = System.currentTimeMillis() - jsapiTicket.getLastChgangeTimeMills();
			if (WeixinConstants.EXPIRE_IN * 1000L < keepMills) {
				try {
					jsapiTicket = JSAPITicket.getJSAPITicket(accessToken);
				} catch (WeixinException e) {
					logger.error(e.getMessage());
				}
			}
		} else {
			// 为空时，立即获取一次
			try {
				jsapiTicket = JSAPITicket.getJSAPITicket(accessToken);
			} catch (WeixinException e) {
				logger.error(e.getMessage());
			}
		}
		return jsapiTicket.getTicket();
	}
}
