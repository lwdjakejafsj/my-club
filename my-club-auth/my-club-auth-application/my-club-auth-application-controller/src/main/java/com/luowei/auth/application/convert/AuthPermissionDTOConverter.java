package com.luowei.auth.application.convert;

import com.luowei.auth.application.dto.AuthPermissionDTO;
import com.luowei.auth.domain.entity.AuthPermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthPermissionDTOConverter {
    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBO convertDTOToBO(AuthPermissionDTO authPermissionDTO);
}
