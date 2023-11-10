package com.luowei.subject.domain.service.Impl;

import com.alibaba.fastjson.JSON;
import com.luowei.subject.common.entity.PageResult;
import com.luowei.subject.common.enums.IsDeleteEnum;
import com.luowei.subject.domain.convert.SubjectInfoConverter;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.domain.handler.SubjectTypeHandler;
import com.luowei.subject.domain.handler.SubjectTypeHandlerFactory;
import com.luowei.subject.domain.service.SubjectInfoDomainService;
import com.luowei.subject.infra.basic.entity.SubjectInfo;
import com.luowei.subject.infra.basic.entity.SubjectLabel;
import com.luowei.subject.infra.basic.entity.SubjectMapping;
import com.luowei.subject.infra.basic.service.SubjectInfoService;
import com.luowei.subject.infra.basic.service.SubjectLabelService;
import com.luowei.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectLabelService subjectLabelService;

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
        subjectInfo.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
        subjectInfoService.insert(subjectInfo);

        //在进行题目类型的判断，这里使用工厂 + 策略
        subjectInfoBO.setId(subjectInfo.getId());
        SubjectTypeHandler subjectTypeHandler = subjectTypeHandlerFactory
                .getSubjectTypeHandler(subjectInfoBO.getSubjectType());
        subjectTypeHandler.add(subjectInfoBO);

        List<Long> categoryIds = subjectInfoBO.getCategoryIds();
        List<Long> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> subjectMappingList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(categoryId);
                subjectMapping.setLabelId(labelId);
                subjectMapping.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
                subjectMappingList.add(subjectMapping);
            });
        });

        subjectMappingService.insertBatch(subjectMappingList);
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.getSubjectPage.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        pageResult.setStart(start);
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBOToEntity(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo
                ,subjectInfoBO.getCategoryId()
                ,subjectInfoBO.getLabelId());
        pageResult.setTotal(count);
        if (count <= 0) {
            return pageResult;
        }

        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo
                ,subjectInfoBO.getCategoryId()
                ,subjectInfoBO.getLabelId()
                ,start
                ,subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE
                .covertEntityListToBoList(subjectInfoList);
        pageResult.setRecords(subjectInfoBOList);

        return pageResult;
    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.querySubjectInfo.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());
        // 得到 Answer
        //在进行题目类型的判断，这里使用工厂 + 策略
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getSubjectTypeHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId());
        SubjectInfoBO bo = SubjectInfoConverter.INSTANCE.convertOptionAndEntityToBo(optionBO, subjectInfo);

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        subjectMapping.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        bo.setLabelName(labelNameList);
        return bo;

    }

}
