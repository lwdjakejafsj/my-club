package com.luowei.auth.domain.entity;

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
public class AuthUserBO implements Serializable {
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
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    private Integer isDeleted;


}

