package com.bite.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDemo2DefaultHandler extends DefaultHandler {

    //使用StringBuffer字符串缓冲区
    private StringBuffer sb  = new StringBuffer() ;

    //定义一个成员方法
    public String getXMLContent(){
        return sb.toString() ;
    }
    /**
     * sb.append("<"+qName) ;
     *
     */

    //开始标签
    /**
     *
     *
     * @param qName 开始标签名称
     * @param attributes：属性列表
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        sb.append("<"+qName) ;//开始拼接开始标签
        //遍历属性列表
        for(int i = 0 ; i<attributes.getLength();i++){
            //String getQName (int index); 通过角标获取属性名称
            //String getValue (int index);获取属性值
            String name = attributes.getQName(i);
            String value = attributes.getValue(i) ;

            //<contact id="001">
            //拼接开始标签的属性
            sb.append(" "+name+"=\""+value+"\"") ;
        }
        sb.append(">") ;

    }

    //遇到文本内容

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        //获取事件文本内容
        String content = new String(ch,start,length) ;
        sb.append(content) ;
    }

    //结束标签
    //qName:结束标签名称   </qname>
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        sb.append("</"+qName+">") ;
    }
}
