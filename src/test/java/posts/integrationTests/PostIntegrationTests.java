package posts.integrationTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import posts.PostsService;
import posts.request.CreatePostBlogRequestBody;
import posts.response.PostsResponse;

public class PostIntegrationTests {

    PostsService postsServices;

    @BeforeClass
    public void beforeClass() {
        postsServices = new PostsService();
    }

    @Test
    public void shouldCreateAndGetThePost() {
        //Arrange
        CreatePostBlogRequestBody postBlogRequestBody = new CreatePostBlogRequestBody.Builder().build();

        //Act
        String id = postsServices.createPosts(postBlogRequestBody).getId();

        //Assert
        postsServices.getPostsById(id).assertPosts(postBlogRequestBody);
    }

    @Test
    public void shouldDeletePostAndVerifyPostNoLongerExists () {
        //Arrange
        CreatePostBlogRequestBody postBlogRequestBody = new CreatePostBlogRequestBody.Builder().build();

        //Act
        String id = postsServices.createPosts(postBlogRequestBody).getId();
        PostsResponse deletePostByID = postsServices.deletePostsById(id);

        //Assert
        deletePostByID.assertDeletePostById();
        postsServices.getPostExpectingError(id)
                .assertPostError(404, "RESOURCE_NOT_FOUND");
    }
}
