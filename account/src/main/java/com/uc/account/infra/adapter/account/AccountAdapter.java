package com.uc.account.infra.adapter.account;

import com.uc.account.domain.account.model.Account;
import com.uc.account.domain.account.port.AccountPort;
import com.uc.account.domain.account.usecase.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountAdapter implements AccountPort {
    @Override
    public Account create(CreateAccountUseCase createAccountUseCase) {
        return null;
    }
}
