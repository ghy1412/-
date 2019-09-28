package com.bite.xml.read;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 获取属性
 *  前提：要获取属性所在标签对象
 *      1)attributeValues(String name)：获取属性值
 *      2)attribute(String s):获取属性对象
 *
 *
 */
public class Demo3 {

    public static void main(String[] args) throws  Exception{
        //1)创建解析器对象并且读取xml文件
        Document doc = new SAXReader().read(Demo3.class
        .getClassLoader().
                        getResource("contact.xml"));
        //2)获取contact标签属性 id="001"
        //获取contact标签
        Element conElem = doc.getRootElement().element("contact");
        //两种方式获取属性内容
        //方式1：attributeValues(String name):通过属性名称获取属性内容
        String idAttr = conElem.attributeValue("id");//String
        System.out.println(idAttr);
        System.out.println("--------------------");

        //方式2：通过该标签对象获取属性对象
        Attribute attr = conElem.attribute("id");
        //getName():获取属性名称
        //getValue():获取属性值
        System.out.println(attr.getName()+"="+attr.getValue()) ;
        System.out.println("--------------------");



        //dom解析中可以将空格和换行依次解析
        String rootText = doc.getRootElement().getText();
        System.out.println(rootText);
        //获取name标签的文本内容
        //前提：获取name标签对象
        Element nameElem = doc.getRootElement().element("contact")
                .element("name") ;
        //1）getText()
        System.out.println(nameElem.getText()) ;

        //2）方式2：通过子标签名称获取子标签的文本内容（前提：获取父标签对象）
        conElem =  doc.getRootElement().element("contact") ;
        //elementText("子标签名称")：子标签文本的内容(常用的)
        String address = conElem.elementText("address");
        System.out.println(address);


    }

}
