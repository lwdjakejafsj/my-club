package com.luowei.subject.application.convert;

import com.luowei.subject.application.dto.SubjectAnswerDTO;
import com.luowei.subject.application.dto.SubjectInfoDTO;
import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectAnswerDTOConverter {
    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);

    SubjectAnswerBO convertDTOToBO(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerDTO> convertBOListToDTOList(List<SubjectAnswerBO> subjectAnswerBOList);

    List<SubjectAnswerBO> convertDTOListToBOList(List<SubjectAnswerDTO> subjectAnswerDTOList);
}
