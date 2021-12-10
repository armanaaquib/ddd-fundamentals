package com.ddd.workshop.domain.banking;

public class Account {
    private Address address;

    public Account(Address address) {
        this.address = address;
    }

    public void updateAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }
}
