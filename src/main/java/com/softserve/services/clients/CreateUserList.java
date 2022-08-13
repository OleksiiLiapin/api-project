package com.softserve.services.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserve.model.user.UserDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.softserve.services.RestServices;
import org.apache.log4j.*;

public class CreateUserList {
    private static final Logger logger = LogManager.getLogger(CreateUserList.class);


    public static ArrayList<UserDTO> createUserList() throws IOException {
        URL url = new URL(RestServices.getBase_URL() + RestServices.getUsersUrl());
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserDTO> usersList = Arrays.asList(objectMapper.readValue(url, UserDTO[].class));
        logger.info("Users parsed into the list. " + "\n" +"number of user: "+ usersList.size());
        return new ArrayList<>(usersList);
    }

}
