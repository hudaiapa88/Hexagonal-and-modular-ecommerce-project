package com.uc.account.infra.adapter.account.jpa.entity;

public enum RoleEnum {
    ADMIN(Values.ADMIN),
    USER(Values.USER);
    private RoleEnum(String value) {
        if (!this.name().equals(value))
            throw new IllegalArgumentException("Incorrect use of Role");
    }
    public static class Values {
        public static final String ADMIN= "ADMIN";
        public static final String USER= "USER";
    }
}
