package com.govern.webservie.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Token工具类
 * @author: Nanf_bunan
 * @date: 2021-12-27 21-22
 */
@Component
public class TokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(UserDetails userDetails) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("username", userDetails.getUsername());
        map.put("created", new Date());
        return this.generateJwrt(map);
    }

    /**
     * 根据荷载信息生成Token
     * @param map
     * @return
     */
    private String generateJwrt(Map<String, Object> map) {
        return Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    /**
     * 根据Token获取荷载信息
     * @param token
     * @return
     */
    public Claims getTockenBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据Token得到用户名
     * @param token
     * @return
     */
    public String getUsernameByToken(String token) {
        return (String) this.getTockenBody(token).get("username");
    }

    /**
     * 判断Token是否过期
     * @param token
     * @return
     */
    public boolean isExpiration(String token) {
        return this.getTockenBody(token).getExpiration().before(new Date());
    }

    public String refreshToken(String token) {
        Claims claims = this.getTockenBody(token);
        claims.setExpiration(new Date());
        return this.generateJwrt(claims);
    }
}
