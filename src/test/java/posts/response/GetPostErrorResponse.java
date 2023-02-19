package posts.response;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

@Getter
public class GetPostErrorResponse {
    private String error;

    @Setter
    private int statusCode;

    public void assertPostError(int expectedStatusCode, String expectedErrorMessage) {
        assertNotNull(this.getError());
        assertEquals(this.getStatusCode(), expectedStatusCode);
        assertEquals(this.getError(), expectedErrorMessage);
    }
}
