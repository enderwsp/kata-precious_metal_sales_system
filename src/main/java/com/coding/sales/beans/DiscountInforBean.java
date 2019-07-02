package com.coding.sales.beans;

import com.coding.sales.enums.DiscountType;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 打折券
 * @date Date : 2019年07月02日 16:07
 */
public class DiscountInforBean {
    /**
     * 优惠类型
     */
    private DiscountType discountType;
    /**
     * 打折
     */
    private double offVal;
    /**
     * 满减金额值要求
     */
    private double fullValNeed;
    /**
     * 满减金额值扣减
     */
    private double fullDiscountVal;
    /**
     * 满减相同产品数目值要求
     */
    private int fullNum;
    /**
     * 满减相同产品数目扣减
     * 可能存在打折不为整数
     */
    private double fullDiscountNum;

    /**
     * 打折券
     *
     * @param woffVal
     */
    public DiscountInforBean(double woffVal) {
        discountType = DiscountType.OffCoupon;
        offVal = woffVal;
    }

    /**
     * 满减金额
     *
     * @param wfullValNeed
     * @param wfullDiscountVal
     */
    public DiscountInforBean(double wfullValNeed, double wfullDiscountVal) {
        discountType = DiscountType.FullDiscountCouponVal;
        fullValNeed = wfullValNeed;
        fullDiscountVal = wfullDiscountVal;
    }

    /**
     * 数目扣减
     *
     * @param wfullNum
     * @param wfullDiscountNum
     */
    public DiscountInforBean(int wfullNum, double wfullDiscountNum) {
        discountType = DiscountType.FullDiscountCouponNum;
        fullNum = wfullNum;
        fullDiscountNum = wfullDiscountNum;
    }

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

    public double getFullDiscountNum() {
        return fullDiscountNum;
    }

    public void setFullDiscountNum(double fullDiscountNum) {
        this.fullDiscountNum = fullDiscountNum;
    }
}
