package com.xiuwei.service;

import com.xiuwei.bean.User;
import org.apache.thrift.TException;

/**
 * 实现UserService.Iface接口，去实现业务逻辑。
 * 适用于全部的server类型。
 */
public class UserServiceImpl implements UserService.Iface{

    private final String NAME = "Tom";

    @Override
    public User getById(int id) throws TException {
        User user = new User();
        user.setAge(10);
        user.setId(id);
        user.setName(NAME);
        /**
         * 注意如果return null，客户端会报以下诡异的错误： https://stackoverflow.com/questions/22082121/thrift-call-gives-unknown-result
         * Exception in thread "main" java.lang.RuntimeException: org.apache.thrift.TApplicationException: getById failed: unknown result
         * 	at com.xiuwei.client.SimpleClient.main(SimpleClient.java:38)
         * Caused by: org.apache.thrift.TApplicationException: getById failed: unknown result
         * 	at com.xiuwei.UserService$Client.recv_getById(UserService.java:69)
         * 	at com.xiuwei.UserService$Client.getById(UserService.java:52)
         * 	at com.xiuwei.client.SimpleClient.main(SimpleClient.java:32)
         */
        return user;
    }

    @Override
    public boolean isExist(String name) throws TException {
        return name != null && name.equals(NAME);
    }
}
