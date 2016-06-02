/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.msg;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * <p>
 * Description： 生成自定义的XStream
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
public class UserDefinedXStream {
	/**
	 * 创建一个自定义的XStream，它可以在xml标记中添加CDATA标记
	 * 
	 * @return XStream
	 */
	public static XStream createUserDefXStream() {
		return new XStream(new XppDriver() {
			@Override
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {
					// 对所有xml节点的转换都增加CDATA标记
					boolean cdata = true;

					@Override
					protected void writeText(QuickWriter writer, String text) {
						if (cdata) {
							if (text.matches("^\\d+$")) {
								writer.write(text);
								return;
							}
							writer.write("<![CDATA[");
							writer.write(text);
							writer.write("]]>");
						} else {
							writer.write(text);
						}
					}
				};
			}
		});
	}
}
