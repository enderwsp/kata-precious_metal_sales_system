package com.coding.sales.order;

import com.coding.sales.beans.DiscountInforBean;
import com.coding.sales.beans.PreciousMetalsProductBean;
import com.coding.sales.enums.DiscountType;
import com.coding.sales.input.OrderItemCommand;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 根据优惠类型获取计算方式
 * @date Date : 2019年07月02日 15:41
 */
public class ItemAmtCalculatorUtil {
    public static List<String> discountCardsUsed = null;

    public static BigDecimal calculateNoDis(PreciousMetalsProductBean preciousMetalsProductBean, OrderItemCommand item) {
        if (item != null && preciousMetalsProductBean != null && item.getAmount() != null && ("" + item.getProduct()).equals(preciousMetalsProductBean.getId())) {
            return preciousMetalsProductBean.getPrice().multiply(item.getAmount());
        }
        return new BigDecimal(0);
    }

    public static BigDecimal calculate(List<String> discountCards, PreciousMetalsProductBean preciousMetalsProductBean, OrderItemCommand item) {
        if (item != null && preciousMetalsProductBean != null && item.getAmount() != null && ("" + item.getProduct()).equals(preciousMetalsProductBean.getId())) {

            if (preciousMetalsProductBean.getDiscountInfors() != null && preciousMetalsProductBean.getDiscountInfors().size() > 0) {
                BigDecimal calAmt = new BigDecimal(0);
                DiscountInforBean usedDiscountInforBean = null;
                for (DiscountInforBean discountInforBean : preciousMetalsProductBean.getDiscountInfors()) {
                    if (discountInforBean.getDiscountType().getIndex() == DiscountType.OffCoupon.getIndex()
                            && (!preciousMetalsProductBean.isOffFlag() || (discountCards != null && !discountCards.contains(discountInforBean.getName())))) {
                        continue;
                    } else {
                        ItemAmtCalculatorInterface itemAmtCalculatorInterface = ItemAmtCalculatorBuilder.get(discountInforBean);
                        BigDecimal calAmtOne = itemAmtCalculatorInterface.calculate(preciousMetalsProductBean, item, discountInforBean);
                        if (calAmt.compareTo(new BigDecimal(0)) == 0) {
                            calAmt = calAmtOne;
                            usedDiscountInforBean = discountInforBean;
                        } else if (calAmtOne.compareTo(calAmt) < 0) {
                            calAmt = calAmtOne;
                            usedDiscountInforBean = discountInforBean;
                        }
                    }
                }
                if (usedDiscountInforBean != null && usedDiscountInforBean.getDiscountType().getIndex() == DiscountType.OffCoupon.getIndex()) {
                    if (discountCardsUsed == null) {
                        discountCardsUsed = new ArrayList<String>();
                    }
                    discountCardsUsed.add(usedDiscountInforBean.getName());
                }
                return calAmt;
            } else {
                return calculateNoDis(preciousMetalsProductBean, item);
            }
        }
        return new BigDecimal(0);
    }
}
