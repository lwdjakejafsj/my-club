package com.luowei.auth.application.convert;

import com.luowei.auth.application.dto.AuthRoleDTO;
import com.luowei.auth.application.dto.AuthUserDTO;
import com.luowei.auth.domain.entity.AuthRoleBO;
import com.luowei.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthRoleDTOConverter {
    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO);

    AuthRoleDTO convertBOToDTO(AuthRoleBO authRoleBO);

    List<AuthRoleDTO> convertBOListToDTOList(List<AuthRoleBO> authRoleBOList);

    List<AuthRoleBO> convertDTOListToBOList(List<AuthRoleDTO> authRoleDTOList);
}
