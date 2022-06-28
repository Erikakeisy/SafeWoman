package com.safewoman.dto.response;

import lombok.Data;

@Data
public class CreateNewUserResponse {

    private String username;
    private String password;
    private String email;

}
