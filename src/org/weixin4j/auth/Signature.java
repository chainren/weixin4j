/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.auth;

import java.util.Arrays;

import org.weixin4j.util.EncoderHandler;

/**
 * <p>
 * Description：接口调用验证，使用申请成为开发者时使用的token字符串。
 * <p>
 * <p>
 * 摘录自微信公众平台开发文档
 * <p>
 * 在开发者首次提交验证申请时，微信服务器将发送GET请求到填写的URL上，并且带上四个参数（signature、timestamp、nonce、
 * echostr），开发者通过对签名（即signature）的效验，来判断此条消息的真实性。
 * 
 * <p>
 * 此后，每次开发者接收用户消息的时候，微信也都会带上前面三个参数（signature、timestamp、nonce）访问开发者设置的URL，
 * 开发者依然通过对签名的效验判断此条消息的真实性。效验方式与首次提交验证申请一致。
 * 
 * <p>
 * 加密/校验流程如下：
 * <p>
 * 1. 将token、timestamp、nonce三个参数进行字典序排序
 * <p>
 * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
 * <p>
 * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
 * 
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月10日
 * 
 * @author chainren
 * @version 1.0
 * @since JDK1.7
 * 
 * 
 */
public class Signature {
	/**
	 * token令牌，是申请成为开发者时使用的token.
	 */
	private String token;
	/**
	 * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 */
	private String signature;
	/**
	 * 时间戳
	 */
	private String timestamp;
	/**
	 * 随机数
	 */
	private String nonce;

	public Signature() {
		super();
	}

	public Signature(String token, String signature, String timestamp,
			String nonce) {
		super();
		this.token = token;
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	/**
	 * 接口访问签名验证
	 * 
	 * @return
	 */
	public boolean checkSignature() {
		if (signature == null) {
			return false;
		}
		String[] arr = { token, timestamp, nonce };
		Arrays.sort(arr);// 数组排序
		String str = "";
		str = arr[0] + arr[1] + arr[2];
		String echo = EncoderHandler.encode("SHA1", str);// SHA1加密
		if (echo.equals(signature)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"token\"=\"");
		builder.append(token);
		builder.append("\", \"signature\"=\"");
		builder.append(signature);
		builder.append("\", \"timestamp\"=\"");
		builder.append(timestamp);
		builder.append("\", \"nonce\"=\"");
		builder.append(nonce);
		builder.append("\"}");
		return builder.toString();
	}

}
