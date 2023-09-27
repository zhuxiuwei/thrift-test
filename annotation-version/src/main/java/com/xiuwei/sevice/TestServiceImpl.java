package com.xiuwei.sevice;

import com.xiuwei.bean.TestRequest;
import com.xiuwei.bean.TestResponse;
import com.xiuwei.bean.exception.TestException;
import org.apache.thrift.TException;

public class TestServiceImpl implements TestService{
    @Override
    public boolean isOk() throws TException {
        return true;
    }
//    @Override
//    public TestResponse method1(TestRequest testRequest) throws TException {
//        return new TestResponse(testRequest.getUserId(), testRequest.getMessage(), testRequest.getSeqId());
//    }
//
//    @Override
//    public Long method2(int i) throws TException {
//        System.out.println("method 2: " + i + ", 平方是： " + i*i);
//        return (long)i*i;
//    }
//
//    @Override
//    public String method3(int i) throws TestException, TException {
//        if(i == 0){
//            throw new TestException("i=0, throw new TestException! ");
//        }else if(i == 1){
//            throw new TException("i=1, throw new TException! ");
//        }
//        return "i is: " + i;
//    }
}
