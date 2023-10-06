package com.uc.account.infra.adapter;

import com.uc.account.domain.model.Account;
import com.uc.account.domain.port.AccountPort;
import com.uc.account.domain.usecase.CreateAccountUseCase;
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
