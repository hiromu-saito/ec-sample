package com.example.ecapitest.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginForm {
    String memNo;

    String pass;

    String name;
}
