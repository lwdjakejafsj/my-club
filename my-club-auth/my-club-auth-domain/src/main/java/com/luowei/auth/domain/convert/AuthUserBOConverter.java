package com.luowei.auth.domain.convert;

import com.luowei.auth.domain.entity.AuthUserBO;
import com.luowei.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthUserBOConverter {
    AuthUserBOConverter INSTANCE = Mappers.getMapper(AuthUserBOConverter.class);

    AuthUserBO convertEntityToBO(AuthUser authUser);

    List<AuthUser> convertBOListToEntityList(List<AuthUserBO> authUserBOList);

    List<AuthUserBO> convertEntityListToBOList(List<AuthUser> authUserList);

    AuthUser convertBOToEntity(AuthUserBO authUserBo);
}
