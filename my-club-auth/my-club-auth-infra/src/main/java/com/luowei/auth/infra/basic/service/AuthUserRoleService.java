package com.luowei.auth.infra.basic.service;

import com.luowei.auth.infra.basic.entity.AuthUserRole;
/**
 * (AuthUserRole)表服务接口
 *
 * @author makejava
 * @since 2023-12-07 22:57:54
 */
public interface AuthUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    AuthUserRole queryById(Long id);

    /**
     * 分页查询
     *
     * @param authUserRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<AuthUserRole> queryByPage(AuthUserRole authUserRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param authUserRole 实例对象
     * @return 实例对象
     */
    AuthUserRole insert(AuthUserRole authUserRole);

    /**
     * 修改数据
     *
     * @param authUserRole 实例对象
     * @return 实例对象
     */
    AuthUserRole update(AuthUserRole authUserRole);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
