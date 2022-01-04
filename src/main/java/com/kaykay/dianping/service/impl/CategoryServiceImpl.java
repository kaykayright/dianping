package com.kaykay.dianping.service.impl;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 8:46 下午 2022/1/4.
 * @Modified By:
 */

import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.EmBussinessError;
import com.kaykay.dianping.dal.CategoryModelMapper;
import com.kaykay.dianping.model.CategoryModel;
import com.kaykay.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: CategoryServiceImpl.java, v 0.1 2022/1/4 8:46 下午 Exp $$
 */
@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private CategoryModelMapper categoryModelMapper;

    @Override
    @Transactional
    public CategoryModel create(CategoryModel categoryModel) throws BusinessException {

        categoryModel.setCreatedAt(new Date());
        categoryModel.setUpdatedAt(new Date());
        try{
            categoryModelMapper.insertSelective(categoryModel);
        }catch(DuplicateKeyException ex){
            throw new BusinessException(EmBussinessError.CATEGORY_NAME_DUPLICATED);
        }

        return get(categoryModel.getId());
    }

    @Override
    public CategoryModel get(Integer id) {
        return categoryModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CategoryModel> selectAll() {
        return categoryModelMapper.selectAll();
    }

    @Override
    public Integer countAllCategory() {
        return categoryModelMapper.countAllCategory();
    }
}