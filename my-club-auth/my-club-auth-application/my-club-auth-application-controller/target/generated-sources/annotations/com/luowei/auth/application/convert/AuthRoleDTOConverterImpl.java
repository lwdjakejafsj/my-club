package com.luowei.auth.application.convert;

import com.luowei.auth.application.dto.AuthRoleDTO;
import com.luowei.auth.domain.entity.AuthRoleBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-25T22:17:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class AuthRoleDTOConverterImpl implements AuthRoleDTOConverter {

    @Override
    public AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO) {
        if ( authRoleDTO == null ) {
            return null;
        }

        AuthRoleBO authRoleBO = new AuthRoleBO();

        authRoleBO.setId( authRoleDTO.getId() );
        authRoleBO.setRoleName( authRoleDTO.getRoleName() );
        authRoleBO.setRoleKey( authRoleDTO.getRoleKey() );

        return authRoleBO;
    }

    @Override
    public AuthRoleDTO convertBOToDTO(AuthRoleBO authRoleBO) {
        if ( authRoleBO == null ) {
            return null;
        }

        AuthRoleDTO authRoleDTO = new AuthRoleDTO();

        authRoleDTO.setId( authRoleBO.getId() );
        authRoleDTO.setRoleName( authRoleBO.getRoleName() );
        authRoleDTO.setRoleKey( authRoleBO.getRoleKey() );

        return authRoleDTO;
    }

    @Override
    public List<AuthRoleDTO> convertBOListToDTOList(List<AuthRoleBO> authRoleBOList) {
        if ( authRoleBOList == null ) {
            return null;
        }

        List<AuthRoleDTO> list = new ArrayList<AuthRoleDTO>( authRoleBOList.size() );
        for ( AuthRoleBO authRoleBO : authRoleBOList ) {
            list.add( convertBOToDTO( authRoleBO ) );
        }

        return list;
    }

    @Override
    public List<AuthRoleBO> convertDTOListToBOList(List<AuthRoleDTO> authRoleDTOList) {
        if ( authRoleDTOList == null ) {
            return null;
        }

        List<AuthRoleBO> list = new ArrayList<AuthRoleBO>( authRoleDTOList.size() );
        for ( AuthRoleDTO authRoleDTO : authRoleDTOList ) {
            list.add( convertDTOToBO( authRoleDTO ) );
        }

        return list;
    }
}
