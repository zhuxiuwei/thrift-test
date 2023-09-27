package com.xiuwei.rpc_server;

import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.xiuwei.sevice.TestService;
import com.xiuwei.sevice.TestServiceImpl;
import org.apache.thrift.TProcessor;

public class Server3 {
    public static void main(String[] args) {
        TestService service = new TestServiceImpl();
//        TProcessor processor = new ThriftServiceProcessor(new ThriftCodecManager(), );
    }
}
