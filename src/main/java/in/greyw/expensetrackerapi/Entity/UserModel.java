package in.greyw.expensetrackerapi.Entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModel {

    @NotBlank(message = "Name must not be null")
    private String name;

    @NotNull(message = "Email must not be null")
    @Email(message = "Enter valid email")
    private String email;

    @NotNull(message = "Password must not be null")
    @Size(min = 5, message = "Password must be at least 5 characters")
    private String password;

    private Long age = 0L;


}
