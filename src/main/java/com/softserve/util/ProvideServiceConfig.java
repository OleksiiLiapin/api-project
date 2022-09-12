package com.softserve.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.settings.MavenProperties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ProvideServiceConfig {
    private static final Logger logger = LogManager.getLogger(ProvideServiceConfig.class);

    public static String getMavenPropertiesPath() throws IOException {
        return String.format("src/main/resources/environment/%s/service_config.json",
                MavenProperties.singleMavenPropertiesInstance().getEnvironment());
    }

public static HashMap<String, Object> getServiceList() throws IOException { //HashMap of Services
    String configPath= getMavenPropertiesPath();
    String json = new String(Files.readAllBytes(Paths.get(configPath)));
        return new ObjectMapper().readValue(json, HashMap.class);
    }


public static String getService(String serviceName, String serviceValue) throws IOException { // get Service and its value
        HashMap <String, Object> serviceList = getServiceList();
        String json = new ObjectMapper().writeValueAsString(serviceList.get(serviceName));
        HashMap <String, String> serviceValueMap = new ObjectMapper().readValue(json, HashMap.class);
        return (String) serviceValueMap.get(serviceValue);

}

    public static String getService (String serviceName){
        String configPath = null;
        String jsonServiceList = null;
        HashMap <String, Object> hashMapListOfServices;
        HashMap <String, String> hashMapServiceValue = null;
        try {
            configPath = getMavenPropertiesPath();
            jsonServiceList = new String(Files.readAllBytes(Paths.get(configPath)));
            hashMapListOfServices = new ObjectMapper().readValue(jsonServiceList,HashMap.class);
            jsonServiceList = new ObjectMapper().writeValueAsString(hashMapListOfServices.get(serviceName));
            hashMapServiceValue = new ObjectMapper().readValue(jsonServiceList, HashMap.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertThat(hashMapServiceValue).isNotEmpty();
        return (String) hashMapServiceValue.get("baseUrl");
    }




    // -------------------------Tests-----------------------------


    @Test
    public static void testReadConfigPath() throws IOException {
        String config = ProvideServiceConfig.getMavenPropertiesPath();
        String json = new String(Files.readAllBytes(Paths.get(config)));
        System.out.println(config);
        System.out.println(json);
    }

    @Test
    public static void testReadConfigJson() throws IOException {
        HashMap <String, Object> serviceList = getServiceList();
        System.out.println(serviceList.get("jsonPlaceholder"));
    }

    @Test
    public static void testgetServiceName () throws IOException {
        String servName = getService("jsonPlaceholder","baseUrl");
        System.out.println(servName);
    }

    @Test
    public static void testgetServiceName2 () throws IOException {
        String servName = getService("jsonPlaceholder");
        System.out.println(servName);
    }


    @Test
    public void testGetServiceList() throws IOException {
        HashMap <String, Object> listOfServices = getServiceList();
        System.out.println("Keys: " + listOfServices.keySet());
        System.out.println("Values: " + listOfServices.values());
        System.out.println(listOfServices);
    }


    @Test
    public void testGetServiceList2Test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String configPath = ProvideServiceConfig.getMavenPropertiesPath();
        File fileObj = new File(configPath);
        Map <String, Object> userData = mapper.readValue(fileObj, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(userData.get("jsonPlaceholder"));
    }



}
