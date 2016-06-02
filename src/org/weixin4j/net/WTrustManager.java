/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.net;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * <p>
 * Description： 证书信任管理器（用于https请求），空实现，可支持所有的证书
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年1月28日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class WTrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {

	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {

	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}
