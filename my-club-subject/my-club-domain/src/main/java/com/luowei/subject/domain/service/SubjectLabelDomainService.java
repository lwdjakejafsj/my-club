package com.luowei.subject.domain.service;

import com.luowei.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * @Author: luowei
 * @Description: 标签服务
 * @DateTime:
 */
public interface SubjectLabelDomainService {
    /**
     * 新增标签
     */
    Boolean add(SubjectLabelBO subjectLabelBO);
    /**
     * 更新标签
     */
    Boolean update(SubjectLabelBO subjectLabelBO);
    /**
     * 删除标签
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);
    /**
     * 查询分类下标签
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
