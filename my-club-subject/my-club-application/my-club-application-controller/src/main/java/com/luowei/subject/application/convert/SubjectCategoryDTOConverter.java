package com.luowei.subject.application.convert;

import com.luowei.subject.application.dto.SubjectCategoryDTO;
import com.luowei.subject.domain.entity.SubjectCategoryBO;
import com.luowei.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryDTOConverter {
    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertDTOToBO(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convertBOListToDTOList(List<SubjectCategoryBO> subjectCategoryBOList);
}
