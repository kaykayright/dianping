package com.kaykay.dianping.service.impl;

import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.EmBussinessError;
import com.kaykay.dianping.dal.UserModelMapper;
import com.kaykay.dianping.model.UserModel;
import com.kaykay.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public UserModel registerUser(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        registerUser.setPassword(encodByMd5(registerUser.getPassword()));
        registerUser.setCreateAt(new Date());
        registerUser.setUpdateAt(new Date());

        try {
            userModelMapper.insert(registerUser);
        }catch (DuplicateKeyException ex) {

            throw new BusinessException(EmBussinessError.REGISTER_DUPLICATE_FAIL);

        }
        return getUser(registerUser.getId());
    }

    @Override
    public UserModel login(String telphone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException {
        UserModel userModel = userModelMapper.selectByTeleponeAndPassword(telphone,encodByMd5(password));

        if(userModel == null){
            throw new BusinessException(EmBussinessError.LOGIN_FAIL);
        }

        return userModel;
    }

    private String encodByMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //确认计算方法
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64 = new BASE64Encoder();
        return  base64.encode(messageDigest.digest(str.getBytes("utf-8")));
    }
}
