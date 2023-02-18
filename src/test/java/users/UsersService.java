package users;

import io.restassured.response.Response;
import users.create.request.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.create.response.GetAllUserResponse;

public class UsersService {
    UsersClient usersClient = new UsersClient();

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = usersClient.create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body) {
        Response response = usersClient.create(body);
        CreateUserErrorResponse createUserErrorResponse = response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.statusCode());
        return createUserErrorResponse;
    }

    public GetAllUserResponse getAllUsers() {
        Response response = usersClient.getAll();
        int statusCode = response.statusCode();
        GetAllUserResponse getAllUserResponse = response.as(GetAllUserResponse.class);
        getAllUserResponse.setStatusCode(statusCode);
        return getAllUserResponse;
    }

    public GetAllUserResponse getUsersCreatedOnTheAccount() {
        Response response = usersClient.getUserAccount();
        int statusCode = response.statusCode();
        GetAllUserResponse getAllUserResponse = response.as(GetAllUserResponse.class);
        getAllUserResponse.setStatusCode(statusCode);
        return getAllUserResponse;
    }
}
