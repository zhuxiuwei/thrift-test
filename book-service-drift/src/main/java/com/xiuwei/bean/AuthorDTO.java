package com.xiuwei.bean;


import com.facebook.drift.annotations.ThriftField;
import com.facebook.drift.annotations.ThriftStruct;
import com.xiuwei.core.model.AuthorBO;

@ThriftStruct
public class AuthorDTO {
    @ThriftField(1)
    public Long id;
    @ThriftField(2)
    public String name;
    @ThriftField(3)
    public String country;

    public AuthorDTO(AuthorBO authorBO) {
        if(authorBO !=null) {
            this.id = authorBO.getId();
            this.name = authorBO.getName();
            this.country = authorBO.getCountry();
        }
    }

    public AuthorDTO() {}
}