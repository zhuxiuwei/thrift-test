package com.xiuwei.server;

import com.xiuwei.service.UserService;
import com.xiuwei.service.UserServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;


/**
 * 2. 单线程同步模型。可以同时服务多个客户端(SimpleClient)。
 * 相比SimpleServer，多个客户端同时调用时，不会阻塞
 */
public class ThreadPoolServer {
    public static void main(String[] args) {
        try {
            //Server transport. Object which provides client transports.
            TServerTransport serverTransport = new TServerSocket(9090);
            //获取processor
            UserService.Processor processor = new UserService.Processor(new UserServiceImpl());
            //指定TBinaryProtocol
            TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
            //以下写法固定
            TThreadPoolServer.Args targs = new TThreadPoolServer.Args(serverTransport);
            targs.processor(processor);
            targs.protocolFactory(protocolFactory);
            /** 线程池服务模型 使用标准的阻塞式IO 预先创建一组线程处理请求(和simple server唯一不同之处) */
            TServer server = new TThreadPoolServer(targs);
            //启动服务
            System.out.println("ThreadPoolServer started....");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
