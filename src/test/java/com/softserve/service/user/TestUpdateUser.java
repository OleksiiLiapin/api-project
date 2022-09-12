package com.softserve.service.user;

import com.softserve.model.user.UserDTO;
import com.softserve.services.clients.UserCRUD;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.logging.Logger;
import static org.assertj.core.api.Assertions.assertThat;

public class TestUpdateUser  {
    private static final Logger LOG = Logger.getLogger("TestUpdateUser.class");

    @Test (testName = "TC-04", description = "METHOD:POST . Method verify that user can be updated")
    public static void updateUserTest(){
        UserDTO userDTO = UserDTO.createRootUser();
        UserDTO updatedUser = null;
        try {
            updatedUser = UserCRUD.updateUser("11", userDTO);
        } catch (IllegalStateException | IOException e) {
            LOG.info("Catch error that user cannot be updated");
        }

        Assertions.assertThat(updatedUser.getId()).isEqualTo("10");
        Assertions.assertThat(updatedUser.getName()).isEqualTo("Oleksii");
        Assertions.assertThat(updatedUser.getUsername()).isEqualTo("Cheezy");
        Assertions.assertThat(updatedUser.getUserAddress().getSuite()).isEqualTo("123");

    }

}


//{
//        "id": 10,
//        "name": "Oleksii",
//        "username": "Cheezy",
//        "email": "OleksiiCheezy@gmail.com",
//        "phone": "3928-28-11-2",
//        "website": "alexch.com",
//        "userAddress": {
//        "city": "Lviv",
//        "street": "st. Kulparkivs",
//        "zipcode": "182121-1",
//        "suite": "123",
//        "geo": {
//        "lat": "2.243",
//        "lng": "1.232"
//        }
//        },
//        "userCompany": {
//        "catchPhrase": "My catch pharase",
//        "bs": "BS v.",
//        "name": "Bulls"
//        },
//        "address": {
//        "city": "Lviv",
//        "street": "st. Kulparkivs",
//        "zipcode": "182121-1",
//        "suite": "123",
//        "geo": {
//        "lat": "2.243",
//        "lng": "1.232"
//        }
//        },
//        "company": {
//        "catchPhrase": "My catch pharase",
//        "bs": "BS v.",
//        "name": "Bulls"
//        }
//        }

