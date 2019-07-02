package com.coding.sales.beans;

import com.coding.sales.enums.DiscountType;

import java.math.BigDecimal;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 打折券
 * @date Date : 2019年07月02日 16:07
 */
public class DiscountInforBean {
    public static String nineOff = "9折券";
    public static String nineFiveOff = "95折券";
    public static String threeNum = "第3件半价";
    public static String fourNum = "满3送1";
    public static String threeThousand = "每满3000元减350";
    public static String twoThousand = "每满2000元减30";
    public static String oneThousand = "每满1000元减10";
    /**
     * 优惠类型
     */
    private DiscountType discountType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 优惠名称
     */
    private String name;
    /**
     * 打折
     */
    private BigDecimal offVal;
    /**
     * 满减金额值要求
     */
    private BigDecimal fullValNeed;
    /**
     * 满减金额值扣减
     */
    private BigDecimal fullDiscountVal;
    /**
     * 满减相同产品数目值要求
     */
    private int fullNumNeed;
    /**
     * 满减相同产品数目扣减
     * 可能存在打折不为整数
     */
    private BigDecimal fullDiscountNum;

    /**
     * 打折券
     *
     * @param woffVal
     */
    public DiscountInforBean(String woffVal) {
        discountType = DiscountType.OffCoupon;
        offVal = new BigDecimal(woffVal);
    }

    /**
     * 满减金额
     *
     * @param wfullValNeed
     * @param wfullDiscountVal
     */
    public DiscountInforBean(String wfullValNeed, String wfullDiscountVal) {
        discountType = DiscountType.FullDiscountCouponVal;
        fullValNeed = new BigDecimal(wfullValNeed);
        fullDiscountVal = new BigDecimal(wfullDiscountVal);
    }

    /**
     * 数目扣减
     *
     * @param wfullNum
     * @param wfullDiscountNum
     */
    public DiscountInforBean(int wfullNum, String wfullDiscountNum) {
        discountType = DiscountType.FullDiscountCouponNum;
        fullNumNeed = wfullNum;
        fullDiscountNum = new BigDecimal(wfullDiscountNum);
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getOffVal() {
        return offVal;
    }

    public void setOffVal(BigDecimal offVal) {
        this.offVal = offVal;
    }

    public BigDecimal getFullValNeed() {
        return fullValNeed;
    }

    public void setFullValNeed(BigDecimal fullValNeed) {
        this.fullValNeed = fullValNeed;
    }

    public BigDecimal getFullDiscountVal() {
        return fullDiscountVal;
    }

    public void setFullDiscountVal(BigDecimal fullDiscountVal) {
        this.fullDiscountVal = fullDiscountVal;
    }

    public int getFullNumNeed() {
        return fullNumNeed;
    }

    public void setFullNumNeed(int fullNumNeed) {
        this.fullNumNeed = fullNumNeed;
    }

    public BigDecimal getFullDiscountNum() {
        return fullDiscountNum;
    }

    public void setFullDiscountNum(BigDecimal fullDiscountNum) {
        this.fullDiscountNum = fullDiscountNum;
    }
}
