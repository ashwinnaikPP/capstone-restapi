package posts.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import posts.PostsService;
import posts.response.PostsResponse;

public class GetPostsByIdTest {
    private PostsService postsService;

    @BeforeMethod
    private void beforeClass() {
        //Arrange
        postsService = new PostsService();
    }

    @Test
    public void shouldGetPostByID() {
        //Act
        PostsResponse getPostsByIdResponse = postsService.getPostsById();

        //Assert
        getPostsByIdResponse.assertPostById();
    }

}
