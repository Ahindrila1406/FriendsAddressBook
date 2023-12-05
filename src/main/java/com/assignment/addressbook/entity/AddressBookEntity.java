package com.assignment.addressbook.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ADDRESS_BOOK")
public class AddressBookEntity {

    @Id
    @Column(name = "ADDRESS_BOOK_NAME")
    @JsonProperty(value = "addressBookName")
    private String addressBookName;

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public AddressBookEntity() {
    }

    public AddressBookEntity(String addressBookName) {
        this.addressBookName = addressBookName;
    }
}
