package com.coding.sales.order;

import com.coding.sales.beans.DiscountInforBean;
import com.coding.sales.input.OrderItemCommand;

import java.math.BigDecimal;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 满足数目的计算
 * @date Date : 2019年07月02日 15:41
 */
public class ItemAmtDisNumCalculator implements ItemAmtCalculatorInterface {
    @Override
    public BigDecimal calculate(OrderItemCommand item, DiscountInforBean discountInforBean) {
        return new BigDecimal(0);
    }
}
