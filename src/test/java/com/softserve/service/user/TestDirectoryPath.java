package com.softserve.service.user;

import com.softserve.util.FileUtil;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


