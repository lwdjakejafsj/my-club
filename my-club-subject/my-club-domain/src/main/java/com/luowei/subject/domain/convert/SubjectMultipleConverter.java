package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.infra.basic.entity.SubjectJudge;
import com.luowei.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectMultipleConverter {
    SubjectMultipleConverter INSTANCE = Mappers.getMapper(SubjectMultipleConverter.class);

    List<SubjectAnswerBO> convertEntityListToBoList(List<SubjectMultiple> subjectMultipleList);

    SubjectMultiple convertBOToEntity(SubjectAnswerBO subjectAnswerBO);
}
