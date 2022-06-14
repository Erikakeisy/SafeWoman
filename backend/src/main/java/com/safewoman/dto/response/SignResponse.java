package com.safewoman.safewoman.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignResponse {

    private String name;

    private String email;

    private LocalDate dateCreation;

}
