package com.uc.account.domain.usecase;

import com.uc.account.domain.model.Account;
import com.uc.account.domain.port.AccountPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.UseCaseHandler;
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
