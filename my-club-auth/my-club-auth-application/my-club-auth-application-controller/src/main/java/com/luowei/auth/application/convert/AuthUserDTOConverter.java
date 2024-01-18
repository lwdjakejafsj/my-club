package com.luowei.auth.application.convert;

import com.luowei.auth.application.dto.AuthUserDTO;
import com.luowei.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthUserDTOConverter {
    AuthUserDTOConverter INSTANCE = Mappers.getMapper(AuthUserDTOConverter.class);

    AuthUserBO convertDTOToBO(AuthUserDTO authUserDTO);

    AuthUserDTO convertBOToDTO(AuthUserBO authUserBO);

    List<AuthUserDTO> convertBOListToDTOList(List<AuthUserBO> authUserBOList);

    List<AuthUserBO> convertDTOListToBOList(List<AuthUserDTO> authUserDTOList);
}
