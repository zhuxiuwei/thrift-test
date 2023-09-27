package com.xiuwei.service;

import com.facebook.drift.annotations.ThriftMethod;
import com.facebook.drift.annotations.ThriftService;
import com.xiuwei.bean.LogEntry;

import java.util.List;

@ThriftService
public class ScribeImpl implements Scribe
{
    @ThriftMethod
    public int log(List<LogEntry> messages)
    {
        messages.forEach(message -> System.out.println(message.getMessage()));
        return 1;
    }
}