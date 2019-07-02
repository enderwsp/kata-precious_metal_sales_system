package com.coding.sales.beans;

import com.coding.sales.enums.DiscountType;

/**
 * @author : wushnegping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 打折券
 * @date Date : 2019年07月02日 16:07
 */
public class DiscountInforBean {
    /**优惠类型*/
    private DiscountType discountType;
    /**满减打折*/
    private double offVal;
    /**满减金额值要求*/
    private double fullValNeed;
    /**满减金额值扣减*/
    private double fullDiscountVal;
    /**满减相同产品数目值要求*/
    private int fullNum;
    /**满减相同产品数目扣减*/
    private int fullDiscountNum;

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double getOffVal() {
        return offVal;
    }

    public void setOffVal(double offVal) {
        this.offVal = offVal;
    }

    public double getFullValNeed() {
        return fullValNeed;
    }

    public void setFullValNeed(double fullValNeed) {
        this.fullValNeed = fullValNeed;
    }

    public double getFullDiscountVal() {
        return fullDiscountVal;
    }

    public void setFullDiscountVal(double fullDiscountVal) {
        this.fullDiscountVal = fullDiscountVal;
    }

    public int getFullNum() {
        return fullNum;
    }

    public void setFullNum(int fullNum) {
        this.fullNum = fullNum;
    }

    public int getFullDiscountNum() {
        return fullDiscountNum;
    }

    public void setFullDiscountNum(int fullDiscountNum) {
        this.fullDiscountNum = fullDiscountNum;
    }
}
