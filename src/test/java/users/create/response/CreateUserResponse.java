package users.create.response;

import lombok.Getter;
import lombok.Setter;
import users.create.request.CreateUserRequestBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreateUserResponse {
    @Setter
    private int statusCode;

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String registerDate;
    private String updatedDate;

    public void assertUser(CreateUserRequestBody userRequestBody) {
        assertEquals(this.getStatusCode(), 200);
        assertNotNull(this.getId());
        assertNotNull(this.getRegisterDate());
        assertNotNull(this.getUpdatedDate());
        assertNotNull(this.getEmail());
        assertEquals(this.getEmail(), userRequestBody.getEmail());
        assertEquals(this.getFirstName(), userRequestBody.getFirstName());
        assertEquals(this.getLastName(), userRequestBody.getLastName());
    }
}
