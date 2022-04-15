package org.zhazha.demo.design;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhazha.demo.design.card.IQiYiCardService;
import org.zhazha.demo.design.coupon.CouponResult;
import org.zhazha.demo.design.coupon.CouponService;
import org.zhazha.demo.design.goods.DeliverReq;
import org.zhazha.demo.design.goods.GoodsService;

/**
 * 模拟发奖服务
 */
public class PrizeController {

    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq req){
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try{
            logger.info("奖品发放开始{}. req:{}", req.getUId(), reqJson);
            //按照不同类型上篇
            if(req.getAwardType() == 1){
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
                if("0000".equals(couponResult.getCode())){
                    awardRes = new AwardRes("0000", "发放成功");
                }else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            }else if(req.getAwardType() == 2){
                GoodsService goodsService = new GoodsService();

                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));

                Boolean boo = goodsService.deliveryGoods(deliverReq);
                if(boo){
                    awardRes = new AwardRes("0000", "发放成功");
                }else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            }else if(req.getAwardType() == 3){
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());
                IQiYiCardService qiYiCardService = new IQiYiCardService();
                qiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());

                awardRes = new AwardRes("0000", "发放成功");
            }
            logger.info("奖品发放完成{}。", req.getUId());
        }catch (Exception e){
            logger.info("奖品发放失败{}. req:{}", req.getUId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());

        }
        return  awardRes;
    }

    private String queryUserName(String uId){
        return "花花";
    }

    private String queryUserPhoneNumber(String uId){
        return "12313131";
    }
}
