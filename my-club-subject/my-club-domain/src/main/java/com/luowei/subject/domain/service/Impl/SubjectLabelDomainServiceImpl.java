package com.luowei.subject.domain.service.Impl;

import com.alibaba.fastjson.JSON;
import com.luowei.subject.common.enums.CategoryTypeEnum;
import com.luowei.subject.common.enums.IsDeleteEnum;
import com.luowei.subject.domain.convert.SubjectCategoryConverter;
import com.luowei.subject.domain.convert.SubjectLabelConverter;
import com.luowei.subject.domain.entity.SubjectLabelBO;
import com.luowei.subject.domain.service.SubjectLabelDomainService;
import com.luowei.subject.infra.basic.entity.SubjectCategory;
import com.luowei.subject.infra.basic.entity.SubjectLabel;
import com.luowei.subject.infra.basic.entity.SubjectMapping;
import com.luowei.subject.infra.basic.service.SubjectCategoryService;
import com.luowei.subject.infra.basic.service.SubjectLabelService;
import com.luowei.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBOToEntity(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteEnum.UN_DELETE.code);
        int count = subjectLabelService.insert(subjectLabel);
        return count > 0;
    }
    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBOToEntity(subjectLabelBO);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }
    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBOToEntity(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteEnum.UN_DELETE.code);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        //如果当前分类是1级分类，则查询所有标签
        // todo 应该是对应的分类下查询对应的标签，不应该只查询大类下的标签
        SubjectCategory subjectCategory = subjectCategoryService.queryById(subjectLabelBO.getCategoryId());
        if(subjectCategory != null && CategoryTypeEnum.PRIMARY.getCode() == subjectCategory.getCategoryType()){
            SubjectLabel subjectLabel = new SubjectLabel();
            subjectLabel.setCategoryId(subjectLabelBO.getCategoryId());
            List<SubjectLabel> labelList = subjectLabelService.queryByCondition(subjectLabel);
            List<SubjectLabelBO> labelResultList = SubjectLabelConverter.INSTANCE.covertEntityListToBoList(labelList);
            return labelResultList;
        }

        Long categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<SubjectLabelBO> boList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            boList.add(bo);
        });
        return boList;
    }
}
