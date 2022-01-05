package com.kaykay.dianping.service;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 9:35 下午 2022/1/4.
 * @Modified By:
 */

import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.model.ShopModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: ShopService.java, v 0.1 2022/1/4 9:35 下午 Exp $$
 */
public interface ShopService {

    ShopModel create(ShopModel shopModel) throws BusinessException;
    ShopModel get(Integer id);
    List<ShopModel> selectAll();

    List<ShopModel> recommend(BigDecimal longtitude,BigDecimal latitude);

    Integer countAllShop();


}