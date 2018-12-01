package com.itzhang.service;

import com.github.pagehelper.PageInfo;
import com.itzhang.domain.Orders;

import java.util.List;

public interface OrderService {


    PageInfo<Orders> findAllOrder(Integer pageNum, Integer pageSize);
}
