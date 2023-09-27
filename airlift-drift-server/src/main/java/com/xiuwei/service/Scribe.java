package com.xiuwei.service;

import com.facebook.drift.annotations.ThriftMethod;
import com.facebook.drift.annotations.ThriftService;
import com.xiuwei.bean.LogEntry;

import java.util.List;

@ThriftService
public interface Scribe
{
    @ThriftMethod
    int log(List<LogEntry> messages);
}