package com.kaykay.dianping.model;

import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_at
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    private Date createAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.update_at
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    private Date updateAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.telphone
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    private String telphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.nick_name
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    private String nickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gender
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    private Integer gender;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_at
     *
     * @return the value of user.create_at
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_at
     *
     * @param createAt the value for user.create_at
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.update_at
     *
     * @return the value of user.update_at
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.update_at
     *
     * @param updateAt the value for user.update_at
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.telphone
     *
     * @return the value of user.telphone
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.telphone
     *
     * @param telphone the value for user.telphone
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.nick_name
     *
     * @return the value of user.nick_name
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.nick_name
     *
     * @param nickName the value for user.nick_name
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gender
     *
     * @return the value of user.gender
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gender
     *
     * @param gender the value for user.gender
     *
     * @mbg.generated Fri Nov 26 19:55:50 CST 2021
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }
}