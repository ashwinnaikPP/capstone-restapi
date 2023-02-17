import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import static org.testng.Assert.*;

public class CreateUsersNegativeTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        //Arrange
        usersClient = new UsersClient();
    }

    @Test
    public void createUserWithExistingEmailID() {
        CreateUserRequestBody userRequestBody = CreateUserRequestBody.builder()
                .lastName("Ramakrishna")
                .firstName("Tenali")
                .email("a24sh@gmail.com")
                .build();
        //Act
        CreateUserErrorResponse createUserErrorResponse = usersClient.createUserExpectingError(userRequestBody);

        //Assert
        assertEquals(createUserErrorResponse.getStatusCode(), 400);
        assertEquals(createUserErrorResponse.getError(),"BODY_NOT_VALID");
        createUserErrorResponse.assertHasError("Email already used");

    }

}
