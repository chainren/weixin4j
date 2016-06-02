/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.msg;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.weixin4j.entity.request.TextMessage;

import com.thoughtworks.xstream.XStream;

/**
 * <p>
 * Description：微信接口消息报文解析工具，负责对微信发送来的xml格式报文进行解析，封装成为接口实体对象。
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月10日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public class MessageParser {

	/**
	 * 转换一个xml字串为接口实体对象
	 * 
	 * @param xml
	 *            字串形式的xml
	 * @param clz
	 *            实体类型
	 * @return 实体对象
	 */
	@SuppressWarnings("rawtypes")
	public static Object parseSimpleXML(String xml, Class clz) {
		XStream xs = UserDefinedXStream.createUserDefXStream();
		xs.alias("xml", clz);
		return xs.fromXML(xml);
	}

	/**
	 * 转换一个xml输入流为接口实体对象
	 * 
	 * @param xml
	 *            输入流
	 * @param clz
	 *            实体类型
	 * @return 实体对象
	 */
	@SuppressWarnings("rawtypes")
	public static Object parseSimpleXML(InputStream xml, Class clz) {
		XStream xs = UserDefinedXStream.createUserDefXStream();
		xs.alias("xml", clz);
		return xs.fromXML(xml);
	}

	/**
	 * 从xml输入流中获取消息数据，封装成map对象
	 * 
	 * @param instream
	 *            输入流
	 * @return 消息数据
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMessageDataMap(InputStream instream) {
		// 读取输入流
		Map<String, Object> map = new HashMap<String, Object>();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(instream);
			if (document != null) {
				// 得到xml根元素
				Element root = document.getRootElement();
				List<Element> els = root.elements();
				// 得到根元素的所有子节点
				for (Element el : els) {
					map.put(el.getName(), el.getText());
				}
			}
		} catch (DocumentException e) {
			throw new RuntimeException("解析xml文档异常，请检查xml格式是否正确");
		}
		return map;
	}

	/**
	 * 
	 * @param xml
	 *            xml流数据
	 * @param entityClz
	 *            实体类型 实体对象
	 * @param otherClz
	 *            实体中属性属于自定义属性的，指定该属性在xml中的标签名为类名，默认是类的全路径。
	 * @param toIgnoreClz
	 *            针对集合属性，在xml中忽略属性名标签
	 * @param toIgnoreTag
	 *            集合属性的属性名
	 * @return 实体对象
	 */
	@SuppressWarnings("rawtypes")
	public static Object parseCustomXML(InputStream xml, Class entityClz,
			Class[] otherClz, Class[] toIgnoreClz, String[] toIgnoreTag) {
		XStream xs = UserDefinedXStream.createUserDefXStream();
		xs.alias("xml", entityClz.getClass());
		if (otherClz != null && otherClz.length > 0) {
			for (Class oclz : otherClz) {
				xs.alias(oclz.getSimpleName(), oclz);
			}
		}
		/** 针对实体中的集合属性，去除集合属性名称 **/
		if (toIgnoreTag != null && toIgnoreTag.length > 0) {
			for (int i = 0; i < toIgnoreTag.length; i++) {
				xs.addImplicitCollection(toIgnoreClz[i], toIgnoreTag[i],
						toIgnoreClz[i].getSimpleName(), toIgnoreClz[i]);
			}
		}
		return xs.fromXML(xml);
	}

	public static void main(String[] args) {
		String xml = "<xml>" + "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[this is a test]]></Content>"
				+ "<MsgId>1234567890123456</MsgId>" + "</xml>";

		TextMessage tm = (TextMessage) parseSimpleXML(xml, TextMessage.class);
		System.out.println(" obj parse from xml: \n" + tm);

		InputStream is = new StringBufferInputStream(xml);
		Map<String, Object> map = getMessageDataMap(is);
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key + "=" + map.get(key));
		}
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
