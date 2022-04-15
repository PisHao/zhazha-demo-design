package org.zhazha.demo.design.goods;

import com.alibaba.fastjson.JSON;

public class GoodsService {

    public Boolean deliveryGoods(DeliverReq req){
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }
}
