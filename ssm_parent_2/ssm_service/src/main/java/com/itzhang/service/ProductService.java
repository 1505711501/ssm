package com.itzhang.service;

import com.itzhang.domain.product;
import com.itzhang.util.PageBean;

import java.util.List;

public interface ProductService {

    List<product> productFindAll();

    void saveProduct(product product);

    product productFindById(Integer id);

    void productUpdate(product product);

    void deleteById(Integer id);

    PageBean<product> findAllProduct(Integer pageNum, Integer pageSize);
}
