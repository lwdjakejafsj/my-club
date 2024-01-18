package com.luowei.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthUser)实体类
 *
 * @author makejava
 * @since 2023-12-05 23:27:46
 */
@Data
public class AuthUserDTO implements Serializable {
    private static final long serialVersionUID = -88570850753987970L;
    
    private Long id;
    
    private String userName;
    
    private String nickName;
    
    private String email;
    
    private String phone;
    
    private String password;
    
    private Integer sex;
    
    private String avatar;
    
    private Integer status;
    
    private String introduce;
    
    private String extJson;

}

