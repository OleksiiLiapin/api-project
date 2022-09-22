package com.softserve.service.user;

import com.softserve.model.user.UserDTO;
import com.softserve.services.clients.UserCRUD;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUserCRUD {
    public static final Logger LOG = Logger.getLogger(UserCRUD.class.toString());

    @Test(testName = "TC-01",
            description = "Method: POST. Test verifies that new user can be created")
    public void verifyUSerCanBeCreated() {
        UserDTO rootUserDTO = UserDTO.createRootUser();
        UserDTO newUserDTO = UserCRUD.createUser(rootUserDTO);
        Assertions.assertThat(newUserDTO)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .ignoringFields("id")
                .isEqualTo(rootUserDTO);
    }

    @Test (testName = "TC-02",
            description = "METHOD:GET. Test verified that user can be retrieved by id")
    public void GetUserByID() {
        String id = "1";
        UserDTO userDTO = UserCRUD.getUserById(id);
        //validation
        assertThat(userDTO.getName()).isEqualTo("Leanne Graham");
        LOG.info("Name matches with expected result");
        assertThat(userDTO.getUsername()).isEqualTo("Bret");
        LOG.info("User name matches with expected result");
        assertThat(userDTO.getUserAddress().getCity()).isEqualTo("Gwenborough");
        LOG.info("City matches with expected result");
    }

    @Test (testName = "TC-03",
            description = "MEHTHOD: GET. Test verifies that all users can be retrieved")
    public void getUserList() {
        List<UserDTO> users = UserCRUD.getAll();

        Assertions.assertThat(users)
                .hasSize(10)
                .extracting("name")
                .contains(
                        "Ervin Howell",
                        "Clementine Bauch",
                        "Patricia Lebsack");
    }

    @Test (testName = "TC-04",
            description = "METHOD:POST . Method verify that user can be updated")
    public void updateUserTest(){
        String id ="1";
        UserDTO userDTO = UserDTO.createRootUser();
        UserDTO updatedUser = null;
        try {
            updatedUser = UserCRUD.updateUser(userDTO, id);
        } catch (IllegalStateException e) {
            LOG.info("Catch error that user cannot be updated - Correct");
        }

        Assertions.assertThat(userDTO)
                .usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .ignoringFields("id")
                .isEqualTo(updatedUser);
    }
}
