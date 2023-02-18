package posts;

import io.restassured.response.Response;
import posts.request.CreatePostBlogRequestBody;
import posts.response.CreatePostsResponse;

public class PostsService {

    PostsClient postsClient = new PostsClient();

    public CreatePostsResponse createPosts(CreatePostBlogRequestBody body) {
        Response response = postsClient.create(body);
        CreatePostsResponse createPostsResponse = response.as(CreatePostsResponse.class);
        createPostsResponse.setStatusCode(response.statusCode());
        return createPostsResponse;
    }
}
