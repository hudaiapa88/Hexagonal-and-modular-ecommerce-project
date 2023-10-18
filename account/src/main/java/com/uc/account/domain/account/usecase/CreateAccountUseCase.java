package com.uc.account.domain.account.usecase;

import com.uc.account.domain.account.model.Phone;
import com.uc.common.usecase.UseCase;
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
