package com.softserve.user.steps;

import com.softserve.steps.CreateUserList;
import com.softserve.steps.GetUserByID;
import com.softserve.user.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.util.ArrayList;

public class GetUserByIDTest {
    private static final Logger log = LogManager.getLogger(com.softserve.steps.GetUserByID.class);

    @Test
    public static void GetUserByID() throws IOException {
        ArrayList<User> userList = CreateUserList.createUserList();
        User user = GetUserByID.getUSerByID(userList,1);
        assertThat("Leanne Graham").isEqualTo(user.getName());
        assertThat("Bret").isEqualTo(user.getUsername());
        assertThat("Gwenborough").isEqualTo(user.getUserAddress().getCity());





    }

}
