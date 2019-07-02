package com.coding.sales.order;

import com.coding.sales.beans.DiscountInforBean;
import com.coding.sales.beans.PreciousMetalsProductBean;
import com.coding.sales.input.OrderItemCommand;

import java.math.BigDecimal;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 折扣
 * @date Date : 2019年07月02日 15:41
 */
public class ItemAmtOffCalculator implements ItemAmtCalculatorInterface {
    @Override
    public BigDecimal calculate(PreciousMetalsProductBean preciousMetalsProductBean, OrderItemCommand item, DiscountInforBean discountInforBean) {
        if (item != null && preciousMetalsProductBean != null && item.getAmount() != null && ("" + item.getProduct()).equals(preciousMetalsProductBean.getId())) {
            BigDecimal amt = preciousMetalsProductBean.getPrice().multiply(item.getAmount());
            System.out.println("amt:" + amt + "getOffVal:" + discountInforBean.getOffVal()+"getAmount"+item.getAmount());
            return amt.multiply(discountInforBean.getOffVal());
        }
        return new BigDecimal(0);
    }
}
