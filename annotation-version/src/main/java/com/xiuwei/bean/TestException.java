package com.xiuwei.bean;
import com.facebook.swift.codec.ThriftConstructor;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import com.facebook.swift.service.ThriftException;

@ThriftStruct
public class TestException extends Exception {

    private String message;

    @ThriftConstructor
    public TestException(String message) {
        this.message = message;
    }

    @Override
    @ThriftField(1)
    public String getMessage() {
        return message;
    }

    @ThriftField
    public void setMessage(String message) {
        this.message = message;
    }
}