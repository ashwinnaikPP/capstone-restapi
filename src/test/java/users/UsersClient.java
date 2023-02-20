package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.request.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response getAll() {
        Response response =
                given()
                        .header("app-id", "63ea666e5dc514a7728f25e3")
                        .when()
                        .get("https://dummyapi.io/data/v1/user?limit=10");
        response.then()
                .log().body();
        return response;
    }

    public Response getUserAccount() {
        Response response =
                given()
                        .header("app-id", "63ea666e5dc514a7728f25e3")
                        .when()
                        .get("https://dummyapi.io/data/v1/user?created=1");
        response.then()
                .log().body();
        return response;
    }

    public Response create(CreateUserRequestBody body) {
        Response response =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("app-id", "63ea666e5dc514a7728f25e3")
                        .body(body)
                        .when()
                        .post("https://dummyapi.io/data/v1/user/create");
        response.then()
                .log().body();
        return response;
    }
}
