package com.assignment.addressbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("addressBookName")
    private String addressBookName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contact(Integer id, String fullName, String phoneNumber, String addressBookName) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.addressBookName = addressBookName;
    }

    public Contact(String fullName, String phoneNumber, String addressBookName) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.addressBookName = addressBookName;
    }

    public Contact() {
    }
}
