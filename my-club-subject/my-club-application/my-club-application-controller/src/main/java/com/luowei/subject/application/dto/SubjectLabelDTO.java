package com.luowei.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: luowei
 * @Description: 标签
 * @DateTime:
 */
@Data
public class SubjectLabelDTO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;
}