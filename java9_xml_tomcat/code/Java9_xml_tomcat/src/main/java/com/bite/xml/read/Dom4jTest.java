package com.bite.xml.read;



import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：读取contact.xml,读取到contact标签，将contact标签对象封装到
 * Contact联系人对象中，获取每一个联系人对象！
 *
 * 目标：contact.xml
 *     contact标签 ：List<Element>获取所有同名contact标签对象----->Contact类
 *                          id name
 *                             setxx/getXX
 *    List<Contact>  遍历集合
 *
 */
public class Dom4jTest {
    public static void main(String[] args) throws  Exception{
        //1)读取xml文件
        Document doc =  new SAXReader()
                .read(Dom4jTest.class.getClassLoader()
                        .getResource("contact.xml")) ;

        //2)创建List集合
        List<Contact> conList = new ArrayList<>() ;
        /**
         * 集合的特点
         *  1）集合长度可变
         *  2）集合中只能存储引用类型
         */
        //3)doc读取所有同名的contact标签
        List<Element> elemList = doc.getRootElement()
                .elements("contact");
        //遍历
        for(Element elem:elemList){
            //获取到了所有的同名的contact标签对象
            //封装Contact联系人
            Contact contact  = new Contact() ;
            contact.setId(elem.attributeValue("id"));
            contact.setName(elem.elementText("name"));
            contact.setGender(elem.elementText("gender"));
            contact.setPhone(elem.elementText("phone"));
            contact.setEmail(elem.elementText("email"));
            contact.setAddress(elem.elementText("address"));

            //将contact添加到集合
            conList.add(contact) ;
        }

        //  List<Contact>遍历
        for(Contact contact :conList) {
            System.out.println(contact);
        }
    }
}
