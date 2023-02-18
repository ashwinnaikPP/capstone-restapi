package posts.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import posts.PostsService;
import posts.request.CreatePostBlogRequestBody;
import posts.response.CreatePostsResponse;

public class CreatePostsTest {
    private PostsService postsServices;

    @BeforeClass
    public void beforeClass() {
        postsServices = new PostsService();
    }

    @Test
    public void shouldCreatePosts() {
        //Arrange
        CreatePostBlogRequestBody postBlogRequestBody = new CreatePostBlogRequestBody.Builder().build();

        //Act
        CreatePostsResponse createPostsResponse = postsServices.createPosts(postBlogRequestBody);

        //Assert
        createPostsResponse.assertUser(postBlogRequestBody);
    }
}
