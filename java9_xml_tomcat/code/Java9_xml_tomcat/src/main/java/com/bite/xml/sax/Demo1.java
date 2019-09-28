package com.bite.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * SAX解析
 *      sun公司
 *      javax.xml.核心api
 *
 *      SAXParser:SAX解析的解析器对象   抽象类
 *      工厂类：SAXParserFactory        工厂 （抽象）
 *
 *  事件三要素
 *      1）事件源：解析contact.xml
 *      2）事件监听器:触发一系列的方法
 *                 事件处理程序（DefaultHandler）
 *                  文档开始：
     *                   开始标签
     *                   遇到文本：
     *                   结束标签
 *                   文档结束
 *      3)注册事件监听器：绑定 事件处理程序（DefaultHandler）
 *          自定义一个类：继承自DefaultHandler
 *           重写方法（）{}
 *     SAX解析的基本使用
 *   A）：创建SAXParser解析器
 *   B):解析contact.xml 同时绑定事件处理程序
 */
public class Demo1 {
    public static void main(String[] args) throws  Exception {
        //A）：创建SAXParser解析器
        SAXParser parser = SAXParserFactory
                .newInstance().newSAXParser();
        // B):解析contact.xml 同时绑定事件处理程序
        //Demo.class.getClassLoder().getResourceAsStream()
         parser.parse(Demo1.class.getClassLoader().
                 //注册事件监听器
                 getResourceAsStream("contact.xml"),new MyDemo1DefaultHandler());
    }
}
