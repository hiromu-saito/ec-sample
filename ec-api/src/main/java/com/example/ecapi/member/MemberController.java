package com.example.ecapi.user;

import com.example.ecdomain.dto.Member;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping(value = "/user")
    public ResponseEntity<Object> Signup (Member member){

        return  new ResponseEntity<>("",new HttpHeaders(),200);
    }
}
