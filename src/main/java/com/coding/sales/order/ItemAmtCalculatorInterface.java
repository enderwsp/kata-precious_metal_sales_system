package com.coding.sales.order;

import com.coding.sales.input.OrderItemCommand;

public interface ItemAmtCalculatorInterface {
    double calculate(OrderItemCommand item);
}
