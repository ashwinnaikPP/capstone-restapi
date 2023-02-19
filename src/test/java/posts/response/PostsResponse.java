package posts.response;

import lombok.Getter;
import lombok.Setter;
import posts.request.CreatePostBlogRequestBody;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

@Getter
public class PostsResponse {
    @Setter
    private int statusCode;

    public String id;
    public String image;
    public int likes;
    public String link;
    public List<String> tags;
    public String text;
    public String publishDate;
    public String updatedDate;
    public Owner owner;

    @Getter
    public static class Owner{
        public String id;
        public String title;
        public String firstName;
        public String lastName;
        public String picture;
    }

    public void assertPosts(CreatePostBlogRequestBody createPostBlogRequestBody) {
        assertEquals(this.getStatusCode(), 200);
        assertNotNull(this.getId());
        assertNotNull(this.getPublishDate());
        assertNotNull(this.getUpdatedDate());
        assertNotNull(this.getText());
        assertNotNull(this.getImage());
        assertEquals(this.getText(), createPostBlogRequestBody.getText());
        assertEquals(this.getImage(), createPostBlogRequestBody.getImage());
        assertEquals(this.getLikes(), createPostBlogRequestBody.getLikes());
        assertEquals(this.owner.id, createPostBlogRequestBody.getOwner());
        assertEquals(this.getTags(), createPostBlogRequestBody.getTags());
    }

    public void assertPostById() {
        assertEquals(this.getStatusCode(), 200);
        assertNotNull(this.getId());
        assertNotNull(this.getPublishDate());
        assertNotNull(this.getUpdatedDate());
        assertNotNull(this.getText());
        assertNotNull(this.getImage());
        assertNotNull(this.getTags());
        assertEquals(this.getText(), "This is a text for the Blog Post");
        assertEquals(this.getId(), "63f10a154089c566c2aac27c");
        assertEquals(this.getImage(), "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg");
        assertEquals(this.getLikes(), 6);
    }
}
