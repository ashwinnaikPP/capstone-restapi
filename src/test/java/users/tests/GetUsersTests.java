package users.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import users.UsersService;
import users.create.response.GetAllUserResponse;

import static org.testng.Assert.assertEquals;

public class GetUsersTests {

    private UsersService usersService;

    @BeforeMethod
    private void beforeClass() {
        //Arrange
        usersService = new UsersService();
    }

    @Test
    public void shouldGetAllTheUsers() {
        //Act
        GetAllUserResponse getAllUserResponse = usersService.getAllUsers();

        //Assert
        getAllUserResponse.assetUser();
    }

    @Test
    public void shouldGetUsersCreatedOnYourAccount() {
        //Act
        GetAllUserResponse getAllUserResponse = usersService.getUsersCreatedOnTheAccount();

        //Assert
        assertEquals(getAllUserResponse.getStatusCode(), 200);
        assertEquals(getAllUserResponse.getPage(), 0);
        assertEquals(getAllUserResponse.getLimit(), 20);
        assertEquals(getAllUserResponse.getDataList().size(), 11);
    }
}
