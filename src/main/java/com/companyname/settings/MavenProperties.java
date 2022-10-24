package com.softserve.settings;
import com.softserve.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class MavenProperties {

    private static MavenProperties singleInstance = null;
    private MavenProperties(){};

    public static MavenProperties singleMavenPropertiesInstance(){
        if(singleInstance==null){
            singleInstance = new MavenProperties();
        }
        return singleInstance;
    }

    private Properties getMavenProperties(){
        InputStream filePath = FileUtil.class.getClassLoader()
                .getResourceAsStream("maven.properties");
        Properties prop = new Properties();
        try {
            prop.load(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }

    public String getEnvironment()  { //return Environment value from Maven.properties file
        return getMavenProperties().getProperty("execution_env");
    }

    public String getBrowserConfig(){
        return getMavenProperties().getProperty("browser");
    }





}