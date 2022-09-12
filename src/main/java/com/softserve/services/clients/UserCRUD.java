package com.softserve.services.clients;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.softserve.model.user.UserDTO;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserCRUD extends AbstractWebEnpoints {
    private static final Logger LOG = LogManager.getLogger(UserCRUD.class);

    public static UserDTO createNewUser(UserDTO rootUserDTO) {
        return createUser("11");
    }

    public static ArrayList<UserDTO> createUserList() throws IOException {
        List<UserDTO> usersList = getAllUserList();
        LOG.info("Users parsed into the list. " + "\n" +"number of user: "+ usersList.size());
        return new ArrayList<>(usersList);
    }

    public static UserDTO getUser(String ID) throws IOException {
        LOG.info("User retrieved ID : " +   ID);
        return getUserById(ID);
    }

    public static UserDTO updateUser(String ID, UserDTO userDTO) throws IOException {
        return updateUserById(ID, userDTO);
    }

}
