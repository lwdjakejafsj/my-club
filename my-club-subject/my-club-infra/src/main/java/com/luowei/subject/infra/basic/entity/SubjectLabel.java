package com.luowei.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2023-11-03 22:05:30
 */
@Data
public class SubjectLabel implements Serializable {
    private static final long serialVersionUID = 174709448666806982L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 分类id
     * 虽然在mapping中已经做了映射，但是在新增题目的时候，题目还没有创建，还需要根据分类查询标签
     */
    private Long categoryId;
    /**
     * 排序
     */
    private Integer sortNum;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    private Integer isDeleted;

}

