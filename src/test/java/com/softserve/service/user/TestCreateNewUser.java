package com.softserve.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.softserve.services.clients.UserCRUD;
import com.softserve.model.user.UserDTO;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class TestCreateNewUser {
    @Test (testName = "TC-02", description = "Method: POST. Test verifies that all users can be retrieved")
    public static void verifyUSerCanBeCreated() {
        Logger log = Logger.getLogger(UserCRUD.class.toString());

        UserDTO rootUserDTO = UserDTO.createRootUser();
        rootUserDTO.setId("11");
        UserDTO newUserDTO = UserCRUD.createNewUser(rootUserDTO);
        Assertions.assertThat(newUserDTO.getName()).isEqualTo(rootUserDTO.getName());
        log.info("Name matched: " + newUserDTO.getName());
        Assertions.assertThat(newUserDTO.getUsername()).isEqualTo(rootUserDTO.getUsername());
        log.info("User name matched: " + newUserDTO.getUsername() );
        Assertions.assertThat(newUserDTO.getId()).isEqualTo(rootUserDTO.getId());
        log.info("id match: " + newUserDTO.getId() );

    }

    }


