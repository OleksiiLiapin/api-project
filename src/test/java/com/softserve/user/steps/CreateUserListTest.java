package com.softserve.user.steps;

import com.softserve.steps.CreateUserList;
import com.softserve.user.User;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;
import java.util.List;

public class CreateUserListTest {

    @Test
    public static void getUserList() throws IOException {
        List<User> userList = CreateUserList.createUserList();
        assertThat(10).isEqualTo(userList.size());
    }


}
