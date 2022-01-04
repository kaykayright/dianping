package com.kaykay.dianping;

import com.kaykay.dianping.model.SellerModel;
import com.kaykay.dianping.service.SellerService;
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

    @Autowired
    private SellerService sellerService;

    @Test
    public void testCountAllUser(){


        System.out.println(userService.countAllUser());

    }

    @Test
    public void testGetSeller(){

        SellerModel sellerModel = sellerService.get(1);

        System.out.println(sellerModel);

    }

}
