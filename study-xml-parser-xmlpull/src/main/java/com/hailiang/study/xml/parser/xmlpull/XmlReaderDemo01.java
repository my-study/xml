package com.hailiang.study.xml.parser.xmlpull;

import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlReaderDemo01 {

	public static void main(String[] args) {
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			
			xpp.setInput(new StringReader(builderXMLContent()));
			
			processDocument(xpp);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String builderXMLContent() {
		StringBuilder xmlSb = new StringBuilder();
		xmlSb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		xmlSb.append("<users>").append(lineSeparator());
		xmlSb.append("  <user id='1001'>").append(lineSeparator());
		xmlSb.append("    <name>张三</name>").append(lineSeparator());
		xmlSb.append("    <sex>男</sex>").append(lineSeparator());
		xmlSb.append("    <age>23</age>").append(lineSeparator());
		xmlSb.append("  </user>").append(lineSeparator());
		xmlSb.append("  <user id='1002'>").append(lineSeparator());
		xmlSb.append("    <name>李四</name>").append(lineSeparator());
		xmlSb.append("    <sex>女</sex>").append(lineSeparator());
		xmlSb.append("    <age>21</age>").append(lineSeparator());
		xmlSb.append("  </user>").append(lineSeparator());
		xmlSb.append("  <user id='1003'>").append(lineSeparator());
		xmlSb.append("    <name>王五</name>").append(lineSeparator());
		xmlSb.append("    <sex>女</sex>").append(lineSeparator());
		xmlSb.append("    <age>22</age>").append(lineSeparator());
		xmlSb.append("  </user>").append(lineSeparator());
		xmlSb.append("</users>");
		
		return xmlSb.toString();
	}

	private static void processDocument(XmlPullParser xpp) throws XmlPullParserException, IOException {
		int eventType = xpp.getEventType();
		
		do {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start Document");
			} else if (eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			} else if (eventType == XmlPullParser.START_TAG) {
				processStartElement(xpp);
			} else if (eventType == XmlPullParser.END_TAG) {
				processEndElement(xpp);
			} else if (eventType == XmlPullParser.TEXT) {
				processTextElement(xpp);
			}
			eventType = xpp.next();
		} while (eventType != XmlPullParser.END_DOCUMENT);
		
	}

	private static void processStartElement(XmlPullParser xpp) {
		String name = xpp.getName();
		String uri = xpp.getNamespace();
		if ("".equals(uri)) {
			System.out.println("Start Element: " + name);
		} else {
			System.out.println("Start Element: {" + uri + "}" + name);
		}
	}
	
	/**
	 * 处理结束标签，与开启标签最大的区别就是，结束标签没有attribute
	 */
	private static void processEndElement(XmlPullParser xpp) {
		String name = xpp.getName();
		String uri = xpp.getNamespace();
		if ("".equals(uri)) {
			System.out.println("End Element: " + name);
		} else {
			System.out.println("End Element: {" + uri + "}" + name);
		}
	}
	
	/**
	 * 处理文本内容
	 */
	private static void processTextElement(XmlPullParser xpp) {
		System.out.println("text Element: " + xpp.getText());
	}
	
	/**
	 * 分行符
	 */
	private static String lineSeparator() {
		return System.getProperty("line.separator");
	}
	
}
