package com.softserve.util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FileUtil {
    private static final Logger logger = LogManager.getLogger(FileUtil.class);

    public static String readFileResourcesByPath(String configPath) { //change to filePath
        FileInputStream fis = null;
        String data  = null;
        try {
            fis = new FileInputStream(configPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            data = IOUtils.toString(fis, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }


    @Test
    public static void TestreadFileResourses() throws IOException {
        String configPath = ProvideServiceConfig.getMavenPropertiesPath();
        String url  = readFileResourcesByPath(configPath);
        System.out.println(url);
    }

}
