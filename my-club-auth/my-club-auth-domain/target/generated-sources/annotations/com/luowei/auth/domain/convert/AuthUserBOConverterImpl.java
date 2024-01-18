package com.luowei.auth.domain.convert;

import com.luowei.auth.domain.entity.AuthUserBO;
import com.luowei.auth.infra.basic.entity.AuthUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-25T22:16:59+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class AuthUserBOConverterImpl implements AuthUserBOConverter {

    @Override
    public AuthUserBO convertEntityToBO(AuthUser authUser) {
        if ( authUser == null ) {
            return null;
        }

        AuthUserBO authUserBO = new AuthUserBO();

        authUserBO.setId( authUser.getId() );
        authUserBO.setUserName( authUser.getUserName() );
        authUserBO.setNickName( authUser.getNickName() );
        authUserBO.setEmail( authUser.getEmail() );
        authUserBO.setPhone( authUser.getPhone() );
        authUserBO.setPassword( authUser.getPassword() );
        authUserBO.setSex( authUser.getSex() );
        authUserBO.setAvatar( authUser.getAvatar() );
        authUserBO.setStatus( authUser.getStatus() );
        authUserBO.setIntroduce( authUser.getIntroduce() );
        authUserBO.setExtJson( authUser.getExtJson() );
        authUserBO.setCreatedBy( authUser.getCreatedBy() );
        authUserBO.setCreatedTime( authUser.getCreatedTime() );
        authUserBO.setUpdateBy( authUser.getUpdateBy() );
        authUserBO.setUpdateTime( authUser.getUpdateTime() );
        authUserBO.setIsDeleted( authUser.getIsDeleted() );

        return authUserBO;
    }

    @Override
    public List<AuthUser> convertBOListToEntityList(List<AuthUserBO> authUserBOList) {
        if ( authUserBOList == null ) {
            return null;
        }

        List<AuthUser> list = new ArrayList<AuthUser>( authUserBOList.size() );
        for ( AuthUserBO authUserBO : authUserBOList ) {
            list.add( convertBOToEntity( authUserBO ) );
        }

        return list;
    }

    @Override
    public List<AuthUserBO> convertEntityListToBOList(List<AuthUser> authUserList) {
        if ( authUserList == null ) {
            return null;
        }

        List<AuthUserBO> list = new ArrayList<AuthUserBO>( authUserList.size() );
        for ( AuthUser authUser : authUserList ) {
            list.add( convertEntityToBO( authUser ) );
        }

        return list;
    }

    @Override
    public AuthUser convertBOToEntity(AuthUserBO authUserBo) {
        if ( authUserBo == null ) {
            return null;
        }

        AuthUser authUser = new AuthUser();

        authUser.setId( authUserBo.getId() );
        authUser.setUserName( authUserBo.getUserName() );
        authUser.setNickName( authUserBo.getNickName() );
        authUser.setEmail( authUserBo.getEmail() );
        authUser.setPhone( authUserBo.getPhone() );
        authUser.setPassword( authUserBo.getPassword() );
        authUser.setSex( authUserBo.getSex() );
        authUser.setAvatar( authUserBo.getAvatar() );
        authUser.setStatus( authUserBo.getStatus() );
        authUser.setIntroduce( authUserBo.getIntroduce() );
        authUser.setExtJson( authUserBo.getExtJson() );
        authUser.setCreatedBy( authUserBo.getCreatedBy() );
        authUser.setCreatedTime( authUserBo.getCreatedTime() );
        authUser.setUpdateBy( authUserBo.getUpdateBy() );
        authUser.setUpdateTime( authUserBo.getUpdateTime() );
        authUser.setIsDeleted( authUserBo.getIsDeleted() );

        return authUser;
    }
}
