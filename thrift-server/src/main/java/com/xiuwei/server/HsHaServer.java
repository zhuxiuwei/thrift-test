package com.xiuwei.server;

import com.xiuwei.service.UserService;
import com.xiuwei.service.UserServiceImpl;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.layered.TFramedTransport;


/**
 * 4. HsHaServer
 * 和NonblockingServer非常像
 */
public class HsHaServer {

    public static void main(String[] args) {

        try {
            //Server transport. Object which provides client transports.
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(9090);
            //获取processor
            UserService.Processor processor = new UserService.Processor(new UserServiceImpl());
            //指定TCompactProtocol
            TCompactProtocol.Factory protocolFactory = new TCompactProtocol.Factory();
            //指定TFramedTransport
            TFramedTransport.Factory tTransport = new TFramedTransport.Factory();

            THsHaServer.Args targs = new THsHaServer.Args(serverTransport);
            targs.processor(processor);
            targs.protocolFactory(protocolFactory);
            targs.transportFactory(tTransport);
            TServer server = new THsHaServer(targs);        // NIO 引入线程池处理业务
            //启动服务
            System.out.println("Starting HsHa  server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
