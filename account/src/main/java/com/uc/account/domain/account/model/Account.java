package com.uc.account.domain.account.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Phone phone;
    private String email;
    private Role role;
}
