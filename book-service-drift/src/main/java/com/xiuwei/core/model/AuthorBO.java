package com.xiuwei.core.model;

public class AuthorBO {
    private Long id;
    private String name;
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AuthorBO(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}