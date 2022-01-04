package com.kaykay.dianping;

import com.kaykay.dianping.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DianpingApplicationTests {

    @Test
    void contextLoads() {
    }




    @Autowired
    private UserService userService;

    @Test
    public void testCountAllUser(){


        System.out.println(userService.countAllUser());

    }

}
