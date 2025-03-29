package com.example.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String userName, String password) {

        boolean isValidUserName = userName.equalsIgnoreCase("test-name");
        boolean isValidPassword = password.equalsIgnoreCase("test-pw");

        return isValidUserName && isValidPassword;
    }

}
