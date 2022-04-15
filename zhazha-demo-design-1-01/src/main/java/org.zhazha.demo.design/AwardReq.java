package org.zhazha.demo.design;

import lombok.Data;

import java.util.Map;

@Data
public class AwardReq {

    private String uId; //用户唯一ID
    private Integer awardType;//奖品类型 1优惠券 2 实物商品 3第三方兑换卡
    private String awardNumber;//奖品编号，sku，couponNumber,cardId
    private String bizId;//业务ID 防重复
    private Map<String, String> extMap;//扩展信息
}
