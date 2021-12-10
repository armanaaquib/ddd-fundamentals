package com.ddd.workshop.domain.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void shouldChangeTheAddress() {
        Address address = new Address("Delhi");
        Account account1 = new Account(address);
        List<Account> customerAccounts = new ArrayList<>();
        customerAccounts.add(account1);
        Customer customer = new Customer(customerAccounts, address);

        Address latestAddress = new Address("Agra");
        customer.updateAddress(latestAddress);

        assertEquals(latestAddress, customer.getAddress());
        assertEquals(latestAddress, customer.getAccounts().get(0).getAddress());
    }
}
