package org.springframework.management.requestmodel;

import lombok.Data;

@Data
public class LoginModel {
    private String username;
    private String password;
}
