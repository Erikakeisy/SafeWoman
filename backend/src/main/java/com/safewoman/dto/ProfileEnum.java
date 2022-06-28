package com.safewoman.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProfileEnum {

    ADMIN("Admin"),
    ENTERPRISE("Enterprise"),
    CLIENT("Client");

    @Getter
    private String description;

}
