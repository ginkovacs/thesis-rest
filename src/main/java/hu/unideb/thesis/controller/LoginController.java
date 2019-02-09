package hu.unideb.thesis.controller;

import hu.unideb.thesis.models.User;
import hu.unideb.thesis.models.UserReg;
import hu.unideb.thesis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody UserReg user) {
        loginService.register(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<Void> login(@RequestBody User user) {
        loginService.login(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
