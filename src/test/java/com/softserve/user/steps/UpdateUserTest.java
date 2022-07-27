package com.softserve.user.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.softserve.steps.UpdateUser;
import com.softserve.user.User;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import static org.assertj.core.api.Assertions.assertThat;

public class UpdateUserTest {

    @Test
    public static void verifyUserIsUpdated() throws IOException {
        Logger log = Logger.getLogger(UpdateUser.class.toGenericString());
        for (int i = 1; i <= 10 ; i++) {
            User rootUser = User.createBasicUser();
            User updatedUser = UpdateUser.updateUser(rootUser, i);
            rootUser.setId(i);
            updatedUser.setId(i);
            assertThat(rootUser).usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(updatedUser);
            log.info("User id:" + i + " is updated");
        }
    }

    @Test
    public static void verifyUserCannotBeUpdatedWithWrongID() throws IOException {
        int rand = ThreadLocalRandom.current().nextInt(11,1_000_000);
        Logger log = Logger.getLogger(UpdateUser.class.toGenericString());
        User rootUser = User.createBasicUser();
        User updatedUser = UpdateUser.updateUser(rootUser, rand);

    }
}
