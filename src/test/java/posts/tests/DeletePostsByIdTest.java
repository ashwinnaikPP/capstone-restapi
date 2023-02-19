package posts.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import posts.PostsService;
import posts.response.PostsResponse;

public class DeletePostsByIdTest {
    private PostsService postsService;

    @BeforeMethod
    private void beforeClass() {
        //Arrange
        postsService = new PostsService();
    }

    @Test
    public void shouldGetPostByID() {
        //Act
        PostsResponse deletePostByID = postsService.deletePostsById();

        //Assert
        deletePostByID.assertDeletePostById();
    }
}
