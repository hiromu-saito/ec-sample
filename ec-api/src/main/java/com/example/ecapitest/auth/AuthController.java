package com.example.ecapitest.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping(value="/auth")
    public ResponseEntity Login (LoginForm loginForm) {
        //便宜的に同じだったらログインできるとする
        //serviceに移す
        if(loginForm.getName().equals(loginForm.getPass())){
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
