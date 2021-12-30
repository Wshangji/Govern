package com.govern.webservie.service.impl;

import com.govern.webservie.config.security.seivice.UserDetailsServiceImpl;
import com.govern.webservie.entity.SysUser;
import com.govern.webservie.mapper.SysUserMapper;
import com.govern.webservie.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.govern.webservie.util.Result;
import com.govern.webservie.util.TokenUtil;
import com.govern.webservie.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Nanf_bunan
 * @since 2021-12-27
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public Result login(LoginVo loginVo) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginVo.getUsername());
        log.info(loginVo.getPassword());
        if (null == userDetails || !passwordEncoder.matches(loginVo.getPassword(), userDetails.getPassword())) {
            return Result.fail("账号或密码错误");
        }
        if(!userDetails.isEnabled()) {
            return Result.fail("该账号已禁用，请联系管理员");
        }
        log.info("登陆成功，在security对象中存入登录者信息");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("根据登录信息获取Token");
        String token = tokenUtil.generateToken(userDetails);
        Map<String, String> map = new HashMap<>(2);
        map.put("tokenHead", tokenHead);
        map.put("token", token);
        return Result.success("登录成功", map);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

}
