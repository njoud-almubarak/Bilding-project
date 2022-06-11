package com.example.building;

import com.example.building.model.Account;
import org.springframework.security.core.context.SecurityContext;

public class Utils {
    public static Account getAccount(SecurityContext context) {
        Account account = (Account) context.getAuthentication().getPrincipal();
        return account;
    }
}
