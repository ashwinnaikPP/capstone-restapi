package users.create.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserErrorResponse {
    @Setter
    private int statusCode;

    private String error;

    private Data data;

    public void assertHasError(String emailErrorMessage) {
        data.emailErrorMessage.equals(emailErrorMessage);
    }

    @Getter
    public static class Data{
        @JsonProperty("email")
       private String emailErrorMessage;
    }
}