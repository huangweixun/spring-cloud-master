package com.cloud.authorizationserver.service;


import com.cloud.authorizationserver.entity.Role;
import com.cloud.authorizationserver.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service("userDetailsService")
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userService.getByUsername(username);
//        log.debug("loadByUsername:{}", user.toString());

        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                this.obtainGrantedAuthorities(user.getId()));
    }

    /**
     * 获得登录者所有角色的权限集合.
     *
     * @param userId
     * @return
     */
    private Set<GrantedAuthority> obtainGrantedAuthorities(long userId) {
        Set<Role> roles = roleService.queryUserRolesByUserId(userId);
//        System.out.println(user.getUsername());
//        log.debug("user:{},roles:{}", user.getUsername(), roles);
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getCode()))
                .collect(Collectors.toSet());
    }
}
