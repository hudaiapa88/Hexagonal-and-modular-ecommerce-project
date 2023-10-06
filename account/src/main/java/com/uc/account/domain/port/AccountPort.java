package com.uc.account.domain.port;

import com.uc.account.domain.model.Account;
import com.uc.account.domain.usecase.CreateAccountUseCase;

public interface AccountPort {
    Account create(CreateAccountUseCase createAccountUseCase);
}
