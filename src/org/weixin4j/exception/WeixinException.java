/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.exception;

/**
 * <p>
 * Description： TODO
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月14日
 *
 * @author chainren
 * @version
 * @since JDK1.7
 *
 *
 */
public class WeixinException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public WeixinException() {
		super();
	}

	public WeixinException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause);
	}

	public WeixinException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeixinException(String message) {
		super(message);
	}

	public WeixinException(Throwable cause) {
		super(cause);
	}

}
