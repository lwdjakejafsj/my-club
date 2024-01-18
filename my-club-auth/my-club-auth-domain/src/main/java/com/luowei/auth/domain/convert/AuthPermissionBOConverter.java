package com.luowei.auth.domain.convert;

import com.luowei.auth.domain.entity.AuthPermissionBO;
import com.luowei.auth.domain.entity.AuthUserBO;
import com.luowei.auth.infra.basic.entity.AuthPermission;
import com.luowei.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthPermissionBOConverter {
    AuthPermissionBOConverter INSTANCE = Mappers.getMapper(AuthPermissionBOConverter.class);

    AuthPermissionBO convertEntityToBO(AuthPermission authPermission);

    List<AuthPermission> convertBOListToEntityList(List<AuthPermissionBO> authPermissionBOList);

    List<AuthPermissionBO> convertEntityListToBOList(List<AuthPermission> authPermissionList);

    AuthPermission convertBOToEntity(AuthPermissionBO authPermissionBO);
}
