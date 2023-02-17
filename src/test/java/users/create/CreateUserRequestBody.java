package users.create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestBody {
    private String lastName;
    private String firstName;
    private String email;
}
