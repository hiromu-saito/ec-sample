package com.example.ecapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {
    @GetMapping(value="/hello")
    public String test(){
        return  "hello world";
    }
}
