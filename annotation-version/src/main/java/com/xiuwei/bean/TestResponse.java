package com.xiuwei.bean;

import com.facebook.swift.codec.ThriftConstructor;
import com.facebook.swift.codec.ThriftField;

import java.util.Objects;

public class TestResponse {
    private Integer userId;
    private String message;
    private Integer seqId;

    @ThriftConstructor
    public TestResponse(Integer userId, String message, Integer seqId) {
        this.userId = userId;
        this.message = message;
        this.seqId = seqId;
    }

    @ThriftField(value = 1,requiredness = ThriftField.Requiredness.REQUIRED)
    public Integer getUserId() {
        return userId;
    }

    @ThriftField
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ThriftField(2)
    public String getMessage() {
        return message;
    }

    @ThriftField
    public void setMessage(String message) {
        this.message = message;
    }

    @ThriftField(value = 3,requiredness = ThriftField.Requiredness.OPTIONAL)
    public Integer getSeqId() {
        return seqId;
    }

    @ThriftField
    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResponse that = (TestResponse) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(message, that.message) &&
                Objects.equals(seqId, that.seqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, message, seqId);
    }

    @Override
    public String toString() {
        return "TestResponse{" +
                "userId=" + userId +
                ", message='" + message + '\'' +
                ", seqId=" + seqId +
                '}';

    }
}
