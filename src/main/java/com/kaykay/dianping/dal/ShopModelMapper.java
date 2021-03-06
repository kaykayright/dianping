package com.kaykay.dianping.dal;

import com.kaykay.dianping.model.ShopModel;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ShopModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Tue Jan 04 21:30:50 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    List<ShopModel> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Tue Jan 04 21:30:50 CST 2022
     */
    int insert(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Tue Jan 04 21:30:50 CST 2022
     */
    int insertSelective(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Tue Jan 04 21:30:50 CST 2022
     */
    ShopModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Tue Jan 04 21:30:50 CST 2022
     */
    int updateByPrimaryKeySelective(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Tue Jan 04 21:30:50 CST 2022
     */
    int updateByPrimaryKey(ShopModel record);


    Integer countAllShop();


    List<ShopModel> recommend(@Param("longtitude")BigDecimal longtitude,
                              @Param("latitude") BigDecimal latitude);

    List<ShopModel> search(@Param("longtitude")BigDecimal longtitude,
                           @Param("latitude") BigDecimal latitude,
                           @Param("keyword") String keyword,
                           @Param("orderby") Integer orderby,
                           @Param("categoryId") Integer categoryId,
                           @Param("tags") String tags);

    List<Map<String,Object>> searchGroupByTags(@Param("keyword") String keyword,
                                               @Param("categoryId") Integer categoryId,
                                               @Param("tags") String tags);
}