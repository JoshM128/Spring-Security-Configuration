package com.Authentication.SpringSecurity.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;
}
