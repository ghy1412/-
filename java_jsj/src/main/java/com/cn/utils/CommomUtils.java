package com.cn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommomUtils {

    public static Properties loadProperties(String filename){
        Properties properties = new Properties();
        InputStream in = CommomUtils.class.getClassLoader().getResourceAsStream(filename);
        try {
            properties.load(in);
        } catch (IOException e) {
            System.out.println("记载资源失败!");
            e.printStackTrace();
        }
        return properties;
    }
}
