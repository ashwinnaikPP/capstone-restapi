package posts.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreatePostBlogRequestBody {
    private final String text;
    private final String image;
    private final int likes;
    private final List<String> tags;
    private final String owner;

    public CreatePostBlogRequestBody(Builder builder) {
        this.text = builder.text;
        this.image = builder.image;
        this.likes = builder.likes;
        this.tags = builder.tagsList;
        this.owner = builder.owner;
    }

    public static class Builder {
        private final String text;
        private final String image;
        private final int likes;
        @JsonProperty("tags")
        private List<String> tagsList = new ArrayList<>(2);
        private final String owner;

        public Builder(){
            this.text = "This is a text for the Blog Post";
            this.image = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg";
            this.likes = 6;
            this.tagsList = addTags();
            this.owner = "60d0fe4f5311236168a10a0b";
        }

        public List<String> addTags() {
            tagsList.add("Nature");
            tagsList.add("Sunset");
            return tagsList;
        }

        public CreatePostBlogRequestBody build() {
            return new CreatePostBlogRequestBody(this);
        }
    }
}
