package com.luowei.auth.domain.convert;

import com.luowei.auth.domain.entity.AuthPermissionBO;
import com.luowei.auth.infra.basic.entity.AuthPermission;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-25T22:17:00+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class AuthPermissionBOConverterImpl implements AuthPermissionBOConverter {

    @Override
    public AuthPermissionBO convertEntityToBO(AuthPermission authPermission) {
        if ( authPermission == null ) {
            return null;
        }

        AuthPermissionBO authPermissionBO = new AuthPermissionBO();

        authPermissionBO.setId( authPermission.getId() );
        authPermissionBO.setName( authPermission.getName() );
        authPermissionBO.setParentId( authPermission.getParentId() );
        authPermissionBO.setType( authPermission.getType() );
        authPermissionBO.setMenuUrl( authPermission.getMenuUrl() );
        authPermissionBO.setStatus( authPermission.getStatus() );
        authPermissionBO.setShow( authPermission.getShow() );
        authPermissionBO.setIcon( authPermission.getIcon() );
        authPermissionBO.setPermissionKey( authPermission.getPermissionKey() );

        return authPermissionBO;
    }

    @Override
    public List<AuthPermission> convertBOListToEntityList(List<AuthPermissionBO> authPermissionBOList) {
        if ( authPermissionBOList == null ) {
            return null;
        }

        List<AuthPermission> list = new ArrayList<AuthPermission>( authPermissionBOList.size() );
        for ( AuthPermissionBO authPermissionBO : authPermissionBOList ) {
            list.add( convertBOToEntity( authPermissionBO ) );
        }

        return list;
    }

    @Override
    public List<AuthPermissionBO> convertEntityListToBOList(List<AuthPermission> authPermissionList) {
        if ( authPermissionList == null ) {
            return null;
        }

        List<AuthPermissionBO> list = new ArrayList<AuthPermissionBO>( authPermissionList.size() );
        for ( AuthPermission authPermission : authPermissionList ) {
            list.add( convertEntityToBO( authPermission ) );
        }

        return list;
    }

    @Override
    public AuthPermission convertBOToEntity(AuthPermissionBO authPermissionBO) {
        if ( authPermissionBO == null ) {
            return null;
        }

        AuthPermission authPermission = new AuthPermission();

        authPermission.setId( authPermissionBO.getId() );
        authPermission.setName( authPermissionBO.getName() );
        authPermission.setParentId( authPermissionBO.getParentId() );
        authPermission.setType( authPermissionBO.getType() );
        authPermission.setMenuUrl( authPermissionBO.getMenuUrl() );
        authPermission.setStatus( authPermissionBO.getStatus() );
        authPermission.setShow( authPermissionBO.getShow() );
        authPermission.setIcon( authPermissionBO.getIcon() );
        authPermission.setPermissionKey( authPermissionBO.getPermissionKey() );

        return authPermission;
    }
}
