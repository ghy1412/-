package com.bit.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
* 封装所有公共操作 包括 json 格式
* getResourceAsStream(fileName); 方法会读取当前工程下的资源文件
*
* ctrl 加 shift 加 T 创建测试类
* */
public class CommUtil {
    //通过properties的文件名 来获取properties资源文件
   public static Properties loadProperties(String fileName){
        Properties properties = new Properties();

        InputStream inputStream = CommUtil.class.getClassLoader().
                         getResourceAsStream(fileName);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("资源文件加载失败");
            e.printStackTrace();
            return null;
        }
        return properties;
    }
}
