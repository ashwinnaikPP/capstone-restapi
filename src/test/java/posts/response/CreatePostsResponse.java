package posts.response;

import lombok.Getter;
import lombok.Setter;
import posts.request.CreatePostBlogRequestBody;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

@Getter
public class CreatePostsResponse {
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

    public void assertUser(CreatePostBlogRequestBody createPostBlogRequestBody) {
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
}
