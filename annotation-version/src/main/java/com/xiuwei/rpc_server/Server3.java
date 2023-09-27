package com.xiuwei.rpc_server;

import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServerConfig;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.xiuwei.sevice.TestService;
import com.xiuwei.sevice.TestServiceImpl;
import org.apache.thrift.TProcessor;

import java.util.ArrayList;

/**
 * 参考swift官方文档：https://github.com/facebookarchive/swift/tree/master/swift-service
 * 还参考了示例代码：https://www.tabnine.com/code/java/classes/com.facebook.swift.service.ThriftServiceProcessor
 * 可以运行了，但是和运行ServerRunner效果一样，客户端报一样的错：org.apache.thrift.transport.TTransportException: Could not find sequenceId in Thrift message
 */
public class Server3 {
    public static void main(String[] args) {
        TestService service = new TestServiceImpl();
        ThriftServiceProcessor processor = new ThriftServiceProcessor(new ThriftCodecManager(),
                new ArrayList<ThriftEventHandler>(), service);
        ThriftServerConfig config = new ThriftServerConfig();
        config.setPort(9090);
        ThriftServer thriftServer = new ThriftServer(processor, config);
        thriftServer.start();
    }
}
