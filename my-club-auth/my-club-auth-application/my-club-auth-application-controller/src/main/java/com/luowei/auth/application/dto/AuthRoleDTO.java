package com.luowei.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AuthRoleDTO implements Serializable {
    private static final long serialVersionUID = -32081771668834582L;
    
    private Long id;
    
    private String roleName;
    
    private String roleKey;
}
