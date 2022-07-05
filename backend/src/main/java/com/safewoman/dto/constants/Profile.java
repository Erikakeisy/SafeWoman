package com.safewoman.dto.constants;

public enum Profile {

    ADMIN(0, "ROLE_ADMIN"),
    USER(1, "ROLE_USER");

    private Integer code;
    private String description;

    private Profile(Integer code, String description){
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
    public static Profile toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Profile profile : Profile.values()) {
            if(cod.equals(profile.getCode())) {
                return profile;
            }
        }

        throw new IllegalArgumentException("Invalid Profile");
    }

}
