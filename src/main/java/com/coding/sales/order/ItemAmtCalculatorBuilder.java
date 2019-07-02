package com.coding.sales.order;

import com.coding.sales.beans.DiscountInforBean;
import com.coding.sales.enums.DiscountType;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 根据优惠类型获取计算方式
 * @date Date : 2019年07月02日 15:41
 */
public class ItemAmtCalculatorBuilder {
    public static ItemAmtCalculatorInterface get(DiscountInforBean discountInforBean) {
        if (discountInforBean.getDiscountType().equals(DiscountType.FullDiscountCouponNum)) {

        }
        if (discountInforBean.getDiscountType().equals(DiscountType.FullDiscountCouponVal)) {

        }
        if (discountInforBean.getDiscountType().equals(DiscountType.OffCoupon)) {

        }
        return null;
    }
}
