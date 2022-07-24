package com.xiuwei.client;

import com.xiuwei.User;
import com.xiuwei.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * 和simple client的区别在头两行transport和protocol。
 * 适用于NonblockingServer、HsHaServer、ThreadedSelectorServer
 */
public class NonblockingClient {
    public static void main(String[] args) {
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

            //发起rpc调用
            User result = client.getById(1);
            System.out.println("Result : " + result);
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }

    }
}
