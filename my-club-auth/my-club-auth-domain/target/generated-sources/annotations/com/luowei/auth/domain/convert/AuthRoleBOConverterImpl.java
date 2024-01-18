package com.luowei.auth.domain.convert;

import com.luowei.auth.domain.entity.AuthRoleBO;
import com.luowei.auth.domain.entity.AuthUserBO;
import com.luowei.auth.infra.basic.entity.AuthRole;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-25T22:16:59+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class AuthRoleBOConverterImpl implements AuthRoleBOConverter {

    @Override
    public AuthRoleBO convertEntityToBO(AuthRole authRole) {
        if ( authRole == null ) {
            return null;
        }

        AuthRoleBO authRoleBO = new AuthRoleBO();

        authRoleBO.setId( authRole.getId() );
        authRoleBO.setRoleName( authRole.getRoleName() );
        authRoleBO.setRoleKey( authRole.getRoleKey() );

        return authRoleBO;
    }

    @Override
    public List<AuthRole> convertBOListToEntityList(List<AuthRoleBO> AuthRoleBOList) {
        if ( AuthRoleBOList == null ) {
            return null;
        }

        List<AuthRole> list = new ArrayList<AuthRole>( AuthRoleBOList.size() );
        for ( AuthRoleBO authRoleBO : AuthRoleBOList ) {
            list.add( convertBOToEntity( authRoleBO ) );
        }

        return list;
    }

    @Override
    public List<AuthUserBO> convertEntityListToBOList(List<AuthRole> authRoleList) {
        if ( authRoleList == null ) {
            return null;
        }

        List<AuthUserBO> list = new ArrayList<AuthUserBO>( authRoleList.size() );
        for ( AuthRole authRole : authRoleList ) {
            list.add( authRoleToAuthUserBO( authRole ) );
        }

        return list;
    }

    @Override
    public AuthRole convertBOToEntity(AuthRoleBO authRoleBO) {
        if ( authRoleBO == null ) {
            return null;
        }

        AuthRole authRole = new AuthRole();

        authRole.setId( authRoleBO.getId() );
        authRole.setRoleName( authRoleBO.getRoleName() );
        authRole.setRoleKey( authRoleBO.getRoleKey() );

        return authRole;
    }

    protected AuthUserBO authRoleToAuthUserBO(AuthRole authRole) {
        if ( authRole == null ) {
            return null;
        }

        AuthUserBO authUserBO = new AuthUserBO();

        authUserBO.setId( authRole.getId() );
        authUserBO.setCreatedBy( authRole.getCreatedBy() );
        authUserBO.setCreatedTime( authRole.getCreatedTime() );
        authUserBO.setUpdateBy( authRole.getUpdateBy() );
        authUserBO.setUpdateTime( authRole.getUpdateTime() );
        authUserBO.setIsDeleted( authRole.getIsDeleted() );

        return authUserBO;
    }
}
