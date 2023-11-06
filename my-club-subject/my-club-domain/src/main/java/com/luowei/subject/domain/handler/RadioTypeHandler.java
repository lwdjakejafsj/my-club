package com.luowei.subject.domain.handler;

import com.luowei.subject.common.enums.SubjectInfoTypeEnum;
import com.luowei.subject.domain.convert.SubjectRadioConverter;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.infra.basic.entity.SubjectRadio;
import com.luowei.subject.infra.basic.mapper.SubjectRadioDao;
import com.luowei.subject.infra.basic.service.SubjectRadioService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class RadioTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        if (subjectInfoBO.getOptionList().isEmpty()) {
            log.error("选项不能为空");
        }
        subjectInfoBO.getOptionList().forEach(v -> {
            SubjectRadio subjectRadio = SubjectRadioConverter.INSTANCE.convertBOToEntity(v);
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.insertBatch(subjectRadioList);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        return null;
    }
}
