package za.ac.nwu.ac.translator.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountUserDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;


import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;
   


    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) 
    {
        this.accountTypeRepository = accountTypeRepository;
    }


    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
            List<AccountTypeDto> result = accountTypeDtos;
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);

        }
       
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        return null;
    }


    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        return null;
    }

@Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }


    @Override
    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic)
    {
        try
        {
            return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);

        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }

    }
}