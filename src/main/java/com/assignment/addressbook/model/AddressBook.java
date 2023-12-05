package com.assignment.addressbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressBook {
    @JsonProperty("addressBookName")
    private String addressBookName;

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public AddressBook() {
    }

    public AddressBook(String addressBookName) {
        this.addressBookName = addressBookName;
    }
}
