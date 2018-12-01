package com.itzhang.service.impl;

import com.itzhang.dao.ProductDao;
import com.itzhang.domain.product;
import com.itzhang.service.ProductService;
import com.itzhang.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public PageBean<product> findAllProduct(Integer pageNum, Integer pageSize) {
        //组装完成pageBean返回
        PageBean<product> pb = new PageBean<product>();
        pb.setPageSize(pageSize);
        pb.setPageNum(pageNum);
        //获取总记录数 赋值
        Integer totalCount = productDao.findTotalCount();
        pb.setTotalCount(totalCount);
        /*计算得到总页数
         * Math.ceil(总记录数/每页条数)
         * 总记录数%每页条数 总记录数/每页条数 总记录数/每页条数+1
         * */
        Integer totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        pb.setTotalPage(totalPage);
        /*分页的sql查询
         * select * from product limit 0,3
         * startIndex = (pageNum-1)*pageSize
         * oracle的sql分页查询  rownum的使用 子查询语法
         * 查询第二页 每页3条
         * select * from  t (select rownum r ,p.* from product p) t where t.r > 3 and t.r<=6
         * startIndex = (pageNum-1)*pageSize
         * endIndex   =pageNum*pageSize
         * select * from  t (select rownum r ,p.* from product p where rownum <=6) t where t.r > 3
         * */
        Integer startIndex = (pageNum-1)*pageSize;
        Integer endIndex = pageNum*pageSize;
        List<product> list = productDao.findAllProduct(startIndex,endIndex);
        pb.setList(list);

        return pb;
    }


    @Override
    public List<product> productFindAll() {
        return productDao.productFindAll();
    }


    //保存产品
    @Override
    public void saveProduct(product product) {
        productDao.saveProduct(product);
    }

    //根据id查询用来修改
    @Override
    public product productFindById(Integer id) {
        return productDao.productFindById(id);
    }

    //修改产品
    @Override
    public void productUpdate(product product) {
        productDao.productUpdate(product);
    }

    @Override
    public void deleteById(Integer id) {
        productDao.deleteById(id);
    }




}
