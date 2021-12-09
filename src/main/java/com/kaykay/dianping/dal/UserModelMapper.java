package com.kaykay.dianping.dal;

import com.kaykay.dianping.model.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    int insert(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    int insertSelective(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    UserModel selectByPrimaryKey(Integer id);

    UserModel selectByTeleponeAndPassword(@Param("telephone") String telphone, @Param("password") String password);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    int updateByPrimaryKeySelective(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    int updateByPrimaryKey(UserModel record);
}