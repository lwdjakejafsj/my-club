package com.luowei.auth.infra.basic.service.impl;

import com.luowei.auth.common.enums.IsDeleteEnum;
import com.luowei.auth.infra.basic.entity.AuthRole;
import com.luowei.auth.infra.basic.mapper.AuthRoleDao;
import com.luowei.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthRole)表服务实现类
 *
 * @author makejava
 * @since 2023-12-07 22:00:17
 */
@Service
public class AuthRoleServiceImpl implements AuthRoleService {
    @Resource
    private AuthRoleDao authRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthRole queryById(Long id) {
        return this.authRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param authRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<AuthRole> queryByPage(AuthRole authRole, PageRequest pageRequest) {
//        long total = this.authRoleDao.count(authRole);
//        return new PageImpl<>(this.authRoleDao.queryAllByLimit(authRole, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(AuthRole authRole) {
        authRole.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
        int count = this.authRoleDao.insert(authRole);
        return count > 0;
    }

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(AuthRole authRole) {
        int count = this.authRoleDao.update(authRole);
        return count > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authRoleDao.deleteById(id) > 0;
    }

    @Override
    public AuthRole queryByCondition(AuthRole authRole) {
        return this.authRoleDao.queryByCondition(authRole);
    }
}
