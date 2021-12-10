package com.ddd.workshop.domain.banking;

import java.util.List;

public class Customer {
    private List<Account> accounts;
    private Address address;

    public Customer(List<Account> accounts, Address address) {
        this.accounts = accounts;
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Address getAddress() {
        return address;
    }

    public void updateAddress(Address address) {
        this.address = address;
        this.accounts.forEach((account) -> account.updateAddress(address));
    }
}
