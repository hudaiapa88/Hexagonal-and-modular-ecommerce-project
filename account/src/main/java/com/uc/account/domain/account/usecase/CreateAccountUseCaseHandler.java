package com.uc.account.domain.account.usecase;

import com.uc.account.domain.account.model.Account;
import com.uc.account.domain.account.port.AccountPort;
import com.uc.account.domain.common.DomainComponent;
import com.uc.account.domain.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class CreateAccountUseCaseHandler implements UseCaseHandler<Account, CreateAccountUseCase> {

   private final AccountPort accountPort;

    @Override
    public Account handle(CreateAccountUseCase value) {
        return accountPort.create(value);
    }
}
