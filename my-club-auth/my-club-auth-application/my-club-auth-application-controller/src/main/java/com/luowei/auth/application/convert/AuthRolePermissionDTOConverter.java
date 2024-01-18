package com.luowei.auth.application.convert;

import com.luowei.auth.application.dto.AuthPermissionDTO;
import com.luowei.auth.application.dto.AuthRolePermissionDTO;
import com.luowei.auth.domain.entity.AuthPermissionBO;
import com.luowei.auth.domain.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthRolePermissionDTOConverter {
    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDTO authRolePermissionDTO);
}
