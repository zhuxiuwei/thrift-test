package com.xiuwei.douban.rpc;

import com.facebook.drift.client.DriftClientFactory;
import com.facebook.drift.client.address.AddressSelector;
import com.facebook.drift.client.address.SimpleAddressSelector;
import com.facebook.drift.codec.ThriftCodecManager;
import com.facebook.drift.transport.netty.client.DriftNettyClientConfig;
import com.facebook.drift.transport.netty.client.DriftNettyMethodInvokerFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.net.HostAndPort;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.xiuwei.service.BookRpcService;

import java.util.List;

/**
 * 生成RPC客户端代理
 */
@Component
public class BookConfig {

    private static DriftClientFactory getClientFactory(String host, int port){
        // server address
        List<HostAndPort> addresses = ImmutableList.of(HostAndPort.fromParts(host, port));

        // expensive services that should only be created once
        ThriftCodecManager codecManager = new ThriftCodecManager();
        AddressSelector addressSelector = new SimpleAddressSelector(addresses, false);
        DriftNettyClientConfig config = new DriftNettyClientConfig();

        // methodInvokerFactory must be closed
        DriftNettyMethodInvokerFactory<?> methodInvokerFactory = DriftNettyMethodInvokerFactory
                .createStaticDriftNettyMethodInvokerFactory(config);

        // client factory
        DriftClientFactory clientFactory = new DriftClientFactory(codecManager, methodInvokerFactory, addressSelector);
        return clientFactory;
    }

    @Bean
    public BookRpcService bookRpcService() throws Exception {
        // create client factory (only create this expensive object once)
        DriftClientFactory clientFactory = getClientFactory("127.0.0.1", 9090);
        // create a client (also only create this once)
        BookRpcService bookRpcService = clientFactory.createDriftClient(BookRpcService.class).get();
        // use client
        return bookRpcService;
    }
}
