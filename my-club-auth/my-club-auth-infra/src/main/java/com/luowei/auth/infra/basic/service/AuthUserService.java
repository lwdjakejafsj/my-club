package com.luowei.auth.infra.basic.service;

import com.luowei.auth.infra.basic.entity.AuthUser;

import java.util.List;

/**
 * (AuthUser)表服务接口
 *
 * @author makejava
 * @since 2023-12-05 23:27:54
 */
public interface AuthUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    AuthUser queryById(Long id);

    /**
     * 分页查询
     *
     * @param authUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<AuthUser> queryByPage(AuthUser authUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    Integer insert(AuthUser authUser);

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    Integer update(AuthUser authUser);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<AuthUser> queryByCondition(AuthUser existAuthUser);

    Integer updateByUserName(AuthUser authUser);
}
