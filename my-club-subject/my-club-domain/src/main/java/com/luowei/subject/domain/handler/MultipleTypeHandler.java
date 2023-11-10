package com.luowei.subject.domain.handler;

import com.luowei.subject.common.enums.IsDeleteEnum;
import com.luowei.subject.common.enums.SubjectInfoTypeEnum;
import com.luowei.subject.domain.convert.SubjectMultipleConverter;
import com.luowei.subject.domain.convert.SubjectRadioConverter;
import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.infra.basic.entity.SubjectMapping;
import com.luowei.subject.infra.basic.entity.SubjectMultiple;
import com.luowei.subject.infra.basic.entity.SubjectRadio;
import com.luowei.subject.infra.basic.service.SubjectMultipleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: luowei
 * @Description: 简答题目策略类
 * @DateTime:
 */
@Component
@Slf4j
public class MultipleTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        if (subjectInfoBO.getOptionList().isEmpty()) {
            log.error("选项不能为空");
        }
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = SubjectMultipleConverter.INSTANCE.convertBOToEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.insertBatch(subjectMultipleList);
    }

    @Override
    public SubjectOptionBO query(Long subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(Long.valueOf(subjectId));
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBOList = SubjectMultipleConverter.INSTANCE.convertEntityListToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
