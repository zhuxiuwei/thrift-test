package com.xiuwei.bean;

import com.facebook.drift.annotations.ThriftConstructor;
import com.facebook.drift.annotations.ThriftField;
import com.facebook.drift.annotations.ThriftStruct;

@ThriftStruct
public class LogEntry
{
    private final String category;
    private final String message;

    @ThriftConstructor
    public LogEntry(String category, String message)
    {
        this.category = category;
        this.message = message;
    }

    @ThriftField(1)
    public String getCategory()
    {
        return category;
    }

    @ThriftField(2)
    public String getMessage()
    {
        return message;
    }
}
