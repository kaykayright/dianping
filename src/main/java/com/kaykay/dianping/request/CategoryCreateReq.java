package com.kaykay.dianping.request;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 9:04 下午 2022/1/4.
 * @Modified By:
 */

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * todo
 *
 * @author hk
 * @version Id: CategoryCreateReq.java, v 0.1 2022/1/4 9:04 下午 Exp $$
 */
public class CategoryCreateReq {

    @NotBlank(message = "名字不能为空")
    private String name;
    @NotBlank(message = "iconUrl不能为空")
    private String iconUrl;
    @NotNull(message = "权重不能为空")
    private Integer sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}