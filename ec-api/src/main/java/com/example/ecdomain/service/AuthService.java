package com.example.ecdomain.service;

import com.example.ecapi.auth.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public LoginForm authCheck(LoginForm loginForm)throws  Exception{
        if (loginForm.getMemNo().equals(loginForm.getPass())) {
            LoginForm result = new LoginForm();
            result.setName("testName");
        }
    }
}
