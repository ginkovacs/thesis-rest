package hu.unideb.thesis.controller;

import hu.unideb.thesis.authentication.*;
import hu.unideb.thesis.models.requests.UserRequest;
import hu.unideb.thesis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpRequest signUpRequest) {
        try {
            userService.register(signUpRequest);
        } catch (RuntimeException e) {
            return new ResponseEntity(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(new ApiResponse(true, "User registered successfully"), HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        String jwt = userService.login(loginRequest);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @GetMapping("/user")
    public UserRequest getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserRequest userRequest = new UserRequest(currentUser.getUsername(), currentUser.getEmail());
        return userRequest;
    }
}
