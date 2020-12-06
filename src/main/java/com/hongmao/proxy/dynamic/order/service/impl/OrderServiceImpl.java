package com.hongmao.proxy.dynamic.order.service.impl;

import com.hongmao.proxy.dynamic.order.model.OrderDTO;
import com.hongmao.proxy.dynamic.order.service.IOrderService;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/31 17:55
 */
public class OrderServiceImpl implements IOrderService {

    @Override
    public Long save(OrderDTO orderDTO){
        System.out.println("执行保存逻辑！");
        return 1001L;
    }

    @Override
    public void update(Long id) throws Exception {
        System.out.println("执行更新逻辑！");
        throw new Exception("throw a Exception when update");
    }
}
