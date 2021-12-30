package com.govern.webservie;

import com.govern.webservie.entity.SysUser;
import com.govern.webservie.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class WebServieApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        System.out.println(passwordEncoder.encode("user"));
    }

    @Test
    void passwordEncoder() {
        String ep = "$2a$10$1esjmYd3TRE4dMFdG6GW3eeWBIaiGmG.T/GXEiNEJqbQ6x1G7kMsW";
        String str = passwordEncoder.encode("user");
        boolean flag = passwordEncoder.matches("user",ep);
        System.out.println(str+"\n"+flag+"\n"+ep);
    }

}
