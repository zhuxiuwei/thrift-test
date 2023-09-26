package com.xiuwei.bean;

import com.facebook.swift.codec.ThriftEnum;
import com.facebook.swift.codec.ThriftEnumValue;

@ThriftEnum
public enum ThriftAnnotatedEnum {

    FIRST_VALUE("first", 0),
    SECOND_VALUE("second", 1);

    private String description;
    //直接在枚举类定义整数类型的成员变量用于标识，int类型这里不能为负数
    private int intValue;

    ThriftAnnotatedEnum(String description, int intValue) {
        this.description = description;
        this.intValue = intValue;
    }

    @ThriftEnumValue
    public int getIntValue() {
        return intValue;
    }
}