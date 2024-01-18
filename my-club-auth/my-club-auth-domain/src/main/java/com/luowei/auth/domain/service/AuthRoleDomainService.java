package com.luowei.auth.domain.service;

import com.luowei.auth.domain.entity.AuthRoleBO;

public interface AuthRoleDomainService {
    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);
}
