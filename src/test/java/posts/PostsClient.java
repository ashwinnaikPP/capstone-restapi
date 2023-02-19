package posts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import posts.request.CreatePostBlogRequestBody;

import static io.restassured.RestAssured.given;

public class PostsClient {
    public Response create(CreatePostBlogRequestBody body) {
        Response response =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("app-id", "63ea666e5dc514a7728f25e3")
                        .body(body)
                        .when()
                        .post("https://dummyapi.io/data/v1/post/create");
        response.then()
                .log().body();
        return response;
    }

    public Response getPost() {
        Response response =
                given()
                        .header("app-id", "63ea666e5dc514a7728f25e3")
                        .when()
                        .get("https://dummyapi.io/data/v1/post/63f10a154089c566c2aac27c");
        response.then()
                .log().body();
        return response;
    }
}
