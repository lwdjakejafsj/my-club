package com.luowei.subject.common.enums;

import lombok.Getter;

/**
 * @Author: luowei
 * @Description: 题目类型枚举
 * 1单选 2多选 3判断 4简答
 * @DateTime:
 */
@Getter
public enum SubjectInfoTypeEnum {
    RADIO(1,"单选"),
    MULTIPLE(2,"多选"),
    JUDGE(3,"判断"),
    BRIEF(4,"简答"),
    ;
    public int code;
    public String desc;
    SubjectInfoTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public static SubjectInfoTypeEnum getByCode(int codeVal){
        for(SubjectInfoTypeEnum resultCodeEnum : SubjectInfoTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
