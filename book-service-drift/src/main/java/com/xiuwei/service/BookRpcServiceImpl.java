package com.xiuwei.service;

import com.facebook.drift.TException;
import com.xiuwei.dto.BookDTO;
import com.xiuwei.core.model.BookBO;
import com.xiuwei.core.service.BookService;

/**
 * 服务的实现类，不需要加thrift相关注解。
 */
public class BookRpcServiceImpl implements BookRpcService {
    private BookService bookService;
    public BookRpcServiceImpl(BookService bookService){
        this.bookService = bookService;
    }

    @Override
    public BookDTO getBookById(long id) throws TException {
        BookBO bookBO = bookService.getBookById(id);
        if(bookBO == null)
            throw new TException("Book id: " + id + "不存在！");
        return new BookDTO(bookBO);
    }
}