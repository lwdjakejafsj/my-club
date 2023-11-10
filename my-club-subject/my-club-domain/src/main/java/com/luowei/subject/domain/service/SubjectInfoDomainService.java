package com.luowei.subject.domain.service;

import com.luowei.subject.common.entity.PageResult;
import com.luowei.subject.domain.entity.SubjectInfoBO;

public interface SubjectInfoDomainService {
    void add(SubjectInfoBO subjectInfoBO);

    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
