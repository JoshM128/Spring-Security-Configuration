package com.Authentication.SpringSecurity.DTO;


import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UpdateUserByIDRequest {
    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;
}
