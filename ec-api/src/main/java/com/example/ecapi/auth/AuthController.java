package com.example.ecapi.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @CrossOrigin
    @GetMapping(value="/auth")
    public ResponseEntity Login (LoginForm loginForm) {
        //便宜的に同じだったらログインできるとする
        //serviceに移す
        if(loginForm.getMemNo().equals(loginForm.getPass())){
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
