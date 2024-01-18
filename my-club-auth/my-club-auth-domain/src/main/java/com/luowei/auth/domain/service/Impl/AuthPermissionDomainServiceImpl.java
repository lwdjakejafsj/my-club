package com.luowei.auth.domain.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.luowei.auth.common.enums.IsDeleteEnum;
import com.luowei.auth.domain.convert.AuthPermissionBOConverter;
import com.luowei.auth.domain.entity.AuthPermissionBO;
import com.luowei.auth.domain.redis.RedisUtil;
import com.luowei.auth.domain.service.AuthPermissionDomainService;
import com.luowei.auth.infra.basic.service.AuthPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.luowei.auth.infra.basic.entity.AuthPermission;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";


    @Override
    public Boolean add(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        authPermission.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
        Integer count = authPermissionService.insert(authPermission);
        return count > 0;
    }
    @Override
    public Boolean update(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        Integer count = authPermissionService.update(authPermission);
        return count > 0;
    }
    @Override
    public Boolean delete(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = new AuthPermission();
        authPermission.setId(authPermissionBO.getId());
        authPermission.setIsDeleted(IsDeleteEnum.DELETE.getCode());
        Integer count = authPermissionService.update(authPermission);
        return count > 0;
    }
    @Override
    public List<String> getPermission(String userName) {
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, userName);
        String permissionValue = redisUtil.get(permissionKey);
        if (StringUtils.isBlank(permissionValue)) {
            return Collections.emptyList();
        }
        List<AuthPermission> permissionList = new Gson().fromJson(permissionValue,
                new TypeToken<List<AuthPermission>>() {
                }.getType());
        List<String> authList = permissionList.stream().map(AuthPermission::getPermissionKey).collect(Collectors.toList());
        return authList;
    }
}