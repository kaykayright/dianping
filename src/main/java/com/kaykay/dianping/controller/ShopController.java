package com.kaykay.dianping.controller;


import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.CommonRes;
import com.kaykay.dianping.common.EmBussinessError;
import com.kaykay.dianping.model.ShopModel;
import com.kaykay.dianping.service.CategoryService;
import com.kaykay.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;


    //推荐服务V1.0
    @RequestMapping("/recommend")
    @ResponseBody
    public CommonRes recommend(@RequestParam(name="longtitude")BigDecimal longtitude, @RequestParam(name="latitude")BigDecimal latitude) throws BusinessException {

        if(longtitude == null || latitude == null){

            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longtitude, latitude);


        return  CommonRes.create(shopModelList);

    }

    //搜索服务V1.0
    @RequestMapping("/search")
    @ResponseBody
    public CommonRes search(@RequestParam(name ="longtitude")BigDecimal longtitude,
                            @RequestParam(name ="latitude")BigDecimal latitude,
                            @RequestParam(name = "keyword")String keyword) throws BusinessException{

        if(StringUtils.isEmpty(keyword) || longtitude == null || latitude ==null){
            throw  new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.search(longtitude,latitude,keyword);
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("shop",shopModelList);
        return CommonRes.create(resMap);
    }

}
