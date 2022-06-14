package com.safewoman.safewoman.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignRequest {

    private String cpf;

    private String name;

    private String email;

    private String password;

    private String confirmPassword;

}

