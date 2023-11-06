package com.luowei.subject.domain.service;

import com.luowei.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {

    void insert(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    Boolean update(SubjectCategoryBO subjectCategoryBO);

    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
