package com.itzhang.controller;


import com.itzhang.domain.product;
import com.itzhang.service.ProductService;
import com.itzhang.util.DateUtil;
import com.itzhang.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 查询所有物品
 */

@Controller
@RequestMapping("/product")
public class ProductController {


    /**
     * 自定义属性编辑器处理日期传递
     */
    @InitBinder
    public void initBind(WebDataBinder binder){
        //注册自定义的属性编辑器 指定转换的类型
        //参数1为需要转换的类型
        binder.registerCustomEditor(Date.class,new PropertiesEditor(){
            //接受得到浏览器传递的字符串参数
            @Override
            public void setAsText(String dateStr) throws IllegalArgumentException {
                //处理得到的字符串编程日期后再赋值
                Date date =  DateUtil.parseStrToDate(dateStr);
                //得到的日期参数赋值给属性
                setValue(date);
            }
        });
    }

    @Autowired
    private ProductService productService;




    @RequestMapping("/productFindAll")
    public String productFindAll(Model model){
        List<product> productList = productService.productFindAll();
        model.addAttribute("productList",productList);

        return "product/productList";
    }

    //接受请求跳转添加页面
    @RequestMapping("/productAddUI")
    public String productAddUI(){

        return  "product/productAdd";

    }

    /**
     * 接受产品对象保存到数据库
     * @param product
     * @return
     */
    @RequestMapping("/productAdd")
    public String productAdd(product product){
        //保存产品
        productService.saveProduct(product);
        //保存成功后，跳转到列表页查看
        //forward  转发    地址不变  一次  数据不丢
        //redirect 重定向  地址变化  两次   数据丢失
        return "redirect:/product/productFindAll";
    }


    /**
     * 通过传递的id得到产品的对象
     */
    @RequestMapping("/updateProductUI")
    public String updateProductUI(Integer id,Model model){

        //查询得到产品对象
        product product = productService.productFindById(id);
        model.addAttribute("product",product);
        return "product/productUpdate";
    }


    /**
     * 接受产品对象更新数据库
     */
    @RequestMapping("/updateProduct")
    public String updateProduct(product product){
        //调用service来更新
        productService.productUpdate(product);
        //更新之后跳转到页面查询
        return "redirect:/product/productFindAll";
    }

    /**
     * 根据id删除产品
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        productService.deleteById(id);
        return "redirect:/product/productFindAll";
    }

    /**
     * 使用pageNumber pageSize
     * 分页查询产品数据
     */
    @RequestMapping("/findAllProduct")
    public String productFindAll(Model model,
                                 @RequestParam(defaultValue = "1")    Integer pageNum,
                                 @RequestParam(defaultValue = "3")    Integer pageSize){
        //通过传递参数调用service得到分页的pageBean对象
        PageBean<product> pb =  productService.findAllProduct(pageNum,pageSize);

        model.addAttribute("pb",pb);
        return "product/productList";
    }
}
