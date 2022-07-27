package com.softserve.user.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.softserve.steps.CreateNewUser;
import com.softserve.user.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.*;

public class CreateNewUserTest {
    @Test
    public static void verifyUSerCanBeCreated() throws JsonProcessingException {
        Logger log = Logger.getLogger(CreateNewUser.class.toString());

        User rootUser = User.createBasicUser();
        User newUser = CreateNewUser.createNewUser(rootUser);

        int count = 0;
        while (count < 10) {
            int rand = ThreadLocalRandom.current().nextInt(11,1_000_000);
            rootUser.setId(rand);
            newUser.setId(rand);

            Assert.assertEquals(rootUser.getName(), newUser.getName());
            assertThat(rootUser).usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(newUser);

            log.info("User with id: " + rand + " is created");
            count++;
        }

    }

}
