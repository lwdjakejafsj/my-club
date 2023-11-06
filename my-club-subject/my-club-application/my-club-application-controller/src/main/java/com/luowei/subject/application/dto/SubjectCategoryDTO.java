package com.luowei.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubjectCategoryDTO implements Serializable {
    private static final long serialVersionUID = -57137887790808633L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类类型
     */
    private Integer categoryType;
    /**
     * 图标连接
     */
    private String imageUrl;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 创建人
     */
    private String createdBy;

}
