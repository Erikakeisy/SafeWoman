package com.safewoman.safewoman.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @OneToMany(mappedBy = "idReport")
    private List<Report> reports = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String name;

    @Column(name = "SOCIAL_NAME", nullable = false)
    private String socialName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE", nullable = true, unique = true)
    private String phone;

    @Column(name = "EMAIL", nullable = false,unique = true)
    private String email;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "CPF",nullable = true, unique = true)
    private String cpf;

//    @OneToMany(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "idReport")
//    public List<Report> report;


//    @OneToOne(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "ID_USER")
//    private Address address;
//

}
