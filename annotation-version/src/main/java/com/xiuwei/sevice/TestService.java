package com.xiuwei.sevice;

import com.facebook.swift.service.ThriftException;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import com.xiuwei.bean.TestRequest;
import com.xiuwei.bean.TestResponse;
import com.xiuwei.bean.exception.TestException;
import org.apache.thrift.TException;

@ThriftService
public interface TestService {
//    @ThriftMethod
//    public TestResponse method1(TestRequest testRequest) throws TException;
//
//    @ThriftMethod
//    public Long method2(int i) throws TException;
//
//    @ThriftMethod(exception = {@ThriftException(type = TestException.class, id=1)})
//    public String method3(int i) throws TestException, TException;

    @ThriftMethod
    public boolean isOk() throws TException;

}
