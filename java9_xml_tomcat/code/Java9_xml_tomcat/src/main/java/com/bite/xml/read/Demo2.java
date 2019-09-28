package com.bite.xml.read;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * 通过dom4j获取标签对象
 *  1)getRootElement():获取根节点对象
 *  2）element("标签名称")：
 *      默认获取第一个子标签对象
 *  3)elemens("标签名称")：获取所有同名标签对象，返回List<Element>
    4)elements():获取所有的标签对象
 */

public class Demo2 {

    public static void main(String[] args) throws  Exception {

        //1)创建解析器对象
        SAXReader reader = new SAXReader();
        //2)读取xml文件
        Document doc = reader.read
                (Demo2.class.getClassLoader()
                        .getResource("contact.xml")) ;
        //3)通过doc：文档对象（内存：树结构）
        //获取contact-list标签对象
        Element rootElem = doc.getRootElement();
        //标签对象.getName()：标签名称
        System.out.println(rootElem.getName()) ;

        //获取子标签对象
        //element("标签名称")
        Element conElem = rootElem.element("contact");
        System.out.println(conElem);
        System.out.println("------------");

        //elemens("标签名称")
        List<Element> list =
                rootElem.elements("contact");
        /**
         * 集合遍历三种
         *  1）get(index)/size()：获取集合元素数结合
         *  2）迭代器
         *  3）增强for（foreach）：替代迭代器的一种方式
         */
       /* for(int i = 0 ; i <list.size();i++){
            Element element = list.get(i);
            System.out.println(element);
        }


        System.out.println("------------");

        //迭代器：Iterator:接口
        Iterator<Element> it = list.iterator();
        while(it.hasNext()){//判断是否有下一个可以迭代的元素
            Element next = it.next();//有元素，获取下一个
            System.out.println(next);
        }*/

        System.out.println("------------");
        //增强for(集合中的遍历)
        //格式：for(泛型类型 变量名 ：集合/数组对象名)
        for(Element elem:list){
            System.out.println(elem);
        }
        System.out.println("------------");

        //获取所有的子标签对象
        //elements()
        List<Element> elements = rootElem.elements();
        for(Element elem:elements){
            System.out.println(elem);
        }
    }
}
