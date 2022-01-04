package com.kaykay.dianping.service;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:43 上午 2022/1/4.
 * @Modified By:
 */

import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.model.SellerModel;

import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: SellerService.java, v 0.1 2022/1/4 10:43 上午 Exp $$
 */
public interface SellerService {

    SellerModel create(SellerModel sellerModel);
    SellerModel get(Integer id);
    List<SellerModel> selectAll();
    SellerModel changeStatus(Integer id, Integer disableFlg) throws BusinessException;
}