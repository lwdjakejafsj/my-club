package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.infra.basic.entity.SubjectBrief;
import com.luowei.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectBriefConverter {
    SubjectBriefConverter INSTANCE = Mappers.getMapper(SubjectBriefConverter.class);

    SubjectBrief convertBOToEntity(SubjectInfoBO subjectInfoBO);

    List<SubjectAnswerBO> convertEntityListToBoList(List<SubjectBrief> subjectBriefList);

    SubjectOptionBO convertEntityToOptionBO(SubjectBrief subjectBrief);
}
