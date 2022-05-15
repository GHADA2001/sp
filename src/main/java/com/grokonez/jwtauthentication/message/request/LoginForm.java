package com.grokonez.jwtauthentication.message.request;

import lombok.Data;

@Data
public class LoginForm {

    private String username;

    private String password;

}