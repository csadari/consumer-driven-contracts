package org.xpdojo.bank.cdc.account.domain;

import java.util.Comparator;

public class AccountBalanceComparator implements Comparator<Account> {

    static AccountBalanceComparator ofBalances() {
        return new AccountBalanceComparator();
    }

    @Override
    public int compare(Account account1, Account account2) {
        return account1.balance().compareTo(account2.balance());
    }

}
