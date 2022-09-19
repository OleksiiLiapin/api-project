package com.softserve.service.user;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;

public class TestDirectoryPath {

    @Test
    public void testResourceDirectoryPath(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("maven.properties").getFile());
        Assertions
                .assertThat(file.getPath())
                .endsWith("\\target\\classes\\maven.properties");
    }
}


