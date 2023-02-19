package posts;

import io.restassured.response.Response;
import posts.request.CreatePostBlogRequestBody;
import posts.response.GetPostErrorResponse;
import posts.response.PostsResponse;

public class PostsService {

    final PostsClient postsClient = new PostsClient();

    public PostsResponse createPosts(CreatePostBlogRequestBody body) {
        Response response = postsClient.create(body);
        PostsResponse postsResponse = response.as(PostsResponse.class);
        postsResponse.setStatusCode(response.statusCode());
        return postsResponse;
    }

    public PostsResponse getPostsById(String id) {
        Response response = postsClient.getPost(id);
        int statusCode = response.statusCode();
        PostsResponse getPostsByIdResponse = response.as(PostsResponse.class);
        getPostsByIdResponse.setStatusCode(statusCode);
        return getPostsByIdResponse;
    }

    public PostsResponse deletePostsById(String id) {
        Response response = postsClient.deletePost(id);
        int statusCode = response.statusCode();
        PostsResponse deletePostByIDResponse = response.as(PostsResponse.class);
        deletePostByIDResponse.setStatusCode(statusCode);
        return deletePostByIDResponse;
    }

    public GetPostErrorResponse getPostExpectingError(String id) {
        Response response = postsClient.getPost(id);
        int statusCode = response.statusCode();
        GetPostErrorResponse getPostErrorResponse = response.as(GetPostErrorResponse.class);
        getPostErrorResponse.setStatusCode(statusCode);
        return getPostErrorResponse;
    }

    public String getIdFromCreatePost() {
        CreatePostBlogRequestBody postBlogRequestBody = new CreatePostBlogRequestBody.Builder().build();
        return createPosts(postBlogRequestBody).getId();
    }
}
