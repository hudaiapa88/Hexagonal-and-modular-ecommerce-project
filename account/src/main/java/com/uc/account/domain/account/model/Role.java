package com.uc.account.domain.account.model;

public enum Role {
    ADMIN(Values.ADMIN),
    USER(Values.USER);
    private Role(String value) {
        if (!this.name().equals(value))
            throw new IllegalArgumentException("Incorrect use of Role");
    }
    public static class Values {
        public static final String ADMIN= "ADMIN";
        public static final String USER= "USER";
    }
}
