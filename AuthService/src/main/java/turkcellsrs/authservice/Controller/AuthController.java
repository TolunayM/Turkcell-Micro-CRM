package turkcellsrs.authservice.Controller;


import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import turkcellsrs.authservice.DTO.Request.UserRequest;
import turkcellsrs.authservice.DTO.Response.UserResponse;
import turkcellsrs.authservice.Entity.User;
import turkcellsrs.authservice.Service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;



    @PostMapping("register")
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest userRequest){
        return authService.addUser(userRequest);
    }

    @PostMapping("/token")
    public String getToken(@Valid @RequestBody UserRequest userRequest){
        System.out.println("Token request");

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));

        System.out.println("Authenticated");

         if(authenticate.isAuthenticated()){

             System.out.println("Authenticated");

             return authService.generateToken(userRequest.getUsername());
         }
        return "Invalid credentials";
    }


    @GetMapping("/user")
    public User getUser(@RequestParam("email") String email){
        return authService.getUser(email);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return authService.getUserbyId(id);
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        return authService.validateToken(token);
    }
}
