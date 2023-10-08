package com.xiuwei.service;

import com.facebook.drift.annotations.ThriftMethod;
import com.facebook.drift.annotations.ThriftService;
import com.xiuwei.bean.LogEntry;

import java.util.List;

/**
 * 服务的实现类，不需要加thrift相关注解。
 */
public class ScribeImpl implements Scribe
{
    @Override
    public int log(List<LogEntry> messages)
    {
        messages.forEach(message -> System.out.println(message.getMessage()));
        return 1;
    }
}