package com.softserve.service.user;

import com.softserve.model.user.UserDTO;
import com.softserve.services.clients.UserCRUD;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;
import java.util.List;

public class TestRetrieveAllUsers {

    @Test (testName = "TC-01", description = "REST: GET: Verify ability to get List of all users")
    public static void getUserList() throws IOException {
        List<UserDTO> userDTOList = UserCRUD.createUserList();

        assertThat(userDTOList.size()).isEqualTo(10);
        assertThat(userDTOList.stream()
                .findFirst().get().getUsername()).isEqualTo("Bret") ;
        assertThat(userDTOList.get(userDTOList.size()-1).getUsername()).isEqualTo("Moriah.Stanton");

        userDTOList.forEach(us -> {
            System.out.println(
                    us.getId() + " " +
                    us.getUsername()
            );
        });

    }


}
