package com.luowei.auth.domain.service.Impl;

import com.luowei.auth.common.enums.IsDeleteEnum;
import com.luowei.auth.domain.convert.AuthRoleBOConverter;
import com.luowei.auth.domain.entity.AuthRoleBO;
import com.luowei.auth.domain.service.AuthRoleDomainService;
import com.luowei.auth.infra.basic.entity.AuthRole;
import com.luowei.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        return authRoleService.insert(authRole);
    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        return authRoleService.update(authRole);
    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        authRole.setIsDeleted(IsDeleteEnum.DELETE.getCode());
        return authRoleService.update(authRole);
    }
}
