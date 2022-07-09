package com.safewoman.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.safewoman.dto.constants.Profile;
import com.safewoman.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {

    private Long id;

    private String socialName;

    private String name;

    private Integer age;

    private String phone;

    private String email;

    private String gender;

    private String city;

    private String cpf;

    private String password;

    private String username;

    private Set<Integer> profiles = new HashSet<>();

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate creationDate = LocalDate.now();
    public Set<Profile> getProfiles() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

}
