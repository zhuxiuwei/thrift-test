package com.xiuwei.client;

import com.xiuwei.User;
import com.xiuwei.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * 相比NonblockingClient主要是多了多线程。
 * 适用于NonblockingServer、HsHaServer、ThreadedSelectorServer: 都是快速同时打出5条： Result =: User(id:1, name:Tom, age:10)
 */
public class ThreadedSelectorClient {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                handle();
            }).start();
        }
    }

    //以下和NonblockingClient 一样。
    public static void handle(){
        TTransport transport = null;
        try {
            // 设置传输通道,对于NIO需要使用TFramedTransport(用于将数据分块发送)
            transport = new TFramedTransport(new TSocket("localhost", 9090));
            //协议和服务端一致
            TProtocol protocol = new TCompactProtocol(transport);
            //创建客户端代理
            UserService.Client client = new UserService.Client(protocol);
            //建立连接
            transport.open();

            //RPC调用
            User result = client.getById(1);
            System.out.println("Result =: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭传输通道
            transport.close();
        }

    }
}

