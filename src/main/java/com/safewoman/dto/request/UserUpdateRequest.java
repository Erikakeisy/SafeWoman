package com.safewoman.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.safewoman.dto.constants.Profile;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserUpdateRequest {


    private String socialName;

    private String name;

    private Integer age;

    private String phone;

    private String email;

    private String gender;

    private String city;

    private String password;

    private String username;


}
