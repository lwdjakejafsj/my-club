package com.luowei.subject.domain.service.Impl;

import com.luowei.subject.common.enums.IsDeleteEnum;
import com.luowei.subject.domain.convert.SubjectCategoryConverter;
import com.luowei.subject.domain.entity.SubjectCategoryBO;
import com.luowei.subject.domain.service.SubjectCategoryDomainService;
import com.luowei.subject.infra.basic.entity.SubjectCategory;
import com.luowei.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void insert(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainService.insert.bo: {}",subjectCategoryBO);
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBOToEntity(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteEnum.UN_DELETE.code);
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBOToEntity(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteEnum.UN_DELETE.code);

        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryConverter.INSTANCE.covertEntityListToBoList(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainService.queryPrimaryCategory.bo: {}",subjectCategoryBOList);
        }
        return subjectCategoryBOList;
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBOToEntity(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBOToEntity(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteEnum.DELETE.code);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }
}
