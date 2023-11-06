package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.infra.basic.entity.SubjectJudge;
import com.luowei.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectRadioConverter {
    SubjectRadioConverter INSTANCE = Mappers.getMapper(SubjectRadioConverter.class);

    List<SubjectAnswerBO> convertEntityListToBoList(List<SubjectRadio> subjectRadioList);

    SubjectRadio convertBOToEntity(SubjectAnswerBO subjectAnswerBO);
}
