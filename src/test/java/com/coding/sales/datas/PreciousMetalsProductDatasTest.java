package com.coding.sales.datas;

import com.coding.sales.beans.PreciousMetalsProductBean;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PreciousMetalsProductDatasTest {
    @Test
    public void should_parse_command() {
        List<PreciousMetalsProductBean> preciousMetalsProducts = PreciousMetalsProductDatas.getALlPreciousMetalsProducts();
        assertEquals(7, preciousMetalsProducts.size());
    }

}