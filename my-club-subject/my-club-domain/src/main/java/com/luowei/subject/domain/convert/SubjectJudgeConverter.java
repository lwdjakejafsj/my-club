package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectCategoryBO;
import com.luowei.subject.infra.basic.entity.SubjectCategory;
import com.luowei.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectJudgeConverter {
    SubjectJudgeConverter INSTANCE = Mappers.getMapper(SubjectJudgeConverter.class);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectJudge> subjectJudgeList);
}
