package com.xiuwei.core.service;

import com.xiuwei.core.model.AuthorBO;
import com.xiuwei.core.model.BookBO;
import java.util.HashMap;
import java.util.Map;

public class BookService {

    private Map<Long, BookBO> bookMap = new HashMap<>();

    public BookService(){
        initBookMap();
    }

    public BookBO getBookById(long id){
        return bookMap.get(id);
    }

    //初始化测试书籍
    private void initBookMap(){
        System.out.println("BookService: init book map!");
        AuthorBO author1 = new AuthorBO(1L, "曹雪芹", "中国");
        BookBO book1 = new BookBO(1L, "红楼梦", author1, System.currentTimeMillis());
        AuthorBO author2 = new AuthorBO(2L, "Jack London", "UK");
        BookBO book2 = new BookBO(2L, "The Call of the Wild", author2, System.currentTimeMillis());
        bookMap.put(book1.getId(), book1);
        bookMap.put(book2.getId(), book2);
    }
}