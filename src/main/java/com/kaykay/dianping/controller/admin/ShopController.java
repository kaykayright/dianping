package com.kaykay.dianping.controller.admin;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:21 下午 2022/1/4.
 * @Modified By:
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaykay.dianping.common.AdminPermission;
import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.CommonUtil;
import com.kaykay.dianping.common.EmBussinessError;
import com.kaykay.dianping.model.ShopModel;
import com.kaykay.dianping.request.PageQuery;
import com.kaykay.dianping.request.ShopCreateReq;
import com.kaykay.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: ShopController.java, v 0.1 2022/1/4 10:21 下午 Exp $$
 */
@Controller("/admin/shop")
@RequestMapping("/admin/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;


    //门店列表
    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery){


        PageHelper.startPage(pageQuery.getPage(),pageQuery.getSize());
        List<ShopModel> shopModelList = shopService.selectAll();
        PageInfo<ShopModel> shopModelPageInfo = new PageInfo<>(shopModelList);

        ModelAndView  modelAndView = new ModelAndView("/admin/shop/index.html");
        modelAndView.addObject("data",shopModelPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","shop");
        modelAndView.addObject("ACTION_NAME","index");
        return  modelAndView;

    }


    @RequestMapping("/createpage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/shop/create.html");
        modelAndView.addObject("CONTROLLER_NAME","shop");
        modelAndView.addObject("ACTION_NAME","index");

        return  modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid ShopCreateReq shopCreateReq, BindingResult bindingResult) throws BusinessException {

        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,
                    CommonUtil.processErrorString(bindingResult));
        }

        ShopModel shopModel = new ShopModel();
        shopModel.setIconUrl(shopCreateReq.getIconUrl());
        shopModel.setAddress(shopCreateReq.getAddress());
        shopModel.setCategoryId(shopCreateReq.getCategoryId());
        shopModel.setEndTime(shopCreateReq.getEndTime());
        shopModel.setStartTime(shopCreateReq.getStartTime());
        shopModel.setLatitude(shopCreateReq.getLatitude());
        shopModel.setLongtitude(shopCreateReq.getLongtitude());
        shopModel.setName(shopCreateReq.getName());
        shopModel.setPricePerMan(shopCreateReq.getPricePerMan());
        shopModel.setSellerId(shopCreateReq.getSellerId());

        shopService.create(shopModel);

        return "redirect:/admin/shop/index";

    }


}