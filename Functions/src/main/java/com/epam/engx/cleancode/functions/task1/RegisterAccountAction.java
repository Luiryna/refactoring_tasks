package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {


    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        validateAndCreateAccount(account);
    }

    public void validateName(Account account) {
        if (account.getName().length() <= 5) {
            throw new WrongAccountNameException();
        }
    }

    public void validatePassword(Account account) {
        if (account.getPassword().length() <= 8) {
            if (passwordChecker.validate(account.getPassword()) != OK) {
                throw new WrongPasswordException();
            }
        }
    }

    public void validateAndCreateAccount(Account account) {
            validateName(account);
            validatePassword(account);
            setAccountInformation(account);
            accountManager.createNewAccount(account);
    }

    public void setAccountInformation(Account account) {
        account.setCreatedDate(new Date());
        List<Address> addresses = new ArrayList<>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        account.setAddresses(addresses);
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {

        this.passwordChecker = passwordChecker;
    }

}
