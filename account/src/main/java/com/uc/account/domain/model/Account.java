package com.uc.account.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String password;
    @Embedded
    private Phone phone;
    private String email;
    @Column(insertable=false, updatable=false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
