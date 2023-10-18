package com.uc.account.domain.account.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name ="account")
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
