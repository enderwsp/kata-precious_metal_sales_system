package com.coding.sales.datas;

import com.coding.sales.beans.CustomerInforBean;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerInforDatasTest {
    @Test
    public void should_parse_command() {
        //    姓名,等级,卡号,积分
//    马丁,普卡,6236609999,9860
//    王立,金卡,6630009999,48860
//    李想,白金卡,8230009999,98860
//    张三,钻石卡,9230009999,198860
        List<CustomerInforBean> customers = CustomerInforDatas.getAllCustomers();
        assertEquals(4, customers.size());
        CustomerInforBean maDing = CustomerInforDatas.getCustomersByMemberId("6236609999");
        assertEquals("马丁", maDing.getName());
        assertEquals("普卡", maDing.getMemberType().getName());
        assertEquals("6236609999", maDing.getMemberId());
        assertEquals(9860, maDing.getCurrentMemberPoints());
        CustomerInforBean wangLi = CustomerInforDatas.getCustomersByMemberId("6630009999");
        assertEquals("王立", wangLi.getName());
        assertEquals("金卡", wangLi.getMemberType().getName());
        assertEquals("6630009999", wangLi.getMemberId());
        assertEquals(48860, wangLi.getCurrentMemberPoints());
        CustomerInforBean liXiang = CustomerInforDatas.getCustomersByMemberId("8230009999");
        assertEquals("李想", liXiang.getName());
        assertEquals("白金卡", liXiang.getMemberType().getName());
        assertEquals("8230009999", liXiang.getMemberId());
        assertEquals(98860, liXiang.getCurrentMemberPoints());
        CustomerInforBean zhangSan = CustomerInforDatas.getCustomersByMemberId("9230009999");
        assertEquals("张三", zhangSan.getName());
        assertEquals("钻石卡", zhangSan.getMemberType().getName());
        assertEquals("9230009999", zhangSan.getMemberId());
        assertEquals(198860, zhangSan.getCurrentMemberPoints());
        assertEquals(null, CustomerInforDatas.getCustomersByMemberId("111111111"));
        assertEquals(null, CustomerInforDatas.getCustomersByMemberId(""));
        assertEquals(null, CustomerInforDatas.getCustomersByMemberId(null));
    }

}