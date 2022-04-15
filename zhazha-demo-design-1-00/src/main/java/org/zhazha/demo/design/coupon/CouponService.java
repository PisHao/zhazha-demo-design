package org.zhazha.demo.design.coupon;

public class CouponService {

    public CouponResult sendCoupon(String uId, String couponNumber, String uuid){
        System.out.println("模拟发送优惠券一张："+ uId + ", " +couponNumber + ", "+uuid);
        return new CouponResult("0000", "发送成功");
    }
}
