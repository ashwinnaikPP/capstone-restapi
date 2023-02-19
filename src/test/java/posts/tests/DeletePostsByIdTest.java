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
    public void shouldDeletePostByID() {
        //Act
        String id = postsService.getIdFromCreatePost();
        PostsResponse deletePostByID = postsService.deletePostsById(id);

        //Assert
        deletePostByID.assertDeletePostById();
    }
}
