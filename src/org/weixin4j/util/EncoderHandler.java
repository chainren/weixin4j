/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.util;

import java.security.MessageDigest;

/**
 * <p>
 * Description： TODO
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月8日
 *
 * @author chainren
 * @version
 * @since JDK1.7
 *
 *
 */
public class EncoderHandler {

	public static final String ALGORITHM_MD5 = "MD5";

	public static final String ALGORITHM_SHA1 = "SHA1";

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
		'e', 'f' };

	public static String encode(String algorithm, String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String encodeByMD5(String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_MD5);
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		// 把密文转换成十六进制的字符串形式
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		System.out.println("111111 MD5  :" + EncoderHandler.encodeByMD5("111111"));
		System.out.println("111111 MD5  :" + EncoderHandler.encode("MD5", "111111"));
		System.out.println("111111 SHA1 :" + EncoderHandler.encode("SHA1", "111111"));

	}

}
