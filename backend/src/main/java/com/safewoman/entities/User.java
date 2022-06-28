package com.safewoman.entities;

import com.safewoman.config.security.UserSS;
import com.safewoman.dto.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String socialName;

    private Integer age;

    private String phone;

    @Email
    private String email;

    private String gender;

    private String city;

    @Column(name = "cpf" ,unique = true)
    private String cpf;

    private ProfileEnum profile;


}
