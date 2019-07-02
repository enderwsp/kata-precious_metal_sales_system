package com.coding.sales;

import com.coding.sales.beans.CustomerInforBean;
import com.coding.sales.datas.CustomerInforDatas;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
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

        String orderId = command.getOrderId();
        Date createTime = new Date();
        String memberNo = command.getMemberId();
        CustomerInforBean customerInforBean = CustomerInforDatas.getCustomersByMemberId(memberNo);
        String memberName = customerInforBean.getName();
        String oldMemberType = customerInforBean.getMemberType().getName();
        String newMemberType = "";
        //本次消费会员新增的积分
        int memberPointsIncreased = 0;
        //会员最新的积分
        int memberPoints = 0;
//        订单明细
        List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();
        BigDecimal totalPrice = new BigDecimal(0);
//        优惠明细
        List<DiscountItemRepresentation> discounts = new ArrayList<DiscountItemRepresentation>();
        BigDecimal totalDiscountPrice = new BigDecimal(0);
        BigDecimal receivables = new BigDecimal(0);
//        付款记录
        List<PaymentRepresentation> payments = new ArrayList<PaymentRepresentation>();
//        付款使用的打折券
        List<String> discountCards = new ArrayList<String>();
        for (OrderItemCommand itemCommand : command.getItems()) {

        }
        result = new OrderRepresentation(orderId, createTime,
                memberNo, memberName, oldMemberType, newMemberType,
                memberPointsIncreased, memberPoints,
                orderItems,
                totalPrice, discounts, totalDiscountPrice,
                receivables, payments, discountCards)
        return result;
    }
}
