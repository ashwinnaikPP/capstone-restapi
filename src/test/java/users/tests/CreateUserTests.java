package users.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersService;
import users.create.request.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

public class CreateUserTests {

    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateUser() {
        //Arrange
        CreateUserRequestBody userRequestBody = new CreateUserRequestBody.Builder().build();

        //Act
        CreateUserResponse createUserResponse = usersService.createUser(userRequestBody);

        //Assert
        createUserResponse.assertUser(userRequestBody);
    }
}