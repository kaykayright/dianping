package com.kaykay.dianping.controller.admin;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:47 上午 2022/1/4.
 * @Modified By:
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaykay.dianping.common.*;
import com.kaykay.dianping.model.SellerModel;
import com.kaykay.dianping.request.PageQuery;
import com.kaykay.dianping.request.SellerCreateReq;
import com.kaykay.dianping.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: SellerController.java, v 0.1 2022/1/4 10:47 上午 Exp $$
 */
@Controller("/admin/seller")
@RequestMapping(value = "/admin/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;


    //商户列表
    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery){


        PageHelper.startPage(pageQuery.getPage(),pageQuery.getSize());
        List<SellerModel> sellerModelList = sellerService.selectAll();
        PageInfo<SellerModel> sellerModelPageInfo = new PageInfo<>(sellerModelList);

        ModelAndView  modelAndView = new ModelAndView("/admin/seller/index.html");
        modelAndView.addObject("data",sellerModelPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","index");
        return  modelAndView;

    }


    @RequestMapping("/createpage")
    @AdminPermission
    public  ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/seller/create.html");
        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","index");

        return  modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid SellerCreateReq sellerCreateReq, BindingResult bindingResult) throws BusinessException {

        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,
                    CommonUtil.processErrorString(bindingResult));
        }

        SellerModel sellerModel = new SellerModel();
        sellerModel.setName(sellerCreateReq.getName());
        sellerService.create(sellerModel);

        return "redirect:/admin/seller/index";

    }

    @RequestMapping(value = "down",method = RequestMethod.POST)
    @AdminPermission
    @ResponseBody
    public CommonRes down(@RequestParam(value = "id")Integer id) throws BusinessException {

        SellerModel sellerModel = sellerService.changeStatus(id,1);
        return  CommonRes.create(sellerModel);

    }

    @RequestMapping(value = "up",method = RequestMethod.POST)
    @AdminPermission
    @ResponseBody
    public CommonRes up(@RequestParam(value = "id")Integer id) throws BusinessException {

        SellerModel sellerModel = sellerService.changeStatus(id,0);
        return  CommonRes.create(sellerModel);

    }


}