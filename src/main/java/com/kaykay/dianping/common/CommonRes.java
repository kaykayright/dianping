package com.kaykay.dianping.common;

public class CommonRes {


    // 表明读经请求的返回处理结果，“success” 或 “fail”
    private String status;

    //若status=success时，表明对应的返回的json类数据
    //若status=fail时，则data内将使用通用的错误返回码对应的格式
    private Object data;

    //定义一个通用的创建返回对象的方法
    public static CommonRes create(Object result) {

        return CommonRes.create(result,"success");

    }

    public static CommonRes create(Object result,String status){

        CommonRes res = new CommonRes();
        res.setStatus(status);
        res.setData(result);
        return res;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
