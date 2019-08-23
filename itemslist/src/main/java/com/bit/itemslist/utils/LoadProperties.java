package com.bit.itemslist.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    public static Properties loadProperties(String file){
        Properties properties = new Properties();
        InputStream in = LoadProperties.class.getClassLoader().getResourceAsStream(file);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
