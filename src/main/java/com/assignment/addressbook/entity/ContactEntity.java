package com.assignment.addressbook.entity;

import lombok.Data;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "contactDetails")
@Table(name = "CONTACT_DETAILS")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS_BOOK_NAME")
    private String addressBookName;

    public ContactEntity(String fullName, String phoneNumber, String addressBookName) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.addressBookName = addressBookName;
    }

    public ContactEntity(Integer id, String fullName, String phoneNumber, String addressBookName) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.addressBookName = addressBookName;
    }

    public ContactEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
