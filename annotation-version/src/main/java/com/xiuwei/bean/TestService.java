package com.xiuwei.bean;


import com.facebook.swift.service.ThriftException;
import com.facebook.swift.service.ThriftMethod;
import org.apache.thrift.TException;

public interface TestService {
    @ThriftMethod
    public TestResponse method1(TestRequest testRequest) throws TException;

    @ThriftMethod
    public Long method2(int i) throws TException;

    @ThriftMethod(exception = {@ThriftException(type = TestException.class, id=1)})
    public String method3() throws TestException, TException;

}
