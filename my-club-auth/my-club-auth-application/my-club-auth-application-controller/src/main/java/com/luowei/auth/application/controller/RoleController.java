package com.luowei.auth.application.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.luowei.auth.application.convert.AuthRoleDTOConverter;
import com.luowei.auth.application.convert.AuthUserDTOConverter;
import com.luowei.auth.application.dto.AuthRoleDTO;
import com.luowei.auth.application.dto.AuthUserDTO;
import com.luowei.auth.common.entity.Result;
import com.luowei.auth.domain.entity.AuthRoleBO;
import com.luowei.auth.domain.entity.AuthUserBO;
import com.luowei.auth.domain.service.AuthRoleDomainService;
import com.luowei.auth.infra.basic.entity.AuthRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Resource
    private AuthRoleDomainService authRoleDomainService;

    /**
     * 添加角色
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.add.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            Preconditions.checkNotNull(authRoleDTO.getRoleKey(),"角色Key不能为空");
            Preconditions.checkNotNull(authRoleDTO.getRoleName(),"角色Name不能为空");

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);
            return Result.ok(authRoleDomainService.add(authRoleBO));
        } catch (Exception e) {
            log.error("RoleController.add.error:{}", e.getMessage(), e);
            return Result.fail("添加角色失败");
        }
    }

    /**
     * 修改用户信息
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.update.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            Preconditions.checkNotNull(authRoleDTO.getId(),"角色Id不能为空");
            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);
            return Result.ok(authRoleDomainService.update(authRoleBO));
        } catch (Exception e) {
            log.error("RoleController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新角色信息失败");
        }
    }

    /**
     * 删除用户
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.delete.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            Preconditions.checkNotNull(authRoleDTO.getId(),"角色Id不能为空");
            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);
            return Result.ok(authRoleDomainService.delete(authRoleBO));
        } catch (Exception e) {
            log.error("RoleController.delete.error:{}", e.getMessage(), e);
            return Result.fail("更新角色信息失败");
        }
    }

}
