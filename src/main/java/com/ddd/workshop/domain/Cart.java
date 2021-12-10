package com.ddd.workshop.domain;

import java.util.*;

public class Cart {

    private final UUID id;
    private final List<Item> items;
    private final Set<String> removedItems;
    private boolean checkedOut;

    public Cart() {
        this.id = UUID.randomUUID();
        this.items = new ArrayList<>();
        this.removedItems = new HashSet<>();
        this.checkedOut = false;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void add(Item item) {
        this.items.add(item);
    }

    public void remove(Item item) {
        final boolean removed = this.items.remove(item);
        if (removed) {
            this.removedItems.add(item.getProduct().getName());
        }
    }

    public Set<String> getRemovedItems() {
        return this.removedItems;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Cart otherCart = (Cart) obj;
            return this.id.equals(otherCart.id);
        }

        return false;
    }

    public void checkout() {
        this.checkedOut = true;
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }
}
