package com.bite.xml.write;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 添加相关：
 *          1）创建一个空文档
 *            2）添加根标签 添加子标签 添加属性。。
 *
 *
 * 读取xml文件
 *
 *      编辑xml文件
 *          1）修改标签属性
 *          2）修改标签的文本内容
 *
 *      删除
 *             1）删除标签属性
 *             2）删除指定标签
 *
 *
 *  输出xml文件（指定磁盘上）
 */
public class Demo2 {

    public static void main(String[] args) throws  Exception{
//        addDoc();
//        editDoc();
        del();

    }

    private static void del() throws DocumentException, IOException {
        //读文件
        //1）读resource下的contact.xml文件
        Document doc = new SAXReader().read(Demo2.class
                .getClassLoader().getResource("contact.xml")) ;


        //删除标签
        //获取第一个子标签
        Element conElem = doc.getRootElement().element("contact");
        //标签对象.detach():自杀(推荐方式)
        //conElem.detach();
        //conElem获取父节点
        Element parent = conElem.getParent();
        parent.remove(conElem) ;

        //3)输出
        OutputStream out = new FileOutputStream("e:/contact.xml") ;
        //输出格式:
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out,format) ;
        writer.write(doc);
        writer.close();
    }

    private static void editDoc() throws DocumentException, IOException {
        //修改文件
        //1）读resource下的contact.xml文件
        Document doc = new SAXReader().read(Demo2.class
        .getClassLoader().getResource("contact.xml")) ;

        //2)修改标签的属性
        //获取标签对象：contact
        Element conElem = doc.getRootElement().element("contact") ;
        //通过属性名称获取属性对象
        Attribute idAttr = conElem.attribute("id");
        //setValue():更改属性值
        idAttr.setValue("003");
        //更改第一个name标签的文本
        Element nameElem = conElem.element("name");
        /*doc.getRootElement().elements("contact").get(1)*/
        //标签对象.setText(String content)
        nameElem.setText("赵六");


        //3）输出
        //输出
        OutputStream out = new FileOutputStream("e:/contact.xml") ;
        //输出格式:
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out,format) ;
        writer.write(doc);
        writer.close();
    }

    private static void addDoc() throws IOException {
        //添加相关：
        //创建一个空文档 ： DocumentHelper
        Document doc = DocumentHelper.createDocument() ;

        //通过文档对象：添加根节点 addElement("标签名称")
        Element rootElem = doc.addElement("contact-list");
        //添加子节点
        Element conElem = rootElem.addElement("contact");
        //添加属性
        conElem.addAttribute("id","001") ;
        conElem.addAttribute("name","eric") ;

        //输出
        OutputStream out = new FileOutputStream("e:/contact.xml") ;
        //输出格式:
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out,format) ;
        writer.write(doc);
        writer.close();
    }
}
