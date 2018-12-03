package com.cloud.authorizationserver.entity;

import com.cloud.core.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User extends BasePo {
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     *  是否可用
     */
    private boolean enabled;
    /**
     * 用户的账号是否过期,过期的账号无法通过授权验证. true 账号未过期
     */
    private boolean accountNonExpired;
    /**
     * 用户的凭据(pasword) 是否过期,过期的凭据不能通过验证. true 没有过期,false 已过期
     */
    private boolean credentialsNonExpired;
    /**
     * 用户的账户是否被锁定,被锁定的账户无法通过授权验证. true 账号未锁定
     */
    private boolean accountNonLocked;
}