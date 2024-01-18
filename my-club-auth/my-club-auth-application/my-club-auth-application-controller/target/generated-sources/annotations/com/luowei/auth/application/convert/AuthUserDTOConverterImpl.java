package com.luowei.auth.application.convert;

import com.luowei.auth.application.dto.AuthUserDTO;
import com.luowei.auth.domain.entity.AuthUserBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-25T22:17:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class AuthUserDTOConverterImpl implements AuthUserDTOConverter {

    @Override
    public AuthUserBO convertDTOToBO(AuthUserDTO authUserDTO) {
        if ( authUserDTO == null ) {
            return null;
        }

        AuthUserBO authUserBO = new AuthUserBO();

        authUserBO.setId( authUserDTO.getId() );
        authUserBO.setUserName( authUserDTO.getUserName() );
        authUserBO.setNickName( authUserDTO.getNickName() );
        authUserBO.setEmail( authUserDTO.getEmail() );
        authUserBO.setPhone( authUserDTO.getPhone() );
        authUserBO.setPassword( authUserDTO.getPassword() );
        authUserBO.setSex( authUserDTO.getSex() );
        authUserBO.setAvatar( authUserDTO.getAvatar() );
        authUserBO.setStatus( authUserDTO.getStatus() );
        authUserBO.setIntroduce( authUserDTO.getIntroduce() );
        authUserBO.setExtJson( authUserDTO.getExtJson() );

        return authUserBO;
    }

    @Override
    public AuthUserDTO convertBOToDTO(AuthUserBO authUserBO) {
        if ( authUserBO == null ) {
            return null;
        }

        AuthUserDTO authUserDTO = new AuthUserDTO();

        authUserDTO.setId( authUserBO.getId() );
        authUserDTO.setUserName( authUserBO.getUserName() );
        authUserDTO.setNickName( authUserBO.getNickName() );
        authUserDTO.setEmail( authUserBO.getEmail() );
        authUserDTO.setPhone( authUserBO.getPhone() );
        authUserDTO.setPassword( authUserBO.getPassword() );
        authUserDTO.setSex( authUserBO.getSex() );
        authUserDTO.setAvatar( authUserBO.getAvatar() );
        authUserDTO.setStatus( authUserBO.getStatus() );
        authUserDTO.setIntroduce( authUserBO.getIntroduce() );
        authUserDTO.setExtJson( authUserBO.getExtJson() );

        return authUserDTO;
    }

    @Override
    public List<AuthUserDTO> convertBOListToDTOList(List<AuthUserBO> authUserBOList) {
        if ( authUserBOList == null ) {
            return null;
        }

        List<AuthUserDTO> list = new ArrayList<AuthUserDTO>( authUserBOList.size() );
        for ( AuthUserBO authUserBO : authUserBOList ) {
            list.add( convertBOToDTO( authUserBO ) );
        }

        return list;
    }

    @Override
    public List<AuthUserBO> convertDTOListToBOList(List<AuthUserDTO> authUserDTOList) {
        if ( authUserDTOList == null ) {
            return null;
        }

        List<AuthUserBO> list = new ArrayList<AuthUserBO>( authUserDTOList.size() );
        for ( AuthUserDTO authUserDTO : authUserDTOList ) {
            list.add( convertDTOToBO( authUserDTO ) );
        }

        return list;
    }
}
