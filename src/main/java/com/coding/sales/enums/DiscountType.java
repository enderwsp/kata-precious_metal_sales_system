package com.coding.sales.enums;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 打折券类型
 * @date Date : 2019年07月02日 15:40
 */
public enum DiscountType {
    /**
     * 金额满减
     */
    FullDiscountCouponVal("金额满减", 1),
    /**
     * 相同产品数目满减
     */
    FullDiscountCouponNum("数目满减", 2),
    /**
     * 折扣
     */
    OffCoupon("折扣", 3);
    private String name;
    private int index;

    DiscountType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (DiscountType c : DiscountType.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.index + "_" + this.name;
    }
}
