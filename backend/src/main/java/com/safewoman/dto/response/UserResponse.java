package com.safewoman.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String socialName;

    private String name;

    private int age;

    private String phone;

    private String email;

    private String gender;

    private String city;

    private String cpf;
}
