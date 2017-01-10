package org.weixin4j.test;

import junit.framework.TestSuite;

import org.junit.Test;
import org.weixin4j.auth.AccessToken;
import org.weixin4j.exception.WeixinException;

public class GetAccessToken extends TestSuite {

	@Test
	public void testAccessToken() throws WeixinException {
		String appid = "wxdb78e54613f0f6fd";
		String appsecret = "7ada13df01eb3d6d27161c22dd9119d4";
		AccessToken accessToken = AccessToken.getAccessToken(appid, appsecret);
		System.out.println(accessToken);
	}
}
