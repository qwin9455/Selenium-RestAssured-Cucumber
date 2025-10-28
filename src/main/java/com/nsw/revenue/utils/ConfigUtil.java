package com.nsw.revenue.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    private static final Properties properties;

    static {
        properties = new Properties();
        String propertyFile = System.getProperty("env") + ".properties";
        try (InputStream input = ConfigUtil.class.getClassLoader().getResourceAsStream(propertyFile)) {
            if (input == null) {
                System.err.println("Sorry, unable to find " + propertyFile);
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}