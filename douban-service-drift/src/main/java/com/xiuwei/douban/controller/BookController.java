package com.xiuwei.douban.controller;

import com.facebook.drift.TException;
import com.xiuwei.dto.BookDTO;
import com.xiuwei.service.BookRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookRpcService bookRpcService;

    @GetMapping("/api/book/{id}")
    public BookDTO getBookById(@PathVariable("id") Long id) throws TException {
        BookDTO bookDTO = bookRpcService.getBookById(id);
        return bookDTO;
    }
}
