package com.xiuwei;

import com.xiuwei.service.UserServiceImpl;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * 3. NonblockingServer
 */
public class NonblockingServer {

    public static void main(String[] args) {

        try {
            //Server transport. Object which provides client transports.
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(9090);
            //获取processor
            UserService.Processor processor = new UserService.Processor(new UserServiceImpl());
            //指定TCompactProtocol
            TCompactProtocol.Factory protocolFactory = new TCompactProtocol.Factory();
            //使用NIO服务端和客户端需要指定TFramedTransport数据传输的方式
            TFramedTransport.Factory tTransport = new TFramedTransport.Factory();

            TNonblockingServer.Args targs = new TNonblockingServer.Args(serverTransport);
            targs.processor(processor);
            targs.protocolFactory(protocolFactory);
            targs.transportFactory(tTransport); //比simple、theadpool server多了这个
            TServer server = new TNonblockingServer(targs);
            //启动服务
            System.out.println("Starting Non-blocking server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
