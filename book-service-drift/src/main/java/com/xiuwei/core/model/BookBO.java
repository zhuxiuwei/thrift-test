package com.xiuwei.core.model;


public class BookBO {
    private Long id;
    private String name;
    private AuthorBO author;
    private Long publishTime;

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

    public AuthorBO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBO author) {
        this.author = author;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public BookBO(Long id, String name, AuthorBO author, Long publishTime) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishTime = publishTime;
    }
}