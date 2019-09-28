package com.bite.xml.sax;

import jdk.nashorn.internal.runtime.ECMAException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 使用SAX解析将contact.xml原封不动打印在控制台上
 *
 * 使用sAX解析读取contact.xml中contact标签 封装Contact联系人对象，遍历联系人
 *
 *
 * 1）创建解析器
 * 2）解析xml文件
 *
 *  3）事件处理程序
 *
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        //A）：创建SAXParser解析器
        SAXParser parser = SAXParserFactory
                .newInstance().newSAXParser();
        // B):解析contact.xml 同时绑定事件处理程序
        //Demo.class.getClassLoder().getResourceAsStream()

        MyDemo2DefaultHandler handler2 = new MyDemo2DefaultHandler() ;
        parser.parse(Demo2.class.getClassLoader().
                //注册事件监听器
                        getResourceAsStream("contact.xml"),handler2);

        String s = handler2.getXMLContent();
        System.out.println(s);

    }
}
