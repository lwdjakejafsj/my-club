package com.luowei.auth.infra.basic.service.impl;

import com.luowei.auth.infra.basic.mapper.AuthUserDao;
import com.luowei.auth.infra.basic.entity.AuthUser;
import com.luowei.auth.infra.basic.mapper.AuthUserDao;
import com.luowei.auth.infra.basic.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AuthUser)表服务实现类
 *
 * @author makejava
 * @since 2023-12-05 23:27:56
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Resource
    private AuthUserDao authUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public AuthUser queryById(Long id) {
        return this.authUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param authUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<AuthUser> queryByPage(AuthUser authUser, PageRequest pageRequest) {
//        long total = this.authUserDao.count(authUser);
//        return new PageImpl<>(this.authUserDao.queryAllByLimit(authUser, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(AuthUser authUser) {
        int count = this.authUserDao.insert(authUser);
        return count;
    }

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthUser authUser) {
        int count = this.authUserDao.update(authUser);
        return count;
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserDao.deleteById(id) > 0;
    }


    @Override
    public List<AuthUser> queryByCondition(AuthUser existAuthUser) {
        return this.authUserDao.queryByCondition(existAuthUser);
    }

    @Override
    public Integer updateByUserName(AuthUser authUser) {
        return this.authUserDao.updateByUserName(authUser);
    }
}
