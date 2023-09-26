package com.xiuwei.sever;


import com.xiuwei.bean.TestService;
import com.xiuwei.service.UserServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * 1. 单线程同步模型，仅适合测试，不适合生产环境使用。
 * 如果有多个客户端同时访问，后来的客户端会被阻塞。
 */
public class SimpleServer {
    public static void main(String[] args) {
        try {
            //Server transport. Object which provides client transports.
            TServerTransport transport = new TServerSocket(9090);
            //获取processor。Processor是UserService里的静态类。
            TestService.Processor processor = new UserService.Processor(new UserServiceImpl());
            //指定二进制协议。服务端和客户端要一致。
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
            //以下写法固定
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(factory);
            //单线程服务模型，一般用于测试
            TServer server = new TSimpleServer(tArgs);
            //启动服务
            System.out.println("Simple server started....");
            server.serve();
        } catch (TTransportException e) {
            throw new RuntimeException(e);
        }
    }
}
