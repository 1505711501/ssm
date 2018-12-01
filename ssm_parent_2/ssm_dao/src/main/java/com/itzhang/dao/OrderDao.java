package com.itzhang.dao;

import com.itzhang.domain.Orders;
import com.itzhang.domain.product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "productId",property = "product",javaType = product.class,
                    one = @One(select = "com.itzhang.dao.ProductDao.productFindById"))
    })
    public List<Orders> findAllOrder();
}
