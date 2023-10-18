package com.uc.account.domain.account.port;

import com.uc.account.domain.account.model.Account;
import com.uc.account.domain.account.usecase.CreateAccountUseCase;

public interface AccountPort {
    Account create(CreateAccountUseCase createAccountUseCase);
}
