package turkcellsrs.authservice.DTO.Request;


import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserRequest {


    @Email(message = "Please enter a valid e-mail address")
    private String username;
    private String password;
}
