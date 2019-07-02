package com.coding.sales.beans;

import com.coding.sales.enums.MemberType;

/**
 * @author : wushnegping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 客户信息
 * @date Date : 2019年07月02日 15:41
 */
public class CustomerInforBean {
    private String name;
    private MemberType memberType;
    private String acNo;
    private int currentMemberPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public int getCurrentMemberPoints() {
        return currentMemberPoints;
    }

    public void setCurrentMemberPoints(int currentMemberPoints) {
        this.currentMemberPoints = currentMemberPoints;
    }
}
