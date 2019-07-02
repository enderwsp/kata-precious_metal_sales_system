package com.coding.sales;

import com.coding.sales.beans.CustomerInforBean;
import com.coding.sales.beans.PreciousMetalsProductBean;
import com.coding.sales.datas.CustomerInforDatas;
import com.coding.sales.datas.PreciousMetalsProductDatas;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.order.ItemAmtCalculatorUtil;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
        }

        String jsonFileName = args[0];
        String txtFileName = args[1];

        String orderCommand = FileUtils.readFromFile(jsonFileName);
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand) {
        OrderCommand command = OrderCommand.from(orderCommand);
        OrderRepresentation result = checkout(command);

        return result.toString();
    }

    OrderRepresentation checkout(OrderCommand command) {
        OrderRepresentation result = null;
        if (command == null) {
            return null;
        }
        String orderId = command.getOrderId();
        Date createTime = new Date();
        String memberNo = command.getMemberId();
        CustomerInforBean customerInforBean = CustomerInforDatas.getCustomersByMemberId(memberNo);
        if (customerInforBean == null) {
//            客户信息未找到
            return null;
        }
        boolean canOff = true;
//        DiscountInforBean.nineFiveOff
//                DiscountInforBean.nineOff
        if (command.getDiscounts() == null || command.getDiscounts().size() == 0) {
            canOff = false;
        }
        String memberName = customerInforBean.getName();
        String oldMemberType = customerInforBean.getMemberType().getName();
        String newMemberType = "";
        //本次消费会员新增的积分
        int memberPointsIncreased = 0;
        //会员最新的积分
        int memberPoints = 0;
//        订单明细
        List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();
//        订单总金额
        BigDecimal totalPrice = new BigDecimal(0);
//        优惠明细
        List<DiscountItemRepresentation> discounts = new ArrayList<DiscountItemRepresentation>();
//        优惠总金额
        BigDecimal totalDiscountPrice = new BigDecimal(0);
//         应收金额
        BigDecimal receivables = new BigDecimal(0);
//        付款记录
        List<PaymentRepresentation> payments = new ArrayList<PaymentRepresentation>();
//        付款使用的打折券
        List<String> discountCards = new ArrayList<String>();
//        清空使用的折扣券
        ItemAmtCalculatorUtil.discountCardsUsed = new ArrayList<String>();
        for (OrderItemCommand itemCommand : command.getItems()) {

            PreciousMetalsProductBean preciousMetalsProductBean = PreciousMetalsProductDatas.getPreciousMetalsProductById(itemCommand.getProduct());
            if (preciousMetalsProductBean == null) {
//                产品信息未找到
                return null;
            }
            preciousMetalsProductBean.setOffFlag(canOff);
            BigDecimal itemAmtOrg = ItemAmtCalculatorUtil.calculateNoDis(preciousMetalsProductBean, itemCommand);
            totalPrice = totalPrice.add(itemAmtOrg);
            BigDecimal itemAmt = ItemAmtCalculatorUtil.calculate(command.getDiscounts(), preciousMetalsProductBean, itemCommand);
            receivables = receivables.add(itemAmt);
            OrderItemRepresentation orderItemRepresentation = new OrderItemRepresentation(preciousMetalsProductBean.getId(), preciousMetalsProductBean.getProductName()
                    , preciousMetalsProductBean.getPrice(), itemCommand.getAmount(), itemAmt);
            orderItems.add(orderItemRepresentation);
            BigDecimal discount = itemAmtOrg.subtract(itemAmt);
            totalDiscountPrice = totalDiscountPrice.add(discount);
            if (itemAmtOrg.compareTo(itemAmt) > 0) {
                DiscountItemRepresentation discountItemRepresentation = new DiscountItemRepresentation(preciousMetalsProductBean.getId(), preciousMetalsProductBean.getProductName(), discount);
                discounts.add(discountItemRepresentation);
            }
        }
        result = new OrderRepresentation(orderId, createTime,
                memberNo, memberName, oldMemberType, newMemberType,
                memberPointsIncreased, memberPoints,
                orderItems,
                totalPrice, discounts, totalDiscountPrice,
                receivables, payments, discountCards);
        return result;
    }
}
