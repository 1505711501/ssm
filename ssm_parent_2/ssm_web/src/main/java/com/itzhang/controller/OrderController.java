package com.itzhang.controller;


import com.github.pagehelper.PageInfo;
import com.itzhang.domain.Orders;
import com.itzhang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 通过查询得到订单和订单的产品信息
     * @param model
     * @return
     */
    @RequestMapping("/findAllOrder")
    public String findAllOrder(Model model,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "3") Integer pageSize){
        //通过传递的pageNum pageSize得到分页的对象
        PageInfo<Orders> pageInfo = orderService.findAllOrder(pageNum,pageSize);

        model.addAttribute("pageInfo",pageInfo);

        return "order/orderList";
    }

}

