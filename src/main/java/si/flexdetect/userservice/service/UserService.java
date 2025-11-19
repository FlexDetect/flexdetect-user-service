package si.flexdetect.userservice.service;

import si.flexdetect.userservice.model.User;
import si.flexdetect.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import si.flexdetect.userservice.security.JwtUtil;

import java.util.Optional;

@Service //poslovna logika
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired //Spring sam ustvari UserRepository in ga da v ta servis
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(String email, String rawPassword) throws IllegalArgumentException {
        if(userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email already registered");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));
        return userRepository.save(user);
    }

    @Autowired
    private JwtUtil jwtUtil;

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(email);
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }

}
