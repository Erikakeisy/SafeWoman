package com.safewoman.safewoman.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sign {

    @Id
    @Column(nullable = true, unique = true)
    private String cpf;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String confirmPassword;
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "GMT-03")
    private LocalDate dateCreation = LocalDate.now();

}
