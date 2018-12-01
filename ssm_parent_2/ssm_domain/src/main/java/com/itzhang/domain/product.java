package com.itzhang.domain;

import com.itzhang.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class product {

    private Long id;
    private String productNum;
    private String productName;
    private String cityName;
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;
    private double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }



    public Date getDepartureTime() {

        return departureTime;
    }
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
        //处理当前日期得到字符串调用 setDepartureTimeStr
    }



    public String getDepartureTimeStr() {
        //返回当前处理时间后的字符串
        return  DateUtil.formatDateToStr(this.departureTime);
    }
    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        //根据数据库状态1或者0返回字符串
        return this.productStatus==1?"有效":"无效";
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
