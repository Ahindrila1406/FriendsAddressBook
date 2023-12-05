package com.assignment.addressbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomResponseModel<T> {
    @JsonProperty("data")
    private T data;

    @JsonProperty("errors")
    private CustomErrorModel errors;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CustomErrorModel getErrors() {
        return errors;
    }

    public void setErrors(CustomErrorModel errors) {
        this.errors = errors;
    }

    public CustomResponseModel() {
    }

    public CustomResponseModel(T data) {
        this.data = data;
    }

    public CustomResponseModel(T data, CustomErrorModel errors) {
        this.data = data;
        this.errors = errors;
    }
}
