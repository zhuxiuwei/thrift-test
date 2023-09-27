package com.xiuwei;

import com.facebook.drift.client.DriftClient;
import com.facebook.drift.client.DriftClientFactory;
import com.facebook.drift.client.address.AddressSelector;
import com.facebook.drift.client.address.SimpleAddressSelector;
import com.facebook.drift.codec.ThriftCodecManager;
import com.facebook.drift.transport.netty.client.DriftNettyClientConfig;
import com.facebook.drift.transport.netty.client.DriftNettyMethodInvokerFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.net.HostAndPort;
import com.xiuwei.bean.LogEntry;
import com.xiuwei.service.Scribe;

import java.util.List;

public class MyClient {

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

    public static void main(String[] args) {
        // create client factory (only create this expensive object once)
        DriftClientFactory clientFactory = getClientFactory("127.0.0.1", 9090);

        // create a client (also only create this once)
        Scribe scribe = clientFactory.createDriftClient(Scribe.class).get();

        // use client
        scribe.log(ImmutableList.of(new LogEntry("category", "message")));
    }
}