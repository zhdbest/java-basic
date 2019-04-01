package com.basic.proxy.ordinary;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/31 13:57
 */
public class ProductDesigner implements TechnologyDepartment {

    private TechnologyDepartment coder;

    ProductDesigner(TechnologyDepartment coder) {
        this.coder = coder;
    }

    @Override
    public void impl() {
        System.out.println("产品经理接收需求！");
        System.out.println("产品经理提供实现方案！");
        coder.impl();
    }
}
