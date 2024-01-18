package com.luowei.auth.domain.convert;

import com.luowei.auth.domain.entity.AuthRoleBO;
import com.luowei.auth.domain.entity.AuthUserBO;
import com.luowei.auth.infra.basic.entity.AuthRole;
import com.luowei.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthRoleBOConverter {
    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRoleBO convertEntityToBO(AuthRole authRole);

    List<AuthRole> convertBOListToEntityList(List<AuthRoleBO> AuthRoleBOList);

    List<AuthUserBO> convertEntityListToBOList(List<AuthRole> authRoleList);

    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);
}
