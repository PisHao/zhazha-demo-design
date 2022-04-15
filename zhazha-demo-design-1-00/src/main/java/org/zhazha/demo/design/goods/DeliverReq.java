package org.zhazha.demo.design.goods;

import lombok.Data;

@Data
public class DeliverReq {

    private String userName;//用户姓名
    private String userPhone;//用户手机
    private String sku;//商品sku
    private String orderId;//订单ID
    private String consigneeUserName;//收获人姓名
    private String consigneeUserPhone;//收货人手机
    private String ConsigneeUserAddress;//收货人地址
}
