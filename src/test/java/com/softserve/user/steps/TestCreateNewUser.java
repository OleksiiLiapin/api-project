package com.softserve.user.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.softserve.services.clients.CreateNewUser;
import com.softserve.model.user.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.*;

public class TestCreateNewUser {
    @Test
    public static void verifyUSerCanBeCreated() throws JsonProcessingException {
        Logger log = Logger.getLogger(CreateNewUser.class.toString());

        UserDTO rootUserDTO = UserDTO.createBasicUser();
        UserDTO newUserDTO = CreateNewUser.createNewUser(rootUserDTO);

        int count = 0;
        while (count < 10) {
            int rand = ThreadLocalRandom.current().nextInt(11,1_000_000);
            rootUserDTO.setId(rand);
            newUserDTO.setId(rand);

            Assert.assertEquals(rootUserDTO.getName(), newUserDTO.getName());
            assertThat(rootUserDTO).usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(newUserDTO);

            log.info("User with id: " + rand + " is created");
            count++;
        }

    }

}
