package turkcellsrs.authservice.Service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import turkcellsrs.authservice.DTO.Request.UserRequest;
import turkcellsrs.authservice.DTO.Response.UserResponse;
import turkcellsrs.authservice.Entity.User;
import turkcellsrs.authservice.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    public ResponseEntity<UserResponse> addUser(UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        var user = userRepository.save(modelMapper.map(userRequest, User.class));
        return ResponseEntity.ok(modelMapper.map(user, UserResponse.class));
    }

    public String generateToken(String email) {
        return jwtService.generateToken(email);
    }

    public String validateToken(String token) {

        jwtService.validateToken(token);
        return "Token is valid";
    }

    public User getUser(String username) {

        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserbyId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
