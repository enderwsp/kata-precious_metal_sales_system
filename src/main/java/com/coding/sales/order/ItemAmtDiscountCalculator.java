package com.coding.sales.order;

import com.coding.sales.beans.DiscountInforBean;
import com.coding.sales.input.OrderItemCommand;
/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 满减计算
 * @date Date : 2019年07月02日 15:41
 */
public class ItemAmtDiscountCalculator implements ItemAmtCalculatorInterface {
    @Override
    public double calculate(OrderItemCommand item, DiscountInforBean discountInforBean) {
        return 1.00;
    }
}
