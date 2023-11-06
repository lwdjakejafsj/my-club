package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.entity.SubjectLabelBO;
import com.luowei.subject.infra.basic.entity.SubjectInfo;
import com.luowei.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoConverter {
    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertBOToEntity(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> covertEntityListToBoList(List<SubjectInfo> subjectInfoList);
}
