package com.example.ecapi.member;


import com.example.ecdomain.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class MemberController {

    @Autowired
    MemberService memberService;


    @PostMapping()
    public ResponseEntity<Object> Signup(@RequestBody MemberResource resource) {
        memberService.register(resource);
        return new ResponseEntity<>(resource, new HttpHeaders(), 200);
    }
}
