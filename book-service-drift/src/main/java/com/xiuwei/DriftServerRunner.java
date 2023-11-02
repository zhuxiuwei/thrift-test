package com.xiuwei;

import com.facebook.drift.codec.ThriftCodecManager;
import com.facebook.drift.server.DriftServer;
import com.facebook.drift.server.DriftService;
import com.facebook.drift.server.stats.NullMethodInvocationStatsFactory;
import com.facebook.drift.transport.netty.server.DriftNettyServerConfig;
import com.facebook.drift.transport.netty.server.DriftNettyServerTransportFactory;
import com.google.common.collect.ImmutableSet;
import com.xiuwei.core.service.BookService;
import com.xiuwei.service.BookRpcService;
import com.xiuwei.service.BookRpcServiceImpl;

/**
 * 启动book RPC 服务。
 * 和springboot无关。
 */
public class DriftServerRunner {
    public static void main(String[] args) {
        // 我们自定义的服务。
        BookRpcService service = new BookRpcServiceImpl(new BookService());

        //RPC设置。这里只是指定了端口。
        DriftNettyServerConfig config = new DriftNettyServerConfig();
        config.setPort(9090);

        //创建Drift Server
        DriftServer server = new DriftServer(
                new DriftNettyServerTransportFactory(config),
                new ThriftCodecManager(),
                new NullMethodInvocationStatsFactory(),
                ImmutableSet.of(new DriftService(service)),
                ImmutableSet.of());

        //启动服务
        System.out.println("Starting Drift server...");
        server.start();
    }
}
