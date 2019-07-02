package com.coding.sales.order;

import com.coding.sales.beans.PreciousMetalsProductBean;
import com.coding.sales.input.OrderItemCommand;

import java.math.BigDecimal;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 根据优惠类型获取计算方式
 * @date Date : 2019年07月02日 15:41
 */
public class ItemAmtCalculatorUtil {

    public static BigDecimal calculateNoDis(PreciousMetalsProductBean preciousMetalsProductBean, OrderItemCommand item) {
        if (item != null && preciousMetalsProductBean != null && item.getAmount() != null && ("" + item.getProduct()).equals(preciousMetalsProductBean.getId())) {
            return preciousMetalsProductBean.getPrice().multiply(item.getAmount());
        }
        return new BigDecimal(0);
    }
    public static BigDecimal calculate(PreciousMetalsProductBean preciousMetalsProductBean, OrderItemCommand item) {
        if (item != null && preciousMetalsProductBean != null && item.getAmount() != null && ("" + item.getProduct()).equals(preciousMetalsProductBean.getId())) {
            return preciousMetalsProductBean.getPrice().multiply(item.getAmount());
        }
        return new BigDecimal(0);
    }
}
