package com.luowei.subject.common.enums;

import lombok.Getter;

@Getter
public enum CategoryTypeEnum {
    PRIMARY(1,"一级大类"),
    SECOND(2,"二级分类");
    public int code;
    public String desc;
    CategoryTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public static CategoryTypeEnum getByCode(int codeVal){
        for(CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}