package users.create.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class GetAllUserResponse {

    @Setter
    private int statusCode;

    @JsonProperty("data")
    public List<Data> dataList;
    public int total;
    public int page;
    public int limit;

    public boolean hasId() {
        return dataList.stream()
                .anyMatch(data -> data.getId().contains("60d"));
    }

    public void assetUser() {
        assertEquals(this.getStatusCode(), 200);
        assertEquals(this.getPage(), 0);
        assertEquals(this.getLimit(), 10);
        assertEquals(this.getDataList().size(), 10);
        assertTrue(this.hasId());
    }

    @Getter
    public static class Data {
        public String id;
        public String title;
        public String firstName;
        public String lastName;
        public String picture;
    }
}
