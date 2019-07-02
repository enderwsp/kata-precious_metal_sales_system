package com.coding.sales.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.beans
 * @Description: 在售贵金属信息
 * @date Date : 2019年07月02日 15:40
 */
public class PreciousMetalsProductBean {
    /***/
    private String productName;
    /**
     * 客户姓名
     */
    private String id;
    /**
     * 客户姓名
     */
    private String unit;
    /**
     * 客户姓名
     */
    private BigDecimal price;
    /**
     * 客户姓名
     */
    private List<DiscountInforBean> discountInfors;

    public PreciousMetalsProductBean(String wproductName, String wid, String wunit, String wprice) {
        productName = wproductName;
        id = wid;
        unit = wunit;
        price = new BigDecimal(wprice);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<DiscountInforBean> getDiscountInfors() {
        return discountInfors;
    }

    public void setDiscountInfors(List<DiscountInforBean> discountInfors) {
        this.discountInfors = discountInfors;
    }

    public void addDiscountInfor(DiscountInforBean discountInfor) {
        if (this.discountInfors == null) {
            this.discountInfors = new ArrayList<DiscountInforBean>();
        }
        this.discountInfors.add(discountInfor);
    }
}
