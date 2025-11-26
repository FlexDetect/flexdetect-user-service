package si.flexdetect.userservice.controller;

import si.flexdetect.userservice.dto.LoginRequest;
import si.flexdetect.userservice.dto.RegisterRequest;
import si.flexdetect.userservice.model.User;
import si.flexdetect.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            String token = userService.registerUser(request.getEmail(), request.getPassword());
            return ResponseEntity.ok("Bearer " + token);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok("Bearer " + token);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
