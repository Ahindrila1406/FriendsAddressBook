package com.assignment.addressbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactIdModel {

    @JsonProperty("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContactIdModel() {
    }

    public ContactIdModel(Integer id) {
        this.id = id;
    }
}
