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
 * @Description: 满减计算
 * @date Date : 2019年07月02日 15:41
 */
public class ItemAmtDisAmtCalculator implements ItemAmtCalculatorInterface {
    @Override
    public BigDecimal calculate(PreciousMetalsProductBean preciousMetalsProductBean, OrderItemCommand item, DiscountInforBean discountInforBean) {
        if (item != null && preciousMetalsProductBean != null && item.getAmount() != null && ("" + item.getProduct()).equals(preciousMetalsProductBean.getId())) {
            BigDecimal amt = preciousMetalsProductBean.getPrice().multiply(item.getAmount());
            BigDecimal num = amt.divide(discountInforBean.getFullValNeed(), 0, BigDecimal.ROUND_DOWN);
            System.out.println("amt:" + amt + "num:" + num + "getAmount" + item.getAmount());
            if (num.compareTo(new BigDecimal(0)) > 0) {
                amt = amt.subtract(discountInforBean.getFullDiscountVal().multiply(num));
            }
            return amt;
        }
        return new BigDecimal(0);
    }
}
