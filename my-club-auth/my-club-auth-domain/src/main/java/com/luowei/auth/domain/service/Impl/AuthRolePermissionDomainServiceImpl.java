package com.luowei.auth.domain.service.Impl;

import com.luowei.auth.common.enums.IsDeleteEnum;
import com.luowei.auth.domain.entity.AuthRolePermissionBO;
import com.luowei.auth.domain.service.AuthRolePermissionDomainService;
import com.luowei.auth.infra.basic.entity.AuthRolePermission;
import com.luowei.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Override
    public Boolean add(AuthRolePermissionBO authRolePermissionBO) {
        List<AuthRolePermission> rolePermissionList = new LinkedList<>();
        Long roleId = authRolePermissionBO.getRoleId();
        authRolePermissionBO.getPermissionIdList().forEach(permissionId -> {
            AuthRolePermission authRolePermission = new AuthRolePermission();
            authRolePermission.setRoleId(roleId);
            authRolePermission.setPermissionId(permissionId);
            authRolePermission.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
            rolePermissionList.add(authRolePermission);
        });
        int count = authRolePermissionService.batchInsert(rolePermissionList);
        return count > 0;
    }
}
