package com.kaykay.dianping.controller.admin;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:45 上午 2021/12/28.
 * @Modified By:
 */

import com.kaykay.dianping.common.AdminPermission;
import com.kaykay.dianping.common.BusinessException;
import com.kaykay.dianping.common.CommonRes;
import com.kaykay.dianping.common.EmBussinessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * todo
 *
 * @author hk
 * @version Id: AdminController.java, v 0.1 2021/12/28 10:45 上午 Exp $$
 */
@Controller("/admin/admin")
@RequestMapping(value = "/admin/admin")
public class AdminController {

    @Value("${admin.email}")
    private String email;
    @Value("${admin.encryptPassword}")
    private String encryptPassword;


    @Autowired
    private HttpServletRequest httpServletRequest;


    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    @RequestMapping("/index")
    @AdminPermission(produceType = "application/json")
    @ResponseBody
    public CommonRes index() {

       // ModelAndView modelAndView = new ModelAndView("/admin/admin/index");
        // return modelAndView;
        return CommonRes.create(null);
    }

    @RequestMapping("/loginpage")
    public ModelAndView loginpage() {

        ModelAndView modelAndView = new ModelAndView("/admin/admin/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(name="email")String email,@RequestParam(name="password")String password) throws BusinessException,
            UnsupportedEncodingException,
                        NoSuchAlgorithmException {

        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password))
        {
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"用户名密码不能为空");
        }
        if(email.equals(this.email) && encodByMd5(password).equals(this.encryptPassword)){
            //登录成功
            httpServletRequest.getSession().setAttribute(CURRENT_ADMIN_SESSION,email);
            return "redirect:/admin/admin/index";
        }else{
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"用户名密码错误");

        }

    }

    private String encodByMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //确认计算方法
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64 = new BASE64Encoder();
        return  base64.encode(messageDigest.digest(str.getBytes("utf-8")));
    }


}