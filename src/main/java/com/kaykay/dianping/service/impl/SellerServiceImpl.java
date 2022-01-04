package com.kaykay.dianping.service.impl;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:45 上午 2022/1/4.
 * @Modified By:
 */

import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.EmBussinessError;
import com.kaykay.dianping.dal.SellerModelMapper;
import com.kaykay.dianping.model.SellerModel;
import com.kaykay.dianping.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: SellerServiceImpl.java, v 0.1 2022/1/4 10:45 上午 Exp $$
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerModelMapper sellerModelMapper;

    @Override
    @Transactional
    public SellerModel create(SellerModel sellerModel) {
        sellerModel.setCreatedAt(new Date());
        sellerModel.setUpdatedAt(new Date());
        sellerModel.setRemarkScore(new BigDecimal(0));
        sellerModel.setDisabledFlag((long) 0);
        sellerModelMapper.insertSelective(sellerModel);
        return get(sellerModel.getId());
    }

    @Override
    public SellerModel get(Integer id) {
        return sellerModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SellerModel> selectAll() {
        return sellerModelMapper.selectAll();
    }

    @Override
    public SellerModel changeStatus(Integer id, Integer disableFlg) throws BusinessException {
        SellerModel sellerModel = get(id);
        if(sellerModel == null){
            throw  new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }
        sellerModel.setDisabledFlag(disableFlg.longValue());
        sellerModelMapper.updateByPrimaryKey(sellerModel);
        return sellerModel;

    }

    @Override
    public Integer countAllSeller() {
        return sellerModelMapper.countAllSeller();
    }
}