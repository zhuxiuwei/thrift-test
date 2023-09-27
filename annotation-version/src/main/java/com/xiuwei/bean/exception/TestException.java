package com.xiuwei.bean.exception;

import com.facebook.swift.codec.ThriftConstructor;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

@ThriftStruct
public class TestException extends AbstractThriftException {
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
