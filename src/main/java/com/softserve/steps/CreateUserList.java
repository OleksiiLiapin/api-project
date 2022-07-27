package com.softserve.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.user.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.softserve.util.services.RestServices;
import org.apache.log4j.*;

public class CreateUserList {
    private static final Logger logger = LogManager.getLogger(CreateUserList.class);


    public static ArrayList<User> createUserList() throws IOException {
        URL url = new URL(RestServices.getBase_URL() + RestServices.getUsersUrl());
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> usersList = Arrays.asList(objectMapper.readValue(url, User[].class));
        logger.info("Users parsed into the list");
        return new ArrayList<>(usersList);
    }

}
