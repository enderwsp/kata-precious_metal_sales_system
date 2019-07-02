package com.coding.sales.datas;

import com.coding.sales.beans.CustomerInforBean;
import com.coding.sales.enums.MemberType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wushnegping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.datas
 * @Description: 客户信息列表，模拟数据库出库信息（有限数据建议加控制是否存在对于数据）
 * @date Date : 2019年07月02日 15:55
 */
public class CustomerInforDatas {
    public static CustomerInforBean customerInforBeanMading = new CustomerInforBean("马丁", MemberType.CardMember, "6236609999", 9860);
    public static CustomerInforBean customerInforBeanWangli = new CustomerInforBean("王立", MemberType.GoldCardMember, "6630009999", 48860);
    public static CustomerInforBean customerInforBeanLixiang = new CustomerInforBean("李想", MemberType.PlatinumCardMember, "8230009999", 98860);
    public static CustomerInforBean customerInforBeanZhangsan = new CustomerInforBean("张三", MemberType.DiamondCardMember, "9230009999", 198860);

    //    姓名,等级,卡号,积分
//    马丁,普卡,6236609999,9860
//    王立,金卡,6630009999,48860
//    李想,白金卡,8230009999,98860
//    张三,钻石卡,9230009999,198860

    /**
     * 获取所有的会员信息，测试使用检验会员信息
     *
     * @return 会员信息列表
     */
    public static List<CustomerInforBean> getAllCustomers() {
        List<CustomerInforBean> allCustomers = new ArrayList<CustomerInforBean>(4);

        allCustomers.add(customerInforBeanMading);
        allCustomers.add(customerInforBeanWangli);
        allCustomers.add(customerInforBeanLixiang);
        allCustomers.add(customerInforBeanZhangsan);
        return allCustomers;
    }

    /**
     * 从会员信息列表中根据会员账户号码获取会员信息
     * @param memberId
     * @return 单个会员信息
     */
    public static CustomerInforBean getCustomersByMemberId(String memberId) {
        List<CustomerInforBean> allCustomers = getAllCustomers();
        for (CustomerInforBean customer : allCustomers) {
            if (("" + customer.getMemberId()).equals(memberId)) {
                return customer;
            }
        }
        return null;
    }
}
