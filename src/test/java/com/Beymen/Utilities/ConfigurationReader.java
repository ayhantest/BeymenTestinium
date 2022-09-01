package com.Beymen.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1- Create the object of properties
    private static Properties properties = new Properties();

    static {

        try {
            //2- We need to open the file in java memory
            FileInputStream file = new FileInputStream("Configuration.properties");
            //3- Load the properties object by using FileInputStream

            properties.load(file);
            //4- Close the file
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static  String get(String keyword){
        return properties.getProperty(keyword);
    }

}
