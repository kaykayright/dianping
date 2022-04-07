package com.kaykay.dianping;

import com.kaykay.dianping.model.SellerModel;
import com.kaykay.dianping.model.ShopModel;
import com.kaykay.dianping.service.SellerService;
import com.kaykay.dianping.service.ShopService;
import com.kaykay.dianping.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class DianpingApplicationTests {

    @Test
    void contextLoads() {
    }




    @Autowired
    private UserService userService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ShopService shopService;

    @Test
    public void testCountAllUser(){


        System.out.println(userService.countAllUser());

    }

    @Test
    public void testGetSeller(){

        SellerModel sellerModel = sellerService.get(1);

        System.out.println(sellerModel.toString());

    }

    @Test
    public  void testShopRecommand(){


        List<ShopModel> shopModelList =  shopService.recommend(new BigDecimal(120),new BigDecimal(30));

        shopModelList.forEach(shopModel -> {
            System.out.println(shopModel.getName());


        });

    }


    @Test
    public  void testShopSearch(){


        List<ShopModel> shopModelList =  shopService.search(new BigDecimal(120),new BigDecimal(30),"和府",0,1,"");

        shopModelList.forEach(shopModel -> {
            System.out.println(shopModel.getName());


        });

    }

}
