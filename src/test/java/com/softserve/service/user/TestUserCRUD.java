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
    public static void verifyUSerCanBeCreated() {
        UserDTO rootUserDTO = UserDTO.createRootUser();
        rootUserDTO.setId("11");
        UserDTO newUserDTO = UserCRUD.createNewUser(rootUserDTO);
        Assertions.assertThat(newUserDTO.getName()).isEqualTo(rootUserDTO.getName());
        LOG.info("Name matched: " + newUserDTO.getName());
        Assertions.assertThat(newUserDTO.getUsername()).isEqualTo(rootUserDTO.getUsername());
        LOG.info("User name matched: " + newUserDTO.getUsername() );
        Assertions.assertThat(newUserDTO.getId()).isEqualTo(rootUserDTO.getId());
        LOG.info("id match: " + newUserDTO.getId() );
    }

    @Test (testName = "TC-02",
            description = "METHOD:GET. Test verified that user can be retrieved by id")
    public static void GetUserByID() throws IOException {
        UserDTO userDTO = UserCRUD.getUser("1");
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
    public static void getUserList() throws IOException {
        List<UserDTO> userDTOList = UserCRUD.createUserList();

        assertThat(userDTOList.stream()
                .findFirst().get().getUsername()).isEqualTo("Bret") ;
        assertThat(userDTOList.get(userDTOList.size()-1).getUsername()).isEqualTo("Moriah.Stanton");

        userDTOList.forEach(us -> {
            System.out.println(
                    us.getId() + " " +
                            us.getUsername()
            );
        });

        Assertions.assertThat(userDTOList)
                .hasSize(10)
                .extracting("name")
                .contains(
                        "Ervin Howell",
                        "Clementine Bauch",
                        "Patricia Lebsack");
    }

    @Test (testName = "TC-04",
            description = "METHOD:POST . Method verify that user can be updated")
    public static void updateUserTest(){
        UserDTO userDTO = UserDTO.createRootUser();
        UserDTO updatedUser = null;
        try {
            updatedUser = UserCRUD.updateUser("11", userDTO);
        } catch (IllegalStateException | IOException e) {
            LOG.info("Catch error that user cannot be updated - Correct");
        }

        Assertions.assertThat(updatedUser.getId()).isEqualTo("10");
        Assertions.assertThat(updatedUser.getName()).isEqualTo("Oleksii");
        Assertions.assertThat(updatedUser.getUsername()).isEqualTo("Cheezy");
        Assertions.assertThat(updatedUser.getUserAddress().getSuite()).isEqualTo("123");



    }



}
