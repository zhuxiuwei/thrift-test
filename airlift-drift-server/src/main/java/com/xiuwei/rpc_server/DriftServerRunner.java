package com.xiuwei.rpc_server;

import com.facebook.drift.codec.ThriftCodecManager;
import com.facebook.drift.server.DriftServer;
import com.facebook.drift.server.DriftService;
import com.facebook.drift.server.stats.NullMethodInvocationStatsFactory;
import com.facebook.drift.transport.netty.server.DriftNettyServerConfig;
import com.facebook.drift.transport.netty.server.DriftNettyServerTransportFactory;
import com.google.common.collect.ImmutableSet;
import com.xiuwei.service.Scribe;
import com.xiuwei.service.ScribeImpl;

public class DriftServerRunner {
    public static void main(String[] args) {
        // 我们自定义的服务。 service handler (must be thread safe)
        Scribe service = new ScribeImpl();

        DriftNettyServerConfig config = new DriftNettyServerConfig();
        config.setPort(9090);

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
