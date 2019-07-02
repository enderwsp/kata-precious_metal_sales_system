package com.coding.sales.datas;

import com.coding.sales.beans.DiscountInforBean;
import com.coding.sales.beans.PreciousMetalsProductBean;
import com.coding.sales.enums.DiscountType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PreciousMetalsProductDatasTest {
    @Test
    public void should_parse_command() {
//        * 世园会五十国钱币册
//		* 编号：001001
//		* 单位：册
//		* 价格：998.00元

        List<PreciousMetalsProductBean> preciousMetalsProducts = PreciousMetalsProductDatas.getALlPreciousMetalsProducts();
        assertEquals(7, preciousMetalsProducts.size());
        PreciousMetalsProductBean preciousMetalsProductBean001001 = PreciousMetalsProductDatas.getPreciousMetalsProductById("001001");
        assertEquals("001001", preciousMetalsProductBean001001.getId());
        assertEquals(new BigDecimal("998.00"), preciousMetalsProductBean001001.getPrice());
        assertEquals("世园会五十国钱币册", preciousMetalsProductBean001001.getProductName());
        assertEquals("册", preciousMetalsProductBean001001.getUnit());
//	* 2019北京世园会纪念银章大全40g
//		* 编号：001002
//		* 单位：盒
//		* 价格：1380.00
//		* 可使用9折打折券------------


        PreciousMetalsProductBean preciousMetalsProductBean001002 = PreciousMetalsProductDatas.getPreciousMetalsProductById("001002");
        assertEquals("001002", preciousMetalsProductBean001002.getId());
        assertEquals(new BigDecimal("1380.00"), preciousMetalsProductBean001002.getPrice());
        assertEquals("2019北京世园会纪念银章大全40g", preciousMetalsProductBean001002.getProductName());
        assertEquals("盒", preciousMetalsProductBean001002.getUnit());
        assertEquals(DiscountType.OffCoupon, preciousMetalsProductBean001002.getDiscountInfors().get(0).getDiscountType());
        assertEquals(DiscountInforBean.nineOff, preciousMetalsProductBean001002.getDiscountInfors().get(0).getName());
//	* 招财进宝
//		* 编号：003001
//		* 单位：条
//		* 价格：1580.00
//		* 可使用95折打折券------------

        PreciousMetalsProductBean preciousMetalsProductBean003001 = PreciousMetalsProductDatas.getPreciousMetalsProductById("003001");
        assertEquals("003001", preciousMetalsProductBean003001.getId());
        assertEquals(new BigDecimal("1580.00"), preciousMetalsProductBean003001.getPrice());
        assertEquals("招财进宝", preciousMetalsProductBean003001.getProductName());
        assertEquals("条", preciousMetalsProductBean003001.getUnit());
        assertEquals(DiscountType.OffCoupon, preciousMetalsProductBean003001.getDiscountInfors().get(0).getDiscountType());
        assertEquals(DiscountInforBean.nineFiveOff, preciousMetalsProductBean003001.getDiscountInfors().get(0).getName());
//	* 水晶之恋
//		* 编号：003002
//		* 单位：条
//		* 价格：980.00
//		* 参与满减：第3件半价，满3送1------------

        PreciousMetalsProductBean preciousMetalsProductBean003002 = PreciousMetalsProductDatas.getPreciousMetalsProductById("003002");
        assertEquals("003002", preciousMetalsProductBean003002.getId());
        assertEquals(new BigDecimal("980.00"), preciousMetalsProductBean003002.getPrice());
        assertEquals("水晶之恋", preciousMetalsProductBean003002.getProductName());
        assertEquals("条", preciousMetalsProductBean003002.getUnit());
        List<DiscountInforBean> discountInforBeans = preciousMetalsProductBean003002.getDiscountInfors();
        assertEquals(2, discountInforBeans.size());
        DiscountInforBean discountInforBean003002a = discountInforBeans.get(0);
        DiscountInforBean discountInforBean003002b = discountInforBeans.get(1);
        assertEquals(DiscountType.FullDiscountCouponNum, discountInforBean003002a.getDiscountType());
        assertEquals(DiscountType.FullDiscountCouponNum, discountInforBean003002b.getDiscountType());
        if (discountInforBean003002a.getName().equals(DiscountInforBean.threeNum) && discountInforBean003002b.getName().equals(DiscountInforBean.fourNum)) {
            assertEquals(3, discountInforBean003002a.getFullNumNeed());
            assertEquals(new BigDecimal("0.5"), discountInforBean003002a.getFullDiscountNum());
            assertEquals(4, discountInforBean003002b.getFullNumNeed());
            assertEquals(new BigDecimal("1"), discountInforBean003002b.getFullDiscountNum());
        } else if (discountInforBean003002b.getName().equals(DiscountInforBean.threeNum) && discountInforBean003002a.getName().equals(DiscountInforBean.fourNum)) {
            assertEquals(4, discountInforBean003002a.getFullNumNeed());
            assertEquals(new BigDecimal("1"), discountInforBean003002a.getFullDiscountNum());
            assertEquals(3, discountInforBean003002b.getFullNumNeed());
            assertEquals(new BigDecimal("0.5"), discountInforBean003002b.getFullDiscountNum());
        } else {
            assertEquals("check", "getDiscountType");
        }
//	* 中国经典钱币套装
//		* 编号：002002
//		* 单位：套
//		* 价格：998.00
//		* 参与满减：每满2000减30，每满1000减10------------
//

        PreciousMetalsProductBean preciousMetalsProductBean002002 = PreciousMetalsProductDatas.getPreciousMetalsProductById("002002");
        assertEquals("002002", preciousMetalsProductBean002002.getId());
        assertEquals(new BigDecimal("998.00"), preciousMetalsProductBean002002.getPrice());
        assertEquals("中国经典钱币套装", preciousMetalsProductBean002002.getProductName());
        assertEquals("套", preciousMetalsProductBean002002.getUnit());
        List<DiscountInforBean> discountInforBeans002002 = preciousMetalsProductBean002002.getDiscountInfors();
        assertEquals(2, discountInforBeans.size());
        DiscountInforBean discountInforBean002002a = discountInforBeans002002.get(0);
        DiscountInforBean discountInforBean002002b = discountInforBeans002002.get(1);
        assertEquals(DiscountType.FullDiscountCouponVal, discountInforBean002002a.getDiscountType());
        assertEquals(DiscountType.FullDiscountCouponVal, discountInforBean002002b.getDiscountType());
        if (discountInforBean002002a.getName().equals(DiscountInforBean.twoThousand) && discountInforBean002002b.getName().equals(DiscountInforBean.oneThousand)) {
            assertEquals(new BigDecimal("2000.00"), discountInforBean002002a.getFullValNeed());
            assertEquals(new BigDecimal("30.00"), discountInforBean002002a.getFullDiscountVal());
            assertEquals(new BigDecimal("1000.00"), discountInforBean002002b.getFullValNeed());
            assertEquals(new BigDecimal("10.00"), discountInforBean002002b.getFullDiscountVal());
        } else if (discountInforBean002002b.getName().equals(DiscountInforBean.twoThousand) && discountInforBean002002a.getName().equals(DiscountInforBean.oneThousand)) {
            assertEquals(new BigDecimal("1000.00"), discountInforBean002002a.getFullValNeed());
            assertEquals(new BigDecimal("10.00"), discountInforBean002002a.getFullDiscountVal());
            assertEquals(new BigDecimal("2000.00"), discountInforBean002002b.getFullValNeed());
            assertEquals(new BigDecimal("30.00"), discountInforBean002002b.getFullDiscountVal());
        } else {
            assertEquals("check", "getDiscountType");
        }
//	* 守扩之羽比翼双飞4.8g
//		* 编号：002001
//		* 单位：条
//		* 价格：1080.00
//		* 参与满减：第3件半价，满3送1------------
//		* 可使用95折打折券------------

        PreciousMetalsProductBean preciousMetalsProductBean002001 = PreciousMetalsProductDatas.getPreciousMetalsProductById("002001");
        assertEquals("002001", preciousMetalsProductBean002001.getId());
        assertEquals(new BigDecimal("1080.00"), preciousMetalsProductBean002001.getPrice());
        assertEquals("守扩之羽比翼双飞4.8g", preciousMetalsProductBean002001.getProductName());
        assertEquals("条", preciousMetalsProductBean002001.getUnit());
        List<DiscountInforBean> discountInforBeans002001 = preciousMetalsProductBean002001.getDiscountInfors();
        assertEquals(3, discountInforBeans002001.size());
        DiscountInforBean discountInforBeans002001a = null;
        DiscountInforBean discountInforBeans002001b = null;
        DiscountInforBean discountInforBeans002001c = null;
        for (DiscountInforBean discountInforBean : discountInforBeans002001) {
            if (discountInforBean.getName().equals(DiscountInforBean.nineFiveOff)) {
                discountInforBeans002001a = discountInforBean;
            }
            if (discountInforBean.getName().equals(DiscountInforBean.threeNum)) {
                discountInforBeans002001b = discountInforBean;
            }
            if (discountInforBean.getName().equals(DiscountInforBean.fourNum)) {
                discountInforBeans002001c = discountInforBean;
            }
        }
        assertEquals(DiscountType.OffCoupon, discountInforBeans002001a.getDiscountType());
        assertEquals(DiscountInforBean.nineFiveOff, discountInforBeans002001a.getName());
        assertEquals(DiscountType.FullDiscountCouponNum, discountInforBeans002001b.getDiscountType());
        assertEquals(3, discountInforBeans002001b.getFullNumNeed());
        assertEquals(new BigDecimal("0.5"), discountInforBeans002001b.getFullDiscountNum());
        assertEquals(DiscountType.FullDiscountCouponNum, discountInforBeans002001c.getDiscountType());
        assertEquals(4, discountInforBeans002001c.getFullNumNeed());
        assertEquals(new BigDecimal("1"), discountInforBeans002001c.getFullDiscountNum());
//	* 中国银象棋12g
//		* 编号：002003
//		* 单位：套
//		* 价格：698.00
//		* 参与满减：每满3000元减350, 每满2000减30，每满1000减10------------
//		* 可使用9折打折券------------
        PreciousMetalsProductBean preciousMetalsProductBean002003 = PreciousMetalsProductDatas.getPreciousMetalsProductById("002003");
        assertEquals("002003", preciousMetalsProductBean002003.getId());
        assertEquals(new BigDecimal("698.00"), preciousMetalsProductBean002003.getPrice());
        assertEquals("中国银象棋12g", preciousMetalsProductBean002003.getProductName());
        assertEquals("套", preciousMetalsProductBean002003.getUnit());
        List<DiscountInforBean> discountInforBeans002003 = preciousMetalsProductBean002003.getDiscountInfors();
        assertEquals(4, discountInforBeans002003.size());
        DiscountInforBean discountInforBeans002003a = null;
        DiscountInforBean discountInforBeans002003b = null;
        DiscountInforBean discountInforBeans002003c = null;
        DiscountInforBean discountInforBeans002003d = null;
        for (DiscountInforBean discountInforBean : discountInforBeans002003) {
            if (discountInforBean.getName().equals(DiscountInforBean.nineFiveOff)) {
                discountInforBeans002003a = discountInforBean;
            } else if (discountInforBean.getName().equals(DiscountInforBean.threeThousand)) {
                discountInforBeans002003b = discountInforBean;
            } else if (discountInforBean.getName().equals(DiscountInforBean.twoThousand)) {
                discountInforBeans002003c = discountInforBean;
            } else if (discountInforBean.getName().equals(DiscountInforBean.oneThousand)) {
                discountInforBeans002003d = discountInforBean;
            }
        }
        assertEquals(DiscountType.OffCoupon, discountInforBeans002003a.getDiscountType());
        assertEquals(DiscountInforBean.nineFiveOff, discountInforBeans002003a.getName());
        assertEquals(DiscountType.FullDiscountCouponVal, discountInforBeans002003b.getDiscountType());
        assertEquals(new BigDecimal("3000.00"), discountInforBeans002003b.getFullValNeed());
        assertEquals(new BigDecimal("350.00"), discountInforBeans002003b.getFullDiscountVal());

        assertEquals(DiscountType.FullDiscountCouponVal, discountInforBeans002003c.getDiscountType());
        assertEquals(new BigDecimal("2000.00"), discountInforBeans002003c.getFullValNeed());
        assertEquals(new BigDecimal("30.00"), discountInforBeans002003c.getFullDiscountVal());
        assertEquals(DiscountType.FullDiscountCouponVal, discountInforBeans002003d.getDiscountType());
        assertEquals(new BigDecimal("1000.00"), discountInforBeans002003d.getFullValNeed());
        assertEquals(new BigDecimal("10.00"), discountInforBeans002003d.getFullDiscountVal());
    }

}