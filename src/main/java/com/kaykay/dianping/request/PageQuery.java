package com.kaykay.dianping.request;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 2:58 下午 2022/1/4.
 * @Modified By:
 */

/**
 * todo
 *
 * @author hk
 * @version Id: PageQuery.java, v 0.1 2022/1/4 2:58 下午 Exp $$
 */
public class PageQuery {

    private Integer page =1;


    private Integer size = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}