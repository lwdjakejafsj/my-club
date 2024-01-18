package com.luowei.auth.common.enums;

import lombok.Getter;

@Getter
public enum IsDeleteEnum {
    DELETE(1,"删除"),
    UN_DELETE(0,"为删除");
    public int code;
    public String desc;

    IsDeleteEnum(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public static ResultCodeEnum getByCode(int codeVal){
        for(ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
