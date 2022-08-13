package com.softserve.user.steps;

import com.softserve.services.clients.UpdateUser;
import com.softserve.model.user.UserDTO;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import static org.assertj.core.api.Assertions.assertThat;

public class TestUpdateUser {

    @Test
    public static void verifyUserIsUpdated() throws IOException {
        Logger log = Logger.getLogger(UpdateUser.class.toGenericString());
        for (int i = 1; i <= 10 ; i++) {
            UserDTO rootUserDTO = UserDTO.createBasicUser();
            UserDTO updatedUserDTO = UpdateUser.updateUser(rootUserDTO, i);
            rootUserDTO.setId(i);
            updatedUserDTO.setId(i);
            assertThat(rootUserDTO).usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(updatedUserDTO);
            log.info("User ID: " + updatedUserDTO.getId() + "\n" + "USer name " + updatedUserDTO.getName() + " updated");
        }
    }

    @Test
    public static void verifyUserCannotBeUpdatedWithWrongID() throws IOException {
        int rand = ThreadLocalRandom.current().nextInt(11,1_000_000);
        Logger log = Logger.getLogger(UpdateUser.class.toGenericString());
        UserDTO rootUserDTO = UserDTO.createBasicUser();
        UserDTO updatedUserDTO = UpdateUser.updateUser(rootUserDTO, rand);

    }
}
