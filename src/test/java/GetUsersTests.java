import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import users.UsersClient;

public class GetUsersTests {

    private UsersClient usersClient;

    @BeforeMethod
    private void beforeClass(){
        // 1. Arrange
        usersClient = new UsersClient();
    }

    @Test
    public void shouldGetAllTheUsers() {
        // 2. Act
        // 3. Assertion
        usersClient
                .getAllUsers()
                .then()
                // 3. Assertion
                .statusCode(200)
                .log().body()
                .body("data", Matchers.hasSize(10))
                .body("", Matchers.hasEntry("limit", 10));

    }



}
