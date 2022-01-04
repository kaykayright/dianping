package com.kaykay.dianping.controller;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 9:19 下午 2022/1/4.
 * @Modified By:
 */

import com.kaykay.dianping.common.CommonRes;
import com.kaykay.dianping.model.CategoryModel;
import com.kaykay.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: CategoryController.java, v 0.1 2022/1/4 9:19 下午 Exp $$
 */
@Controller("/category")
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/list")
    public CommonRes list(){
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        return CommonRes.create(categoryModelList);
    }

}