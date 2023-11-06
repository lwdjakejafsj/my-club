package com.luowei.subject.application.convert;

import com.luowei.subject.application.dto.SubjectCategoryDTO;
import com.luowei.subject.application.dto.SubjectLabelDTO;
import com.luowei.subject.domain.entity.SubjectCategoryBO;
import com.luowei.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelDTOConverter {
    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convertDTOToBO(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertBOListToDTOList(List<SubjectLabelBO> subjectLabelBOList);
}
