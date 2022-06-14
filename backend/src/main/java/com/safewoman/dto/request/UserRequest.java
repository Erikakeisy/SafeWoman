package com.safewoman.safewoman.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id;

    private String socialName;

    private String name;

    private Integer age;

    private String phone;

    private String email;

    private String gender;

    private String city;

    private String cpf;

}
