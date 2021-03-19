package com.example.ecapi.member;


import com.example.ecdomain.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping(value = "/user")
    public ResponseEntity<Object> Signup(@RequestBody MemberResource resource) {
        memberService.register(resource);
        return new ResponseEntity<>(resource, new HttpHeaders(), 200);
    }
}
