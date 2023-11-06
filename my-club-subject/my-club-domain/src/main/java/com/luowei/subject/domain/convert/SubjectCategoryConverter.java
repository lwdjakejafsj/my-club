package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectCategoryBO;
import com.luowei.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {
    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBOToEntity(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> covertEntityListToBoList(List<SubjectCategory> subjectCategoryList);
}
