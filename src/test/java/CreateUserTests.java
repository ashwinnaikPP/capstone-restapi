import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CreateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        // 1.Arrange
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateUser() {
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody userRequestBody =
                CreateUserRequestBody
                        .builder()
                        .lastName("Ramakrishna")
                        .firstName("Tenali")
                        .email(email)
                        .build();
        //2.Act
        CreateUserResponse createUserResponse = usersClient.createUser(userRequestBody);

        //3.Assertion.
        assertEquals(createUserResponse.getStatusCode(), 200);
        assertNotNull(createUserResponse.getId());
        assertNotNull(createUserResponse.getRegisterDate());
        assertNotNull(createUserResponse.getUpdatedDate());
        assertNotNull(createUserResponse.getEmail());
        assertEquals(createUserResponse.getEmail(), userRequestBody.getEmail());
        assertEquals(createUserResponse.getFirstName(), "Tenali");
        assertEquals(createUserResponse.getLastName(), "Ramakrishna");
    }
}
