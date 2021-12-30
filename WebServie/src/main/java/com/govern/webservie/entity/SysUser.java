package com.govern.webservie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Nanf_bunan
 * @since 2021-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable , UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String usrName;

    @ApiModelProperty(value = "用户密码")
    private String usrPwd;

    @ApiModelProperty(value = "用户账号状态")
    private Boolean usrStatues;

    @ApiModelProperty(value = "用户对应的角色信息")
    private List<SysRole> roles;

    @ApiModelProperty(value = "用户对应的菜单")
    private List<SysMenu> menus;

    @ApiModelProperty(value = "用户对应的数据权限")
    private List<SysPermission> permissions;


    /**
     * 权限数据
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(item -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + item.getLabel()));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return usrPwd;
    }

    @Override
    public String getUsername() {
        return usrName;
    }

    /**
     * 账号是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * 账号是否锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return usrStatues;
    }

    /**
     * 是否被禁用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return usrStatues;
    }
}
