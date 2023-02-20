package users.create.request;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {
    private final String lastName;
    private final String firstName;
    private final String email;

    public CreateUserRequestBody(Builder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.email = builder.email;
    }

    public static class Builder {
        private final String lastName;
        private final String firstName;
        private String email;

        public Builder() {
            this.lastName = "Shetty";
            this.firstName = "Ash";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public CreateUserRequestBody build() {
            return new CreateUserRequestBody(this);
        }
    }
}
