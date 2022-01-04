package com.kaykay.dianping.request;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 1:31 下午 2022/1/4.
 * @Modified By:
 */

import javax.validation.constraints.NotBlank;

/**
 * todo
 *
 * @author hk
 * @version Id: SellerCreateReq.java, v 0.1 2022/1/4 1:31 下午 Exp $$
 */
public class SellerCreateReq {

    @NotBlank(message = "姓名不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}