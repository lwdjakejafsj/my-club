package com.luowei.auth.infra.basic.service.impl;

import com.luowei.auth.infra.basic.entity.AuthUserRole;
import com.luowei.auth.infra.basic.mapper.AuthUserRoleDao;
import com.luowei.auth.infra.basic.service.AuthUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthUserRole)表服务实现类
 *
 * @author makejava
 * @since 2023-12-07 22:57:54
 */
@Service
public class AuthUserRoleServiceImpl implements AuthUserRoleService {
    @Resource
    private AuthUserRoleDao authUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public AuthUserRole queryById(Long id) {
        return this.authUserRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param authUserRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<AuthUserRole> queryByPage(AuthUserRole authUserRole, PageRequest pageRequest) {
//        long total = this.authUserRoleDao.count(authUserRole);
//        return new PageImpl<>(this.authUserRoleDao.queryAllByLimit(authUserRole, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param authUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public AuthUserRole insert(AuthUserRole authUserRole) {
        this.authUserRoleDao.insert(authUserRole);
        return authUserRole;
    }

    /**
     * 修改数据
     *
     * @param authUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public AuthUserRole update(AuthUserRole authUserRole) {
        this.authUserRoleDao.update(authUserRole);
        return this.queryById(authUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserRoleDao.deleteById(id) > 0;
    }
}
