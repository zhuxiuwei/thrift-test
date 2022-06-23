package com.xiuwei.client;

import com.xiuwei.User;
import com.xiuwei.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * 阻塞式客户端
 * 用二进制协议
 * 单线程同步模型，仅适合测试，不适合生产环境使用。
 */
public class SimpleClient {
    public static void main(String[] args) {
        TTransport transport = null;
        try {
            //使用阻塞IO
            transport = new TSocket("localhost", 9090);
            //指定二进制编码协议
            TProtocol protocol = new TBinaryProtocol(transport);
            //创建客户端代理
            UserService.Client client = new UserService.Client(protocol);
            //建立连接
            transport.open();
            /**
             * 发起RPC调用
             */
            User user = client.getById(1);
            System.out.println(user);
            System.out.println("Tom existed? " + client.isExist("Tom"));
            System.out.println("Haha existed? " + client.isExist("Haha"));
        } catch (TTransportException e) {
            throw new RuntimeException(e);
        } catch (TException e) {
            throw new RuntimeException(e);
        }finally {
            transport.close();
        }
    }
}
