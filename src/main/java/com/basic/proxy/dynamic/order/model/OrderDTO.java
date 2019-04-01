package com.basic.proxy.dynamic.order.model;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/31 17:49
 */
public class OrderDTO {

    private Long skuID;

    private String customer;

    public Long getSkuID() {
        return skuID;
    }

    public void setSkuID(Long skuID) {
        this.skuID = skuID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
