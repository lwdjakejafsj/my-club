package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectCategoryBO;
import com.luowei.subject.domain.entity.SubjectLabelBO;
import com.luowei.subject.infra.basic.entity.SubjectCategory;
import com.luowei.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelConverter {
    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel convertBOToEntity(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> covertEntityListToBoList(List<SubjectLabel> subjectLabelList);
}
