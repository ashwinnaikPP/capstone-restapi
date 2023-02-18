package users.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersService;
import users.create.request.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import static org.testng.Assert.assertEquals;

public class CreateUsersNegativeTests {
    private UsersService usersService;

    @BeforeClass
    public void beforeClass(){
        usersService = new UsersService();
    }

    @Test
    public void createUserWithExistingEmailID() {
        //Arrange
        CreateUserRequestBody userRequestBody = new CreateUserRequestBody.Builder().email("a24sh@gmail.com").build();

        //Act
        CreateUserErrorResponse createUserErrorResponse = usersService.createUserExpectingError(userRequestBody);

        //Assert
        assertEquals(createUserErrorResponse.getStatusCode(), 400);
        assertEquals(createUserErrorResponse.getError(),"BODY_NOT_VALID");
        createUserErrorResponse.assertHasError("Email already used");
    }
}
