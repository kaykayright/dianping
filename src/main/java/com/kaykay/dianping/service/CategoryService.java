package com.kaykay.dianping.service;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 8:44 下午 2022/1/4.
 * @Modified By:
 */

import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.model.CategoryModel;

import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: CategoryService.java, v 0.1 2022/1/4 8:44 下午 Exp $$
 */
public interface CategoryService {

    CategoryModel create(CategoryModel categoryModel) throws BusinessException;
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();

    Integer countAllCategory();

}