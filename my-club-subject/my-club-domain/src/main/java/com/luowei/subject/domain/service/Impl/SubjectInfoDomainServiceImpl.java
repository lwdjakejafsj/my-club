package com.luowei.subject.domain.service.Impl;

import com.alibaba.fastjson.JSON;
import com.luowei.subject.domain.convert.SubjectInfoConverter;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.handler.SubjectTypeHandler;
import com.luowei.subject.domain.handler.SubjectTypeHandlerFactory;
import com.luowei.subject.domain.service.SubjectInfoDomainService;
import com.luowei.subject.infra.basic.entity.SubjectInfo;
import com.luowei.subject.infra.basic.entity.SubjectMapping;
import com.luowei.subject.infra.basic.service.SubjectInfoService;
import com.luowei.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    //涉及到多张表的时候需要事务
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        //先插入题目
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE
                .convertBOToEntity(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);

        //在进行题目类型的判断，这里使用工厂 + 策略
        SubjectTypeHandler subjectTypeHandler = subjectTypeHandlerFactory
                .getSubjectTypeHandler(subjectInfoBO.getSubjectType());
        subjectTypeHandler.add(subjectInfoBO);

        List<Long> categoryIds = subjectInfoBO.getCategoryIds();
        List<Long> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> subjectMappingList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfoBO.getId());
                subjectMapping.setSubjectId(categoryId);
                subjectMapping.setLabelId(labelId);
            });
        });

        subjectMappingService.insertBatch(subjectMappingList);
    }

}
