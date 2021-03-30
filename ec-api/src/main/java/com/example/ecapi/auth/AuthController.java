package com.example.ecapi.auth;

import com.example.ecapi.member.MemberResource;
import com.example.ecdomain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;

    @CrossOrigin
    @GetMapping(value="/auth")
    public ResponseEntity<Object> Login (LoginForm loginForm) throws Exception{
        MemberResource resource = authService.authCheck(loginForm);
        return  new ResponseEntity<>(resource,new HttpHeaders(), HttpStatus.OK);
    }
}
