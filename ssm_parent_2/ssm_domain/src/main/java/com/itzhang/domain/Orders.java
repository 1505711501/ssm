package com.itzhang.domain;

import com.itzhang.util.DateUtil;

import java.util.Date;

public class Orders {

    private Long id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private Integer peopleCount;
    private String orderDesc;
    private Integer payType;
    private Integer orderStatus;
    //多方的订单一方的产品对象属性
    private product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public com.itzhang.domain.product getProduct() {
        return product;
    }

    public void setProduct(com.itzhang.domain.product product) {
        this.product = product;
    }

    public String getOrderTimeStr() {
        return DateUtil.formatDateToStr(this.orderTime);
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }
}
