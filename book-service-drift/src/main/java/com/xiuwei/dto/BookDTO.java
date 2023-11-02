package com.xiuwei.dto;

import com.facebook.drift.annotations.ThriftField;
import com.facebook.drift.annotations.ThriftStruct;
import com.xiuwei.core.model.BookBO;

@ThriftStruct
public class BookDTO {
    @ThriftField(1)
    public Long id;
    @ThriftField(2)
    public String name;
    @ThriftField(3)
    public AuthorDTO author;
    @ThriftField(4)
    public Long publishTime;

    public BookDTO(BookBO bookBO){
        if(bookBO != null) {
            this.id = bookBO.getId();
            this.name = bookBO.getName();
            this.author = new AuthorDTO(bookBO.getAuthor());
            this.publishTime = bookBO.getPublishTime();
        }
    }

    public BookDTO() {}
}