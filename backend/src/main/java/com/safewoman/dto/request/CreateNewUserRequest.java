package com.safewoman.dto.request;

import lombok.Data;

@Data
public class CreateNewUserRequest {

    private String username;
    private String password;
    private String email;

}
