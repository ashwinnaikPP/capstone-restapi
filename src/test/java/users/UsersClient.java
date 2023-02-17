package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response getAllUsers() {
        return given()
                .header("app-id", "63ea666e5dc514a7728f25e3")
                .when()
                .get("https://dummyapi.io/data/v1/user?limit=10");
    }

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public static Response create(CreateUserRequestBody body) {
        Response response =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("app-id", "63ea666e5dc514a7728f25e3")
                        .body(body)
                        .when()
                        .post("https://dummyapi.io/data/v1/user/create");
        response
                .then()
                .log().body();
        return response;
    }

}
