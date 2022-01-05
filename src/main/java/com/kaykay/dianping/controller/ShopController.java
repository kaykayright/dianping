package com.kaykay.dianping.controller;


import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.CommonRes;
import com.kaykay.dianping.common.EmBussinessError;
import com.kaykay.dianping.model.ShopModel;
import com.kaykay.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;


    //推荐服务V1.0
    @RequestMapping("/recommended")
    @ResponseBody
    public CommonRes recommend(@RequestParam(name="longtitude")BigDecimal longtitude, @RequestParam(name="latitude")BigDecimal latitude) throws BusinessException {

        if(longtitude == null || latitude == null){

            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longtitude, latitude);

        return  CommonRes.create(shopModelList);

    }
}
