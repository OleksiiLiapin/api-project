package com.softserve.user.steps;

import com.softserve.services.clients.CreateUserList;
import com.softserve.services.clients.GetUserByID;
import com.softserve.model.user.UserDTO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.util.ArrayList;

public class TestGetUserByID {
    private static final Logger log = LogManager.getLogger(GetUserByID.class);

    @Test
    public static void GetUserByID() throws IOException {
        ArrayList<UserDTO> userDTOList = CreateUserList.createUserList();
        UserDTO userDTO = GetUserByID.getUSerByID(userDTOList,1);
        //validation
        assertThat("Leanne Graham").isEqualTo(userDTO.getName());
        log.info("Name matches with expected result");
        assertThat("Bret").isEqualTo(userDTO.getUsername());
        log.info("User name matches with expected result");
        assertThat("Gwenborough").isEqualTo(userDTO.getUserAddress().getCity());
        log.info("City matches with expected result");
        assertThat(10).isEqualTo(userDTOList.size());
        log.info("List of users contains " + userDTOList.size() + " users");




    }

}
