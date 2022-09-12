package com.softserve.service.user;

import com.softserve.model.user.UserDTO;
import com.softserve.services.clients.UserCRUD;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;

public class TestGetUserByID {
    private static final Logger LOG = LogManager.getLogger(TestGetUserByID.class);

    @Test (testName = "TC-02", description = "METHOD:GET. Test verified that user can be retrieved by id")
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



}
