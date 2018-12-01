package com.itzhang.dao;

import com.itzhang.domain.product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductDao {
    //列表查询产品数据
    @Select("select * from   (select rownum r ,p.* from product p where rownum <=#{endIndex}) t where t.r > #{startIndex} ")
    public List<product> findAllProduct(@Param("startIndex") Integer s, @Param("endIndex")Integer e);


    //通过统计函数得到总数量
    @Select("select count(1) from product ")
    Integer findTotalCount();

    //列表查询商品数据
    @Select("select * from product")
    List<product> productFindAll();

    //保存产品插入
    @Insert("insert into product values(com_sequence.nextval," +
            "#{productNum},#{productName},#{cityName}," +
            "#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(product product);

    //根据id查询用来修改
    @Select("select * from product where id=#{id}")
    product productFindById(Integer id);

    //修改产品
    @Update({"update product set productName=#{productName},cityName=#{cityName}," +
            "departureTime=#{departureTime},productPrice=#{productPrice}," +
            "productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}"})
    void productUpdate(product product);

    //删除产品
    @Delete("delete from product where id=#{id}")
    void deleteById(Integer id);



}
