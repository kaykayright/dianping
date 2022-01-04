package com.kaykay.dianping.controller.admin;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 8:59 下午 2022/1/4.
 * @Modified By:
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaykay.dianping.common.AdminPermission;
import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.CommonUtil;
import com.kaykay.dianping.common.EmBussinessError;
import com.kaykay.dianping.model.CategoryModel;
import com.kaykay.dianping.request.CategoryCreateReq;
import com.kaykay.dianping.request.PageQuery;
import com.kaykay.dianping.service.CategoryService;
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
 * @version Id: CategoryController.java, v 0.1 2022/1/4 8:59 下午 Exp $$
 */
@Controller("/admin/category")
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //商户列表
    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery){


        PageHelper.startPage(pageQuery.getPage(),pageQuery.getSize());
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        PageInfo<CategoryModel> categoryModelPageInfo = new PageInfo<>(categoryModelList);

        ModelAndView  modelAndView = new ModelAndView("/admin/category/index.html");
        modelAndView.addObject("data",categoryModelPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","index");
        return  modelAndView;

    }


    @RequestMapping("/createpage")
    @AdminPermission
    public  ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/category/create.html");
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","index");

        return  modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid CategoryCreateReq categoryCreateReq, BindingResult bindingResult) throws BusinessException {

        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,
                    CommonUtil.processErrorString(bindingResult));
        }

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(categoryCreateReq.getName());
        categoryModel.setIconUrl(categoryCreateReq.getIconUrl());
        categoryModel.setSort(categoryCreateReq.getSort());

        categoryService.create(categoryModel);

        return "redirect:/admin/category/index";

    }



}