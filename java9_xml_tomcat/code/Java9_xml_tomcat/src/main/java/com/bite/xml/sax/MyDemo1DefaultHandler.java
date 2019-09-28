package com.bite.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 2）编写监听器
 */
public class MyDemo1DefaultHandler extends DefaultHandler {

    //文档开始
    @Override
    public void startDocument() throws SAXException {
        System.out.println("MyDemo1DefaultHandler.startDocument,文档开始了。。。");
    }

    //开始标签

    /**
     *
     *
     * @param qName 开始标签名称
     * @param attributes：属性列表
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("MyDemo1DefaultHandler.startElement,开始标签是:"+qName);
    }

    //遇到文本内容

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        //               张三
        //每次读取文本内容：都是实际内容:从指定索引开始读取实际长度
        String content = new String(ch,start,length) ;
        System.out.println("MyDemo1DefaultHandler.characters,文本内容是："+content);
    }

    //结束标签
    //qName:结束标签名称   </qname>
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("MyDemo1DefaultHandler.endElement,结束标签是："+qName);
    }

    //文档结束

    @Override
    public void endDocument() throws SAXException {
        System.out.println("MyDemo1DefaultHandler.endDocument,文档解析完成。。。");
    }
}
