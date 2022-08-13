package com.softserve.user.steps;

import com.softserve.services.clients.CreateUserList;
import com.softserve.model.user.UserDTO;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;
import java.util.List;

public class TestCreateUserList {

    @Test
    public static void getUserList() throws IOException {
        List<UserDTO> userDTOList = CreateUserList.createUserList();
        assertThat(10).isEqualTo(userDTOList.size());
        String name = userDTOList.stream()
                .findFirst().get().getUsername();
        userDTOList.forEach(us -> {
            System.out.println(
                    us.getId() + " " +
                    us.getUsername()
            );
        });

    }


}
