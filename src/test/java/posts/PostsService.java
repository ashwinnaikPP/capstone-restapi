package posts;

import io.restassured.response.Response;
import posts.request.CreatePostBlogRequestBody;
import posts.response.PostsResponse;

public class PostsService {

    PostsClient postsClient = new PostsClient();

    public PostsResponse createPosts(CreatePostBlogRequestBody body) {
        Response response = postsClient.create(body);
        PostsResponse postsResponse = response.as(PostsResponse.class);
        postsResponse.setStatusCode(response.statusCode());
        return postsResponse;
    }

    public PostsResponse getPostsById() {
        Response response = postsClient.getPost();
        int statusCode = response.statusCode();
        PostsResponse getPostsByIdResponse = response.as(PostsResponse.class);
        getPostsByIdResponse.setStatusCode(statusCode);
        return getPostsByIdResponse;
    }

    public PostsResponse deletePostsById() {
        Response response = postsClient.deletePost();
        int statusCode = response.statusCode();
        PostsResponse deletePostByIDResponse = response.as(PostsResponse.class);
        deletePostByIDResponse.setStatusCode(statusCode);
        return deletePostByIDResponse;
    }
}
