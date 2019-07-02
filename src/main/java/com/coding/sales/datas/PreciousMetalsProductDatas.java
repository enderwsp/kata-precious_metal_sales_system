package com.coding.sales.datas;

import com.coding.sales.beans.DiscountInforBean;
import com.coding.sales.beans.PreciousMetalsProductBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wushengping
 * @version V1.0
 * @Project: kata-precious_metal_sales_system
 * @Package com.coding.sales.datas
 * @Description: 贵金属信息列表，模拟数据库出库信息（有限数据建议加控制是否存在对于数据）
 * @date Date : 2019年07月02日 15:56
 */
public class PreciousMetalsProductDatas {
    /**
     * 九折券
     */
    public static DiscountInforBean nineOff = new DiscountInforBean("0.9");
    /**
     * 九5折券
     */
    public static DiscountInforBean nineFiveOff = new DiscountInforBean("0.95");
    /**
     * 每满3000元减350
     */
    public static DiscountInforBean threeThousandDis = new DiscountInforBean("3000.00", "350.00");
    /**
     * 每满2000元减30
     */
    public static DiscountInforBean twoThousandDis = new DiscountInforBean("2000.00", "30.00");
    /**
     * 每满1000元减10
     */
    public static DiscountInforBean oneThousandDis = new DiscountInforBean("1000.00", "10.00");
    /**
     * 第3件半价（买3件及以上，其中1件半价）
     */
    public static DiscountInforBean threeNumDis = new DiscountInforBean(3, "0.5");
    /**
     * 满3送1（买4件及以上，其中1件免费）
     */
    public static DiscountInforBean fourNumDis = new DiscountInforBean(4, "1");
    //    * 世园会五十国钱币册
//		* 编号：001001
//            * 单位：册
//		* 价格：998.00元
    public static PreciousMetalsProductBean prdNum001001 = new PreciousMetalsProductBean("世园会五十国钱币册", "001001", "册", "998.00");
    //	* 2019北京世园会纪念银章大全40g
//		* 编号：001002
//            * 单位：盒
//		* 价格：1380.00
//            * 可使用9折打折券
    public static PreciousMetalsProductBean prdNum001002 = new PreciousMetalsProductBean("2019北京世园会纪念银章大全40g", "001002", "盒", "1380.00");
    //	* 招财进宝
//		* 编号：003001
//            * 单位：条
//		* 价格：1580.00
//            * 可使用95折打折券
    public static PreciousMetalsProductBean prdNum003001 = new PreciousMetalsProductBean("招财进宝", "003001", "条", "1580.00");
    //	* 水晶之恋
//		* 编号：003002
//            * 单位：条
//		* 价格：980.00
//            * 参与满减：第3件半价，满3送1
    public static PreciousMetalsProductBean prdNum003002 = new PreciousMetalsProductBean("水晶之恋", "003002", "条", "980.00");
    //	* 中国经典钱币套装
//		* 编号：002002
//            * 单位：套
//		* 价格：998.00
//            * 参与满减：每满2000减30，每满1000减10
    public static PreciousMetalsProductBean prdNum002002 = new PreciousMetalsProductBean("中国经典钱币套装", "002002", "套", "998.00");
    //
//	* 守扩之羽比翼双飞4.8g
//		* 编号：002001
//            * 单位：条
//		* 价格：1080.00
//            * 参与满减：第3件半价，满3送1
//		* 可使用95折打折券
    public static PreciousMetalsProductBean prdNum002001 = new PreciousMetalsProductBean("守扩之羽比翼双飞4.8g", "002001", "条", "1080.00");
    //	* 中国银象棋12g
//		* 编号：002003
//            * 单位：套
//		* 价格：698.00
//            * 参与满减：每满3000元减350, 每满2000减30，每满1000减10
//		* 可使用9折打折券
    public static PreciousMetalsProductBean prdNum002003 = new PreciousMetalsProductBean("中国银象棋12g", "002003", "套", "698.00");

    static {
        nineOff.setName("9折券");
        nineFiveOff.setName("95折券");
        threeNumDis.setName("第3件半价");
        fourNumDis.setName("满3送1");
        threeThousandDis.setName("每满3000元减350");
        twoThousandDis.setName("每满2000元减30");
        oneThousandDis.setName("每满1000元减10");
        prdNum001002.addDiscountInfor(nineOff);
        prdNum003001.addDiscountInfor(nineFiveOff);
        prdNum003002.addDiscountInfor(threeNumDis);
        prdNum003002.addDiscountInfor(fourNumDis);
        prdNum002002.addDiscountInfor(twoThousandDis);
        prdNum002002.addDiscountInfor(oneThousandDis);
        prdNum002001.addDiscountInfor(nineFiveOff);
        prdNum002003.addDiscountInfor(threeThousandDis);
        prdNum002003.addDiscountInfor(twoThousandDis);
        prdNum002003.addDiscountInfor(oneThousandDis);
    }

    /**
     * 获取所有的在售贵金属信息
     *
     * @return 在售贵金属信息列表
     */
    public static List<PreciousMetalsProductBean> getALlPreciousMetalsProducts() {
        List<PreciousMetalsProductBean> preciousMetalsProducts = new ArrayList<PreciousMetalsProductBean>(8);

        preciousMetalsProducts.add(prdNum001001);
        preciousMetalsProducts.add(prdNum001002);
        preciousMetalsProducts.add(prdNum003001);
        preciousMetalsProducts.add(prdNum003002);
        preciousMetalsProducts.add(prdNum002002);
        preciousMetalsProducts.add(prdNum002001);
        preciousMetalsProducts.add(prdNum002003);
        return preciousMetalsProducts;
    }

    /**
     * 从在售贵金属信息列表中根据编号获取在售贵金属信息
     *
     * @param memberId
     * @return 单个在售贵金属信息
     */
    public static PreciousMetalsProductBean getPreciousMetalsProductById(String memberId) {
        List<PreciousMetalsProductBean> allCustomers = getALlPreciousMetalsProducts();
        for (PreciousMetalsProductBean preciousMetalsProduct : allCustomers) {
            if (("" + preciousMetalsProduct.getId()).equals(memberId)) {
                return preciousMetalsProduct;
            }
        }
        return null;
    }
}
