package com.xiuwei.service;


import com.facebook.drift.TException;
import com.facebook.drift.annotations.ThriftMethod;
import com.facebook.drift.annotations.ThriftService;
import com.xiuwei.dto.BookDTO;

@ThriftService
public interface BookRpcService {
    @ThriftMethod
    BookDTO getBookById(long id) throws TException;

}