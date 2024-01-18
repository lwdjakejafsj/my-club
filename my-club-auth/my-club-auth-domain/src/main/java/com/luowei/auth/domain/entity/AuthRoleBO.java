package com.luowei.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AuthRoleBO implements Serializable {
    private static final long serialVersionUID = -32081771668834582L;
    
    private Long id;
    
    private String roleName;
    
    private String roleKey;

}
