package turkcellsrs.authservice.DTO.Request;


import lombok.Data;

@Data
public class UserRequest {


    private String username;
    private String password;
}
