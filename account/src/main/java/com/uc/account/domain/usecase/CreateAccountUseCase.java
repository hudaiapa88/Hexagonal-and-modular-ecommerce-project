package com.uc.account.domain.usecase;

import com.uc.account.domain.model.Phone;
import com.uc.common.usecase.UseCase;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountUseCase implements UseCase {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Phone phone;
    private String email;
}
