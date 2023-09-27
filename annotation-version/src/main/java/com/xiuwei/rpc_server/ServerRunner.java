package com.xiuwei.rpc_server;

import com.facebook.swift.service.ThriftServer;

/**
 * 参考：https://blog.csdn.net/weixin_33701294/article/details/90305200
 * 跑不通，server可以运行，但是client运行会报错：
 * org.apache.thrift.transport.TTransportException: Could not find sequenceId in Thrift message
 * 	at com.facebook.nifty.client.AbstractClientChannel.extractSequenceId(AbstractClientChannel.java:102)
 * 	at com.facebook.nifty.client.AbstractClientChannel.sendAsynchronousRequest(AbstractClientChannel.java:174)
 * 	at com.facebook.swift.service.SyncClientHelpers.sendSynchronousTwoWayMessage(SyncClientHelpers.java:52)
 * 	at com.facebook.swift.service.ThriftMethodHandler.synchronousInvoke(ThriftMethodHandler.java:164)
 * 	at com.facebook.swift.service.ThriftMethodHandler.invoke(ThriftMethodHandler.java:131)
 * 	at com.facebook.swift.service.ThriftClientManager$ThriftInvocationHandler.invoke(ThriftClientManager.java:520)
 * 	at com.sun.proxy.$Proxy6.isOk(Unknown Source)
 * 	at com.xiuwei.client.ThriftClientDemo.main(ThriftClientDemo.java:20)
 * Caused by: java.lang.AbstractMethodError: org.apache.thrift.transport.TTransport.checkReadBytesAvailable(J)V
 * 	at org.apache.thrift.protocol.TBinaryProtocol.checkStringReadLength(TBinaryProtocol.java:444)
 * 	at org.apache.thrift.protocol.TBinaryProtocol.readStringBody(TBinaryProtocol.java:415)
 * 	at org.apache.thrift.protocol.TBinaryProtocol.readString(TBinaryProtocol.java:411)
 * 	at org.apache.thrift.protocol.TBinaryProtocol.readMessageBegin(TBinaryProtocol.java:251)
 * 	at com.facebook.nifty.client.AbstractClientChannel.extractSequenceId(AbstractClientChannel.java:98)
 * 	... 7 more
 */
public class ServerRunner {

    public static void main(String[] args) {
        ServerCreator serverCreator = new ServerCreator().invoke();
        ThriftServer server = serverCreator.getServer();
        server.start();
        System.out.println("服务已启动!");
    }
}
