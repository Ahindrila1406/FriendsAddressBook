package com.assignment.addressbook.exception;

public class CustomException extends RuntimeException{
    private String errMsg;

    public CustomException(String errMsg){
        super(errMsg);
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
