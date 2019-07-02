package com.coding.sales.enums;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 会员等级
 * @date Date : 2019年07月02日 15:40
 */
public enum MemberType {
    /**
     * 普卡
     */
    CardMember("普卡", 1),
    /**
     * 金卡
     */
    GoldCardMember("金卡", 2),
    /**
     * 白金卡
     */
    PlatinumCardMember("白金卡", 3),
    /**
     * 钻石卡
     */
    DiamondCardMember("钻石卡", 4);
    private String name;
    private int index;

    private MemberType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (MemberType c : MemberType.values()) {
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
