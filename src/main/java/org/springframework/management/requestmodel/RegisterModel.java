package org.springframework.management.requestmodel;

import lombok.Data;

@Data
public class RegisterModel {
    private String name;
    private String password;
    private String phone;
    private String email;
}
