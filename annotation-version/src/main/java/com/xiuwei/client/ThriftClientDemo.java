package com.xiuwei.client;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.xiuwei.sevice.TestService;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

import java.util.concurrent.ExecutionException;

import static com.google.common.net.HostAndPort.fromParts;

public class ThriftClientDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TException {
        ThriftClientManager clientManager = new ThriftClientManager();
        TestService testService = clientManager.createClient(
                new FramedClientConnector(fromParts("localhost", 12345)),
                TestService.class).get();
        try {
            testService.isOk();
        } catch (TTransportException e) {
            // 处理异常
            e.printStackTrace();
        }
//        System.out.println(testService.method2(1));
//        System.out.println(testService.method2(3));
    }
}
