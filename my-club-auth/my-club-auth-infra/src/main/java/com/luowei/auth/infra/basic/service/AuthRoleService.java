package com.luowei.auth.infra.basic.service;

import com.luowei.auth.infra.basic.entity.AuthRole;

/**
 * (AuthRole)表服务接口
 *
 * @author makejava
 * @since 2023-12-07 22:00:17
 */
public interface AuthRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRole queryById(Long id);

    /**
     * 分页查询
     *
     * @param authRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<AuthRole> queryByPage(AuthRole authRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    Boolean insert(AuthRole authRole);

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    Boolean update(AuthRole authRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    AuthRole queryByCondition(AuthRole authRole);
}
