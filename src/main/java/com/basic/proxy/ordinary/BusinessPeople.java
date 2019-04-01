package com.basic.proxy.ordinary;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/31 14:12
 */
public class BusinessPeople {

    public static void main(String[] args) {
        TechnologyDepartment coder = new Coder();
        ProductDesigner pd = new ProductDesigner(coder);
        pd.impl();
    }
}
