package com.basic.proxy.dynamicproxy.order.service;

import com.basic.proxy.dynamicproxy.order.model.OrderDTO;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/31 17:49
 */
public interface IOrderService {

    Long save(OrderDTO orderDTO);

    void update(Long id) throws Exception;
}
