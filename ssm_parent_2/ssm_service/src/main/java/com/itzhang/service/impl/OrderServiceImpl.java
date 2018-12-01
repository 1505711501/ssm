package com.itzhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itzhang.dao.OrderDao;
import com.itzhang.domain.Orders;
import com.itzhang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;


    @Override
    public PageInfo<Orders> findAllOrder(Integer pageNum, Integer pageSize) {
        //开启分页插件的静态方法
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> list =  orderDao.findAllOrder();
        //使用返回得到的list对象初始化pageInfo对象
        PageInfo<Orders> pi = new PageInfo<Orders>(list);
        return pi;
    }
}
